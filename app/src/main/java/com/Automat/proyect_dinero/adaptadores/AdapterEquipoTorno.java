package com.Automat.proyect_dinero.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Automat.proyect_dinero.Entidades.EquipoTorno;
import com.Automat.proyect_dinero.R;

import java.util.ArrayList;

public class AdapterEquipoTorno extends RecyclerView.Adapter<AdapterEquipoTorno.ViewHolder> {

    LayoutInflater inflater;
    public ArrayList<EquipoTorno> model;

    // listener



    public AdapterEquipoTorno(Context context, ArrayList<EquipoTorno> model) {
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_equipo_torno, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = model.get(position).getTituloEquipoTorno();
        String fechanacimiento = model.get(position).getDescripcionTorno();
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
            palabras = itemView.findViewById(R.id.titulo_equipo_torno);
            conceptos = itemView.findViewById(R.id.descripcion_equipo_torno);
            imageView = itemView.findViewById(R.id.imagen_equipo_torno);
        }
    }

    public void filtrar(ArrayList<EquipoTorno> filtroPalabras){
        this.model = filtroPalabras;
        notifyDataSetChanged();
    }
}
