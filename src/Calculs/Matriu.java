package Calculs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matriu {
    private List<String> signeList;
    private String resultat;

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

        String[] resultat = new String[resultatList.size()];
        resultatList.toArray(resultat);

        String stringProva = "";
        List<String> llistaProva = new ArrayList<>();
        int ta = 1;
        for (int i = 0; i < resultat.length; i++) {
            for (int j = 2; j < resultat[i].length() - 2; j++) {
                String actual = Character.toString(resultat[i].charAt(j));

                if (actual.equals("}")) {
                    actual.replace("}", "/");
                    if (i == 0) {
                        ta++;
                    }
                } else if (actual.equals("{")) {
                    actual.replace("{", "");
                } else if (actual.equals(",")) {
                    actual.replace(",", "");
                } else {
                    stringProva = stringProva + actual;
                }
            }
            llistaProva.add(stringProva);
            stringProva = "";
        }

        System.out.println(llistaProva);
        System.out.println(ta);
        System.out.println("Llargaria tamany matrius totals: " + llistaProva.size());
        System.out.println("Llargaria de cada matriu: " + ta);


        int [] matriuDeMatriu = new int[ta];
        for (int i = 0; i < 1; i++) {
            String actual = llistaProva.get(i);
            int actualMatriu =  actual.charAt(i);
            System.out.println(actualMatriu);

        }
        int [][] matriuPasada = new int[2][ta];

    }
    public static int[][] sumaMatrius(int[][] matriu1, int[][] matriu2) throws Exception {
        int[][] resultatSumaMatrius = new int[matriu1.length][matriu2.length];

        for (int i = 0; i < matriu1.length; i++) {
            for (int j = 0; j < matriu2.length; j++) {
                resultatSumaMatrius[i][j] = matriu1[i][j] + matriu2[i][j];
            }
        }
        System.out.println();
        return null;
    }

    static class main {
        public static void main(String[] args) {
            Matriu c = new Matriu("{{1, 2, 3}{3, 4, 5}{6, 7, 8}{1, 2, 3}{3, 4, 5}{6, 7, 8}} |+| {{5, 6, 7}{7, 8, 9}{7, 8, 9}{1, 2, 3}{3, 4, 5}{6, 7, 8}}");

        }
    }
}
