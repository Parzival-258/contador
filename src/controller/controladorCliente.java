package controller;
import java.util.ArrayList;

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
    public double calcularFactura(int mes) {
        return cliente.valorFactura(mes);
    }
    public double[][] obtenerMatrizMes(int mes) {
    return cliente.getEnergia().getMes(mes);
    } 
    public void imprimirMatriz(double[][] matriz) {
    System.out.println("\nMatriz de consumo del mes:");
    for (int i = 0; i < matriz.length; i++) {
        System.out.print("Día " + (i + 1) + ": ");
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.printf("%.1f\t", matriz[i][j]);
        }
        System.out.println();
    }
    }
    public double consumoMaximo(int mes) {
        double[][] matriz = cliente.getEnergia().getMes(mes);
        imprimirMatriz(matriz);

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
    public double consumoMinimo(int mes) {
    double[][] matriz = cliente.getEnergia().getMes(mes);

    double min = Double.MAX_VALUE;
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j] < min) {
                min = matriz[i][j];
            }
        }
    }

    return min;
}
}
