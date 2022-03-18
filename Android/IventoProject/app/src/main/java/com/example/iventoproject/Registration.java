package com.example.iventoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText mFullName,mEmailId,mPassword,mPhone,mDate;
    Button btnSignUp;
    TextView mBtnLogin;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    ProgressBar progressBar;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        mFullName = findViewById(R.id.fname);
        mEmailId = findViewById(R.id.EmailId);
        mPassword = findViewById(R.id.PasswordSign);
        mPhone = findViewById(R.id.MobileNum);
        mDate =findViewById(R.id.dob);
        btnSignUp = findViewById(R.id.SignUpBtn);
        mBtnLogin = findViewById(R.id.LoginTxt);
        fAuth = FirebaseAuth.getInstance();
        fStore= FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressBarSign);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();

        }


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String email = mEmailId.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String fullName =mFullName.getText().toString();
                String phone = mPhone.getText().toString();
                String date = mDate.getText().toString();

                if(TextUtils.isEmpty(email)){
                    mEmailId.setError(" Email Required ");
                    return ;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError(" Password Required ");
                    return ;
                }
                if (password.length()<6){
                    mPassword.setError(" Password must me less than 6 Characters  ");
                    return ;
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Registration.this, "User Created ", Toast.LENGTH_SHORT).show();
                            userID=fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference= fStore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName",fullName);
                            user.put("email",email);
                            user.put("phone",phone);
                            user.put("DoB",date);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG,"onSuccess: user profile is created for"+ userID);

                                }
                            });


                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else{
                            Toast.makeText(Registration.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });



            }

        });
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));

            }

        });



    }
}