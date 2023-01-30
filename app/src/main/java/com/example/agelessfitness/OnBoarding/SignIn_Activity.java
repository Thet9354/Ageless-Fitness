package com.example.agelessfitness.OnBoarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agelessfitness.Database.DatabaseHelper;
import com.example.agelessfitness.MainActivity;
import com.example.agelessfitness.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignIn_Activity extends AppCompatActivity {

    private com.google.android.material.textfield.TextInputEditText editTxt_username, editTxt_password;
    private TextView txtView_signUp, txtView_loopHole;
    private Button btn_logIn;

    private String mUsername, mPassword;

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initWidget();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mUsername = editTxt_username.getText().toString();
                mPassword = editTxt_password.getText().toString();

                validateUsername();
                validatePassword();
                validateInput();
            }
        });

        txtView_loopHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        txtView_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }

    private void validateInput() {

        if (!validateUsername() | !validatePassword())
            return;
        else
        {
            verifyData();
        }
    }

    private void verifyData() {

        //TODO: Verify existing acc in firebase
        myDb = new DatabaseHelper(this);
        boolean isUsernameTaken = myDb.isUsernameTaken(mUsername);
        if (!isUsernameTaken) {
            Toast.makeText(SignIn_Activity.this, "Username does not exist", Toast.LENGTH_SHORT).show();
        } else {
            boolean isPasswordCorrect = myDb.isPasswordCorrect(mUsername, mPassword);
            if (!isPasswordCorrect) {
                Toast.makeText(SignIn_Activity.this, "Password incorrect", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SignIn_Activity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        }

    }

    private boolean validatePassword() {

        if (mPassword.isEmpty())
        {
            editTxt_password.setError("Required");
            return false;
        }
        else
            return true;
    }

    private boolean validateUsername() {

        //Regex pattern to allow only alphabets and numbers
        String userNamePattern = "^[a-zA-Z0-9]+$";

        if (mUsername.isEmpty())
        {
            editTxt_username.setError("Required");
            return false;
        }
        else if (mUsername.matches(userNamePattern)) {
            return true;
        } else {
            editTxt_username.setError("Invalid Username");
            return false;
        }
    }

    private void initWidget() {

        //EditText
        editTxt_username = findViewById(R.id.editTxt_username);
        editTxt_password = findViewById(R.id.editTxt_password);

        //TextView
        txtView_signUp = findViewById(R.id.txtView_signUp);
        txtView_loopHole = findViewById(R.id.txtView_loopHole);

        //Button
        btn_logIn = findViewById(R.id.btn_logIn);
    }
}