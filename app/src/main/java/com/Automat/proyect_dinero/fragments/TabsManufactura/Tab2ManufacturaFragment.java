package com.Automat.proyect_dinero.fragments.TabsManufactura;

import android.content.Intent;
import android.net.Uri;
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

import com.Automat.proyect_dinero.Entidades.FormatosManufactura;
import com.Automat.proyect_dinero.R;
import com.Automat.proyect_dinero.adaptadores.AdapterEquipoManufactura;

import java.util.ArrayList;


public class Tab2ManufacturaFragment extends Fragment {

    EditText buscador;
    AdapterEquipoManufactura adapterEquipoManufactura;
    RecyclerView recyclerView;
    ArrayList<FormatosManufactura> listaManufactura;

    public Tab2ManufacturaFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2_manufactura, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewManufacturatab2);
        buscador = view.findViewById(R.id.bucadortab2_manufactura);
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

        listaManufactura = new ArrayList<>();

        cargarLista();

        mostrarLista();

        return (view);
    }
    public void cargarLista(){
        listaManufactura.add(new FormatosManufactura("Hoja de Proceso","Hoja informativa en la que se recogen todas las" +
                " características necesarias para su fabricación, operaciones a realizar y su secuencia de trabajo, tratados de forma secuencial, y con un proceso lógico y " +
                "estudiado de fabricación, máquinas que intervienen en su mecanizado, herramientas que se han de utilizar y sus características, así como los cálculo técnicos, " +
                "etc.","https://mega.nz/file/SEkxUKpC#48A3TGmBxRyznXktidnfwyiCyaB7c9RTUoBGSpy2i30",R.drawable.hoja_de_proceso));

        listaManufactura.add(new FormatosManufactura("Hoja de Operaciones","Hoja donde describes una parte del proceso, por ejemplo el corte" +
                " del material, y pones cuánto tiempo tardas, que herramientas usas, etc.","https://mega.nz/file/Tct3WK6D#G6tqZXdxNdwXctfRL4KMtJTB0nmxRtsSanW65F6VWxw",R.drawable.hoja_de_operaciones));

        listaManufactura.add(new FormatosManufactura("Análisis de Fase","El análisis de fase es un instrumento muy poderoso. La percepción" +
                " puede que la medida de la fase es difícil de reunir o posiblemente que las lecturas son difíciles de comprender o interpretar. Algunas personas pueden creer que esas " +
                "medidas de fase no ofrecen información útil.","https://mega.nz/file/iZs3WazA#_-wXC8BYAgPSy5ipHL0MOlaKOw9DvhnpCjP3YDMukqU",R.drawable.analisis_fase));

        listaManufactura.add(new FormatosManufactura("","","https://mega.nz/file/qUtDUIZD#I13pAQoWqiInULOQgCVuXridjPQ2SwoRVVFeuS88znQ",R.drawable.analisis_fase2));

        listaManufactura.add(new FormatosManufactura("Análisis de Fabricación","La idea es determinar si tu equipo del proyecto puede elaborar un producto o" +
                " desarrollar un servicio frente a la posibilidad de adquirirlo fuera de la empresa. Esta técnica forma parte del proceso de " +
                "planificación","https://mega.nz/file/XAswTTiZ#K1D51WXWW4YqOX7vjiFZuROBLkCks1OfJ9Xv_foBkDc",R.drawable.analisis_de_fabricacion));

        listaManufactura.add(new FormatosManufactura("Diagrama de Flujo de Proceso","Consisten en una representación gráfica de los pasos que se siguen en la secuencia de " +
                "actividades de los procesos de transformación o elaboración de alimentos, identificándolos mediante símbolos o bloques. Es una herramienta que permite ordenar la información " +
                "en forma sistemática e identificar las fases de los procesos de elaboración, mostrando también la composición de las cadenas agroalimentarias desde la disponibilidad de la materia" +
                " prima, con la secuencia de elaboración de los productos finales. A partir de estos diagramas se pueden realizar análisis más profundos, tales como balances de materia, balances de" +
                " energía, comparación de diversas alternativas tecnológicas y de estructura de costos y análisis de peligros y control de puntos críticos. Asimismo, permiten identificar los problemas " +
                "y las oportunidades de mejora del proceso, visualizando por ejemplo los pasos redundantes, siendo una herramienta de suma utilidad para actividades de diagnóstico " +
                "y de capacitación.","https://mega.nz/file/TUkV3IhZ#qTOF4KbIYwM9rLhGvK2mdcvc8EHK4oYhHbpx-8CwfYg",R.drawable.diagrama_flujo_proceso));

        listaManufactura.add(new FormatosManufactura("Reporte de Verificación","","https://mega.nz/file/6RkkRbTT#9yzrRMjf5mJMM_1dMoBlyd47erK8RXb37_qt6DcMP9Y",R.drawable.reporte_de_verificacion));
       /*
       listaManufactura.add(new EquipoManufactura("","","",));
        */
    }
    public void mostrarLista(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterEquipoManufactura = new AdapterEquipoManufactura(getContext(), listaManufactura);
        recyclerView.setAdapter(adapterEquipoManufactura);

        adapterEquipoManufactura.setOnClickLister(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String linksito = listaManufactura.get(recyclerView.getChildAdapterPosition(view)).getLinkManufactura();
                Uri uri =Uri.parse(linksito);
                Intent intent =new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
    public void filtrar(String texto){
        ArrayList<FormatosManufactura> filtrarLista = new ArrayList<>();
        for (FormatosManufactura formatosManufactura : listaManufactura){
            if (formatosManufactura.getTituloEquipoManufactura().toLowerCase().contains(texto.toLowerCase())){
                filtrarLista.add(formatosManufactura);
            }
        }
        adapterEquipoManufactura.filtrar(filtrarLista);
    }
}