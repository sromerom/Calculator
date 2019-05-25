package Calculs;

public class ConversorBase {
    private int resultatDecimal;
    private String resultatOctal;
    private String resultatHexacimal;
    private String resultatBinari;

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
                resultatDecimal = (int) (resultatDecimal + operacioCon);
            }

            resultatOctal = operacio;
            resultatHexacimal = Integer.toHexString(resultatDecimal);
            resultatBinari = Integer.toBinaryString(resultatDecimal);


        } else if (tipusOp.equals("HEXADECIMAL")) {

            int decimal = Integer.parseInt(operacio, 16);
            resultatDecimal = decimal;
            resultatOctal = Integer.toOctalString(resultatDecimal);
            resultatHexacimal = operacio;
            resultatBinari = Integer.toBinaryString(resultatDecimal);


        } else if (tipusOp.equals("BINARI")) {
            int decimal = Integer.parseInt(operacio, 2);
            resultatDecimal = decimal;
            resultatOctal = Integer.toOctalString(resultatDecimal);
            resultatHexacimal = Integer.toHexString(resultatDecimal);
            resultatBinari = operacio;
        }

    }

    public int getResultatDecimal() {
        return resultatDecimal;
    }

    public void setResultatDecimal(int resultatDecimal) {
        this.resultatDecimal = resultatDecimal;
    }

    public String getResultatOctal() {
        return resultatOctal;
    }

    public void setResultatOctal(String resultatOctal) {
        this.resultatOctal = resultatOctal;
    }

    public String getResultatHexacimal() {
        return resultatHexacimal;
    }

    public void setResultatHexacimal(String resultatHexacimal) {
        this.resultatHexacimal = resultatHexacimal;
    }

    public String getResultatBinari() {
        return resultatBinari;
    }

    public void setResultatBinari(String resultatBinari) {
        this.resultatBinari = resultatBinari;
    }
}