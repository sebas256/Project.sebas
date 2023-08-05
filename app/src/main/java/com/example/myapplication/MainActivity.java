package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eTusuario;
    EditText eTpass;
    Button btnlogin;

    Button btnregistrar;

    String user = "Sebas25";
    String pass = "1234";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTusuario = (EditText) findViewById(R.id.eTusuario);
        eTpass = (EditText) findViewById(R.id.eTpass);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnregistrar = (Button) findViewById(R.id.btnregistrar);

        eTusuario.setText("Hola mundo");


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUser = eTusuario.getText().toString();
                String strPass = eTpass.getText().toString();
                if (strUser.equals(user)) {
                    if (strPass.equals(pass)) {
                        Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
                }
            }


        });


        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Registro.class));
            }


        });


    }

}

