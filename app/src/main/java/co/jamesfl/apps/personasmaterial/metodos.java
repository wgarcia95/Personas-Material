package co.jamesfl.apps.personasmaterial;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by android on 07/10/2017.
 */

public class metodos {
    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return fotos.get(fotoSeleccionada);
    }
}
