package co.jamesfl.apps.personasmaterial;

import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearPersona extends AppCompatActivity {

    private EditText cajaCedula, cajaNombre, cajaApellido;
    private TextInputLayout icajaCedula, icajaNombre, icajaApellido;
    private ArrayList<Integer> fotos;
    private String[] sexo_;
    private Spinner spnsexo;
    private ArrayAdapter<String> adapter;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);

        res = this.getResources();


        cajaCedula = (EditText)findViewById(R.id.txtCedula);
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);

        icajaCedula = (TextInputLayout)findViewById(R.id.cajaCedula);
        icajaNombre = (TextInputLayout)findViewById(R.id.cajaNombre);
        icajaApellido = (TextInputLayout)findViewById(R.id.cajaApellido);

        spnsexo = (Spinner)findViewById(R.id.spnSexo);
        sexo_ = res.getStringArray(R.array.opc_sexo);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sexo_);
        spnsexo.setAdapter(adapter);

        iniciarFotos();
    }

    public void iniciarFotos(){
        fotos = new ArrayList<>();
        fotos.add(R.drawable.carro1);
        fotos.add(R.drawable.carro2);
        fotos.add(R.drawable.carro3);
        fotos.add(R.drawable.carro4);
    }

    public void guardar(View v){
        String cedula, nombre, apellido;
        int sexo;
        cedula = cajaCedula.getText().toString();
        nombre = cajaNombre.getText().toString();
        apellido = cajaApellido.getText().toString();
        sexo = spnsexo.getSelectedItemPosition();
        Persona p = new Persona(metodos.fotoAleatoria(fotos), cedula, nombre, apellido, sexo);
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
