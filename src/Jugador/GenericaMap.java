package Jugador;

import java.util.*;

public class GenericaMap<K, V> {
    K k;
    V v;
    Map<K, V> elementos;

    public GenericaMap() {
        this.elementos=new HashMap<>();
    }

    public GenericaMap(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public Map<K, V> getElementos() {
        return elementos;
    }

    public boolean agregar(K k, V v) {
        elementos.put(k,v);
        return false;
    }

    public int contar() {
        int cantidad= elementos.size();
        return cantidad;
    }


    public String listar() {
        String lista="";
        Iterator it = elementos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> e = (Map.Entry<K, V>)it.next();
            lista += e.getValue().toString();
        }
        return lista;
    }

    public boolean eliminar(Object o) {
        elementos.remove(o);
        return true;
    }

    /**
     * Busca el elemento mapeado a una clave y lo devuelve.
     * @return Valor del elemento al cual corresponde la clave o null si no se encontro la clave
     * */
    public V getElemento(K k) {
        V v=(V)null;
        Boolean rta= elementos.containsKey(k);
        if(rta==true){
            v=elementos.get(k);
        }
        return v;
    }

    public boolean contains(K k){
        return elementos.containsKey(k);
    }


    public ArrayList<V> pasarValoresAunArray(){
        // Getting Collection of values from HashMap
        Collection<V> values = elementos.values();

        // Creating an ArrayList of values
        ArrayList<V> listOfValues = new ArrayList<>(values);

        return listOfValues;
    }

    /**
     * Elimina un par clave/valor del mapa
     * @param k clave
     * @return El valor asociado a la clave o null si no se encontro la clave
     */
    public V eliminarKey(K k){
        V v= elementos.remove(k);
        return v;
    }

    /**
     * Reemplaza el valor asociado a una clave
     * @param k clave
     * @param v nuevo valor
     * @return El valor que estaba anteriormente asociado a la clave o null si no se encontro la clave
     */
    public V reemplazarValor(K k, V v){
        V aux= elementos.replace(k, v);
        return aux;
    }
}