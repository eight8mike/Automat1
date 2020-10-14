package com.Automat.proyect_dinero.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Automat.proyect_dinero.Entidades.Equipo;
import com.Automat.proyect_dinero.R;

import java.util.ArrayList;

public class AdapterEquipoMetrologia extends RecyclerView.Adapter<AdapterEquipoMetrologia.ViewHolder> {

    LayoutInflater inflater;
    public ArrayList<Equipo> model;

    // listener



    public AdapterEquipoMetrologia(Context context, ArrayList<Equipo> model){
         this.inflater = LayoutInflater.from(context);
         this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_equipo_metrologia, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = model.get(position).getTituloEquipo();
        String fechanacimiento = model.get(position).getDescripcion();
        int imagen = model.get(position).getImagenid();
        holder.palabras.setText(nombre);
        holder.conceptos.setText(fechanacimiento);
        holder.imageView.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
            TextView palabras, conceptos;
            ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            palabras = itemView.findViewById(R.id.titulo_equipo_metrologia);
            conceptos = itemView.findViewById(R.id.descripcion_equipo_metrologia);
            imageView = itemView.findViewById(R.id.imagen_equipo_metrologia);
        }
    }

    public void filtrar(ArrayList<Equipo> filtroPalabras){
        this.model = filtroPalabras;
        notifyDataSetChanged();
    }
}
