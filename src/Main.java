public class Main {
    public static void main(String[] args) {

        Tiempo tiempo1 = new Tiempo(8, 30, 0);   // 08:30 → 08:30 AM
        Tiempo tiempo2 = new Tiempo(15, 45, 0);  // 15:45 → 03:45 PM


        Fecha fecha1 = new Fecha(12, 2, 2002, tiempo1);
        Fecha fecha2 = new Fecha(13, 3, 2020, tiempo2);


        System.out.println("Fecha 1: " + fecha1);
        System.out.println("Fecha 2: " + fecha2);


        System.out.println();
        fecha1.imprimirDiferencia(fecha2);

    }
}


