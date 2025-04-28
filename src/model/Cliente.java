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
            double[][] matriz = c.getEnergia().getMes(mes);
            for (double[] dia : matriz) {
                for (double hora : dia) {
                    if (hora > max) max = hora;
                }
            }
        }
        return max;
    }
    public double[] consumoPorFranja(int mes) {
        double[] franjas = new double[3];
        for (Contador c : contadores) {
            double[][] matriz = c.getEnergia().getMes(mes);
            for (double[] dia : matriz) {
                for (int hora = 0; hora < dia.length; hora++) {
                    if (hora >= 0 && hora <= 6) franjas[0] += dia[hora];
                    else if (hora >= 7 && hora <= 17) franjas[1] += dia[hora];
                    else if (hora >= 18 && hora <= 23) franjas[2] += dia[hora];
                }
            }
        }
        return franjas;
    }
    public double[] consumoPorDias(int mes) {
        Contador contador = contadores.get(0);
        double[][] matriz = contador.getEnergia().getMes(mes);
        double[] dias = new double[matriz.length];
        for (int dia = 0; dia < matriz.length; dia++) {
            double sumaDia = 0;
            for (int hora = 0; hora < 24; hora++) {
                sumaDia += matriz[dia][hora];
            }
            dias[dia] = sumaDia;
        }
        return dias;
    }
    public double valorFactura(int mes) {
        double total = 0;
        for (Contador c : contadores) {
            double[][] matriz = c.getEnergia().getMes(mes);
            for (double[] dia : matriz) {
                for (int hora = 0; hora < dia.length; hora++) {
                    double consumo = dia[hora];
                    if (hora >= 0 && hora <= 6) total += consumo * 200;
                    else if (hora >= 7 && hora <= 17) total += consumo * 300;
                    else if ( hora >= 18 &&hora <= 23) total += consumo * 500;
                }
            }
        }
        return total;
    }
}
