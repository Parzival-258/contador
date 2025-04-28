package model;

public class Contador {
    private String id;
    private String direeccion;
    private String ciudad;
    private Energia energia;

    public Contador(String id, String direccion, String ciudad) {
        this.id = id;
        this.direeccion = direccion;
        this.ciudad = ciudad;
        this.energia = new Energia();
    }
    public Energia getEnergia() {
        return energia;
    }
}
