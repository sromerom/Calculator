package Calculs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fraccio {
    String signeFraccio;

    public Fraccio(String operacio) {
        String parts[] = operacio.split("\\|");
        List<Integer> numeradors = new ArrayList<>();
        List<Integer> denominadors = new ArrayList<>();

        List<String> resultatList = new ArrayList<>();
        System.out.println(Arrays.toString(parts));

        for (int i = 0; i < parts.length; i += 2) {
            signeFraccio = parts[1].replaceAll(" ", "");
            resultatList.add(parts[i].replaceAll(" ", ""));
        }

        String[] operacioArray = new String[resultatList.size()];
        resultatList.toArray(operacioArray);

        for (int i = 0; i < operacioArray.length; i++) {
            for (int j = 0; j < 3; j++) {
                char c = operacioArray[i].charAt(j);
                int ccc = Character.getNumericValue(c);
                String cc = Character.toString(c);
                System.out.println(ccc);

                if (cc.equals("/")) {
                    continue;
                }
                if (j == 0) {
                    numeradors.add(ccc);
                } else {
                    denominadors.add(ccc);
                }
            }

        }
        System.out.println("numeradors: " + numeradors);
        System.out.println("denominadors" + denominadors);


    }

    static class main {
        public static void main(String[] args) {
            Fraccio c = new Fraccio("3/6 |+| 3/4");
        }
    }
}
