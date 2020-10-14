package com.Automat.proyect_dinero.fragments.TabsTornofresa;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.Automat.proyect_dinero.Entidades.EquipoMateriales;
import com.Automat.proyect_dinero.R;
import com.Automat.proyect_dinero.adaptadores.AdapterEquipoMateriales;

import java.util.ArrayList;


public class Tab3TornoFragment extends Fragment {

    EditText buscador;
    AdapterEquipoMateriales adapterEquipoTorno;
    RecyclerView recyclerView;
    ArrayList<EquipoMateriales> listaTrono;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab3_torno, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewTornotab3);
        buscador = view.findViewById(R.id.bucadortab3_torno);
        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) { filtrar(s.toString());
            }
        });

        listaTrono = new ArrayList<>();

        cargarLista();
        mostrarLista();

        return (view);
    }
    public void cargarLista(){
        listaTrono.add(new EquipoMateriales("RPM Sistema Métrico","Vc = Es la velocidad de corte del material expresada en m/min\n\uD835\uDF7F = Es 3.1416\nD = " +
                "Es el diámtero del material o la herramienta expresada en milímetros",R.drawable.rpm));
        listaTrono.add(new EquipoMateriales("RPM Sistema Inglés","Vc = Es la velocidad de corte del material expresada en pies/min\n\uD835\uDF7F = Es 3.1416\nD = " +
                "Es el diámtero del material o la herramienta expresada en pulgadas",R.drawable.rpm2));
        listaTrono.add(new EquipoMateriales("Tiempo de Mecanizado para Torno","Longitud de aproximacion = ",R.drawable.tm_torno));
        listaTrono.add(new EquipoMateriales("Tiempo de Mecanizado para Fresadora y Taladro","",R.drawable.tm_mecanizado));
        /* Añadir mas
        listaTrono.add(new EquipoMateriales("","",R.drawable.));
        listaTrono.add(new EquipoMateriales("","",R.drawable.));
        listaTrono.add(new EquipoMateriales("","",R.drawable.));
         */
    }
    public void mostrarLista(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterEquipoTorno = new AdapterEquipoMateriales(getContext(), listaTrono);
        recyclerView.setAdapter(adapterEquipoTorno);
    }
    public void filtrar(String texto){
        ArrayList<EquipoMateriales> filtrarLista = new ArrayList<>();
        for (EquipoMateriales equipoTorno : listaTrono){
            if (equipoTorno.getTituloEquipoMateriales().toLowerCase().contains(texto.toLowerCase())){
                filtrarLista.add(equipoTorno);
            }
        }
        adapterEquipoTorno.filtrar(filtrarLista);
    }
}