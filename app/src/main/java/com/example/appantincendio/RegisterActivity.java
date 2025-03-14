package com.example.appantincendio;

import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.CalendarView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Collegamento con elementi grafici

        EditText nome = findViewById(R.id.nome);
        EditText cognome = findViewById(R.id.cognome);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        CalendarView dataNascita = findViewById(R.id.data_nascita);
        final String[] dataFormattata = new String[1];

        dataNascita.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // Formatta la data
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.set(year, month, dayOfMonth);
                dataFormattata[0] = sdf.format(cal.getTime());
            }
        });

        Button btnEffettuaRegistrazione = findViewById(R.id.registrati);
        btnEffettuaRegistrazione.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Utente utente = new Utente(nome.getText().toString(), cognome.getText().toString(), email.getText().toString(),dataFormattata[0],password.getText().toString());

                Gson gson = new Gson();
                String utentejson = gson.toJson(utente);

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("utente", utentejson);
                startActivity(intent);

                //Uso del log
                Log.d("Registrazione", "Utente JSON: " + utentejson);
                Log.d("Registrazione", "Nome: " + nome.getText().toString());
                Log.d("Registrazione", "Cognome: " + cognome.getText().toString());
                Log.d("Registrazione", "Email: " + email.getText().toString());
                Log.d("Registrazione", "Password: " + password.getText().toString());
                //Messaggio pop up che mi da una conferma di registrazione avvenuta con successo
                Toast.makeText(RegisterActivity.this, "Registrazione avvenuta con successo", Toast.LENGTH_SHORT).show();
            }


        });

    }

}