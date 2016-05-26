package co.idsoft.registrodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSiguiente;
    EditText txtNombre, txtTelefono, txtCorreo, txtdescripcion;
    DatePicker dpFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSiguiente =(Button) findViewById(R.id.btnSiguiente);
        txtNombre = (EditText) findViewById(R.id.nombre);
        txtCorreo = (EditText) findViewById(R.id.correo);
        txtTelefono =(EditText) findViewById(R.id.telefono);
        txtdescripcion = (EditText) findViewById(R.id.descripcion);
        dpFecha = (DatePicker) findViewById(R.id.date);

        btnSiguiente.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSiguiente:
                String nombre = txtNombre.getText().toString();
                String telefono = txtTelefono.getText().toString();
                String correo = txtCorreo.getText().toString();
                String descripcion = txtdescripcion.getText().toString();
                String fecha = String.valueOf(dpFecha.getDayOfMonth()) + "/" +
                        String.valueOf(dpFecha.getMonth() + 1) + "/" +
                        String.valueOf(dpFecha.getYear());

                Intent intent = new Intent(this,VisualizacionDeDatos.class);

                intent.putExtra("nombre", nombre);
                intent.putExtra("telefono", telefono);
                intent.putExtra("correo", correo);
                intent.putExtra("descripcion",descripcion);
                intent.putExtra("fecha",fecha);

                startActivity(intent);
                break;
        }
    }
}
