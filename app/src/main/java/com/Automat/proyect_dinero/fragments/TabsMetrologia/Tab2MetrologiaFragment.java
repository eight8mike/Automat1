package com.Automat.proyect_dinero.fragments.TabsMetrologia;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Automat.proyect_dinero.Entidades.Equipo;
import com.Automat.proyect_dinero.R;
import com.Automat.proyect_dinero.adaptadores.AdapterEquipoMetrologia;

import java.util.ArrayList;


public class Tab2MetrologiaFragment extends Fragment {

    EditText buscador;
    AdapterEquipoMetrologia adapterEquipoMetrologia;
    RecyclerView recyclerViewmetrologia;
    ArrayList<Equipo> listaEquipos;

    public Tab2MetrologiaFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2_metrologia, container, false);
        recyclerViewmetrologia = view.findViewById(R.id.recyclerView);
        buscador = view.findViewById(R.id.bucador);
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
        listaEquipos = new ArrayList<>();
        // Cargar la lista

        cargarLista();

        //mostrar datos

        mostrarData();

        return view;
    }

    // Asignar los datos de cada apartado

    public void cargarLista() {
        listaEquipos.add(new Equipo("Escala Metalica","Versión industrial de las reglas de dibujo, ya que ambas se utilizan muy similarmente, la diferencia, y el hecho" +
                " de que sean de acero obedece a que también son útiles de trazo, es decir el dibujo que se va a realizar se hará sobre una superficie de un material más duro que el papel",R.drawable.ic_regla));
        listaEquipos.add(new Equipo("Escuadra","Es una herramienta para el trabajo en carpintería o metalistería, usada para marcar y medir una pieza de material." +
                "Consta de una paleta ancha, fabricada de acero o bronce y remachada a un mango de madera. El interior del mango se encuentra generalmente fijado con un listón metálico, para asegurar que la paleta quede inmóvil debidamente a 90 grados.",R.drawable.ic_escuadra));
        listaEquipos.add(new Equipo("Compases de Punta","Se utilizan para obtener medidas entre líneas o puntos; para transportar medidas tomadas de una regla de acero, y para trazar círculos o arcos. " +
                "Las puntas son aladas y los brazos paralelos permiten que las mediciones se efectúen por comparación visual en lugar del tacto.",R.drawable.ic_compas));
        listaEquipos.add(new Equipo("Compas de Exterior","Este instrumento es muy comúnmente utilizado en el torneado de piezas tanto en los tornos paralelos para maquinado de piezas metálicas " +
                "o en el torneado de madera ya que la apertura de sus brazos es más grande que los brazos de un calibrador vernier.",R.drawable.ic_compas_exterior));
        listaEquipos.add(new Equipo("Compas de Interior","De la misma forma en que se utiliza el compás de exteriores en el maquinado de pieza tanto de madera como metálicas, el compás de interiores" +
                " permite la verificación del torneado de piezas huecas de difícil acceso para un calibrador vernier.",R.drawable.ic_compas_inteior));
        listaEquipos.add(new Equipo("Calibrador Vernier","Es un instrumento de medición, principalmente de diámetros exteriores, interiores y profundidades, utilizado en el ámbito industrial." +
                " El vernier es una escala auxiliar que se desliza a lo largo de una escala principal para permitir en ella lecturas fraccionales exactas de la mínima división.", R.drawable.ic_vernier));
        listaEquipos.add(new Equipo("Calibrador Vernier de Caratula","Debido al mecanismo del indicador basado en cremallera y piñón, el calibrador de carátula ofrece lecturas fáciles; pero," +
                " al mismo tiempo, esta característica requiere poner una atención especial en su manejo, que no se requiere en el de los calibradores de vernier.", R.drawable.ic_vernier_caratula));
        listaEquipos.add(new Equipo("Calibrador Vernier Digital","Las mediciones con los calibres digitales es un procedimiento de medición directo, rápido y preciso, ya que las señales de entrada" +
                " y salida son idénticas. Estos calibres digitales son robustos y de fácil manejo.", R.drawable.ic_vernier_digital));
        listaEquipos.add(new Equipo("Micrómetro de Exteriores","Instrumento de medición cuyo funcionamiento se basa en un tornillo" +
                "micrométrico que sirve para valorar el tamaño de un objeto con gran precisión, en un rango del orden de centésimas o de milésimas de milímetro (0,01 mm y 0,001 mm, respectivamente).", R.drawable.ic_micrometro));
        listaEquipos.add(new Equipo("Micrómetro de Interiores","Los micrómetros de interior sirven para medir dimensiones interiores de un objeto." +
                "Se basan en una cabeza a la cual se le van añadiendo uno o varios ejes que sirven para hacer tope y determinar la medida interior.", R.drawable.ic_micrometro_interiores));
        listaEquipos.add(new Equipo("Micrómetro de Profundidad","Son aquellos que están diseñados y pensados para medir las profundidades de ranuras y huecos de una determinada pieza; " +
                "por ejemplo una perforación llevada a cabo en un objeto que forma parte de una cadena de montaje.", R.drawable.ic_micrometro_profundidad));
        listaEquipos.add(new Equipo("Goniómetro","Es un instrumento de medición angular, muy práctico e idóneo, cuando se desea medir con mayor exactitud ángulos entre dos superficies.", R.drawable.ic_goniometro));
        listaEquipos.add(new Equipo("Mesa de Precisión", "Es el plano de referencia ideal para inspección de trabajos. Su alto grado de plenitud y calidad también las convierten en las bases " +
                "ideales para el montaje de sistemas de medición sofisticados", R.drawable.ic_mesa_presicion));
        listaEquipos.add(new Equipo("Bloques Patron","Son un sistema para producir longitudes de precisión. El bloque patrón individual es un bloque metálico o cerámico que ha sido rectificado con precisión y" +
                " lapeado hasta alcanzar un espesor específico. Los bloques patrón vienen en sets de bloques de un conjunto de longitudes estándar.",R.drawable.ic_bloques_patron));
        listaEquipos.add(new Equipo("Medidor de Alturas","Instrumento de medición y trazado que se utiliza en los laboratorios de metrología y control de calidad, para realizar todo tipo de " +
                "trazado en piezas como por ejemplo ejes de simetría, centros para taladros, excesos de mecanizado etc.",R.drawable.ic_medidor_alturas));
        listaEquipos.add(new Equipo("Comparador Óptico","Posee dos ejes de coordenadas (x,y), luz episcópica y diascópica, goniómetro análogo con precisión de 10/6 minutos, " +
                "produce una imagen amplificada de los objetos a medir.", R.drawable.ic_comparador));
        listaEquipos.add(new Equipo("Rugosímetro","Es un instrumento capaz de cuantificar la calidad que tienen diferentes superficies y perforaciones. Puede medir la rugosidad que presentan " +
                "las piezas mecánicas, además de determinar el nivel de desgaste así como la resistencia que puede tener una pieza mecánica.", R.drawable.ic_rugosimetro));
    }
    public void mostrarData(){
        recyclerViewmetrologia.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterEquipoMetrologia = new AdapterEquipoMetrologia(getContext(), listaEquipos);
        recyclerViewmetrologia.setAdapter(adapterEquipoMetrologia);
    }
    public void filtrar(String texto){
        ArrayList<Equipo> filtrarLista = new ArrayList<>();
        for (Equipo equipo : listaEquipos){
            if (equipo.getTituloEquipo().toLowerCase().contains(texto.toLowerCase())){
                filtrarLista.add(equipo);
            }
        }
        adapterEquipoMetrologia.filtrar(filtrarLista);
    }
}