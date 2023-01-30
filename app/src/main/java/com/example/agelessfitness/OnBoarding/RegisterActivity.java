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

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private com.google.android.material.textfield.TextInputEditText editTxt_username, editTxt_password;
    private TextView txtView_logIn, txtView_loopHole;
    private Button btn_signUp;

    private String mUsername, mPassword;

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initWidget();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_signUp.setOnClickListener(new View.OnClickListener() {
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

        txtView_logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SignIn_Activity.class));
            }
        });
    }

    private void validateInput() {

        if (!validateUsername() | !validatePassword())
            return;
        else
        {
            addData();
        }
    }

    private void addData() {

        //TODO: Add the user to firebase later

        myDb = new DatabaseHelper(this);
        boolean isUsernameTaken = myDb.isUsernameTaken(mUsername);
        if (isUsernameTaken) {
            Toast.makeText(RegisterActivity.this, "Username taken", Toast.LENGTH_SHORT).show();
        } else {
            boolean isInserted = myDb.insertData(mUsername, mPassword);
            if (isInserted) {
                Toast.makeText(RegisterActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(RegisterActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
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
        txtView_logIn = findViewById(R.id.txtView_logIn);
        txtView_loopHole = findViewById(R.id.txtView_loopHole);

        //Button
        btn_signUp = findViewById(R.id.btn_signUp);
    }
}