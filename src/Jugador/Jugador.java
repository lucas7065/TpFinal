package Jugador;

import BJ.Carta;

import java.util.ArrayList;

public abstract class Jugador {
    private ArrayList<Carta> mano;
    private boolean turno;

    public Jugador(){
        mano = new ArrayList<>();
        turno = false;
    }

    public boolean plantarse() {
        return false;
    }

    public void recibirCarta(Carta carta) {
        mano.add(carta);
    }

    public String listarMano(){
        String info = "";

        for (Carta carta : mano){
            info += carta.toString() + "\n";
        }

        return info;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public boolean isTurno() {
        return turno;
    }
}
