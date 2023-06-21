package BJ;

import Jugador.Jugador;

public class Dealer extends Jugador{
    public Dealer(){
    }

    public String listarMano(boolean turnoUsuario){
        String info = "";
        if (turnoUsuario == false){
            info = getMano().get(0).toString() + "\nCarta: X";
        } else {
            info = listarMano();
        }
        return info;
    }

}
