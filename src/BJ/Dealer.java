package BJ;

import Jugador.Jugador;

public class Dealer extends Jugador{
    public Dealer(){
        super();
    }

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
