package Calculs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fraccio {
    List<String> signeList;
    private String resultat;

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

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    static class main {
        public static void main(String[] args) {
            Fraccio c = new Fraccio("2/3 |+| 5/3 |+| 8/3");
        }
    }
}
