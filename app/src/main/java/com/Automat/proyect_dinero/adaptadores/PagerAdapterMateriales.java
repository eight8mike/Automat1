package com.Automat.proyect_dinero.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Automat.proyect_dinero.fragments.TabsMateriales.Tab1MaterialesFragment;
import com.Automat.proyect_dinero.fragments.TabsMateriales.Tab2MaterialesFragment;
import com.Automat.proyect_dinero.fragments.TabsMateriales.Tab3MaterialesFragment;
import com.Automat.proyect_dinero.fragments.TabsMateriales.Tab4Materiales;

public class PagerAdapterMateriales extends FragmentPagerAdapter {
    int numoftabs;

    public PagerAdapterMateriales(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numoftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tab1MaterialesFragment();
            case 1:
                return new Tab2MaterialesFragment();
            case 2:
                return new Tab3MaterialesFragment();
            case 3:
                return new Tab4Materiales();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}
