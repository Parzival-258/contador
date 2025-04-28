import java.util.Scanner;

import controller.controladorCliente;
import view.vistaCliente;

public class App {
    public static void main(String[] args)  {
        controladorCliente controlador = new controladorCliente();
        vistaCliente vista = new vistaCliente(controlador);
        Scanner sc = new Scanner(System.in);

        controlador.crearCliente("123", "cedula", "ejemplo@gmail.com", "calle 123");
        controlador.agregarContador("c001", "calle 55", "Bogota");
        
        int opcion;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Ver consumo mínimo del mes");
            System.out.println("2. Ver consumo máximo del mes");
            System.out.println("3. Ver consumo por franjas horarias del mes");
            System.out.println("4. Ver consumo total por día del mes");
            System.out.println("5. Ver valor de la factura del mes");
            System.out.println("6. Modificar consumo en una fecha y hora");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el mes (0=Enero, 1=Febrero, 2=Marzo, 3=Abril, 4=Mayo, 5=Junio, 6=Julio 7=Agosto, 8=Septiembre, 9=octubre, 10=noviembre, 11=Diciembre): ");
                    int mes = sc.nextInt();
                    vista.mostrarConsumoMinimo(mes);
                }
                case 2 -> {
                    System.out.print("Ingrese el mes (0=Enero, 1=Febrero, 2=Marzo, 3=Abril, 4=Mayo, 5=Junio, 6=Julio 7=Agosto, 8=Septiembre, 9=octubre, 10=noviembre, 11=Diciembre): ");
                    int mes = sc.nextInt();
                    vista.mostrarConsumoMaximo(mes);
                }
                case 3 -> {
                    System.out.print("Ingrese el mes (0=Enero, 1=Febrero, 2=Marzo, 3=Abril, 4=Mayo, 5=Junio, 6=Julio 7=Agosto, 8=Septiembre, 9=octubre, 10=noviembre, 11=Diciembre): ");
                    int mes = sc.nextInt();
                    vista.mostrarConsumoFranjas(mes);
                }
                case 4 -> {
                    System.out.print("Ingrese el mes (0=Enero, 1=Febrero, 2=Marzo, 3=Abril, 4=Mayo, 5=Junio, 6=Julio 7=Agosto, 8=Septiembre, 9=octubre, 10=noviembre, 11=Diciembre): ");
                    int mes = sc.nextInt();
                    vista.mostrarConsumoDias(mes);
                }
                case 5 -> {
                    System.out.print("Ingrese el mes (0=Enero, 1=Febrero, 2=Marzo, 3=Abril, 4=Mayo, 5=Junio, 6=Julio 7=Agosto, 8=Septiembre, 9=octubre, 10=noviembre, 11=Diciembre): ");
                    int mes = sc.nextInt();
                    vista.mostrarValorFactura(mes);
                }
                case 6 -> {
                    System.out.print("Ingrese el mes (0=Enero, 1=Febrero, 2=Marzo, 3=Abril, 4=Mayo, 5=Junio, 6=Julio 7=Agosto, 8=Septiembre, 9=octubre, 10=noviembre, 11=Diciembre): ");
                    int mes = sc.nextInt();
                    System.out.print("Ingrese el día (1 a 31): ");
                    int dia = sc.nextInt() - 1;
                    System.out.print("Ingrese la hora (0 a 23): ");
                    int hora = sc.nextInt();
                    System.out.print("Ingrese el nuevo consumo (kW/h): ");
                    double consumo = sc.nextDouble();
                    vista.modificarConsumo(mes, dia, hora, consumo);
                }
                case 0 -> System.out.println("saliendo del sistema");
                default -> System.out.println("opcion invalida, intente de nuevo.");
            }
        } while (opcion != 0);
        
        sc.close();
    }
}
