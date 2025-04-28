package model;
import java.util.Random;

public class Energia {

    private double[][] enero;
    private double[][] febrero;
    private double[][] marzo;
    private double[][] abril;
    private double[][] mayo;
    private double[][] junio;
    private double[][] julio;
    private double[][] agosto;
    private double[][] septiembre;
    private double[][] octubre;
    private double[][] noviembre;
    private double[][] diciembre;
    
    public Energia(){
        enero = new double[31][24];
        febrero = new double[28][24];
        marzo = new double[31][24];
        abril = new double[30][24];
        mayo = new double[31][24];
        junio = new double[30][24];
        julio = new double[31][24];
        agosto = new double[31][24];
        septiembre = new double[30][24];
        octubre = new double[31][24];
        noviembre = new double[30][24];
        diciembre = new double[31][24];

        iniciarConsumos();
    }
    private void iniciarConsumos(){
        Random rand = new Random();
        llenarConsumo(enero, rand);
        llenarConsumo(febrero, rand);
        llenarConsumo(marzo, rand);
        llenarConsumo(abril, rand);
        llenarConsumo(mayo, rand);
        llenarConsumo(junio, rand);
        llenarConsumo(julio, rand);
        llenarConsumo(agosto, rand);
        llenarConsumo(septiembre, rand);
        llenarConsumo(octubre, rand);
        llenarConsumo(noviembre, rand);
        llenarConsumo(diciembre, rand);
    }
    private void llenarConsumo(double[][] mes, Random rand) {
        for (int dia = 0; dia < mes.length; dia++) {
            for (int hora = 0; hora < 24; hora++) {
                if (hora >= 0 && hora <=6) {
                   mes[dia][hora] = 100 + rand.nextDouble() * 200;
                } else if (hora >= 7 && hora <= 17) {
                    mes[dia][hora] = 300 + rand.nextDouble() * 300;
                }  else if (hora >= 18 && hora <= 23) {
                    mes[dia][hora] = 600 + rand.nextDouble() * 500;
                }
            }
        }
    }
    public double[][] getMes(int mes) {
        return switch (mes) {
            case 0 -> enero;
            case 1 -> febrero;
            case 2 -> marzo;
            case 3 -> abril;
            case 4 -> mayo;
            case 5 -> junio;
            case 6 -> julio;
            case 7 -> agosto;
            case 8 -> septiembre;
            case 9 -> octubre;
            case 10 -> noviembre;
            case 11 -> diciembre;
            default -> null;
        };
    }
    public void modificarConsumo(int mes, int dia, int hora, double nuevoConsumo) {
        double[][] matriz = getMes(mes);
        if (matriz != null && dia >= 0 && dia < matriz.length && hora >= 0 && hora < 24) {
            matriz[dia][hora] = nuevoConsumo;
        }
    }
}