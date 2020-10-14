package com.Automat.proyect_dinero.fragments.TabsMetrologia;

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


public class Tab1MetrologiaFragment extends Fragment {

    EditText buscador;
    AdapterEquipoMateriales adapterEquipoMateriales;
    RecyclerView recyclerView;
    ArrayList<EquipoMateriales> listaMateriales;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab3_materiales, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewMaterialestab2);
        buscador = view.findViewById(R.id.bucadortab2_materiales);
        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filtrar(s.toString());
            }
        });

        listaMateriales = new ArrayList<>();

        cargarLista();
        mostrarLista();

        return (view);
    }

    public void cargarLista() {
        listaMateriales.add(new EquipoMateriales("(Vernier Sistema Internacional) \n10 divisiones de 0.1 milímetros.", "", R.drawable.vernier_10));
        listaMateriales.add(new EquipoMateriales("(Vernier Sistema Internacional) \n20 divisiones de 0.05 milímetros.", "", R.drawable.vernier_20));
        listaMateriales.add(new EquipoMateriales("(Vernier Sistema Internacional) \n50 divisiones de 0.02 milímetros.", "", R.drawable.vernier_50));
        listaMateriales.add(new EquipoMateriales("(Vernier Sistema Inglés) \n25 divisiones de 0.001 milésima de pulgada.", "", R.drawable.vernieri_25));
        listaMateriales.add(new EquipoMateriales("(Vernier Sistema Inglés) \n50 divisiones de 0.001 milésima de pulgada.", "", R.drawable.vernieri_50));
        listaMateriales.add(new EquipoMateriales("(Vernier Sistema Inglés) \nFraccionario.", "", R.drawable.vernieri_frac));
        listaMateriales.add(new EquipoMateriales("(Micrómetro Sistema Internacional) \nRango de medición de 0-25 mm y 0.01 mm de resolución.", "", R.drawable.micrometro_01));
        listaMateriales.add(new EquipoMateriales("(Micrómetro Sistema Internacional) \nRango de medición de 0-25 mm y 0.001 mm de resolución.", "", R.drawable.micrometro_001));
        listaMateriales.add(new EquipoMateriales("(Micrómetro Sistema Inglés) \nMilésimas de pulgada", "La lectura milesimal se obtiene gracias al perímetro del tambor, donde se acuñaron veinticinco divisiones equidistantes. Una vuelta completa producirá un avance de 0,025″ y las divisiones barrerán la línea de referencia.", R.drawable.micrometroi_mile));
        listaMateriales.add(new EquipoMateriales("(Micrómetro Sistema Inglés) \nDiez milésimas de pulgada", "La lectura en diez milésimas es obtenida aplicando el principio de lectura del nonio, por las marcas acuñadas en el cilindro.", R.drawable.micrometroi_diezmile));
    }

    public void mostrarLista() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterEquipoMateriales = new AdapterEquipoMateriales(getContext(), listaMateriales);
        recyclerView.setAdapter(adapterEquipoMateriales);
    }

    public void filtrar(String texto) {
        ArrayList<EquipoMateriales> filtrarLista = new ArrayList<>();
        for (EquipoMateriales equipoMateriales : listaMateriales) {
            if (equipoMateriales.getTituloEquipoMateriales().toLowerCase().contains(texto.toLowerCase())) {
                filtrarLista.add(equipoMateriales);
            }
        }
        adapterEquipoMateriales.filtrar(filtrarLista);
    }
}