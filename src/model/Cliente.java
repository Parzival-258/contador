package model;

import java.util.ArrayList;

public class Cliente {
    private String id;
    private String tipoDeIdentificacion;
    private String correro;
    private String direccion;
    private ArrayList<Contador> contadores;

    public Cliente(String id, String tipoDeIdentificacion, String correo, String direccion) {
        this.id = id;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.correro = correo;
        this.direccion = direccion;
        this.contadores = new ArrayList<>();        
    }
    public void agregarContador(Contador contador) {
        contadores.add(contador);
    }
    public ArrayList<Contador> getContadores(){
        return contadores;
    }
    public double consumoMinimo(int mes) {
        double min = Double.MAX_VALUE;
        for (Contador c : contadores) {
            double[][] matriz = c.getEnergia().getMes(mes);
            for (double[] dia : matriz) {
                for (double hora : dia) {
                    if (hora < min) min = hora;
                }
            }
        }
        return min;
    }
    public double consumoMaximo(int mes) {
        double max = Double.MIN_VALUE;
        for (Contador c : contadores) {
            double[][] matriz = c.getClass().getMes(mes);
            for (double[] dia : matriz) {
                for (double hora : dia) {
                    if (hora > max) max = hora;
                }
            }
        }
        return max;
    }
    
}
