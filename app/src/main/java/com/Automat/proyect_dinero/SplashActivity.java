package com.Automat.proyect_dinero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Para que salga a pantalla completa
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        // Agregar animaciones

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        // Referenciar los id

        TextView PorTextView =findViewById(R.id.PorTextView);
        TextView FutureFixTextView =findViewById(R.id.FutureFixTextView);
        ImageView LogoImageView = findViewById(R.id.LogoImageView);

        // Asignar animaciones

        PorTextView.setAnimation(animation2);
        FutureFixTextView.setAnimation(animation2);
        LogoImageView.setAnimation(animation1);

        // Poner el tiempo para que pase a la siguiente actividad

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1700);
    }
}