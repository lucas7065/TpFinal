package BJ;

import Jugador.Usuario;

import java.util.ArrayList;

public class Partida {
    private int id;
    private Usuario usuario;
    private Dealer dealer;
    private Mazo mazo;
    private int resultado;
    private int apuesta;

    public Partida(int id, Usuario usuario){
        // id comprobar arreglo de ids y generar uno nuevo
        this.usuario = usuario;
        dealer = new Dealer();
        resultado = 0;
        mazo = new Mazo();
        apuesta = 0;
    }

    public int iniciarTurnoUsuario(){
        usuario.iniciarMano(mazo.sacarCarta(), mazo.sacarCarta());

        return sumarMano(usuario.getMano());
    }

    public Carta iniciarTurnoDealer(){
        dealer.iniciarMano(mazo.sacarCarta(), mazo.sacarCarta());

        return dealer.getMano().get(0);
    }

    public boolean iniciarPartida(){
        boolean rta = false;
        if (iniciarTurnoUsuario() == 21){
            rta = true;
            resultado += apuesta*2;
        }

        iniciarTurnoDealer();
        return rta;
    }



    //metodos para el juego

    public String mostrarManoDealer(){
        return dealer.listarMano() + "( " + sumarMano(dealer.getMano()) + " )";
    }





    public int sumarMano(ArrayList<Carta> mano){
        int suma = 0;
        int contAses = 0;

        for (Carta carta : mano){
            if (carta.getRango().equals(Rango.AS)){
                contAses++;
            }
            suma += carta.getValor();
        }

        while (suma>21 && contAses>0){
            suma -= 10;
            contAses--;
        }

        return suma;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public int getResultado() {
        return resultado;
    }

    public int getApuesta() {
        return apuesta;
    }
}
