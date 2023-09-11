package com.example.tarea3.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea3.R;
import com.example.tarea3.entidades.Alumnos;

import java.util.ArrayList;

public class ListaAlumnosAdapter extends RecyclerView.Adapter<ListaAlumnosAdapter.AlumnosViewHolder> {

    ArrayList<Alumnos> listaAlumnos;

    public ListaAlumnosAdapter(ArrayList<Alumnos> listaAlumnos){
        this.listaAlumnos=listaAlumnos;
    }

    @NonNull
    @Override
    public AlumnosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_alumno, null, false);
       return new AlumnosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnosViewHolder holder, int position) {
        holder.view_nombres.setText(listaAlumnos.get(position).getNombres());
        holder.view_apellidos.setText(listaAlumnos.get(position).getApellidos());
        holder.view_correo.setText(listaAlumnos.get(position).getCorreo());

    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }

    public class AlumnosViewHolder extends RecyclerView.ViewHolder {

        TextView view_nombres, view_apellidos, view_correo;

        public AlumnosViewHolder(@NonNull View itemView) {
            super(itemView);

            view_nombres = itemView.findViewById(R.id.view_nombres);
            view_apellidos = itemView.findViewById(R.id.view_apellidos);
            view_correo = itemView.findViewById(R.id.view_correo);

        }
    }
}
