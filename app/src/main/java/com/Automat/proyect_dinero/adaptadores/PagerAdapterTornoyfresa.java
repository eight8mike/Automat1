package com.Automat.proyect_dinero.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Automat.proyect_dinero.fragments.TabsTornofresa.Tab1TornoFragment;
import com.Automat.proyect_dinero.fragments.TabsTornofresa.Tab2TornoFragment;
import com.Automat.proyect_dinero.fragments.TabsTornofresa.Tab3TornoFragment;

public class PagerAdapterTornoyfresa extends FragmentPagerAdapter {
    int numoftabs;

    public PagerAdapterTornoyfresa(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numoftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tab1TornoFragment();
            case 1:
                return new Tab2TornoFragment();
            case 2:
                return new Tab3TornoFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}
