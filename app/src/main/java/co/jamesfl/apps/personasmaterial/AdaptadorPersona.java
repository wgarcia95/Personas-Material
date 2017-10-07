package co.jamesfl.apps.personasmaterial;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 07/10/2017.
 */

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder> {
    private ArrayList<Persona> personas;
    private Resources res;

    public AdaptadorPersona(ArrayList<Persona> personas, Context contexto) {
        this.personas = personas;
        this.res = contexto.getResources();
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_persona, parent, false);
        return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        final Persona p = personas.get(position);
        holder.foto.setImageDrawable(ResourcesCompat.getDrawable(res, p.getFoto(),null));
        holder.nombre.setText(p.getNombre());
        holder.apellido.setText(p.getApellido());
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends ViewHolder{

        private ImageView foto;
        private TextView nombre;
        private TextView apellido;
        private View v;

        public PersonaViewHolder(View itemView) {
            super(itemView);

            v = itemView;
            foto = (ImageView)v.findViewById(R.id.idfoto);
            nombre = (TextView)v.findViewById(R.id.txtNombre);
            apellido = (TextView)v.findViewById(R.id.txtApellido);

        }
    }
}
