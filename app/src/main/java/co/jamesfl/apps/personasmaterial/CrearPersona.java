package co.jamesfl.apps.personasmaterial;

import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class CrearPersona extends AppCompatActivity {

    private EditText cajaNombre, cajaApellido;
    private TextInputLayout icajaNombre, icajaApellido;
    private ArrayList<Integer> fotos;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);

        res = this.getResources();
        fotos = new ArrayList<>();
        fotos.add(R.drawable.carro1);
        fotos.add(R.drawable.carro2);
        fotos.add(R.drawable.carro3);
        fotos.add(R.drawable.carro4);

        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);

        icajaNombre = (TextInputLayout)findViewById(R.id.cajaNombre);
        icajaApellido = (TextInputLayout)findViewById(R.id.cajaApellido);
    }

    public void guardar(View v){
        String nombre, apellido;
        nombre = cajaNombre.getText().toString();
        apellido = cajaApellido.getText().toString();
        Persona p = new Persona(metodos.fotoAleatoria(fotos), nombre, apellido);
        p.guardar();
        Snackbar.make(v, res.getString(R.string.msjguardado), Snackbar.LENGTH_SHORT).setAction("Action", null).show();
        limpiar();
    }

    public void limpiar(View v){
        limpiar();
    }

    private void limpiar(){
        cajaNombre.setText("");
        cajaApellido.setText("");
        cajaNombre.requestFocus();
    }
}
