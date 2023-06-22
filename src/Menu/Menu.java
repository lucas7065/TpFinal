package Menu;

import Archivos.ControladoraArchivos;
import BJ.Partida;
import Exceptions.ContraseñaIncorrectaException;
import Exceptions.DineroInsuficienteException;
import Exceptions.NombreDeUsuarioExistenteException;
import Exceptions.UsuarioNoExisteException;
import JSON.ControladoraJSON;
import Jugador.ControladoraUsuario;
import Jugador.Usuario;

import java.util.Scanner;

public class Menu {
    static Scanner teclado;
    /*
    public static void iniciarMenu(){
        teclado = new Scanner(System.in);
        Usuario usuario = null;
        ControladoraJuego controladoraJuego = new ControladoraJuego();
        ControladoraUsuario controladoraUsuario = new ControladoraUsuario();

        controladoraUsuario = ControladoraJSON.leerArchivo();


        String seguir = "s";
        int eleccionUsuario = 0;

        while (seguir.equalsIgnoreCase("s")){

            menuPrincipal();
            eleccionUsuario = teclado.nextInt();
            if (eleccionUsuario == 1){
                System.out.println("Bienvenido! Ingrese su usuario y contraseña");
                teclado.nextLine();
                usuario = controladoraUsuario.loginUsuario(teclado.nextLine(), teclado.nextLine());
                if (usuario!=null){
                    System.out.println("1. JUGAR" + "\n" +
                            "2. MODIFICAR DATOS" + "\n" +
                            "3. SALIR");
                    eleccionUsuario = teclado.nextInt(;

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

     */

    public static void iniciarMenu(){
        teclado = new Scanner(System.in);
        Usuario usuario = null;
        ControladoraJuego controladoraJuego = new ControladoraJuego();

        ControladoraUsuario controladoraUsuario = new ControladoraUsuario(ControladoraArchivos.leerUsuarios());
        //controladoraUsuario = ControladoraJSON.leerArchivo();

        //controladoraJuego.asignarPartidas(controladoraUsuario);

        System.out.println(controladoraUsuario.listarUsuarios());



        String seguir = "s";
        int eleccionUsuario = 0;

        usuario = ingresar(controladoraUsuario);

        while (seguir.equalsIgnoreCase("s")){
            if (usuario != null){
                menuPrincipal(usuario, controladoraJuego);
            }
            System.out.println("Si desea seguir jugando ingrese 's'");
            teclado.nextLine();
            seguir = teclado.nextLine();
        }

    }

    public static Usuario ingresar(ControladoraUsuario cu) {
        Usuario usuario = null;
        boolean verificacion = false;
        int eleccionUsuario = 0;

        while (verificacion != true) {
            System.out.println("¡Bienvenido!" + "\n" +
                    "Menu: " + "\n" +
                    "1. Ingresar" + "\n" +
                    "2. Registrarse");
            eleccionUsuario = teclado.nextInt();
            if (eleccionUsuario == 1) {
                System.out.println("Ingrese su usuario y contraseña");
                teclado.nextLine();
                try {
                    usuario = cu.loginUsuario(teclado.nextLine(), teclado.nextLine());
                    verificacion = true;
                } catch (UsuarioNoExisteException e) {
                    System.out.println(e.getMessage());
                } catch (ContraseñaIncorrectaException e) {
                    System.out.println(e.getMessage());
                }
            } else if (eleccionUsuario  == 2){
                System.out.println("Ingrese un nombre de usuario unico e irrepetible");
                usuario.setNombreDeUsuario(teclado.nextLine());
                System.out.println("Ingrese su nombre completo");
                usuario.setNombreCompleto(teclado.nextLine());
                System.out.println("Ingrese su email");
                usuario.setEmail(teclado.nextLine());
                System.out.println("Ingrese su contraseña");
                usuario.setPassword(teclado.nextLine());

                cu.registrarUsuario(usuario); // try catch
            } else {
                System.out.println("Opcion inexistente");
            }
        }
        return usuario;

    }

    public static void menuPrincipal(Usuario usuario, ControladoraJuego cj){
        int eleccionUsuario = 0;
        System.out.println("1. JUGAR" + "\n" +
                "2. MODIFICAR DATOS" + "\n" +
                "3. SALIR");
        eleccionUsuario = teclado.nextInt();

        switch (eleccionUsuario){
            case 1:
                Partida partida = cj.crearNuevaPartida(usuario);
                usuario.setTurno(true);

                while (partida.getApuesta() == 0){
                    System.out.println("Dinero disponible: " + usuario.getSaldo() + "\n" +
                            "¿Cuanto desea apostar?");

                    System.out.println(partida.setApuesta(teclado.nextInt()));
                }


                if (partida.iniciarPartida()){
                        System.out.println("BlackJack! Ganaste.");
                        System.out.println(usuario.listarMano() + "( " + partida.sumarMano(usuario.getMano()) + " )");
                    }else {
                        System.out.println(usuario.getNombreDeUsuario() + ": " + "\n" + usuario.listarMano() + "( " + partida.sumarMano(usuario.getMano()) + " )");
                        System.out.println("Dealer: \n" + partida.getDealer().listarMano());

                        do{
                            System.out.println("1. Pedir" + "\n" +
                                    "2. Plantarse");
                            eleccionUsuario = teclado.nextInt();

                            if (eleccionUsuario==1){
                                partida.getUsuario().recibirCarta(partida.getMazo().sacarCarta());
                                System.out.println(usuario.getNombreDeUsuario() + ": " + "\n" + usuario.listarMano() + "( " + partida.sumarMano(usuario.getMano()) + " )");
                            }
                        } while (partida.sumarMano(usuario.getMano())<21 && eleccionUsuario==1);

                        usuario.setTurno(false);
                        partida.getDealer().setTurno(true);

                        System.out.println("Turno del dealer...");
                        System.out.println("Dealer: \n" + partida.getDealer().listarMano() + "( " + partida.sumarMano(partida.getDealer().getMano()) + " )");
                        while (partida.sumarMano(partida.getDealer().getMano())<17){
                            System.out.println("Una mas...");
                            partida.getDealer().recibirCarta(partida.getMazo().sacarCarta());
                            System.out.println("Dealer: \n" + partida.getDealer().listarMano() + "( " + partida.sumarMano(partida.getDealer().getMano()) + " )");
                        }

                        if (partida.definirGanador()!=null){
                            System.out.println("El ganador es: " + partida.definirGanador().toString());
                        } else {
                            System.out.println("Ninguno gana, algo paso.");
                        }

                    }



            case 2:
                // funciones modificar
            default:
                break;
        }
    }
}
