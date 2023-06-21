package Jugador;


import java.io.Serializable;



public class Usuario extends Jugador implements Serializable{
        private String nombreDeUsuario;
        private String nombreCompleto;
        private String email;
        private String password;
        private int saldo;
        private int puntaje;


    public Usuario() {
        this.nombreCompleto = "";
        this.email = "";
        this.nombreDeUsuario = "";
        this.password = "";
        this.saldo = 1000;
        this.puntaje = 0;
        super.setTurno(true);
    }


    public Usuario(String nombreDeUsuario, String nombreCompleto, String email, String password, int saldo, int puntaje) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.saldo = saldo;
        this.puntaje = puntaje;
    }

    public Usuario(String nombre, String apellido, String id, String email, String nombreDeUsuario, String password, int saldo, int puntaje) {
        this.nombreCompleto = nombre;
        this.email = email;
        this.nombreDeUsuario = nombreDeUsuario;
        this.password = password;
        this.saldo = saldo;
        this.puntaje = puntaje;
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


    @Override
    public String toString() {
        return "Usuario{" +
                "nombreDeUsuario='" + nombreDeUsuario + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", saldo=" + saldo +
                ", puntaje=" + puntaje +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        boolean rta = false;
        if (o != null) {
            if (o instanceof Usuario) {
                Usuario u = (Usuario) o;
                if (((Usuario) o).nombreDeUsuario.equalsIgnoreCase(nombreDeUsuario)) {
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
