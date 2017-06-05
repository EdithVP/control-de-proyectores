package com.example.abrahamxsaboter.minialmacen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class ActualizarDatos extends AppCompatActivity {

    private TextInputEditText correo;

    private String datoCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos);
        //Aplica el botón atras en el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //Buscamos la id del TextEdit
        correo = (TextInputEditText) findViewById(R.id.id_app_correo);


    }
    public void ActualizarDatosCuenta(View v) {

        SqLiteHelper admin=new SqLiteHelper(this,"almacen",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String email = correo.getText().toString();

        Cursor fila;
        fila=db.rawQuery("SELECT id,correo FROM usuario_almacen WHERE correo='" +
                email + "';", null);
        //preguntamos si el cursor tiene algun valor almacenado
        if(fila.moveToFirst()==true) {
            //capturamos los valores del cursos y lo almacenamos en variable
            String id = fila.getString(0);
            String correo1 = fila.getString(0);

            //preguntamos si los datos ingresados son iguales
            if (email.equals(correo1)) {
                //si son iguales entonces vamos a otra ventana
                //Menu es una nueva actividad empty
                Intent ven = new Intent(this, actualizar_datos3.class);
                ven.putExtra("id",id);
                startActivity(ven);
                //limpiamos las las cajas de texto
                correo.setText("");
                Toast.makeText(this,"Prosigamos ",Toast.LENGTH_SHORT).show();

            }
        }
    }

    public void CancelarActu(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(getBaseContext(),"Actualización Cancelada", Toast.LENGTH_LONG).show();
        finish();
    }

    /*//Bloquea el boton "Atras" del telefono
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //Esto es lo que hace mi botón al pulsar ir a atrás (UN mensaje)
            //Toast.makeText(getApplicationContext(), "Click en Salir", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/
}
