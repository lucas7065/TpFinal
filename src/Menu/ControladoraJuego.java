package Menu;

import Archivos.ControladoraArchivos;
import BJ.Partida;
import ClasesGenericas.Pila;
import Exceptions.PilaVaciaException;
import Jugador.Usuario;
import java.util.*;

public class ControladoraJuego {
    private Pila<Partida> partidas;



    public ControladoraJuego(){
        partidas = new Pila<>();
    }

    /**
     * crea una nueva partida y le asigna una id segun las partidas guardadas
     * @param usuario
     * @return la nueva partida
     */
    public Partida crearNuevaPartida(Usuario usuario){
        partidas = ControladoraArchivos.leerPartidas();
        Partida nuevaPartida=null;
        try {
            nuevaPartida = new Partida((partidas.tope().getId() + 1), usuario);
        }catch(PilaVaciaException e){
            nuevaPartida= new Partida(1, usuario);
        }
        return nuevaPartida;
    }

    /**
     * metodo para guardar una partida en el archivo de partidas
     * @param aux una partida
     */
    public void finalizarPartida(Partida aux){
        Pila<Partida> partidas = new Pila<Partida>();
        partidas = ControladoraArchivos.leerPartidas();
        partidas.apilar(aux);
        ControladoraArchivos.grabarPartidas(partidas);
    }


    /**
     * lee el archivo de partidas y busca a las partidas de cada usuario
     * y las guarda en un HashSet
     * @param u usuario a buscar
     * @return hashset de partidas
     * @throws PilaVaciaException cuando el usuario no tiene partidas
     */
    private HashSet<Partida> buscarPartidas(Usuario u) throws PilaVaciaException{
        HashSet<Partida> partidasUsuario=new HashSet<Partida>();
        partidas = ControladoraArchivos.leerPartidas();


        while (!partidas.vacio()) {
            if(partidas.tope().getUsuario().getNombreDeUsuario().equalsIgnoreCase(u.getNombreDeUsuario())){
                partidasUsuario.add(partidas.desapilar());
            }else {
                partidas.desapilar();
            }
        }
        return partidasUsuario;
    }

    public String mostrarPartidas(Usuario u){
        String info = "";
        try{
            HashSet<Partida>partidas = buscarPartidas(u);
            if (partidas.isEmpty()){
                info = "No hay partidas.";
            }else {
                Iterator it = partidas.iterator();

                while (it.hasNext()){
                    info += it.next().toString() + "\n";
                }
            }
        } catch (PilaVaciaException e){
            info = e.getMessage();

        }
        return info;
    }




}