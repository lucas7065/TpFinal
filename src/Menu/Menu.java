package Menu;

import BJ.Partida;
import Jugador.ControladoraUsuario;
import Jugador.Usuario;

import java.util.Scanner;

public class Menu {
    static Scanner teclado;
    public static void iniciarMenu(){
        teclado = new Scanner(System.in);
        Usuario usuario = null;
        ControladoraJuego controladoraJuego = new ControladoraJuego();
        // 1 para login o 2 para registrarse

        Partida partida = controladoraJuego.crearNuevaPartida(usuario);

        System.out.println("cuanto apostas?");
        partida.setApuesta(teclado.nextInt());


        if (partida.iniciarPartida()){
            System.out.println("ganaste!");
        }else {
            System.out.println("desea otra carta?");
            partida.mostrarManoDealer();
        }

        if (partida.getDealer().)



    }
}
