package com.Automat.proyect_dinero.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Automat.proyect_dinero.fragments.TabsMetrologia.Tab1MetrologiaFragment;
import com.Automat.proyect_dinero.fragments.TabsMetrologia.Tab2MetrologiaFragment;
import com.Automat.proyect_dinero.fragments.TabsMetrologia.Tab3MetrologiaFragment;
public class PagerAdapterMetrologia extends FragmentPagerAdapter {
    int numoftabs;

    public PagerAdapterMetrologia(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numoftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tab1MetrologiaFragment();
            case 1:
                return new Tab2MetrologiaFragment();
            case 2:
                return new Tab3MetrologiaFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}
