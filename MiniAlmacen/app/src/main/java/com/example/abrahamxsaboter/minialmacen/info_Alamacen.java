package com.example.abrahamxsaboter.minialmacen;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class info_Alamacen extends AppCompatActivity implements View.OnClickListener{
    TextView nombre,desc,pro,cant,tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__alamacen);

        nombre = (TextView)findViewById(R.id.textoTitulo);
        desc = (TextView)findViewById(R.id.DescripcionAl);
        pro = (TextView)findViewById(R.id.TextoProducto);
        tipo = (TextView)findViewById(R.id.TextoTipoProducto);
        cant = (TextView)findViewById(R.id.TextoProductoCantidad);

        Bundle parametros = getIntent().getExtras();
        String nombre1 = parametros.getString("Nombre");
        String descrip = parametros.getString("descripcion");
        String produ = parametros.getString("tipo_pro");
        String can = parametros.getString("cantidad");

        String nombre2 = "ALMACEN DE "+nombre1;

        nombre.setText(nombre2);
        desc.setText(descrip);
        pro.setText(nombre1);
        cant.setText(can);
        tipo.setText(produ);

    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, Consultas.class);
        startActivity(intent);
        Toast.makeText(getBaseContext(),"Se ha unido al almacen", Toast.LENGTH_LONG).show();
        finish();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {

            Intent evento = new Intent(this, Consultas.class);

            startActivity(evento);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
