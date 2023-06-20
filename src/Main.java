import Archivos.ControladoraArchivos;
import BJ.Mazo;
import JSON.ConsumoAPI;
import JSON.ControladoraJSON;
import Jugador.ControladoraUsuario;
import Jugador.Usuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Usuario u1=new Usuario();
        u1.setNombreDeUsuario("usuario1");
        Usuario u2=new Usuario();
        u2.setNombreDeUsuario("usuario2");
        Usuario u3=new Usuario();
        u3.setNombreDeUsuario("usuario3");

        ArrayList<Usuario>usuarios=new ArrayList<>();
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);

        ControladoraArchivos.grabar(usuarios);
        boolean rta= false;
        rta= ControladoraUsuario.loginUsuario("usuario4");


        Mazo mazo = new Mazo();

        mazo.verMazo();

        System.out.println("La respuesta es "+ rta);






    }
}