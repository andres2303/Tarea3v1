package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tarea3.adaptadores.ListaAlumnosAdapter;
import com.example.tarea3.bd.DbAlumno;
import com.example.tarea3.bd.DbHelper;
import com.example.tarea3.entidades.Alumnos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnCrear;
    RecyclerView listaAlumnos;
    FloatingActionButton add_icon;

    ArrayList<Alumnos>listaArrayAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaAlumnos =findViewById(R.id.listaAlumnos);
        listaAlumnos.setLayoutManager(new LinearLayoutManager(this));

        DbAlumno dbAlumno = new DbAlumno(MainActivity.this);

        listaArrayAlumnos = new ArrayList<>();

        ListaAlumnosAdapter listaAlumnosAdapter = new ListaAlumnosAdapter(dbAlumno.verAlumnos());
        listaAlumnos.setAdapter(listaAlumnosAdapter);
        /*
        btnCrear=findViewById(R.id.btn_crearbd);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db !=null){
                    Toast.makeText(MainActivity.this, "BD CREATED", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "BD UNCREATED", Toast.LENGTH_SHORT).show();
                }
            }
        });

         */

        add_icon = findViewById(R.id.add_icon);
        add_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NuevoActivity.class);
                startActivity(intent);
            }
        });

    }
}