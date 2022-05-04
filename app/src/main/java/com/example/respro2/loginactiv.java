package com.example.respro2;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.respro2.ui.home.HomeFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;


public class loginactiv extends AppCompatActivity{

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView googlebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivez);
        Objects.requireNonNull(getSupportActionBar()).hide();
        googlebtn = findViewById(R.id.goog_btn);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        googlebtn.setOnClickListener(v -> signin());

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        MaterialButton loginbtn = findViewById(R.id.loginbtn);




        //Check with database
        loginbtn.setOnClickListener(v -> {
            if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                Toast.makeText(loginactiv.this,"Login Successfull",Toast.LENGTH_SHORT).show();

            }
            else{
                Toast.makeText(loginactiv.this,"Login Failed!",Toast.LENGTH_SHORT).show();
            }
        });

    }

    void signin() {

        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigatetoHomeActivty();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    void navigatetoHomeActivty(){
        finish();
        Intent intent = new Intent(loginactiv.this, MainActivity.class);
        startActivity(intent);





    }

}
