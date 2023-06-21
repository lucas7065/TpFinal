package Menu;

import BJ.Partida;
import JSON.ControladoraJSON;
import Jugador.ControladoraUsuario;
import Jugador.Usuario;

import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    static Scanner teclado;
    public static void iniciarMenu(){
        teclado = new Scanner(System.in);
        Usuario usuario = null;
        ControladoraJuego controladoraJuego = new ControladoraJuego();
        ControladoraUsuario controladoraUsuario = new ControladoraUsuario();

        controladoraUsuario = ControladoraJSON.leerArchivo();

        
        String seguir = "s";
        int eleccionUsuario = 0;

        while (seguir.equalsIgnoreCase("s")){
            System.out.println("Menu: " + "\n" +
                    "1. Ingresar" + "\n" +
                    "2. Registrarse");
            eleccionUsuario = teclado.nextInt();
            if (eleccionUsuario == 1){
                System.out.println("Bienvenido! Ingrese su usuario");
                teclado.nextLine();
                usuario = controladoraUsuario.loginUsuario(teclado.nextLine());
                if (usuario!=null){
                    System.out.println("1. JUGAR" + "\n" +
                            "2. MODIFICAR DATOS" + "\n" +
                            "3. SALIR");
                    teclado.nextLine();
                    eleccionUsuario = teclado.nextInt();

                   switch (eleccionUsuario){
                       case 1:
                           Partida partida = controladoraJuego.crearNuevaPartida(usuario);

                           System.out.println("Dinero disponible: " + usuario.getSaldo() + "\n" +
                                   "¿Cuanto desea apostar?");
                           // falta comprobacion de si tiene suficiente saldo disponible
                           teclado.nextLine();

                           partida.setApuesta(teclado.nextInt());

                           if (partida.iniciarPartida()){
                               System.out.println("BlackJack! Ganaste.");
                           }else {
                               System.out.println("Usted tiene: " + "\n" + usuario.listarMano());
                               System.out.println("Dealer: \n" + partida.getDealer().listarMano(usuario.isTurno()));

                               System.out.println("1. Pedir" + "\n" +
                                       "2. Plantarse");
                               eleccionUsuario = teclado.nextInt();

                               if (eleccionUsuario == 1){
                                   // agregarle carta a usuario
                               } else if (eleccionUsuario == 2) {
                                   // seguir con dealer
                               } else {
                                   System.out.println("Opcion incorrecta.");
                               }
                           }


                       case 2:
                           // funciones modificar
                       default:
                           break;
                   }





                }else {
                    System.out.println("Ese nombre de usuario no existe!");
                }


            }else if (eleccionUsuario == 2){
                System.out.println("Ingrese su nombre");
                usuario.setNombreCompleto(teclado.nextLine());
                //  con todos los atributos

                controladoraUsuario.registrarUsuario(usuario);
            }else{
                System.out.println("Opcion incorrecta.");
            }
            System.out.println("¿Desea continuar?");
            seguir = teclado.nextLine();
        }

    }
}
