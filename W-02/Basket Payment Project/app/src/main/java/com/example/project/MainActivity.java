package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    private EditText editEmail, editPassword;
    private Button btnLogin;
    private String txtEmail, txtPassword;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editEmail = (EditText) findViewById(R.id.edit_email);
        editPassword = (EditText) findViewById(R.id.edit_password);
        btnLogin = findViewById(R.id.btn_login);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void login(){
        txtEmail = editEmail.getText().toString();
        txtPassword = editPassword.getText().toString();

        if(!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtPassword)){
            mAuth.signInWithEmailAndPassword(txtEmail, txtPassword).addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            mUser = mAuth.getCurrentUser();

                            System.out.println("Kullanıcı Adı" + mUser.getDisplayName());
                            System.out.println("Kullanıcı Email:" + mUser.getEmail());
                            System.out.println("Kullanıcı Uid: " + mUser.getUid());

                            Intent intent = new Intent(MainActivity.this, FruitListActivity.class);
                            startActivity(intent);

                        }
                    }).addOnFailureListener(this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(getApplicationContext(), "Hata Oluştu", Toast.LENGTH_LONG);


                }
            });
        }

    }

    }