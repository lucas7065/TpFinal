package BJ;

import java.util.ArrayList;
import java.util.List;

public class Pila<T> {
    private List<T> pila;

    public Pila() {
        pila = new ArrayList<>();
    }

    public void apilar(T elemento) {
        pila.add(elemento);
    }

    public boolean pilaVacia() {
        return pila.isEmpty();
    }


    public T desapilar() throws PilaVaciaException {
        if (pilaVacia()) {
            throw new PilaVaciaException("La pila esta vacía");
        }
        return pila.remove(pila.size() - 1);
    }

    public T tope() throws PilaVaciaException {
        if (pilaVacia()) {
            throw new PilaVaciaException("La pila esta vacía");
        }
        return pila.get(pila.size() - 1);
    }
}
