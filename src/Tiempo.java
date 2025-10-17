
public class Tiempo {

    private int hora;
    private int minuto;
    private int segundo;
    private String periodo;

    public Tiempo(int h, int m, int s) {

        if (h >= 0 && h <= 23) {
            convertirDe24hA12h(h);
        } else {
            System.out.println("ERROR: Hora debe estar entre 0 y 23.");
            this.hora = 12;
            this.periodo = "AM";
        }

        if (m >= 0 && m <= 59) {
            this.minuto = m;
        } else {
            System.out.println("ERROR: Minuto debe estar entre 0 y 59.");
            this.minuto = 0;
        }


        if (s >= 0 && s <= 59) {
            this.segundo = s;
        } else {
            System.out.println("ERROR: Segundo debe estar entre 0 y 59.");
            this.segundo = 0;
        }
    }


    private void convertirDe24hA12h(int hora24) {
        if (hora24 == 0) {
            this.hora = 12;
            this.periodo = "AM";
        } else if (hora24 >= 1 && hora24 <= 11) {
            this.hora = hora24;
            this.periodo = "AM";

        } else if (hora24 == 12) {

            this.hora = 12;
            this.periodo = "PM";
        } else {
            this.hora = hora24 - 12;
            this.periodo = "PM";
        }
    }


    // GETTERS

    public int getHora() {
        return hora;  // Retorna en formato 12h
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public String getPeriodo() {
        return periodo;
    }

    // Retorna la hora en formato 24h (conversión inversa)
    public int getHora24() {
        if (this.periodo.equals("AM")) {
            if (this.hora == 12) {
                return 0;  // 12 AM = 00:00
            }
            return this.hora;  // 1-11 AM = 1-11
        } else {  // PM
            if (this.hora == 12) {
                return 12;  // 12 PM = 12:00
            }
            return this.hora + 12;  // 1-11 PM = 13-23
        }
    }


    // SETTERS

    // Recibe hora en formato 24h y la convierte
    public void setHora24(int hora24) {
        if (hora24 >= 0 && hora24 <= 23) {
            convertirDe24hA12h(hora24);
        } else {
            System.out.println("ERROR: Hora debe estar entre 0 y 23.");
        }
    }

    public void setMinuto(int minuto) {
        if (minuto >= 0 && minuto <= 59) {
            this.minuto = minuto;
        } else {
            System.out.println("ERROR: Minuto debe estar entre 0 y 59.");
        }
    }

    public void setSegundo(int segundo) {
        if (segundo >= 0 && segundo <= 59) {
            this.segundo = segundo;
        } else {
            System.out.println("ERROR: Segundo debe estar entre 0 y 59.");
        }
    }



    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d %s", hora, minuto, segundo, periodo);
    }



    public String toString24h() {
        return String.format("%02d:%02d:%02d", getHora24(), minuto, segundo);
    }
}
