package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tarea3.bd.DbAlumno;
import com.example.tarea3.bd.DbHelper;

public class NuevoActivity extends AppCompatActivity {

    EditText nombres_input, apellidos_input, correo_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        nombres_input= findViewById(R.id.nombres_input);
        apellidos_input= findViewById(R.id.apellidos_input);
        correo_input= findViewById(R.id.correo_input);
        add_button= findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbAlumno dbAlumno =  new DbAlumno(NuevoActivity.this);
                long id = dbAlumno.insertarAlumno(nombres_input.getText().toString(),
                        apellidos_input.getText().toString(),
                        correo_input.getText().toString());
                if (id>0){
                    Toast.makeText(NuevoActivity.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else{
                    Toast.makeText(NuevoActivity.this, "Error al guardar el registro", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void limpiar(){
        nombres_input.setText("");
        apellidos_input.setText("");
        correo_input.setText("");
    }
}