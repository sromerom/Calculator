package Calculs;

public class ConversorBase {
    private int resultat;

    public ConversorBase(String operacio, String tipusOp) {

        if (tipusOp.equals("OCTAL")) {

            //Ficam els numeros resultants en format octal en un array
            int[] resultatArray = new int[operacio.length()];
            for (int c = 0; c < resultatArray.length; c++) {
                int resint = Integer.parseInt(String.valueOf(operacio.charAt(c)));
                resultatArray[c] = resint;
            }

            //Aplicam formula per tal de aconseguir el tamany en format decimal
            //EX: 3050 = (3 × 8³) + (0 × 8²) + (5 × 8¹) + (0 × 8⁰) = 1576
            int enrere = resultatArray.length - 1;
            for (int e = 0; e < resultatArray.length; e++, enrere--) {
                int actual = resultatArray[e];
                double operacioCon = (actual * Math.pow(8, enrere));
                resultat = (int) (resultat + operacioCon);
            }
        } else if (tipusOp.equals("HEXADECIMAL")) {

            int decimal = Integer.parseInt(operacio,16);
            resultat = decimal;
        } else if (tipusOp.equals("BINARI")) {
            int decimal = Integer.parseInt(operacio,2);
            resultat = decimal;
        }

        System.out.println(resultat);
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}