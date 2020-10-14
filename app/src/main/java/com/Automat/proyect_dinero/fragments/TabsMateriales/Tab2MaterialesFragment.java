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

import com.Automat.proyect_dinero.Entidades.EquipoMateriales;
import com.Automat.proyect_dinero.R;
import com.Automat.proyect_dinero.adaptadores.AdapterEquipoMateriales;

import java.util.ArrayList;


public class Tab2MaterialesFragment extends Fragment {

    EditText buscador;
    AdapterEquipoMateriales adapterEquipoMateriales;
    RecyclerView recyclerView;
    ArrayList<EquipoMateriales> listaMateriales;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2_materiales, container, false);
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
            public void afterTextChanged(Editable s) { filtrar(s.toString());
            }
        });

        listaMateriales = new ArrayList<>();

        cargarLista();
        mostrarLista();

        return (view);
    }
    public void cargarLista(){

        listaMateriales.add(new EquipoMateriales("Estructuras Cristalinas","Es la forma sólida de cómo se ordenan y empaquetan los átomos, moléculas, o iones. Estos " +
                "son empaquetados de manera ordenada y con patrones de repetición que se extienden en las tres dimensiones del espacio. La cristalografía es el" +
                " estudio científico de los cristales y su formación.",R.drawable.estructuras_cristalinas));

        listaMateriales.add(new EquipoMateriales("Representación de Estructuras Cristalinas","",R.drawable.estructuras_cristalinas2));

        listaMateriales.add(new EquipoMateriales("Diagrama Hierro-Carbono","Se representan las transformaciones que sufren los aceros al carbono con la temperatura, " +
                "admitiendo que el calentamiento de la mezcla se realiza muy lentamente, de modo tal que los procesos de difusión tengan tiempo para completarse.",R.drawable.diagraama_hierrocarbono));

        listaMateriales.add(new EquipoMateriales("Diagrama Esfuerzo-Deformación","Es la curva resultante graficada con los valores del esfuerzo y la correspondiente " +
                "deformación unitaria en el espécimen calculado a partir de los datos de un ensayo de tensión o de compresión.",R.drawable.diagrama_esfuerzo));

        listaMateriales.add(new EquipoMateriales("Tabla Rockwell","La dureza Rockwell o ensayo de dureza Rockwell es un método para determinar la dureza, es decir, la " +
                "resistencia de un material a ser penetrado. El ensayo de dureza Rockwell constituye el método más usado para medir la dureza debido a que es muy simple de llevar a cabo y no requiere " +
                "conocimientos especiales.",R.drawable.tabla_rockwel));

        listaMateriales.add(new EquipoMateriales("Escala de Dureza","El ensayo de dureza Rockwell es un método rápido y, por lo tanto, ideal" +
                " para evaluar la dureza. ",R.drawable.tabla_rockwel_2));

/*        listaMateriales.add(new EquipoMateriales("","",R.drawable.));
        listaMateriales.add(new EquipoMateriales("","",R.drawable.));*/
    }
    public void mostrarLista(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterEquipoMateriales = new AdapterEquipoMateriales(getContext(), listaMateriales);
        recyclerView.setAdapter(adapterEquipoMateriales);
    }
    public void filtrar(String texto){
        ArrayList<EquipoMateriales> filtrarLista = new ArrayList<>();
        for (EquipoMateriales equipoMateriales : listaMateriales){
            if (equipoMateriales.getTituloEquipoMateriales().toLowerCase().contains(texto.toLowerCase())){
                filtrarLista.add(equipoMateriales);
            }
            /* Para que el buscador considere tambien el contenido

            else if (equipoMateriales.getDescripcionMateriales().toLowerCase().contains(texto.toLowerCase())){
                filtrarLista.add(equipoMateriales);
            }*/
        }
        adapterEquipoMateriales.filtrar(filtrarLista);
    }
}