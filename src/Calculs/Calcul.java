package Calculs;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Calcul {
    private int [] numbers;
    private List<String> signes;
    private String resultatString = "";

    public String getResultatString() {
        return resultatString;
    }

    public void setResultatString(String resultatString) {
        this.resultatString = resultatString;
    }

    private enum tipusCalcul {
        NORMAL,
        ROMA,
        POLINOMIS

    }
    String actualCalcul = "";

    public Calcul() {

    }

    public Calcul(String operacio, String tipusCalcul) {
        String regEx = "[\\+\\-\\*\\/]";
        String split[] = operacio.split(regEx);
        int[] numbers = new int[split.length];
        List<String> signes = new ArrayList<>();
        int resultatInt  = 0;

        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }

        for (int i = 0; i < operacio.length(); i++) {
            char actual = operacio.charAt(i);
            String actualString = Character.toString(actual);
            if (actual == 42 || actual == 43 || actual == 45 || actual == 47) {
                signes.add(actualString);
            }
        }

        System.out.println("TipusCalcul: " + tipusCalcul);
        System.out.println("Numbers: " + Arrays.toString(numbers));
        this.numbers = numbers;

        System.out.println("Signes: " + signes);
        this.signes = signes;

        if (tipusCalcul.equals("POLINOMI")) {
            System.out.println("FuncionaPOLINOMI");
            int calculActual = calculSimple(numbers, signes);
            resultatString = Integer.toString(calculActual);
        }

        if (tipusCalcul.equals("RPN")) {
            System.out.println("FuncionaRPN");
        }
    }

    public static int calculSimple(int[] numbers, List<String> signes) {

        int resultat = 0;
        int recorrNumbers = 0;
        int aux = 0;
        while (aux < signes.size()) {
            //Si el total de numeros es senar l'ultim numero el calcularem diferent
            if (recorrNumbers == signes.size() && numbers.length % 2 != 0) {
                switch (signes.get(aux)) {
                    case "+":
                        resultat = resultat + numbers[numbers.length - 1];
                        break;
                    case "-":
                        resultat = resultat - numbers[numbers.length - 1];
                        break;
                    case "*":
                        resultat = resultat * numbers[numbers.length - 1];
                        break;
                    case "/":
                        resultat = resultat / numbers[numbers.length - 1];
                        break;
                    default:
                        // code block
                }
                break;
            }

            //Si es l'inici del numeros...
            if (recorrNumbers == 0) {
                switch (signes.get(aux)) {
                    case "+":
                        resultat = numbers[0] + numbers[1];
                        break;
                    case "-":
                        resultat = numbers[0] - numbers[1];
                        break;
                    case "*":
                        resultat = numbers[0] * numbers[1];
                        break;
                    case "/":
                        resultat = numbers[0] / numbers[1];
                        break;
                    default:
                        System.out.println("error");
                }

                recorrNumbers += 1;
            } else {
                switch (signes.get(aux)) {
                    case "+":
                        resultat = resultat + numbers[recorrNumbers];
                        break;
                    case "-":
                        resultat = resultat - numbers[recorrNumbers];
                        break;
                    case "*":
                        resultat = resultat * numbers[recorrNumbers];
                        break;
                    case "/":
                        resultat = resultat / numbers[recorrNumbers];
                        break;
                    default:
                        System.out.println("error");
                }

            }

            recorrNumbers++;
            aux++;

        }
        return resultat;
    }


    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public List<String> getSignes() {
        return signes;
    }

    public void setSignes(List<String> signes) {
        this.signes = signes;
    }
}
