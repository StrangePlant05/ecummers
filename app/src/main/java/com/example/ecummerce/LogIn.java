package com.example.ecummerce;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.ecummerce.databinding.ActivityLayoutBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LogIn extends AppCompatActivity {

    String NUMBER = "+17603920677";
    String AUTH_TOKEN = "3fadb1b3e76d25d5c6bd839e546a9cb9";
    String ACC_SID = "AC1e2aa1ffd3f6ddd02b9947f3bf3fb030";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityLayoutBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bind.picker.setDefaultCountryUsingNameCode("PH");
        bind.picker.setCountryForNameCode("PH");
        bind.number.setText("+" + bind.picker.getDefaultCountryCode());
        bind.number.setSelection(bind.number.getText().toString().length());
        bind.picker.setOnCountryChangeListener(() -> {
           bind.number.setText("+" + bind.picker.getSelectedCountryCode());
           bind.number.setSelection(bind.number.getText().toString().length());
        });

        bind.button.setOnClickListener(v -> {
            FirebaseUtils.checkPhoneNumber(bind.number.getText().toString(), FirebaseFirestore.getInstance(), new FirebaseUtils.DuplicatePhoneNumber() {
                @Override
                public void allowSignup(boolean nodupe) {
                    if(nodupe){
                        int code = (int) (Math.random() * 900000) + 100000;
                        String code1 = String.valueOf(code);
                        //new SendMessageTask().execute(bind.number.getText().toString(), code);
                        Intent intent = new Intent(LogIn.this, verify_code_sent.class);
                        intent.putExtra("code", code1);
                        intent.putExtra("number", bind.number.getText().toString());

                        Log.d("CODE", code1);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LogIn.this, "Another account is using the same phone number already.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });
        bind.toPassword.setOnClickListener(v -> {
            Intent intent = new Intent(LogIn.this, Main_LogIn.class);
            startActivity(intent);
            finish();
        });


    }
    private class SendMessageTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            String phoneNumber = params[0];
            String code = params[1];

            OkHttpClient client = new OkHttpClient();

            String url = "https://api.twilio.com/2010-04-01/Accounts/" + ACC_SID + "/Messages.json";
            String body = "To=" + phoneNumber + "&From=+17603920677&Body=This+is+from+Zeth Dabanay Tindahan, %2C+your+OTP+code+is%3A+" + code;

            Request request = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), body))
                    .addHeader("Authorization", Credentials.basic(ACC_SID, AUTH_TOKEN))
                    .build();

            try {
                Response response = client.newCall(request).execute();
                return response.isSuccessful();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                // Handle successful message sending
                System.out.println("Message sent successfully!");
            } else {
                // Handle failed message sending
                System.out.println("Failed to send message.");
            }
        }
    }
    @Override
    public void onBackPressed() {
        //TODO: Dialog on back pressed
        if (false) super.onBackPressed();
    }
}