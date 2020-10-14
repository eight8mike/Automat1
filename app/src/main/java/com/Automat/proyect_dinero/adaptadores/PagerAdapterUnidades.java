package com.Automat.proyect_dinero.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Automat.proyect_dinero.fragments.TabsUnidades.Tab1UnidadesFragment;
import com.Automat.proyect_dinero.fragments.TabsUnidades.Tab2UnidadesFragment;
import com.Automat.proyect_dinero.fragments.TabsUnidades.Tab3UnidadesFragment;

public class PagerAdapterUnidades extends FragmentPagerAdapter {
    int numoftabs;

    public PagerAdapterUnidades(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numoftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tab1UnidadesFragment();
            case 1:
                return new Tab2UnidadesFragment();
            case 2:
                return new Tab3UnidadesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}
