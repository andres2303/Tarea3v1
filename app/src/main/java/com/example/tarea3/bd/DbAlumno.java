package com.example.tarea3.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.tarea3.entidades.Alumnos;

import java.util.ArrayList;

public class DbAlumno extends DbHelper{

    Context context;
    public DbAlumno(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarAlumno(String nombres,String apellidos, String correo ){

        long id=0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values= new ContentValues();
            values.put("nombres",nombres );
            values.put("apellidos",apellidos );
            values.put("correo", correo);
            id = db.insert(TABLE_ALUMNO, null, values);

        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Alumnos> verAlumnos(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Alumnos> listaAlumnos= new ArrayList<>();
        Alumnos alumnos= null;
        Cursor cursorAlumnos = null;

        cursorAlumnos=db.rawQuery("SELECT * FROM "+TABLE_ALUMNO, null);

        if (cursorAlumnos.moveToFirst()){
            do{
                alumnos= new Alumnos();
                alumnos.setId(cursorAlumnos.getInt(0));
                alumnos.setNombres(cursorAlumnos.getString(1));
                alumnos.setApellidos(cursorAlumnos.getString(2));
                alumnos.setCorreo(cursorAlumnos.getString(3));
                listaAlumnos.add(alumnos);
            }while (cursorAlumnos.moveToNext());
        }
        cursorAlumnos.close();

        return listaAlumnos;
    }
}
