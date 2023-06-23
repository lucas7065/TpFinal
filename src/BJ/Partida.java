package BJ;

import Exceptions.DineroInsuficienteException;
import Jugador.Usuario;
import Jugador.Jugador;

import java.io.Serializable;
import java.util.ArrayList;

public class Partida implements Serializable {
    private int id;
    private Usuario usuario;
    private transient Dealer dealer;
    private transient Mazo mazo;
    private int resultado;
    private int apuesta;

    public Partida(int id, Usuario usuario){
        this.id = id;
        this.usuario = usuario;
        dealer = new Dealer();
        resultado = 0;
        mazo = new Mazo();
        apuesta = 0;
    }


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
            resultado = apuesta;
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

        int sumaUsuario = sumarMano(usuario.getMano());
        int sumaDealer = sumarMano(dealer.getMano());

        if (sumaUsuario<=21 && sumaDealer<=21){
            if (sumaUsuario < sumaDealer){
                ganador = dealer;
            } else if (sumaUsuario > sumaDealer){
                ganador = usuario;
                usuario.setSaldo(apuesta*2);
            }else {
                usuario.setSaldo(apuesta);
            }
        } else if (sumaUsuario<=21 && sumaDealer>21){
            ganador = usuario;
            usuario.setSaldo(apuesta*2);
        } else if (sumaUsuario>21 && sumaDealer<=21){
            ganador = dealer;
        } else {
            ganador = dealer;
        }

        if (ganador instanceof Usuario){
            resultado += apuesta;
            usuario.setPuntaje(apuesta);
        }else if (ganador instanceof Dealer){
            resultado -= apuesta;
        }

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
            usuario.setSaldo(-(apuesta));
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

    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", usuario=" + usuario.getNombreDeUsuario() +
                ", resultado=" + resultado +
                ", apuesta=" + apuesta +
                '}';
    }
}
