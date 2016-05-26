package co.idsoft.registrodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class VisualizacionDeDatos extends AppCompatActivity implements View.OnClickListener {

    TextView txtNombre, txtTelefono, txtCorreo, txtDescripcion, txtFecha;
    Button btnEditar;
    Intent intent;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacion_de_datos);
        txtNombre  = (TextView) findViewById(R.id.nombre);
        txtFecha  = (TextView) findViewById(R.id.fecha);
        txtCorreo  = (TextView) findViewById(R.id.correo);
        txtDescripcion = (TextView) findViewById(R.id.descripcion);
        txtTelefono  = (TextView) findViewById(R.id.telefono);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(this);

        intent = getIntent();
        bundle = intent.getExtras();

        if(bundle!=null){
            String nombre = (String) bundle.get("nombre");
            String telefono = txtTelefono.getText().toString() + " " + (String) bundle.get("telefono");
            String correo = txtCorreo.getText().toString() + " " + (String) bundle.get("correo");
            String descripcion = txtDescripcion.getText().toString() + " " + (String) bundle.get("descripcion");
            String fecha = txtFecha.getText().toString() + (String) bundle.get("fecha");

            txtNombre.setText(nombre);
            txtFecha.setText(fecha);
            txtTelefono.setText(telefono);
            txtCorreo.setText(correo);
            txtDescripcion.setText(descripcion);

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditar:
                finish();
                break;
        }
    }
}
