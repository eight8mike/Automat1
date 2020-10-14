package com.Automat.proyect_dinero.fragments.TabsManufactura;

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

import com.Automat.proyect_dinero.Entidades.Palabra;
import com.Automat.proyect_dinero.R;
import com.Automat.proyect_dinero.adaptadores.AdapterPalabras;

import java.util.ArrayList;

public class Tab1ManufacturaFragment extends Fragment{
    EditText buscador;
    AdapterPalabras adapterPersona;
    RecyclerView recyclerViewpalabras;
    ArrayList<Palabra> listaPalabras;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1_manufactura, container, false);
        recyclerViewpalabras = view.findViewById(R.id.recyclerViewPalabras);
        buscador = view.findViewById(R.id.buscador);
        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                filtrar(s.toString());
            }
        });
        listaPalabras = new ArrayList<>();
        // Cargar la lista

        cargarLista();

        //mostrar datos

        mostrarData();

        return view;
    }

    // Asignar los datos de cada apartado

    public void cargarLista() {
        listaPalabras.add(new Palabra("Estudio de factibilidad", "Fundamentar la factibilidad del producto, pieza o proyecto, para su respectiva planeación del proceso de manufactura."));
        listaPalabras.add(new Palabra("Dibujo de conjunto", "Representar los requerimientos gráficos de fabricación de una pieza o proyecto de manufactura, considerando las normas existentes del dibujo mecánico."));
        listaPalabras.add(new Palabra("Dibujo de definición", "Representar las especificaciones de fabricación de una pieza o proyecto de manufactura, considerando las normas existentes del dibujo mecánico."));
        listaPalabras.add(new Palabra("Dibujo de ensamble", "Representar en perspectiva el conjunto de piezas del proyecto de manufactura, en posición conveniente para el ensamble del mismo."));
        listaPalabras.add(new Palabra("Hoja de proceso y operaciones", "Establecer los proceso y operaciones requeridas en un proyecto de manufactura, a través de registros que muestren la planeación del mismo."));
        listaPalabras.add(new Palabra("Análisis de fabricación", "Secuencia en la que intervienen los equipos, herramientas y operaciones, especificado en el dibujo de definición."));
        listaPalabras.add(new Palabra("Análisis de fase", "Realizar un estudio minucioso de todas las operaciones requeridas, para cumplir con cada etapa en la fabricación del proyecto de manufactura."));
        listaPalabras.add(new Palabra("Diagrama de flujo del proceso", "Mostrar la trayectoria de un producto o procedimiento, señalando todas las actividades mediante la simbología correspondiente."));
        listaPalabras.add(new Palabra("Mecanizado de piezas", "Aplicar los procesos de arranque de viruta, tomando en cuenta las características técnicas y de funcionabilidad."));
        listaPalabras.add(new Palabra("Verificación de piezas mecánicas", "Comparar las dimensiones de los planos o dibujos de definición, con las piezas maquinadas para su verificación y ensamble."));
    }
    public void mostrarData(){
        recyclerViewpalabras.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPersona = new AdapterPalabras(getContext(), listaPalabras);
        recyclerViewpalabras.setAdapter(adapterPersona);
    }
    public void filtrar(String texto){
        ArrayList<Palabra> filtrarLista = new ArrayList<>();
        for (Palabra palabra : listaPalabras){
            if (palabra.getTituloGlosario().toLowerCase().contains(texto.toLowerCase())){
                filtrarLista.add(palabra);
            }
        }
        adapterPersona.filtrar(filtrarLista);
    }
}