package com.Automat.proyect_dinero.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Automat.proyect_dinero.Entidades.FormatosManufactura;
import com.Automat.proyect_dinero.R;

import java.util.ArrayList;

public class AdapterEquipoManufactura extends RecyclerView.Adapter<AdapterEquipoManufactura.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    public ArrayList<FormatosManufactura> model;

    private View.OnClickListener listener;

    public AdapterEquipoManufactura(Context context, ArrayList<FormatosManufactura> model){
         this.inflater = LayoutInflater.from(context);
         this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_manufactura, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = model.get(position).getTituloEquipoManufactura();
        String fechanacimiento = model.get(position).getDescripcionManufactura();
        String link = model.get(position).getLinkManufactura();
        int imagen = model.get(position).getImagenid();
        holder.palabras.setText(nombre);
        holder.conceptos.setText(fechanacimiento);
        holder.links.setText(link);
        holder.imageView.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }

    public void setOnClickLister(View.OnClickListener lister) {
        this.listener = lister;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
            TextView palabras, conceptos, links;
            ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            palabras = itemView.findViewById(R.id.titulo_equipo_manufactura);
            conceptos = itemView.findViewById(R.id.descripcion_equipo_manufactura);
            links = itemView.findViewById(R.id.link_manufactura);
            imageView = itemView.findViewById(R.id.imagen_manufactura);
        }
    }

    public void filtrar(ArrayList<FormatosManufactura> filtroPalabras){
        this.model = filtroPalabras;
        notifyDataSetChanged();
    }
}
