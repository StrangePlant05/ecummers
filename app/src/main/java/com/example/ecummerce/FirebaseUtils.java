package com.example.ecummerce;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.Map;
import com.example.ecummerce.FirebaseInterface.*;

public class FirebaseUtils {

    public static void addAccount(FirebaseFirestore f_instance, Map map){
        //Map keys: email, password, full_name, address, phone_number, type
        //Type values: buyer, seller, admin
        f_instance.collection("ACCOUNTS")
                .document( map.get("email") + "_" + map.get("phone_number"))
                .set(map);
    }

    public static void authEmail(FirebaseAuth auth_instance, Map map, EmailAuth authListener ,Context c){
        auth_instance.createUserWithEmailAndPassword((String)map.get("email"), (String)map.get("password"))
                .addOnCompleteListener(task -> {
                   if(task.isSuccessful()){
                       Toast.makeText(c, "A verification email has been sent. Please check your mail.", Toast.LENGTH_SHORT).show();
                       FirebaseUser user = auth_instance.getCurrentUser();
                       user.sendEmailVerification()
                               .addOnCompleteListener(success ->{
                                  if(success.isSuccessful()){
                                        authListener.changeLayout(true);
                                  }
                               });
                   }
                });
    }

    public static void loginAccount(FirebaseFirestore f_instance, Map map, LoginComplete login){
        f_instance.collection("ACCOUNTS")
                .whereEqualTo("phone_number", (String)map.get("phone_number"))
                .whereEqualTo("password", (String) map.get("password"))
                .get()
                .addOnCompleteListener(task -> {
                    if(task.getResult().size() > 0){
                        login.loginSuccess(true);
                    } else {
                        login.loginSuccess(false);
                    }
                });
    }
    public static void checkPhoneNumber(String number, FirebaseFirestore f_instance, DuplicatePhoneNumber duplicate){
        f_instance.collection("ACCOUNTS")
                .whereEqualTo("phone_number", number)
                .get()
                .addOnCompleteListener(task->{
                    if(task.getResult().size() > 0){
                        duplicate.allowSignup(false);
                    } else {
                        duplicate.allowSignup(true);
                    }
                });
    }

    public static void addProducts(FirebaseFirestore f_instance, Map products, ProductAdded added){
        f_instance.collection("PRODUCTS")
                .add(products)
                .addOnCompleteListener(task->{
                    if(task.isComplete()){
                        added.addID(task.getResult().getId());
                    }
                });

    }

    public static void purchaseProducts(FirebaseFirestore f_instance, List<UserPurchase> purchase, String userID){
        for (UserPurchase userp : purchase){
            f_instance.collection("PURCHASES")
                    .document(userID)
                    .collection("USER_PURCHASES")
                    .add(userp);
        }


    }

}
