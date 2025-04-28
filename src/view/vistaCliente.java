package view;
import model.Cliente;
import model.Contador;
import controller.controladorCliente;

public class vistaCliente {
    private controladorCliente controlador;
    
    public vistaCliente(controladorCliente controlador) {
        this.controlador = controlador;
    } 
    public void mostrarConsumoMinimo(int mes) {
        Cliente cliente = controlador.getCliente();
        System.out.println("consumo minimo del mes: " + cliente.consumoMinimo(mes) + "kw/H");
    }
    public void mostrarConsumoMaximo(int mes) {
        Cliente cliente = controlador.getCliente();
        System.out.println("consumo maximo del mes: " + cliente.consumoMaximo(mes) + "kw/H");
    }
    public void mostrarConsumoFranjas(int mes) {
        Cliente cliente = controlador.getCliente();
        double[] franjas = cliente.consumoPorFranja(mes);
        System.out.println("consumo franja 00-06: " + franjas[0] + "kw/H");
        System.out.println("consumo franja 07-17: " + franjas[1] + "kw/H");
        System.out.println("consumo franja 18-23: " + franjas[2] + "kw/H");
    }
    public void mostrarConsumoDias(int mes) {
        Cliente cliente = controlador.getCliente();
        double[] dias = cliente.consumoPorDias(mes);
        for (int i = 0; i < dias.length; i++) {
            System.out.println("dia " + (i + 1) + ":" + dias[i] + "kw/H");
        }
    }
    public void mostrarValorFactura(int mes) {
        Cliente cliente = controlador.getCliente();
        System.out.println("valor total de la factura: " + cliente.valorFactura(mes) + "COP");
    }
    public void modificarConsumo(int mes, int dia, int hora, double nuevoConsumo) {
        Cliente cliente = controlador.getCliente();
        for (Contador c : cliente.getContadores()) {
            c.getEnergia().modificarConsumo(mes, dia, hora, nuevoConsumo);
        }
        System.out.println("consumo modificado exitosamente. ");
    }
}
