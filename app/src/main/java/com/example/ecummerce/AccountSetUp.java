package com.example.ecummerce;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.ecummerce.databinding.ActivityAccountSetUpBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class AccountSetUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityAccountSetUpBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_account_set_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        bind.button.setOnClickListener(v->{
            if(bind.confirm.getText().toString().equals(bind.password.getText().toString())){
                if((Integer.parseInt(bind.age.getText().toString()) >= 13)){
                    User user = new User(bind.email.getText().toString(), bind.password.getText().toString(), getIntent().getStringExtra("number"), bind.fname.getText().toString(), bind.address.getText().toString(), "buyer", Integer.parseInt(bind.age.getText().toString()));FirebaseUtils.authEmail(FirebaseAuth.getInstance(), user.addToMap(), new FirebaseUtils.EmailAuth() {
                        @Override
                        public void changeLayout(boolean change) {
                            if(change){
                                FirebaseUtils.addAccount(FirebaseFirestore.getInstance(), user.addToMap());
                                startActivity(new Intent(AccountSetUp.this, Dashboard.class));
                            }
                        }
                    }, this);
                } else {
                    Toast.makeText(this, "You must be 13 and above to use our platform.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}