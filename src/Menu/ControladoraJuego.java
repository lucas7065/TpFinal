package Menu;

import BJ.Partida;
import BJ.Pila;
import Jugador.ControladoraUsuario;
import Jugador.Usuario;

public class ControladoraJuego {
    private Pila<Partida> partidas;



    public ControladoraJuego(){
        partidas = new Pila<>();
    }

    public Partida crearNuevaPartida(Usuario usuario){
        Partida nuevaPartida = new Partida(1, usuario);

        return nuevaPartida;
    }

}
