package Calculs;

import java.util.*;

/**
 * La classe NumeroRoma ens permetra fer calculs entre numeros romans.
 * @author Samuel Romero Marín
 * @version 0.7.0
 * @since 0.7.0
 */
public class NumeroRoma {
    private String operacio;
    private String resultat;
    private final static TreeMap<Integer, String> map = new TreeMap<>();

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

    /**
     * Constructor de la classe NumeroRoma que ens permetra calcular entre numeros romans fer servint els metodes de
     * calcul.
     * @param operacio Parametre String que li passem amb l'operacio amb numeros romans
     */
    public NumeroRoma(String operacio) {
        int resultatDecimal = 0;
        this.operacio = operacio;
        List<String> signes = aconsegueixSignes(operacio);
        String[] numeros = aconseguiexNumeros(operacio);

        System.out.println(Arrays.toString(numeros));
        System.out.println(signes);

        for (int i = 0; i < numeros.length; i++) {
            if (signes.get(0).equals("+")) {
                resultatDecimal = resultatDecimal + convertirRoma(numeros[i]);
            } else if (signes.get(0).equals("-")){
                if (i == 0) {
                    resultatDecimal = convertirRoma(numeros[i]);
                } else {
                    resultatDecimal = resultatDecimal - convertirRoma(numeros[i]);
                }
            } else if (signes.get(0).equals("*")) {
                if (i == 0) {
                    resultatDecimal = convertirRoma(numeros[i]);
                } else {
                    resultatDecimal = resultatDecimal * convertirRoma(numeros[i]);
                }
            } else if (signes.get(0).equals("/")) {
                if (i == 0) {
                    resultatDecimal = convertirRoma(numeros[i]);
                } else {
                    resultatDecimal = resultatDecimal / convertirRoma(numeros[i]);
                }
            }
        }

        resultat = convertirRoma(resultatDecimal);


    }


    /**
     * Metode que ens permet passar d'un numero decimal o arabic a roma. No nomes això si no que tambe ens permet passar
     * d'una operacio que li passem con a parametre fins arribar a un numero decimal.
     * @param operacio Parametre String que li passem amb l'operacio que s'ha introduit.
     * @return Retorna el resultat en numero arabic o decimal de l'operacio que s'ha introduit.
     */
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

    /**
     * Metode convertirRoma que ens permet passar d'un numero arabic o decimal a un numero roma. Aquest metode
     * s'utilitzara una vegada tinguem el resultat de l'operacio introduida en decimal i aquest decimal ho volguem tornar
     * a passar a Roma.
     * @param number Parametre int del decimal que volem passar a roma.
     * @return Retorna un numero Roma
     */
    public final static String convertirRoma(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + convertirRoma(number-l);
    }


    /**
     * Metode aconsguiexSignes que ens permet aconsguir els signes del string que ens passa l'usuari (operacio). Metode
     * molt parescut al "separa()" de la classe Calcul.
     * @param operacio Parametre String amb l'operacio que volem separar.
     * @return Retorna els signes de l'actual operacio que ha introduit l'usuari.
     */
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

    /**
     * Metode aconseguiexNumeros que ens permet aconsguir el numeros a partir d'un string. Metode molt parescut al
     * "separa()" de la classe Calcul.
     * @param operacio Parametre String amb l'operacio que volem separar.
     * @return Retorna els numeros de l'actual operacio que ha introduit l'usuari.
     */
    public static String[] aconseguiexNumeros(String operacio) {
        String regEx = "[\\+\\-\\*\\/]";
        String split[] = operacio.split(regEx);
        String[] numbers = new String[split.length];

        for (int i = 0; i < split.length; i++) {
            numbers[i] = split[i].replaceAll(" ", "");
        }

        return numbers;
    }


    /**
     * Metode getter que ens permet aconseguir el resultat que en ha donat
     * @return Retorna el valor de la variable resultat amb el resultat del calcul.
     */
    public String getResultat() {
        return resultat;
    }

}


