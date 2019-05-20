package Calculs;

import java.util.*;

public class NumeroRoma {
    private String operacio;
    private int resultat;

    public NumeroRoma(String operacio) {
        this.operacio = operacio;
        List<String> signes = aconsegueixSignes(operacio);
        String[] numeros = aconseguiexNumeros(operacio);

        System.out.println(Arrays.toString(numeros));
        System.out.println(signes);

        for (int i = 0; i < numeros.length; i++) {
            resultat = resultat + convertirRoma(numeros[i]);
        }
        System.out.println("Resultat total :) " + resultat);
    }

    public static int convertirRoma(String operacio) {
        int resultatConversio = 0;
        int anteriorNumero = 0;
        boolean esta;
        String lletra;
        int valor;
        Map<String, Integer> numRom;
        numRom = new HashMap<>();
        numRom.put("I", 1);
        numRom.put("V", 5);
        numRom.put("X", 10);
        numRom.put("L", 50);
        numRom.put("C", 100);
        numRom.put("D", 500);
        numRom.put("M", 1000);

        for (int i = 0; i < operacio.length(); i++) {

            char lletraChar = operacio.charAt(i);
            lletra = Character.toString(lletraChar).replaceAll(" ", "");

            esta = numRom.containsKey(lletra);
            if (esta) {
                valor = numRom.get(lletra);
                System.out.println("Valor: " + valor);
                resultatConversio = resultatConversio + valor;

                if (anteriorNumero < valor) {
                    resultatConversio = resultatConversio - anteriorNumero * 2;
                    anteriorNumero = valor;
                } else {
                    anteriorNumero = valor;
                }
            } else {
                resultatConversio = 0;
            }
        }
        return resultatConversio;
    }


    public static List<String> aconsegueixSignes(String operacio) {
        String regEx = "[\\+\\-\\*\\/]";
        String split[] = operacio.split(regEx);
        List<String> signes = new ArrayList<>();

        for (int i = 0; i < operacio.length(); i++) {
            char actual = operacio.charAt(i);
            String actualString = Character.toString(actual);
            if (actual == 42 || actual == 43 || actual == 45 || actual == 47) {
                signes.add(actualString);
            }
        }
        return signes;
    }

    public static String[] aconseguiexNumeros(String operacio) {
        String regEx = "[\\+\\-\\*\\/]";
        String split[] = operacio.split(regEx);
        String[] numbers = new String[split.length];

        for (int i = 0; i < split.length; i++) {
            numbers[i] = split[i].replaceAll(" ", "");
        }

        return numbers;
    }

    public String getOperacio() {
        return operacio;
    }

    public void setOperacio(String operacio) {
        this.operacio = operacio;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}


