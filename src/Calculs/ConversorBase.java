package Calculs;

/**
 * Classe ConversosBase que ens permetra fer conversions entre bases 2, 8 i 16. Segons la base que introdueixi l'usuari
 * es calcular cada un d'aquest incloent binari
 * @author Samuel Romero Marín
 * @version 0.7.0
 * @since 0.7.0
 */
public class ConversorBase {
    private int resultatDecimal;
    private String resultatOctal;
    private String resultatHexacimal;
    private String resultatBinari;

    /**
     * Constructor de ConversorBase que segons una operacio i un tipus d'operacio fara les respectives conversions. Cada
     * canvi de tipus d'operació s'haura de variar el resultat.
     * @param operacio Parametre de l'operacio que introduiex l'usuari
     * @param tipusOp Parametre del tipus operacio de base que introduiex l'usuari
     */
    public ConversorBase(String operacio, String tipusOp) {

        if (tipusOp.equals("OCTAL")) {

            //Ficam els numeros resultants en format octal en un array
            int[] resultatArray = new int[operacio.length()];
            for (int c = 0; c < resultatArray.length; c++) {
                int resint = Integer.parseInt(String.valueOf(operacio.charAt(c)));
                resultatArray[c] = resint;
            }

            //Aplicam formula per tal de aconseguir el tamany en format decimal
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

    /**
     * Metode getter per aconseguir el resultat en decimal que ha fet el constructor.
     * @return Retorna el resultat calculat en decimal.
     */
    public int getResultatDecimal() {
        return resultatDecimal;
    }


    /**
     * Metode getter per aconseguir el resultat en octal que ha fet el constructor.
     * @return Retorna el resultat calculat en octal.
     */
    public String getResultatOctal() {
        return resultatOctal;
    }


    /**
     * Metode getter per aconseguir el resultat en hexadecimal que ha fet el constructor.
     * @return Retorna el resultat calculat en hexadecimal.
     */
    public String getResultatHexacimal() {
        return resultatHexacimal;
    }


    /**
     * Metode getter per aconseguir el resultat en binari que ha fet el constructor.
     * @return Retorna el resultat calculat en binari.
     */
    public String getResultatBinari() {
        return resultatBinari;
    }

}