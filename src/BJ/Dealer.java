package BJ;

import Jugador.Jugador;

public class Dealer extends Jugador{
    public Dealer(){
        super();
    }

    /**
     * cuando no es el turno del dealer muestra solo una carta
     * y muestra las dos cuando termina el turno del usuario y es su turno
     * @return las cartas
     */
    public String listarMano(){
        String info = "";
        if (!isTurno()){
            info = getMano().get(0).toString() + "\nCarta: X";
        } else {
            info = super.listarMano();
        }
        return info;
    }

    @Override
    public String toString() {
        return "Dealer";
    }
}
