package Menu;

import Archivos.ControladoraArchivos;
import BJ.Partida;
import BJ.Pila;
import Exceptions.PilaVaciaException;
import Exceptions.UsuarioNoExisteException;
import Jugador.ControladoraUsuario;
import Jugador.Usuario;

import java.util.Iterator;

public class ControladoraJuego {
    private Pila<Partida> partidas;



    public ControladoraJuego(){
        partidas = new Pila<>();
    }

    public Partida crearNuevaPartida(Usuario usuario){
        Partida nuevaPartida=null;
        try {
            nuevaPartida = new Partida(partidas.tope().getId() + 1, usuario);
        }catch(PilaVaciaException e){
            nuevaPartida= new Partida(1, usuario);
        }
        return nuevaPartida;
    }

    public void finalizarPartida(Partida aux){
        Pila<Partida> partidas = new Pila<Partida>();
        partidas = ControladoraArchivos.leerPartidas();
        partidas.apilar(aux);
        ControladoraArchivos.grabarPartidas(partidas);
    }


    public void asignarPartidas(ControladoraUsuario cu) {
        partidas = ControladoraArchivos.leerPartidas();
        try {
            while (!partidas.pilaVacia()) {
                Usuario u = cu.buscarUsuario(partidas.tope().getUsuario().getNombreDeUsuario());
                u.cargarPartidas(partidas.desapilar());
            }

        } catch (PilaVaciaException e) {
            System.out.println(e.getMessage());
        } catch (UsuarioNoExisteException e) {
            System.out.println(e.getMessage());
        }
    }




}
