package BJ;

import ClasesGenericas.Pila;
import Exceptions.PilaVaciaException;

import java.util.ArrayList;
import java.util.Arrays;


import static BJ.Rango.*;

public class Mazo {

private Pila<Carta> cartas;

    public Mazo() {
        this.cartas = new Pila<>();
        crearMazo();
    }

    /**
     * crea un mazo con las enumeraciones de rango y palo
     * le asigna un valor numerico a cada carta
     */
    public void crearMazo() {
        ArrayList<Integer> numeros=new ArrayList<>(Arrays.asList(2,3,4,5,6,7,8,9,10,11));

        for (Palo palo : Palo.values()) {
            int i=0;
            for (Rango rango : Rango.values()) {
                Carta carta=null;
                if(rango.equals(JOTA) || rango.equals(REINA) || rango.equals(REY)){
                    carta = new Carta(palo, rango, 10);
                } else{
                    carta = new Carta(palo, rango,numeros.get(i));
                    i++;
                }
                cartas.apilar(carta);
                cartas.mezclar();
            }
        }
    }

    /**
     * desapila una carta del mazo para repartir en la partida
     * @return una carta
     */
    public Carta sacarCarta(){
        Carta c=new Carta();
        try{
            c = cartas.desapilar();
        }
        catch(PilaVaciaException e){
            System.out.println(e.getMessage());
        }
        return c;
    }

}
