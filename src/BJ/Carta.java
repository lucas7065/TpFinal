package BJ;

public class Carta {

    private Palo palo;
    private Rango rango;
    private int valor;

    public Carta(){
        palo=null;
        rango=null;
        valor=0;
    }
    public Carta(Palo palo, Rango rango, int valor) {
        this.palo = palo;
        this.rango = rango;
        this.valor=valor;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Carta: " +
                "" + rango +
                " de " + palo +
                ", valor:" + valor +
                '}';
    }
}
