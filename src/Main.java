public class Main {
    public static void main(String[] args) {

        System.out.println("Conversión 24h a 12h:");

        Tiempo t1 = new Tiempo(8, 0, 0);
        Tiempo t2 = new Tiempo(15, 30, 0);

        System.out.println("08:00 → " + t1);
        System.out.println("15:30 → " + t2);

        Fecha fecha1 = new Fecha(29, 1, 1997, t1);
        Fecha fecha2 = new Fecha(5, 2, 2003, t2);

        System.out.println("\nFecha 1: " + fecha1);
        System.out.println("Fecha 2: " + fecha2);

        System.out.println("\nDiferencias:");
        System.out.println("Años: " + fecha1.diferenciaAnios(fecha2));
        System.out.println("Meses: " + fecha1.diferenciaMeses(fecha2));
        System.out.println("Días: " + fecha1.diferenciaDias(fecha2));
        System.out.println("Horas: " + fecha1.diferenciaHoras(fecha2));
    }
}
