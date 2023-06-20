package Menu;

import BJ.Partida;
import JSON.ControladoraJSON;
import Jugador.ControladoraUsuario;
import Jugador.Usuario;

import java.util.Scanner;

public class Menu {
    static Scanner teclado;
    public static void iniciarMenu(){
        teclado = new Scanner(System.in);
        Usuario usuario = null;
        ControladoraJuego controladoraJuego = new ControladoraJuego();
        ControladoraUsuario controladoraUsuario = new ControladoraUsuario();

        controladoraUsuario = ControladoraJSON.leerArchivo();

        
        String seguir = "s";
        int eleccionUsuario = 0;
        String jugar = ""; // para pedir o plantarse.

        while (seguir.equalsIgnoreCase("s")){
            System.out.println("Menu: " + "\n" +
                    "1. Ingresar" + "\n" +
                    "2. Registrarse");
            eleccionUsuario = teclado.nextInt();
            if (eleccionUsuario == 1){
                System.out.println("Bienvenido! Ingrese su usuario");
                usuario = controladoraUsuario.loginUsuario(teclado.nextLine());
                if (usuario!=null){
                    Partida partida = controladoraJuego.crearNuevaPartida(usuario);

                    System.out.println("Dinero disponible: " + usuario.getSaldo() + "\n" +
                            "¿Cuanto desea apostar?");
                    // falta comprobacion de si tiene suficiente saldo disponible

                    partida.setApuesta(teclado.nextInt());

                    if (partida.iniciarPartida()){
                        System.out.println("BlackJack! Ganaste.");
                    }else {
                        System.out.println("Usted tiene: " + usuario.listarMano());
                        System.out.println("Dealer: " + partida.mostrarManoDealer());
                    }
                }else {
                    System.out.println("Ese nombre de usuario no existe!");
                }


            }else if (eleccionUsuario == 2){
                // registrar usuario
            }else{
                System.out.println("Opcion incorrecta.");
            }
            System.out.println("¿Desea continuar?");
            seguir = teclado.nextLine();
        }










    }
}
