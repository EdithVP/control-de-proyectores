package com.example.abrahamxsaboter.minialmacen;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Consultas extends AppCompatActivity {

    ArrayList<AlmacenesCon> almacenes;
    private DataCurrentSql data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        //Aplica el botón atras en el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        data = new DataCurrentSql(this);
        data.open();
        almacenes = data.GetConsultaPro();

        /*
        almacenes = new ArrayList();
        almacenes.add(new infoAlmacen("ALMACEN DE PROYECTORES", "Almacén dedicado a contener\nproyectores para uso\nacadémico y con motivos\neducativos.", "PROYECTORES", "10"));
        almacenes.add(new infoAlmacen("ALMACEN DE TELEVISIONES", "Almacén dedicado a contener\ntelevisores para uso\nacadémico y con motivos\neducativos o entretenimiento.", "TELEVISORES", "15"));
        almacenes.add(new infoAlmacen("ALMACEN DE HERRAMIENTAS", "Almacén dedicado a contener\nherramientas para uso\nprofecional y con motivos\ntecnicos y auxiliares.", "HERRAMIENTAS", "150"));
        almacenes.add(new infoAlmacen("ALMACEN DE CABLES DE VISION", "Almacén dedicado a contener\ncables de visión para uso\nacademico y con motivos\neducativos y entretenimiento.", "CABLES DE VIDEO", "23"));
        almacenes.add(new infoAlmacen("ALMACEN DE TORNOS Y FREZADORAS", "Almacén dedicado a contener\ntornos y frezadoras para uso\nacademico y con motivos\neducativos y profecionales.", "TORNOS Y FREZADORAS", "12"));
        */
        ArrayList<String> nombres = new ArrayList<String>();

        for (AlmacenesCon almacenesCon : almacenes) {
            nombres.add("ALMACEN DE "+almacenesCon.getNombre());
        }
        //referencia el id del menu de activityMain.xml
        ListView listViewAlmacenes = (ListView) findViewById(R.id.ListConsulta);
        listViewAlmacenes.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, nombres));
        listViewAlmacenes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //colocalo como esta en el paquete de java
                //donde estas      donde quieres ir
                Intent evento = new Intent(Consultas.this, info_Alamacen.class);
                evento.putExtra("Nombre", almacenes.get(position).getNombre());
                evento.putExtra("descripcion", almacenes.get(position).getDescripcion());
                evento.putExtra("tipo_pro", almacenes.get(position).getTipo_pro());
                evento.putExtra("cantidad", almacenes.get(position).getCantidad());

                //con este se inicia el metodo
                startActivity(evento);
                finish();
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {

                    Intent evento = new Intent(this, menu_usuario.class);

                    startActivity(evento);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}