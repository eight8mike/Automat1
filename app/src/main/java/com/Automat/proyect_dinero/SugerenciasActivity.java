package com.Automat.proyect_dinero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SugerenciasActivity extends Activity {

    String correo,contrasena;
    EditText mensaje;
    Button button;
    TextView textView;
    javax.mail.Session session;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias);

        mensaje = findViewById(R.id.descripcion_sugerencias);
        button = findViewById(R.id.enviar_sugerencias);
        textView = findViewById(R.id.boton_atras2);
        correo = "aheilyx@gmail.com";
        contrasena = "Disenos2020";

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties properties = new Properties();
                properties.put("mail.smtp.hots","smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port","465");
                properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.port","465");
                try {
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contrasena);
                        }
                    });

                    if (session!=null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Sugerencias para AUTOMAT");
                        message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("futurefix.19@gmail.com"));
                        message.setContent(mensaje.getText().toString(),"text/html; charset=utf-8");
                        Transport.send(message);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
                mensaje.setText(null);
            }
        });

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SugerenciasActivity.this, AyudaActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void clisdfr(View view) {
    }

    public void clickick(View view) {
    }
}
