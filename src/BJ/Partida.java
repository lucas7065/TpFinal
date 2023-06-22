package BJ;

import Exceptions.DineroInsuficienteException;
import Jugador.Usuario;
import Jugador.Jugador;

import javax.swing.*;
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

    /*

    public int iniciarTurnoUsuario(){
        usuario.iniciarMano(mazo.sacarCarta(), mazo.sacarCarta());


        return sumarMano(usuario.getMano());
    }

    public String iniciarTurnoDealer(){
        dealer.iniciarMano(mazo.sacarCarta(), mazo.sacarCarta());

        return dealer.getMano().get(0).toString() + "\nCarta: X";
    }


    public void repartirCarta(){
        usuario.pedirCarta(mazo.sacarCarta());
    }




    //metodos para el juego

    public String mostrarManoUsuario(){
        return usuario.listarMano() + "( " + sumarMano(usuario.getMano()) + " )";
    }

    public String mostrarManoDealer(){
        return dealer.listarMano() + "( " + sumarMano(dealer.getMano()) + " )";
    }

     */


    public boolean iniciarPartida(){
        boolean rta = false;
        for (int i = 0; i<2; i++){
            usuario.recibirCarta(mazo.sacarCarta());
            dealer.recibirCarta(mazo.sacarCarta());
        }
        if (verificarBJ(usuario)){
            usuario.setTurno(false);
            dealer.setTurno(true);
            rta = true;
        }

        return rta;
    }


    public boolean verificarBJ(Jugador jugador){
        boolean rta = false;
        if (sumarMano(jugador.getMano()) == 21){
            rta = true;
            resultado += apuesta;
        }
        return rta;
    }


    public Jugador definirGanador(){
        Jugador ganador = null;
        int resultado = apuesta;

        if (sumarMano(usuario.getMano())<=21 && sumarMano(dealer.getMano())<=21){
            if (sumarMano(dealer.getMano()) < sumarMano(usuario.getMano())){
                ganador = usuario;
            } else if (sumarMano(dealer.getMano()) > sumarMano(usuario.getMano())){
                ganador = dealer;
                resultado*=-1;
            }
        }else if (sumarMano(usuario.getMano())<=21 && sumarMano(dealer.getMano())>21){
            ganador = usuario;
        }
        else {
            resultado*=-1;
            ganador = dealer;
        }

        usuario.setSaldo(resultado);
        setResultado(resultado);
        this.resultado += resultado;
        usuario.getMano().clear();

        return ganador;
    }

    public void comprobarSaldo(int apuesta)throws DineroInsuficienteException {
        if (apuesta <= usuario.getSaldo()) {
            this.apuesta = apuesta;
        } else {
            throw new DineroInsuficienteException("Dinero insuficiente para apostar esa cantidad");
        }
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

    public String setApuesta(int apuesta){
        String rta = "";
        try {
            comprobarSaldo(apuesta);
        } catch (DineroInsuficienteException e){
            rta = e.getMessage();
        }
        return rta;
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
