package Calculs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matriu {
    private List<String> signeList;
    private int [][] resultat;

    public Matriu(String operacio) {
        List<String> resultatList = new ArrayList<>();
        String[] split = operacio.split("\\|");
        System.out.println(Arrays.toString(split));


        for (int i = 0; i < split.length; i += 2) {
            resultatList.add(split[i].replaceAll(" ", ""));
        }

        signeList = new ArrayList<>();
        for (int i = 1; i < split.length; i += 2) {
            signeList.add(split[i].replaceAll(" ", ""));
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

        resultat = sumaMatrius(matriu1, matriu2);
        System.out.println(Arrays.deepToString(resultat));


    }

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

    public int[][] getResultat() {
        return resultat;
    }

    public void setResultat(int[][] resultat) {
        this.resultat = resultat;
    }

    static class main {
        public static void main(String[] args) {
            Matriu c = new Matriu("{{1, 2}{3, 4}} |+| {{1, 2}{3, 4}}");

            //2 --> 1 = 2
            //3 --> 2 = 3
            //4 --> 3 = 4
        }
    }
}
