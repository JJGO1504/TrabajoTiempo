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



    public int[] calcularDiferencia(Fecha otraFecha) {

        int anios = 0;
        int meses = 0;
        int dias = 0;
        int horas = 0;
        int minutos = 0;
        int segundos = 0;

        int seg1 = this.tiempo.getSegundo();
        int seg2 = otraFecha.tiempo.getSegundo();
        int min1 = this.tiempo.getMinuto();
        int min2 = otraFecha.tiempo.getMinuto();
        int hora1 = this.tiempo.getHora24();
        int hora2 = otraFecha.tiempo.getHora24();
        int dia1 = this.dia;
        int dia2 = otraFecha.dia;
        int mes1 = this.mes;
        int mes2 = otraFecha.mes;
        int anio1 = this.anio;
        int anio2 = otraFecha.anio;



        if (seg2 >= seg1) {
            segundos = seg2 - seg1;
        } else {
            segundos = 60 - seg1 + seg2;
            min2--;
        }



        if (min2 >= min1) {
            minutos = min2 - min1;
        } else {
            minutos = 60 - min1 + min2;
            hora2--;
        }



        if (hora2 >= hora1) {
            horas = hora2 - hora1;
        } else {
            horas = 24 - hora1 + hora2;
            dia2--;
        }



        anios = anio2 - anio1;


        if (mes2 < mes1) {
            anios--;
        } else if (mes2 == mes1 && dia2 < dia1) {
            anios--;
        }



        if (mes2 >= mes1) {
            meses = mes2 - mes1;
        } else {
            meses = 12 - mes1 + mes2;
        }


        if (dia2 < dia1) {
            meses--;
            if (meses < 0) {
                meses = 11;
            }
        }


        if (dia2 >= dia1) {
            dias = dia2 - dia1;
        } else {

            int mesAnterior = mes2 - 1;
            if (mesAnterior == 0) {
                mesAnterior = 12;
            }
            int diasDelMesAnterior = obtenerDiasDelMes(mesAnterior);
            dias = diasDelMesAnterior - dia1 + dia2;
        }


        return new int[]{anios, meses, dias, horas, minutos, segundos};
    }


    public void imprimirDiferencia(Fecha otraFecha) {
        int[] dif = calcularDiferencia(otraFecha);
        System.out.println("La diferencia es de " + dif[0] + " años " + dif[1] + " meses " + dif[2] + " días " + dif[3] + " horas " + dif[4] + " minutos " + dif[5] + " segundos");
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

        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            return 31;
        }

        else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        }

        else if (mes == 2) {
            return 28;
        }

        else {
            return 31;
        }
    }
}
