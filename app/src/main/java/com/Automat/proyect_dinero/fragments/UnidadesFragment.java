package com.Automat.proyect_dinero.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.Automat.proyect_dinero.adaptadores.PagerAdapterUnidades;
import com.Automat.proyect_dinero.R;
import com.google.android.material.tabs.TabLayout;

public class UnidadesFragment extends Fragment{

    TabLayout tabLayout;
    ViewPager viewPager;

    PagerAdapterUnidades pagerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.unidades_fragment, container, false);
        tabLayout = view.findViewById(R.id.tabLayout_unidades);
        viewPager = view.findViewById(R.id.viewPager_unidades);

        pagerAdapter = new PagerAdapterUnidades(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if (tab.getPosition() == 1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if (tab.getPosition() == 2){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return view;
    }
}

