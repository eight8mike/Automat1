package com.Automat.proyect_dinero.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Automat.proyect_dinero.Entidades.EquipoMateriales;
import com.Automat.proyect_dinero.R;

import java.util.ArrayList;

public class AdapterEquipoMateriales extends RecyclerView.Adapter<AdapterEquipoMateriales.ViewHolder> {

    LayoutInflater inflater;
    public ArrayList<EquipoMateriales> model;

    // listener




    public AdapterEquipoMateriales(Context context, ArrayList<EquipoMateriales> model){
         this.inflater = LayoutInflater.from(context);
         this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_materiales, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = model.get(position).getTituloEquipoMateriales();
        String fechanacimiento = model.get(position).getDescripcionMateriales();
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
            palabras = itemView.findViewById(R.id.titulo);
            conceptos = itemView.findViewById(R.id.descripcion);
            imageView = itemView.findViewById(R.id.imagen);
        }
    }

    public void filtrar(ArrayList<EquipoMateriales> filtroPalabras){
        this.model = filtroPalabras;
        notifyDataSetChanged();
    }
}
