package com.magove.tiempo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
private Button btn_proyectos,btn_tiempos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn_proyectos= findViewById(R.id.id_btnProyectos);
        btn_tiempos=findViewById(R.id.id_btntimepos);
    }
    public void ir_proyectos(View v){
        Intent intent = new Intent(this,Proyectos.class);
        startActivity(intent);
        finish();
    }
    public void ir_tiempos(View v){
        Intent intent = new Intent(this,ControlTeimpos.class);
        startActivity(intent);
        finish();
    }
}