package Calculs;

import java.util.*;

public class NumeroRoma {
    private String operacio;
    private String resultat;
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public NumeroRoma(String operacio) {
        int resultatDecimal = 0;
        this.operacio = operacio;
        List<String> signes = aconsegueixSignes(operacio);
        String[] numeros = aconseguiexNumeros(operacio);

        System.out.println(Arrays.toString(numeros));
        System.out.println(signes);

        for (int i = 0; i < numeros.length; i++) {
            resultatDecimal = resultatDecimal + convertirRoma(numeros[i]);
        }

        resultat = toRoman(resultatDecimal);


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

    public final static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
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

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}


