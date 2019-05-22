package Calculs;

import Calculadora.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Calcul {
    private String operacio;
    private String tipusCalcul;
    private int[] numbers;
    List<String> signes;
    private String resultatString = "";
    String signePolinomi = "";
    private String resultatConversio;

    public Calcul(String operacio, String tipusCalcul) {
        this.operacio = operacio;
        this.tipusCalcul = tipusCalcul;

        switch (tipusCalcul) {
            case "POLINOMI":
                System.out.println("Funciona POLINOMI");

                Polynomial[] resultat = calculPolinomi(operacio);
                //System.out.println("signoooooooooooo" + signePolinomi);
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
                break;
            case "ROMANS":
                NumeroRoma numeroroma = new NumeroRoma(operacio);
                resultatString = Integer.toString(numeroroma.getResultat());
                break;
            case "FRACCIONS":
                Fraccio f = new Fraccio(operacio);
                resultatString = f.getResultat();
                break;
            case "MATRIUS":
                Matriu m = new Matriu(operacio);
                System.out.println("????" + Arrays.deepToString(m.getResultat()));
            case "OCTAL":
                separa(operacio);
                resultatString = Integer.toString(calculSimple(numbers, signes));

                if (signes.size() == 0) {
                    ConversorBase conversorBase = new ConversorBase(operacio, tipusCalcul);
                    resultatConversio = Integer.toString(conversorBase.getResultat());
                } else {
                    ConversorBase conversorBase = new ConversorBase(resultatString, tipusCalcul);
                    resultatConversio = Integer.toString(conversorBase.getResultat());
                }
                break;
            case "HEXADECIMAL":
                ConversorBase conversorBase = new ConversorBase(operacio, tipusCalcul);
                resultatConversio = Integer.toString(conversorBase.getResultat());
                break;
            case "BINARI":
                ConversorBase conversorbase = new ConversorBase(operacio, tipusCalcul);
                resultatConversio = Integer.toString(conversorbase.getResultat());
                break;
            case "RPN":
                System.out.println("FuncionaRPN");
                separa(operacio);
                resultatString = Integer.toString(calculSimple(numbers, signes));
                break;
            default:

        }
    }

    public void separa(String operacio) {
        String regEx = "[\\+\\-\\*\\/]";
        String split[] = operacio.split(regEx);
        int[] numbers = new int[split.length];
        List<String> signes = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i].replaceAll(" ", ""));
        }

        for (int i = 0; i < operacio.length(); i++) {
            char actual = operacio.charAt(i);
            String actualString = Character.toString(actual);
            if (actual == 42 || actual == 43 || actual == 45 || actual == 47) {
                signes.add(actualString);
            }
        }

        this.numbers = numbers;
        this.signes = signes;
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

    public String getResultatString() {
        return resultatString;
    }

    public void setResultatString(String resultatString) {
        this.resultatString = resultatString;
    }

    public String getResultatConversio() {
        return resultatConversio;
    }

    public void setResultatConversio(String resultatConversio) {
        this.resultatConversio = resultatConversio;
    }

}
