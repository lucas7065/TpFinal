package Jugador;

import Archivos.ControladoraArchivos;

import java.util.ArrayList;
import java.util.HashMap;

public class ControladoraUsuario {

    private HashMap<String, Usuario> usuarios;

    public ControladoraUsuario(){
        usuarios = new HashMap<>();
    }

    public static boolean loginUsuario(String username){
        boolean rta=false;
        rta= comprobarUsuario(username);
        return rta;
    }

    public static boolean comprobarUsuario(String username){

        // adaptar a hashamap
        boolean rta=false;
        ArrayList<Usuario> usuarios= new ArrayList<>();
        usuarios= ControladoraArchivos.leer("usuarios.dat");
        for(Usuario u: usuarios){
            if(u.getNombreDeUsuario().equals(username)){
                rta=true;
            }
        }
        return rta;
    }

    // falta registrar


}
