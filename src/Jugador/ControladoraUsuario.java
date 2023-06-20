package Jugador;

import Archivos.ControladoraArchivos;

import java.util.ArrayList;
import java.util.HashMap;

public class ControladoraUsuario {

    GenericaMap<String, Usuario> usuarios;

    public ControladoraUsuario() {
        this.usuarios = new GenericaMap<>();
    }

    public Usuario loginUsuario(String username) {
        Usuario rta = null;
        rta = usuarios.getElemento(username);
        return rta;
    }

    public boolean registrarUsuario(Usuario usuario) {
        boolean rta = false;
        rta = comprobarUsuario(usuario.getNombreDeUsuario());
        if (rta == false) {
            usuarios.agregar(usuario.getNombreDeUsuario(), usuario);
            ArrayList<Usuario> aux = new ArrayList<>();
            aux = usuarios.pasarValoresAunArray();
            ControladoraArchivos.grabar(aux);
        }
        return rta;
    }

    public boolean comprobarUsuario(String username) {
        boolean rta = false;
        rta = usuarios.contains(username);
        return rta;

    }

    public String listarUsuarios() {
        return usuarios.listar();
    }
}