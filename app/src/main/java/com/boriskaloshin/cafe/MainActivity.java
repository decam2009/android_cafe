package com.boriskaloshin.cafe;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText userNameTextView;
    private EditText passwordTextView;
    private Button signInButton;

    private void initViews() {
        userNameTextView = findViewById(R.id.editTextName);
        passwordTextView = findViewById(R.id.editTextPassword);
        signInButton = findViewById(R.id.sign_in_button);
    }

    private void launchNextScreen(String userName) {
        Intent intent = MakeOrderActivity.newIntent(this, userName);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userNameTextView.getText().toString().trim();
                String userPassword = passwordTextView.getText().toString().trim();
                if (userName.isEmpty() || userPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            R.string.error_fields_empty,
                            Toast.LENGTH_SHORT).show();
                } else {
                    launchNextScreen(userName);
                }
            }
        });
    }


}