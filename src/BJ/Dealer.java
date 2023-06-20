package BJ;

import java.util.ArrayList;

public class Dealer implements I_Jugar{
    private ArrayList<Carta> mano;

    public Dealer(){
        mano = new ArrayList<>();
    }

    @Override
    public void iniciarMano(Carta carta1, Carta carta2) {
        this.mano.add(carta1);
        this.mano.add(carta2);
    }

    @Override
    public boolean plantarse() {
        return false;
    }

    @Override
    public Carta pedirCarta(Carta carta) {
        return null;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }



    @Override
    public String listarMano(){
        String info = "";

        for (Carta carta : mano){
            info += carta.toString() + "\n";
        }

        return info;
    }

}
