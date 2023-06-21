package Jugador;

import Archivos.ControladoraArchivos;
import Exceptions.ContraseñaIncorrectaException;
import Exceptions.NombreDeUsuarioExistenteException;
import Exceptions.UsuarioNoExisteException;

import java.util.ArrayList;

public class ControladoraUsuario {
    GenericaMap<String, Usuario> usuarios;

    public ControladoraUsuario() {
        usuarios = new GenericaMap<String, Usuario>();
    }

    /**
     *
     * @param username
     * @return el usuario
     * @throws ContraseñaIncorrectaException cuando la contraseña asociada al nombre de usuario no es correcta
     */
    public Usuario loginUsuario(String username, String contraseña) {
        Usuario aux= null;
        try {
            aux = buscarUsuario(username);
            comprobarContraseña(aux,contraseña);
        }
        catch(UsuarioNoExisteException e){
            System.out.println(e.getMessage());
        }
        catch(ContraseñaIncorrectaException e){
            System.out.println(e.getMessage());
        }
        return aux;
    }

    public String registrarUsuario(Usuario usuario){
        boolean rta=false;
        String message="";
        try {
            rta = comprobarUsuario(usuario.getNombreDeUsuario());
            usuarios.agregar(usuario.getNombreDeUsuario(), usuario);
            ArrayList<Usuario> aux=new ArrayList<>();
            aux= usuarios.pasarValoresAunArray();
            ControladoraArchivos.grabar(aux);
        }
        catch(NombreDeUsuarioExistenteException e){
            message=e.getMessage();

        }
        return message;

    }

    public boolean comprobarUsuario(String username) throws NombreDeUsuarioExistenteException{
        boolean rta=false;
        rta= usuarios.contains(username);
        if(rta) {
            throw new NombreDeUsuarioExistenteException("El nombre de usuario ya existe. Ingrese un nuevo nombre.");
        }
        return rta;
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
    public Usuario modificarNombreDeUsuario(String nuevoUsername, String viejoUsername){
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
                ControladoraArchivos.grabar(arreglo);
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
                ControladoraArchivos.grabar(arreglo);
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
                ControladoraArchivos.grabar(arreglo);
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
                ControladoraArchivos.grabar(arreglo);
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
