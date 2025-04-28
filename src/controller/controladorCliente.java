package controller;
import model.Cliente;
import model.Contador;

public class controladorCliente {
    private Cliente cliente;

    public void crearCliente(String id, String tipoDeIdentificacion, String correo, String direccion) {
        cliente = new Cliente(id, tipoDeIdentificacion, correo, direccion);
    }
    public void agregarContador(String id, String direccion, String ciudad) {
        cliente.agregarContador(new Contador(id, direccion, ciudad));
    }
    public Cliente getCliente() {
        return cliente;
    }
}
