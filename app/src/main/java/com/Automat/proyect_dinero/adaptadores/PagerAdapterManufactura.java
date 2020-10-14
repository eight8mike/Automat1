package com.Automat.proyect_dinero.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Automat.proyect_dinero.fragments.TabsManufactura.Tab1ManufacturaFragment;
import com.Automat.proyect_dinero.fragments.TabsManufactura.Tab2ManufacturaFragment;
import com.Automat.proyect_dinero.fragments.TabsManufactura.Tab3ManufacturaFragment;

public class PagerAdapterManufactura extends FragmentPagerAdapter {
    int numoftabs;

    public PagerAdapterManufactura(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numoftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tab1ManufacturaFragment();
            case 1:
                return new Tab2ManufacturaFragment();
            case 2:
                return new Tab3ManufacturaFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}
