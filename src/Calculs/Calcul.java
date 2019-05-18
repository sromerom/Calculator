package Calculs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Calcul {
    private int[] numbers;
    private List<String> signes;
    private String resultatString = "";
    String signePolinomi = "";

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
        /*
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
        */
        //System.out.println("TipusCalcul: " + tipusCalcul);
        //System.out.println("Numbers: " + Arrays.toString(numbers));
        //this.numbers = numbers;

        //System.out.println("Signes: " + signes);
        //this.signes = signes;

        System.out.println(operacio);


        if (tipusCalcul.equals("POLINOMI")) {
            System.out.println("Funciona POLINOMI");

            //suma
            //Polynomial p1 = new Polynomial("2x^2 + 3x - 5");
            //Polynomial p2 = new Polynomial("7x^2 + 10");
            //System.out.println(p1.add(p2).toString());

            //multiplicacio
            //Polynomial p1 = new Polynomial("x^4 - 6x^2 + 8");
            //Polynomial p2 = new Polynomial("-6x^6 - 91x + 12");
            //System.out.println(p1.mult(p2).toString());
            //System.out.println(Arrays.toString(calculPolinomi(operacio)));


            Polynomial[] resultat = calculPolinomi(operacio);
            System.out.println("signoooooooooooo" + signePolinomi);
            //System.out.println(resultat[0].add(resultat[1]).toString());

            for (int i = 0; i < resultat.length; i++) {
                if (i == 0) {
                    continue;
                } else {
                    if (signePolinomi.equals("+")) {
                        System.out.println("Es una suma!!!!!!!");
                        setResultatString(resultat[i - 1].add(resultat[i]).toString());
                    } else if (signePolinomi.equals("*")) {
                        System.out.println("Es una multiplicacion!!!!!!!!!!!");
                        setResultatString(resultat[i - 1].mult(resultat[i]).toString());
                    }
                }
            }
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

    public Polynomial[] calculPolinomi(String polinomi) {
        String parts[] = polinomi.split("\\|");
        Polynomial[] resultat;
        List<Polynomial> polynomialsList = new ArrayList<>();

        for (int i = 0; i < parts.length; i += 2) {
            signePolinomi = parts[1].replaceAll(" ", "");
            polynomialsList.add(new Polynomial(parts[i]));
        }

        resultat = new Polynomial[polynomialsList.size()];
        polynomialsList.toArray(resultat);


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
