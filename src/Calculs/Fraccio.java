package Calculs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe Fraccio que ens permet calcular les operacion a on hagui fraccions
 * @author Samuel Romero Marín
 * @version 0.7.0
 * @since 0.7.0
 */
public class Fraccio {
    private List<String> signeList;
    private String resultat;

    /**
     * Constructor de Fraccio a on separarem els signes del numeros i calcularem segons el signe aconsguit la fraccio
     * corresponent i es donara el resultat
     * @param operacio Parametre String de l'operacio que introduiex l'usuari amb les fraccions a calcular.
     */
    public Fraccio(String operacio) {
        String parts[] = operacio.split("\\|");
        List<Integer> numeradors = new ArrayList<>();
        List<Integer> denominadors = new ArrayList<>();
        List<String> resultatList = new ArrayList<>();
        System.out.println(Arrays.toString(parts));

        for (int i = 0; i < parts.length; i += 2) {
            resultatList.add(parts[i].replaceAll(" ", ""));
        }

        signeList = new ArrayList<>();
        for (int i = 1; i < parts.length; i += 2) {
            signeList.add(parts[i].replaceAll(" ", ""));
        }

        String[] signeFraccio = new String[signeList.size()];
        signeList.toArray(signeFraccio);
        System.out.println("signos" + Arrays.toString(signeFraccio));
        String[] operacioArray = new String[resultatList.size()];
        resultatList.toArray(operacioArray);

        preparaFraccio(operacioArray, numeradors, denominadors);

        System.out.println("numeradors: " + numeradors);
        System.out.println("denominadors" + denominadors);

        int c = 0;
        for (int i = 0; i < signeFraccio.length; i++, c++) {
            String actualSigne = signeFraccio[i];
            if (actualSigne.equals("+") || actualSigne.equals("-")) {
                if (!denominadors.get(0).equals(denominadors.get(1))) {
                    int mcm = mcm(denominadors.get(0), denominadors.get(1));
                    int primerDenominador = mcm / denominadors.get(0);
                    int numeradorCalPrimer = primerDenominador * numeradors.get(0);

                    int segonDenominador = mcm / denominadors.get(1);
                    int numeradorCalSegon = segonDenominador * numeradors.get(1);

                    String[] arrayPreparacio = new String[2];
                    arrayPreparacio[0] = numeradorCalPrimer + "/" + mcm;
                    arrayPreparacio[1] = numeradorCalSegon + "/" + mcm;

                    numeradors.clear();
                    denominadors.clear();
                    preparaFraccio(arrayPreparacio, numeradors, denominadors);

                    System.out.println(numeradors);
                    System.out.println(denominadors);
                }
                if (actualSigne.equals("+")) {
                    int suma = numeradors.get(0) + numeradors.get(1);
                    resultat = suma + "/" + denominadors.get(0);

                } else {
                    int resta = numeradors.get(0) - numeradors.get(1);
                    resultat = resta + "/" + denominadors.get(0);
                }
            } else if (actualSigne.equals("*")) {
                int mulNumerador = numeradors.get(0) * numeradors.get(1);
                int mulDenominador = denominadors.get(0) * denominadors.get(1);
                resultat = mulNumerador + "/" + mulDenominador;
            } else if (actualSigne.equals("/")) {
                int divNumerador = numeradors.get(0) * denominadors.get(1);
                int divDenominador = denominadors.get(0) * numeradors.get(1);
                resultat = divNumerador + "/" + divDenominador;
            }
        }




        
        System.out.println("Resultat total: " + resultat);

    }

    /**
     * Metode senzill per calcular el mcm de dos numeros, en aquest cas per calcular el mcm del denominadors en el cas
     * que no siguin iguals
     * @param den1 Parametre int del primer denominador
     * @param den2 Parametre int del segon denominador
     * @return Retorna el resultat del minim comu multiple dels dos numeros introduits
     */
    public static int mcm(int den1, int den2) {
        int mcm = 1;
        int i = 2;

        while (i <= den1 || i <= den2) {
            if (den1 % i == 0 || den2 % i == 0) {
                mcm = mcm * i;
                if (den1 % i == 0) den1 = den1 / i;
                if (den2 % i == 0) den2 = den2 / i;
            } else {
                i = i + 1;
            }
        }
        return mcm;
    }

    /**
     * Metode void que ens permet prepapar la següent passa del calcul i que consisteix en separar el numeradors i
     * denominadors en dos llistes diferents.
     * @param operacioArray Parametre a on estan tots els numeros a separar
     * @param numeradors Paramaetre List que ens permetra anar guardant tots els numeradors en ella
     * @param denominadors Paramaetre List que ens permetra anar guardant tots els denominadors en ella
     */
    public void preparaFraccio(String[] operacioArray, List numeradors, List denominadors) {
        String operacioArrayString = "";

        for (int i = 0; i < operacioArray.length; i++) {
            operacioArrayString = operacioArrayString + operacioArray[i] + "/";
        }

        String[] splitOperacio = operacioArrayString.split("/");

        for (int i = 0; i < splitOperacio.length; i++) {
            int actual = Integer.parseInt(splitOperacio[i]);
            if (i % 2 == 0) {
                numeradors.add(actual);
            } else {
                denominadors.add(actual);
            }
        }
    }

    /**
     * Metode getter que ens serveir per aconseguir el resultat total de les fraccions
     * @return Retorna el resultat entre les fraccions introduides
     */
    public String getResultat() {
        return resultat;
    }

}
