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
import android.widget.TextView;
import android.widget.Toast;

public class actualizar_datos3 extends AppCompatActivity {

    private TextView correo;
    private String datoCorreo;
    private TextInputEditText pass1,pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos3);
        pass1 = (TextInputEditText)findViewById(R.id.id_app_pass);
        pass2 = (TextInputEditText)findViewById(R.id.id_app_pass2);

    }
    public void ActualizarDatosCuenta(View v) {
        SqLiteHelper admin=new SqLiteHelper(this,"almacen",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String contra = pass1.getText().toString();
        String contra2 = pass2.getText().toString();
        Bundle parametros = getIntent().getExtras();
        String id = parametros.getString("id");

        if(contra.equals(contra2) == true){
                    Cursor fila;
                    fila=db.rawQuery("UPDATE usuario_almacen SET contrasena='"+contra+"' WHERE id_user='"+id+"';", null);
                    Toast.makeText(this,"Contraseña actualizada con exito.",Toast.LENGTH_SHORT).show();
                    Intent evento = new Intent(this,MainActivity.class);
                    startActivity(evento);
        }else if (contra.equals(contra2) == false){
            Toast.makeText(this,"Las contraseñas no son iguales.",Toast.LENGTH_SHORT).show();
            Intent evento = new Intent(this,actualizar_datos3.class);
            evento.putExtra("id",id);
            startActivity(evento);
        }
    }

    public void CancelarActu(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(getBaseContext(),"Actualización Cancelada", Toast.LENGTH_LONG).show();
        finish();
    }

    //Bloquea el boton "Atras" del telefono
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //Esto es lo que hace mi botón al pulsar ir a atrás (UN mensaje)
            Toast.makeText(getBaseContext(),"Por favor, actualice su contraseña", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
