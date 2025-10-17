
public class Fecha {

    private int dia;
    private int mes;
    private int anio;
    private Tiempo tiempo;

    public Fecha(int d, int m, int a, Tiempo t) {

        this.dia = d;
        this.mes = m;
        this.anio = a;
        this.tiempo = t;

        validarMes();
        validarDia();
    }


    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }



    public void setDia(int dia) {
        this.dia = dia;
        validarDia();
    }

    public void setMes(int mes) {
        this.mes = mes;
        validarMes();
        validarDia();
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setTiempo(Tiempo tiempo) {
        this.tiempo = tiempo;
    }




    public static Fecha nuevaFecha(int d, int m, int a, Tiempo t) {
        return new Fecha(d, m, a, t);
    }

    public int diferenciaAnios(Fecha otraFecha) {
        return otraFecha.anio - this.anio;
    }


    public int diferenciaMeses(Fecha otraFecha) {
        int mesesDiferencia = (otraFecha.anio - this.anio) * 12 + (otraFecha.mes - this.mes);
        return mesesDiferencia;
    }


    public int diferenciaDias(Fecha otraFecha) {

        int diasFecha1 = this.anio * 365 + obtenerDiasHastaFinDeAnio(this.mes, this.dia);
        int diasFecha2 = otraFecha.anio * 365 + obtenerDiasHastaFinDeAnio(otraFecha.mes, otraFecha.dia);

        return diasFecha2 - diasFecha1;
    }


    public int diferenciaHoras(Fecha otraFecha) {
        // Primero calcular días de diferencia
        int diasDiferencia = diferenciaDias(otraFecha);


        int horasFecha1 = this.tiempo.getHora24();
        int horasFecha2 = otraFecha.tiempo.getHora24();


        int horasDiferencia = (diasDiferencia * 24) + (horasFecha2 - horasFecha1);

        return horasDiferencia;
    }


    public String getNombreMes() {
        String[] nombresMeses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        if (mes >= 1 && mes <= 12) {
            return nombresMeses[mes - 1];
        }
        return "Mes inválido";
    }


    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d %s", dia, mes, anio, tiempo.toString());
    }



    private void validarMes() {
        if (this.mes < 1 || this.mes > 12) {
            System.out.println("ERROR: Mes debe estar entre 1 y 12.");
        }
    }


    private void validarDia() {
        int diasDelMes = obtenerDiasDelMes(this.mes);

        if (this.dia < 1 || this.dia > diasDelMes) {
            System.out.println("ERROR: El mes " + this.mes + " solo tiene " + diasDelMes + " días.");
        }
    }


    private int obtenerDiasDelMes(int mes) {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;

            case 4:
            case 6:
            case 9:
            case 11:
                return 30;

            case 2:
                return 28;

            default:
                return 31;
        }
    }


    private int obtenerDiasHastaFinDeAnio(int mes, int dia) {
        int diasTotales = 0;


        for (int m = 1; m < mes; m++) {
            diasTotales += obtenerDiasDelMes(m);
        }


        diasTotales += dia;

        return diasTotales;
    }
}
