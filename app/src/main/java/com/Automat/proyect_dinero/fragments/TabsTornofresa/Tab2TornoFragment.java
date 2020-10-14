package com.Automat.proyect_dinero.fragments.TabsTornofresa;

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

import com.Automat.proyect_dinero.Entidades.EquipoTorno;
import com.Automat.proyect_dinero.R;
import com.Automat.proyect_dinero.adaptadores.AdapterEquipoTorno;

import java.util.ArrayList;

public class Tab2TornoFragment extends Fragment {

    EditText buscador;
    AdapterEquipoTorno adapterEquipoTorno;
    RecyclerView recyclerView;
    ArrayList<EquipoTorno> listaTrono;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2_torno, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewTornotab2);
        buscador = view.findViewById(R.id.bucadortab2_torno);
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
        listaTrono.add(new EquipoTorno("Gafas de Seguridad","Son un tipo de anteojos protectores que normalmente se usan para evitar la entrada de objetos, agua o" +
                " productos químicos en los ojos.",R.drawable.ic_lentes));
        listaTrono.add(new EquipoTorno("Guantes de Carnaza","Son resistentes a la abrasión y a las chispas de soldadura. Protegen las manos contra objetos ásperos " +
                "y agudos que pueden penetrar.",R.drawable.ic_guantes));
        listaTrono.add(new EquipoTorno("Buril","Herramienta manual de corte o marcado formada por una barra de acero templado terminada en una punta con un mango en" +
                " forma de pomo que sirve fundamentalmente para cortar, marcar, ranurar o desbastar material en frío",R.drawable.ic_buril));
        listaTrono.add(new EquipoTorno("Buril de Pastillas","Se usa para el mecanismo de aleaciones de gran resistencia de metales como cobre, bronce y aleaciones " +
                "ligeras.",R.drawable.ic_buril_pastillas));
        listaTrono.add(new EquipoTorno("Cortador Vertical","Herramienta de corte se utiliza en los procesos de fresado. Dependiendo del tipo de trabajo y material que" +
                " se tenga que maquinar, se debe utilizar el tipo de cortador con el número de gavilanes (filos de corte) adecuado.",R.drawable.ic_cortador));
        listaTrono.add(new EquipoTorno("Broca","Herramienta metálica de corte que crea orificios circulares en diversos materiales cuando se coloca en una herramienta " +
                "mecánica como taladro, berbiquí u otra máquina. Su función es formar un orificio o cavidad cilíndrica.",R.drawable.ic_broca));
        listaTrono.add(new EquipoTorno("Machuelo","Es una herramienta de corte para tallar (generar) cuerdas de tornillo interiores. Es una especie de tornillo de " +
                "acero aleado templado y rectificado, con ranuras a lo largo de la cuerda que permiten el desalojo de las rebabas arrancadas al generar la cuerda.",R.drawable.ic_machuelo));
        listaTrono.add(new EquipoTorno("Torno","Opera haciendo girar la pieza a mecanizar (sujeta en el cabezal o también llamado chuck fijada entre los puntos de " +
                "centraje) mientras una o varias herramientas de corte son empujadas en un movimiento regulado de avance contra la superficie de la pieza, cortando la viruta de acuerdo con las " +
                "condiciones tecnológicas de mecanizado adecuadas.",R.drawable.ic_torno_));
        listaTrono.add(new EquipoTorno("Torno Copiador","Máquina de mecanizado, aquel tipo de torno que, mediante el uso de un dispositivo hidráulico y electrónico, " +
                "permite el torneado de piezas hasta alcanzar una réplica de éstas.",R.drawable.ic_torno_copiado));
        listaTrono.add(new EquipoTorno("Torno Revólver","Es una variedad de torno diseñado para mecanizar piezas sobre las que sea posible el trabajo simultáneo de " +
                "varias herramientas con el fin de disminuir el tiempo total de mecanizado.",R.drawable.ic_torno_revolver));
        listaTrono.add(new EquipoTorno("Torno Vertical","Es un tipo de torno diseñado para mecanizar piezas grandes, que sujetan el plato de grandes dimensiones con " +
                "grapas u otros accesorios, y que por su magnitud o peso imposibilitan su fijación a un torno estándar.",R.drawable.ic_torno_vertical));
        listaTrono.add(new EquipoTorno("Torno CNC","Máquina herramienta del tipo torno que se utiliza para mecanizar piezas de revolución mediante un software de " +
                "computadora que utiliza datos alfa-numéricos, siguiendo los ejes cartesianos X, Y.",R.drawable.ic_tornocnc));
        listaTrono.add(new EquipoTorno("Fresadora","Máquina herramienta para realizar trabajos mecanizados por arranque de viruta mediante el movimiento de una herramienta" +
                " rotativa de varios filos de corte denominada fresa.",R.drawable.ic_fresa));
        listaTrono.add(new EquipoTorno("Fresadora CNC","Herramientas utilizadas en mayor medida para mecanizar. Las fresadoras CNC funcionan por arranque de viruta, " +
                "mediante el movimiento de una herramienta de rotación con varios labios/cortes ",R.drawable.ic_fresacnc));
        listaTrono.add(new EquipoTorno("Taladro de Banco","Es la versión estacionaria del taladro convencional. Las taladradoras de columna son las más usadas en talleres " +
                "gracias a la posibilidad de realizar en ellas los más variados trabajos, incluso de serie, con útiles adecuados.",R.drawable.ic_taladro));
        /* Añadir mas
        listaTrono.add(new EquipoTorno("","",R.drawable));
        listaTrono.add(new EquipoTorno("","",R.drawable));
        listaTrono.add(new EquipoTorno("","",R.drawable));
         */
    }
    public void mostrarLista(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterEquipoTorno = new AdapterEquipoTorno(getContext(), listaTrono);
        recyclerView.setAdapter(adapterEquipoTorno);
    }
    public void filtrar(String texto){
        ArrayList<EquipoTorno> filtrarLista = new ArrayList<>();
        for (EquipoTorno equipoTorno : listaTrono){
            if (equipoTorno.getTituloEquipoTorno().toLowerCase().contains(texto.toLowerCase())){
                filtrarLista.add(equipoTorno);
            }
        }
        adapterEquipoTorno.filtrar(filtrarLista);
    }
}