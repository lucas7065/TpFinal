package Jugador;


import BJ.Partida;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;


public class Usuario extends Jugador implements Serializable{
        private String nombreDeUsuario;
        private String nombreCompleto;
        private String email;
        private String password;
        private int saldo;
        private int puntaje;
        private transient HashSet<Partida> partidas;


    public Usuario() {
        this.nombreCompleto = "";
        this.email = "";
        this.nombreDeUsuario = "";
        this.password = "";
        this.saldo = 1000;
        this.puntaje = 0;
        super.setTurno(true);
        partidas = new HashSet<Partida>();
    }


    public Usuario(String nombreDeUsuario, String nombreCompleto, String email, String password) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        saldo = 1000;
        puntaje = 0;
        partidas = new HashSet<Partida>();
    }

    public Usuario(String nombre, String apellido, String id, String email, String nombreDeUsuario, String password) {
        this.nombreCompleto = nombre;
        this.email = email;
        this.nombreDeUsuario = nombreDeUsuario;
        this.password = password;
        this.saldo = 1000;
        puntaje = 0;
        partidas = new HashSet<Partida>();
    }




    // --------------------------------------------- GETTER Y SETTER ---------------------------------------------



    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
            return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void cargarPartidas(Partida aux){
        partidas.add(aux);
    }


    public String listarPartidas(){
        String info = "";

        Iterator it = partidas.iterator();

        while (it.hasNext()){
            info += it.next().toString() + "\n";
        }

        return info;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "nombreDeUsuario='" + nombreDeUsuario + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", email='" + email + '\'' +
                ", saldo=" + saldo +
                ", puntaje=" + puntaje +
                " " + password +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        boolean rta = false;
        if (o != null) {
            if (o instanceof Usuario) {
                Usuario u = (Usuario) o;
                if (((Usuario) o).getNombreDeUsuario().equalsIgnoreCase(nombreDeUsuario)) {
                    rta = true;
                }
            }
        }
        return rta;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
