package com.hoscanoa.sqliteingresarlistar;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    EditText txtNombre, txtApellido, txtEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtApellido = (EditText)findViewById(R.id.txtApellido);
        txtEdad = (EditText)findViewById(R.id.txtEdad);
    }

    public void guardarDatos(View view)
    {
        String nombre = txtNombre.getText().toString();
        String apellido = txtApellido.getText().toString();
        int edad = Integer.parseInt(txtEdad.getText().toString());

        BaseHelper baseHelper = new BaseHelper(this,"DEMODB",null,1);
        SQLiteDatabase db = baseHelper.getWritableDatabase();
        if(db!=null)
        {
            ContentValues r = new ContentValues();
            r.put("Nombre",nombre);
            r.put("Apellido",apellido);
            r.put("Edad",edad);

            long i = db.insert("Personas",null,r);
            if(i>0)
            {
                Toast.makeText(this,"Registro Insertado",Toast.LENGTH_SHORT).show();

            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_listar) {
            startActivity(new Intent(this, SegundaActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
