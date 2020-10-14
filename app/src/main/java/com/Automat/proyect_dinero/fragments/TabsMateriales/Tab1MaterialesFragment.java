package com.Automat.proyect_dinero.fragments.TabsMateriales;

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

public class Tab1MaterialesFragment extends Fragment{
    EditText buscador;
    AdapterPalabras adapterPersona;
    RecyclerView recyclerViewpalabras;
    ArrayList<Palabra> listaPalabras;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1_materiales, container, false);
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
        listaPalabras.add(new Palabra("Ensayo de tracción", "Consiste en una prueba destructiva para obtención, interpretación y análisis de algunas propiedades mecánicas del material a analizar; se realiza sometiendo una probeta normalizada a una carga que intente estirarla  y que va aumentando con el tiempo hasta producir la estricción y posterior rotura de la probeta."));
        listaPalabras.add(new Palabra("Ensayo de compresión", "Es un ensayo técnico para determinar la resistencia de un material o su deformación ante un esfuerzo de compresión, en la mayoría de los casos se realiza con hormigones y metales (sobre todo aceros), aunque puede realizarse sobre cualquier material.\n Se realiza preparando probetas normalizadas que se someten a compresión en una máquina universal.\n"));
        listaPalabras.add(new Palabra("Ensayo de impacto", "Los ensayos de impacto se realizan sometiendo a las probetas a varios golpes de intensidad creciente, como en el ensayo de impacto con caída de bola y el ensayo de impacto con golpe repetido."));
        listaPalabras.add(new Palabra("Ensayo de torsión", "Consiste en aplicar un par torsor a una probeta por medio de un dispositivo de carga y medir el ángulo de torsión resultante en el extremo de la probeta. Este ensayo se realiza en el rango de comportamiento linealmente elástico del material."));
        listaPalabras.add(new Palabra("Ensayo de dureza", "Consiste en presionar un objeto (penetrador) con unas medidas y una carga concretos sobre la superficie del material a evaluar. La dureza se determina al medir la profundidad de penetración del penetrador o bien midiendo el tamaño de la impresión dejada por el penetrador."));
        listaPalabras.add(new Palabra("Dureza ROCKWELL", "Suele usarse como ensayo rápido en los talleres de fabricación o en los laboratorios, principalmente con materiales metálicos, consiste en medir la profundidad de una penetración causada por una bola de carburo de diamante o tungsteno."));
        listaPalabras.add(new Palabra("Dureza BRINELL", "Es un método de ensayo por indentación por el cual, con el uso de una máquina calibrada, llamada durómetro, se fuerza una bola fabricada de un acero templado extra duro de un diámetro (D) determinado (función del espesor de la probeta a ensayar), y bajo unas condiciones específicas, contra la superficie del material que se quiere calcular su dureza, mediante la aplicación de una fuerza (P) durante un tiempo (t) dado. El valor que hay que medir en el ensayo es precisamente este diámetro (d) del casquete que se forma en la superficie del material"));
        listaPalabras.add(new Palabra("Dureza VICKERS", "Se emplea como elemento indentador una pirámide regular de diamante, de base cuadrada, cuyas caras laterales forman un ángulo de 136º. En la penetración del indentador contra la probeta, éste dejará una impresión cuadrada sobre el material de la probeta, que resulta más fácil de medir (más precisa) en este tipo de ensayo. El ensayo Vickers se recomienda especialmente para determinar la dureza de materiales muy duros, con valores de dureza superiores a 500 HB. Para materiales con una dureza inferior, se recomienda emplear el ensayo de dureza Brinell."));
        listaPalabras.add(new Palabra("Dureza KNOOP", "El ensayo de dureza Knoop es una alternativa al ensayo Vickers dentro del rango de microdureza. Además se puede realizar en la misma máquina de ensayo de microdureza o dureza universal. Se utiliza básicamente para superar las fracturas en los materiales quebradizos, y para facilitar los ensayos de dureza en las capas finas."));
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