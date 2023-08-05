package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText eTnombres;
    EditText eTapellidos;
    EditText eTcorreo;
    EditText eTpassr;
    EditText eTnacimiento;
     Spinner spGenero;
    EditText eTtelefono;

    Button btnguardar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eTnombres = (EditText) findViewById(R.id.eTnombres);
        eTapellidos = (EditText) findViewById(R.id.eTapellidos);
        eTcorreo = (EditText) findViewById(R.id.eTcorreo);
        eTpassr = (EditText) findViewById(R.id.eTpassr);
        eTnacimiento = (EditText) findViewById(R.id.eTnacimiento);
        spGenero = (Spinner) findViewById(R.id.spGenero);
        eTtelefono = (EditText) findViewById(R.id.eTtelefono);
        btnguardar = (Button) findViewById(R.id.btnguardar);


        eTnacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(Registro.this);
                dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        eTnacimiento.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                });
                dialog.show();

            }
        });

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombres = eTnombres.getText().toString();
                String apellidos = eTapellidos.getText().toString();
                String correo = eTcorreo.getText().toString();
                String passr = eTpassr.getText().toString();
                String nacimiento = eTnacimiento.getText().toString();
                String genero = spGenero.getSelectedItem().toString();
                String telefono = eTtelefono.getText().toString();

                if (nombres.equals("")) {
                    eTnombres.setError("El nombre no puede estar vacio");
                } else {
                    if (apellidos.equals("")) {
                        eTapellidos.setError("Los apellidos no pueden estar vacio");
                    } else {
                        if (correo.equals("")) {
                            eTcorreo.setError(" no puede estar vacio");
                        } else {
                            if (passr.equals("")) {
                                eTpassr.setError(" no puede estar vacio");
                            } else {
                                if (nacimiento.equals("")) {
                                    eTnacimiento.setError(" no puede estar vacio");
                                } else {
                                    if (genero.equals("")) {

                                    }else{
                                        Dialog dialog = new Dialog(Registro.this);
                                        ImageView imgDialogo = (ImageView) dialog.findViewById(R.id.imgDioalogo_layout);

                                        TextView txtTitulo=(TextView)dialog.findViewById(R.id.TxtTitulo);
                                        TextView txtMensaje=(TextView)dialog.findViewById(R.id.TxtMensaje);
                                        Button btnCancelar = (Button) dialog.findViewById(R.id.btnCancelar);
                                        Button btnConfirmar = (Button) dialog.findViewById(R.id.btnConfirmar);

                                        if (genero.equals("Masculino")) {
                                            imgDialogo.setImageResource(R.mipmap.hombre);
                                        } else {
                                            imgDialogo.setImageResource(R.mipmap.mujer);
                                        }
                                    btnCancelar.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog.dismiss();
                                        }
                                    });
                                        btnConfirmar.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                dialog.dismiss();
                                                Toast.makeText(Registro.this, "Informacion guardada con exito", Toast.LENGTH_SHORT).show();
                                                Registro.this.finish();
                                            }
                                        });

                                        txtTitulo.setText(nombres);
                                        txtMensaje.setText("confirma");
                                        dialog.show();

                                    }

                                }
                            }

                        }


                    }
                }



            }
        });

        }
    }


