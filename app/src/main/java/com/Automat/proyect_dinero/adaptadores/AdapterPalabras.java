package com.Automat.proyect_dinero.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Automat.proyect_dinero.Entidades.Palabra;
import com.Automat.proyect_dinero.R;

import java.util.ArrayList;

public class AdapterPalabras extends RecyclerView.Adapter<AdapterPalabras.ViewHolder> {

    LayoutInflater inflater;
    public ArrayList<Palabra> model;

    // listener



    public AdapterPalabras(Context context, ArrayList<Palabra> model){
         this.inflater = LayoutInflater.from(context);
         this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_palabras, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = model.get(position).getTituloGlosario();
        String fechanacimiento = model.get(position).getConcepto();
        holder.palabras.setText(nombre);
        holder.conceptos.setText(fechanacimiento);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
            TextView palabras, conceptos;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            palabras = itemView.findViewById(R.id.titulo_concepto);
            conceptos = itemView.findViewById(R.id.descripcion_concepto);
        }
    }

    public void filtrar(ArrayList<Palabra> filtroPalabras){
        this.model = filtroPalabras;
        notifyDataSetChanged();
    }
}
