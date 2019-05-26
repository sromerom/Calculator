package Calculs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe Matriu que ens permet calcular matrius, ja sigui fent una suma, una resta o una multipliacio.
 * @author Samuel Romero Marín
 */
public class Matriu {
    private String signeList;
    private int [][] resultat;

    /**
     * Constructor de la classe Matriu que el que fara principialment es preparar operacio introduida per posteriorment
     * cridar als corresponent metode de l'operacio en concret.
     * @param operacio Parametre operacio a on es troban tota la operacio a calcular entre matrius.
     */
    public Matriu(String operacio) {
        List<String> resultatList = new ArrayList<>();
        String[] split = operacio.split("\\|");
        System.out.println(Arrays.toString(split));


        for (int i = 0; i < split.length; i += 2) {
            resultatList.add(split[i].replaceAll(" ", ""));
        }

        for (int i = 1; i < split.length; i += 2) {
            signeList = split[i].replaceAll(" ", "");
        }

        System.out.println("Signes: " + signeList);
        System.out.println("Numeros" + resultatList);

        String[] resultatf = new String[resultatList.size()];
        resultatList.toArray(resultatf);

        String stringProva = "";
        List<String> llistaProva = new ArrayList<>();
        int ta = 1;
        int comes = 0;
        boolean primeresComes = true;
        for (int i = 0; i < resultatf.length; i++) {
            for (int j = 2; j < resultatf[i].length() - 2; j++) {
                String actual = Character.toString(resultatf[i].charAt(j));

                if (actual.equals("}")) {
                    actual.replace("}", "/");
                    primeresComes = false;
                    if (i == 0) {
                        ta++;
                    }
                } else if (actual.equals("{")) {
                    actual.replace("{", "");
                } else if (actual.equals(",")) {
                    actual.replace(",", "");
                    if (primeresComes) {
                        comes++;
                    }
                } else {
                    stringProva = stringProva + actual;
                }
            }
            llistaProva.add(stringProva);
            stringProva = "";
        }
        System.out.println(llistaProva);
        System.out.println("Llargaria tamany matrius totals: " + llistaProva.size());
        System.out.println("Llargaria de cada matriu: " + ta);
        comes = comes + 1;
        System.out.println("Dades de cada matriu: " + comes);

        int [][] matriu1 = new int [ta][comes];
        int [][] matriu2 = new int [ta][comes];
        int comparant = 0;
        int c = 0;

        for (int j = 0; j < ta; j++) {
            comparant = 0;
            String actualMatriu = llistaProva.get(0);
            int actualCaracter;
            while (comparant < comes) {
                actualCaracter = Character.getNumericValue(actualMatriu.charAt(c));
                if (comparant == 0) {
                    matriu1[j][comparant] = actualCaracter;
                } else {
                    matriu1[j][comparant] = actualCaracter;
                }
                comparant++;
                c++;
            }

        }

        c = 0;
        for (int j = 0; j < ta; j++) {
            comparant = 0;
            String actualMatriu = llistaProva.get(1);
            int actualCaracter;
            while (comparant < comes) {
                actualCaracter = Character.getNumericValue(actualMatriu.charAt(c));
                if (comparant == 0) {
                    matriu2[j][comparant] = actualCaracter;
                } else {
                    matriu2[j][comparant] = actualCaracter;
                }
                comparant++;
                c++;
            }

        }
        System.out.println(Arrays.deepToString(matriu1));
        System.out.println(Arrays.deepToString(matriu2));


        if (signeList.equals("+")) {
            resultat = sumaMatrius(matriu1, matriu2);
        } else if (signeList.equals("-")) {
            resultat = restaMatrius(matriu1, matriu2) ;
        } else if (signeList.equals("*")) {
            resultat = mult(matriu1, matriu2);
        }

        System.out.println(Arrays.deepToString(resultat));


    }

    /**
     * Metode sumaMatrius que ens permetra sumar matrius.
     * @param matriu1 Parametre d'un array bidimensional de la primera matriu a sumar.
     * @param matriu2 Parametre d'un array bidimensional de la segona matriu a sumar.
     * @return Retorna la solucio de la suma d'aquestes dos matrius introduides
     */
    public static int[][] sumaMatrius(int[][] matriu1, int[][] matriu2){
        int[][] resultatSumaMatrius = new int[matriu1.length][matriu2.length];

        for (int i = 0; i < matriu1.length; i++) {
            for (int j = 0; j < matriu2.length; j++) {
                resultatSumaMatrius[i][j] = matriu1[i][j] + matriu2[i][j];
            }
        }
        System.out.println();
        return resultatSumaMatrius;
    }

    /**
     * Metode restaMatrius que ens permet restar matrius entre si
     * @param matriu1 Parametre d'un array bidimensional de la primera matriu a restar.
     * @param matriu2 Parametre d'un array bidimensional de la segona matriu a restar.
     * @return Retorna la solucio de la resta d'aquestes dos matrius introduides
     */
    public static int[][] restaMatrius(int[][] matriu1, int[][] matriu2){
        int[][] resultatSumaMatrius = new int[matriu1.length][matriu2.length];

        for (int i = 0; i < matriu1.length; i++) {
            for (int j = 0; j < matriu2.length; j++) {
                resultatSumaMatrius[i][j] = matriu1[i][j] - matriu2[i][j];
            }
        }
        System.out.println();
        return resultatSumaMatrius;
    }


    /**
     * Metode mult que ens permet mulitplicar matrius entre si
     * @param mat1 Parametre d'un array bidimensional de la primera matriu a multiplicar.
     * @param mat2 Parametre d'un array bidimensional de la segona matriu a multiplicar.
     * @return
     */
    static int[][] mult(int[][] mat1, int[][] mat2) {
        int dimv1 = mat1.length;
        int dimh1 = mat1[0].length;
        int dimv2 = mat2.length;
        int dimh2 = mat2[0].length;
        if (dimh1 != dimv2) {
            // Les matrius no són compatibles
            return null;
        }

        // Creació de la matriu resultat amb les dimensions corresponents
        int[][] result = new int[dimv1][dimh2];

        // Operem
        for (int line = 0; line < dimv1; line++) {
            for (int col = 0; col < dimh2; col++) {
                int part = 0;
                for (int i = 0; i < dimh1; i++) {
                    part += mat1[line][i] * mat2[i][col];
                }
                result[line][col] = part;
            }
        }

        // Tornem el resultat
        return result;
    }

    /**
     * Metode getter que ens permet aconseguir el valor actual del resultat
     * @return Retorna el resultat del calcul que s'ha fet anteriorment
     */
    public int[][] getResultat() {
        return resultat;
    }

}
