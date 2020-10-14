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


public class Tab3MaterialesFragment extends Fragment {

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

        listaMateriales.add(new EquipoMateriales("Ensayo de tracción", "e = Alargamiento o Deformacion unitaria\n\nL0 = Longitud inicial de la probeta" +
                "\n\nL = Longitud de la probeta en un momento determinado", R.drawable.tra_p));

        listaMateriales.add(new EquipoMateriales("Ensayo ROCKWELL", "n = Valor numerico de la dureza obtenida\n\nHR = Es el identificador del ensayo Rockwell\n\nLetra = Despues " +
                "del identificador HR, seguirá una letra correspondiente al tipo de escala usada", R.drawable.rock_p));

        listaMateriales.add(new EquipoMateriales("Ensayo BRINELL", "P = Carga a utilizar en el ensayo, medida en (Kp)\n\nD = Es el diametro de la bola" +
                " (indentador) medida en mm\n\nd = Es el diametro de la huella creada en la superficie de la probeta, en mm", R.drawable.bri_p));

        listaMateriales.add(new EquipoMateriales("Ensayo VICKERS", "P = La carga aplicada en el ensayo (Kp)\n\nS = Es la superficie de la huella en mm cuadrados" +
                "\n\nd = Es el valor promedio de la diagonal de la huella impresa en la probeta en mm", R.drawable.vick_p));

        listaMateriales.add(new EquipoMateriales("Ensayo KNOOP", "L = longitud de la hendidura en su eje largo\n\nCp = Factor de correccion relativo a la forma de la hendidura" +
                ", idealmente 0.070279\n\n P = Carga", R.drawable.kn_p));
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