package Modelo;

public class ClienteModel {

    public int id;
    public String nombre;
    public String apellido;
    public String f_compra;
    public String h_compra;
    public double credito;

    // Para MVC es recomendable inicalizar las variables
    // en un constructor y dejar uno vacio
    public ClienteModel(int id, String nombre, String apellido, String f_compra, String h_compra, double credito) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.f_compra = f_compra;
        this.h_compra = h_compra;
        this.credito = credito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getF_compra() {
        return f_compra;
    }

    public void setF_compra(String f_compra) {
        this.f_compra = f_compra;
    }

    public String getH_compra() {
        return h_compra;
    }

    public void setH_compra(String h_compra) {
        this.h_compra = h_compra;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

}
