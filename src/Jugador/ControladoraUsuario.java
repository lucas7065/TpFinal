package Jugador;

import Archivos.ControladoraArchivos;
import ClasesGenericas.GenericaMap;
import Exceptions.ContraseñaIncorrectaException;
import Exceptions.NombreDeUsuarioExistenteException;
import Exceptions.UsuarioNoExisteException;

import java.util.ArrayList;

public class ControladoraUsuario {
    GenericaMap<String, Usuario> usuarios;

    public ControladoraUsuario(GenericaMap<String,Usuario> u) {
        usuarios = u;
    }

    public ControladoraUsuario(){
        usuarios = new GenericaMap<String, Usuario>();
    }

    /**
     *
     * @param username
     * @return el usuario
     * @throws ContraseñaIncorrectaException cuando la contraseña asociada al nombre de usuario no es correcta
     */
    public Usuario loginUsuario(String username, String contraseña) throws UsuarioNoExisteException, ContraseñaIncorrectaException {
        Usuario aux= null;
        aux = buscarUsuario(username);
        comprobarContraseña(aux,contraseña);
        return aux;
    }

    /**
     * metodo para registrar un nuevo usuario
     * comprueba que el nombre de usuario no exista
     * y guarda el nuevo usuario en el archivo
     * @param usuario
     * @throws NombreDeUsuarioExistenteException cuando el nombre de usuario ya existe
     */
    public boolean registrarUsuario(Usuario usuario) throws NombreDeUsuarioExistenteException {
        boolean rta=false;
        comprobarUsuario(usuario.getNombreDeUsuario());
        usuarios.agregar(usuario.getNombreDeUsuario(), usuario);
        guardarUsuario();
        return rta;

    }
    public void guardarUsuario(){
        ArrayList<Usuario> aux = new ArrayList<>();
        aux = usuarios.pasarValoresAunArray();
        ControladoraArchivos.grabarUsuarios(aux);
    }

    public void comprobarUsuario(String username) throws NombreDeUsuarioExistenteException{
        if(usuarios.buscar(username)) {
            throw new NombreDeUsuarioExistenteException("El nombre de usuario ya existe. Ingrese un nuevo nombre.");
        }
    }

    public boolean comprobarContraseña(Usuario aux, String contraseña) throws ContraseñaIncorrectaException{
        boolean rta=false;
        if(aux!=null){
            if(aux.getPassword().equalsIgnoreCase(contraseña)== true){
                rta=true;
            }
            else {
                throw new ContraseñaIncorrectaException("La contraseña es incorrecta, ingrese nuevamente");
            }
        }
        return rta;
    }


    public boolean comprobarMail(String email){
        boolean rta = false;
        if (email.contains("@") && email.contains(".")){
            rta = true;
        }
        return rta;
    }


    public Usuario modificarNombreDeUsuario(String viejoUsername, String nuevoUsername){
        Usuario aux= null;
        String mensaje="";
        try{
            aux= buscarUsuario(viejoUsername);
            if(aux!=null){
                usuarios.eliminarKey(viejoUsername);
                aux.setNombreDeUsuario(nuevoUsername);
                usuarios.agregar(aux.getNombreDeUsuario(), aux);
                ArrayList<Usuario> arreglo=new ArrayList<>();
                arreglo= usuarios.pasarValoresAunArray();
                ControladoraArchivos.grabarUsuarios(arreglo);
                mensaje="Nombre de usuario cambiado con éxito";
            }
        }
        catch (UsuarioNoExisteException e){
            mensaje=e.getMessage();
        }
        return aux;
    }
    public String modificarEmail(String username, String email){
        Usuario aux= null;
        String mensaje="";
        try {
            aux= buscarUsuario(username);
            if(aux!=null){
                aux.setEmail(email);
                usuarios.reemplazarValor(aux.getNombreDeUsuario(), aux);
                ArrayList<Usuario> arreglo=new ArrayList<>();
                arreglo= usuarios.pasarValoresAunArray();
                ControladoraArchivos.grabarUsuarios(arreglo);
                mensaje="Email cambiado con éxito.";
            }
        }
        catch(UsuarioNoExisteException e){
            mensaje= e.getMessage();
        }

        return mensaje;
    }
    public String modificarContraseña(String username, String contraseña){
        Usuario aux= null;
        String mensaje="";
        try {
            aux= buscarUsuario(username);
            if(aux!=null){
                aux.setPassword(contraseña);
                usuarios.reemplazarValor(aux.getNombreDeUsuario(), aux);
                ArrayList<Usuario> arreglo=new ArrayList<>();
                arreglo= usuarios.pasarValoresAunArray();
                ControladoraArchivos.grabarUsuarios(arreglo);
                mensaje="Contraseña cambiada con éxito.";
            }
        }
        catch(UsuarioNoExisteException e){
            mensaje= e.getMessage();
        }

        return mensaje;
    }
    public String modificarNombre(String username, String nombreCompleto){
        Usuario aux= null;
        String mensaje="";
        try {
            aux=buscarUsuario(username);
            if(aux!=null){
                aux.setNombreCompleto(nombreCompleto);
                usuarios.reemplazarValor(aux.getNombreDeUsuario(), aux);
                ArrayList<Usuario> arreglo=new ArrayList<>();
                arreglo= usuarios.pasarValoresAunArray();
                ControladoraArchivos.grabarUsuarios(arreglo);
                mensaje="Nombre cambiado con éxito.";
            }
        }
        catch(UsuarioNoExisteException e){
            mensaje= e.getMessage();
        }

        return mensaje;
    }

    public Usuario buscarUsuario(String username) throws UsuarioNoExisteException{
        Usuario aux=null;
        aux= usuarios.getElemento(username);
        if(aux==null){
            throw new UsuarioNoExisteException("No se encontro el usuario.");
        }
        return aux;
   }

    public String listarUsuarios(){
        return usuarios.listar();
    }

}
