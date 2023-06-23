package ClasesGenericas;

import Exceptions.PilaVaciaException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Pila<T> implements Serializable, I_Administrar {
    private ArrayList<T> pila;

    public Pila() {
        pila = new ArrayList<>();
    }

    public boolean apilar(T t){
        return pila.add(t);
    }

    public boolean vacio() {
        return pila.isEmpty();
    }


    public T desapilar() throws PilaVaciaException {
        if (vacio()) {
            throw new PilaVaciaException("La pila esta vacía");
        }
        return pila.remove(pila.size() - 1);
    }

    public void mezclar(){
        Collections.shuffle(pila);
    }

    public T tope() throws PilaVaciaException {
        if (vacio()) {
            throw new PilaVaciaException("La pila esta vacía");
        }
        return pila.get(pila.size() - 1);
    }

    @Override
    public String listar() {
        String lista = "";
        try {
            while (!vacio()) {
                lista += desapilar();
            }
        } catch (PilaVaciaException e) {
            System.out.println("La pila esta vacía");
        }
        return lista;
    }

    @Override
    public Boolean buscar(Object o) {
        T t=(T)o;
        boolean rta=false;
        try{
            while(!vacio()){
                if(desapilar().equals(t)){
                    rta=true;
                }
            }
        }catch(PilaVaciaException e){
            System.out.println(e.getMessage());
        }
        return rta;
    }
}