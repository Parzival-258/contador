package view;
import model.Cliente;
import model.Contador;

import java.util.ArrayList;

import controller.controladorCliente;

public class vistaCliente {
    private controladorCliente controlador;
    
    public vistaCliente(controladorCliente controlador) {
        this.controlador = controlador;
    } 
   public void mostrarConsumoMinimo(int mes) {
    double[][] matriz = controlador.getCliente().getEnergia().getMes(mes);
    controlador.imprimirMatriz(matriz);

    double min = controlador.consumoMinimo(mes);
    System.out.println("Consumo mínimo del mes: " + min + " kW");

    int contador = 0;
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j] == min) {
                System.out.println(" - Día " + (i + 1) + ", Hora " + j);
                contador++;
            }
        }
    }
    System.out.println("Este valor mínimo se repitió " + contador + " veces en el mes.");
}
   public double consumoMaximo(int mes) {
    double[][] matriz = controlador.getCliente().getEnergia().getMes(mes);
    controlador.imprimirMatriz(matriz);

    double max = Double.MIN_VALUE;
    ArrayList<Integer> dias = new ArrayList<>();

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j] > max) {
                max = matriz[i][j];
                dias.clear();
                dias.add(i + 1);
            } else if (matriz[i][j] == max) {
                dias.add(i + 1);
            }
        }
    }

    System.out.println("\nConsumo máximo del mes: " + max + " kW");
    System.out.println("Se repitió " + dias.size() + " veces en los días: " + dias);

    return max;  
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
    public void mostrarMatrizDelMes(int mes) {
    double[][] matriz = controlador.obtenerMatrizMes(mes);
    if (matriz == null) {
        System.out.println("Mes inválido.");
        return;
    }

    System.out.println("Matriz de consumo del mes seleccionado:");
    for (int i = 0; i < matriz.length; i++) {
        System.out.print("Día " + (i + 1) + ": ");
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.printf("%.2f ", matriz[i][j]);
        }
        System.out.println();
    }
}

}
