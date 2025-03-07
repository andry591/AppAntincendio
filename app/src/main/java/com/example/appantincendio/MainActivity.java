package com.example.appantincendio;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the button from the layout
        final Button registratiButton = findViewById(R.id.registrati);
        final Button loginButton = findViewById(R.id.login);

        if (registratiButton != null) {
            // Assign a listener to the button
            registratiButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                }
            });
        }

        if (loginButton != null) {
            // Assign a listener to the button
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            });
        }
    }

}
