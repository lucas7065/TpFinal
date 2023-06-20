package Jugador;

import BJ.Carta;
import BJ.I_Jugar;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable, I_Jugar {
        private String nombreDeUsuario;
        private String nombre;
        private String apellido;
        private String email;
        private String password;
        private String fechaNacimiento;
        private int saldo;
        private int puntaje;
        private ArrayList<Carta> mano;

    public Usuario() {
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.nombreDeUsuario = "";
        this.password = "";
        this.fechaNacimiento = "";
        this.saldo = 0;
        this.puntaje = 0;
    }


    public Usuario(String nombre, String apellido, String id, String email, String nombreDeUsuario, String password, String fechaNacimiento, int saldo, int puntaje) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nombreDeUsuario = nombreDeUsuario;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.saldo = saldo;
        this.puntaje = puntaje;
    }

    public void iniciarMano(Carta c1, Carta c2){
        mano.add(c1);
        mano.add(c2);
    }

    @Override
    public boolean plantarse() {
        return false;
    }

    @Override
    public Carta pedirCarta(Carta carta) {
        return null;
    }


    // --------------------------------------------- GETTER Y SETTER ---------------------------------------------

    public String getApellido() {
        return apellido;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
            this.nombre = nombre;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
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

    public ArrayList<Carta> getMano() {
        return mano;
    }

    @Override
    public String listarMano(){
        String info = "";

        for (Carta carta : mano){
            info += carta.toString() + "\n";
        }

        return info;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", nombreDeUsuario='" + nombreDeUsuario + '\'' +
                ", password='" + password + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", saldo=" + saldo +
                ", puntaje=" + puntaje +
                '}';
    }
}
