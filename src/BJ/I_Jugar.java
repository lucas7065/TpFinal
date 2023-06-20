package BJ;

public interface I_Jugar {
    void iniciarMano(Carta carta1, Carta carta2);
    boolean plantarse();
    Carta pedirCarta(Carta carta);
    String listarMano();
}
