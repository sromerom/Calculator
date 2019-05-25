package Calculs;

import Calculadora.Calculator;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.*;
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
    //private String resultatConversio;
    private int resultatDecimal;
    private String resultatOctal;
    private String resultatHexacimal;
    private String resultatBinari;
    BufferedWriter bw = null;
    FileWriter fw = null;

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
                resultatString = numeroroma.getResultat();
                break;
            case "FRACCIONS":
                Fraccio f = new Fraccio(operacio);
                resultatString = f.getResultat();
                break;
            case "MATRIUS":
                Matriu m = new Matriu(operacio);
                if (Arrays.deepToString(m.getResultat()).equals("null")) {
                    System.out.println("Es resta!!");
                    resultatString = "[[0,0][0,0]]";
                } else {
                    resultatString = Arrays.deepToString(m.getResultat());
                }
                System.out.println("????" + Arrays.deepToString(m.getResultat()));
                break;
            case "OCTAL":
                //separa(operacio);
                //resultatString = Integer.toString(calculSimple(numbers, signes));

                ConversorBase conversorBase = new ConversorBase(operacio, tipusCalcul);
                resultatDecimal = conversorBase.getResultatDecimal();
                resultatOctal = conversorBase.getResultatOctal();
                resultatHexacimal = conversorBase.getResultatHexacimal();
                resultatBinari = conversorBase.getResultatBinari();

                break;
            case "HEXADECIMAL":
                ConversorBase conversorBase2 = new ConversorBase(operacio, tipusCalcul);
                resultatDecimal = conversorBase2.getResultatDecimal();
                resultatOctal = conversorBase2.getResultatOctal();
                resultatHexacimal = conversorBase2.getResultatHexacimal();
                resultatBinari = conversorBase2.getResultatBinari();
                break;
            case "BINARI":
                ConversorBase conversorBase3 = new ConversorBase(operacio, tipusCalcul);
                resultatDecimal = conversorBase3.getResultatDecimal();
                resultatOctal = conversorBase3.getResultatOctal();
                resultatHexacimal = conversorBase3.getResultatHexacimal();
                resultatBinari = conversorBase3.getResultatBinari();

                break;
            case "RPN":
                System.out.println("FuncionaRPN");
                separa(operacio);
                resultatString = Integer.toString(calculSimple(numbers, signes));
                break;
            case "PER_DEFECTE":
                System.out.println("Funcion per defecte");

                if (operacio.contains("sin")) {
                    String [] split = operacio.split("sin");
                    double number = Integer.parseInt(split[1].replaceAll(" ", ""));
                    double res = Math.sin(number);
                    resultatString = Double.toString(res);

                } else if (operacio.contains("cos")) {
                    String [] split = operacio.split("cos");
                    double number = Integer.parseInt(split[1].replaceAll(" ", ""));
                    double res = Math.cos(number);
                    resultatString = Double.toString(res);
                } else if (operacio.contains("log")) {
                    String [] split = operacio.split("log");
                    double number = Integer.parseInt(split[1].replaceAll(" ", ""));
                    double res = Math.log10(number);
                    resultatString = Double.toString(res);
                } else if (operacio.contains("ln")) {
                    String [] split = operacio.split("ln");
                    double number = Integer.parseInt(split[1].replaceAll(" ", ""));
                    double res = Math.log(number);
                    resultatString = Double.toString(res);

                } else if (operacio.contains("exp")) {
                    String [] split = operacio.split("exp");
                    System.out.println(Arrays.toString(split));

                    int numInicial = Integer.parseInt(split[0]);
                    int numZeros = Integer.parseInt(split[1]);
                    String resultatExp = Integer.toString(numInicial);
                    for (int i = 0; i < numZeros; i++) {
                        resultatExp = resultatExp + 0;
                    }

                    resultatString = resultatExp;

                    System.out.println(resultatExp);
                } else if (operacio.contains("!")) {
                    String [] split = operacio.split("!");
                    System.out.println(Arrays.toString(split));

                    double factorial = 1;
                    double numeroIntroduit = Double.parseDouble(split[0]);

                    while ( numeroIntroduit != 0) {
                        factorial = factorial * numeroIntroduit;
                        numeroIntroduit--;
                    }

                    resultatString = Double.toString(factorial);
                }

                else {
                    separa(operacio);
                    resultatString = Integer.toString(calculSimple(numbers, signes));
                }
                break;
            default:

        }

        try {
            historial();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void historial() throws Exception {
        String data;
        if (tipusCalcul.equals("DECIMAL") || tipusCalcul.equals("OCTAL") || tipusCalcul.equals("HEXADECIMAL") ||tipusCalcul.equals("BINARI")) {
            System.out.println("Es tipo base!!");
            data = tipusCalcul + ": " + "Decimal: " + getResultatDecimal() + " Octal: " +getResultatOctal() + " Hexadecimal: " + getResultatHexacimal() + " Binari" + getResultatBinari() + "|";
        } else {
            data = getOperacio() + "=" + getResultatString() + "|";
        }
        System.out.println("aaaa" + data);
        File file = new File("C:\\Users\\Samuel Romero Marín\\Desktop\\historialCalc.txt");

        if (!file.exists()) {
            file.createNewFile();
        }
        // flag true, indica adjuntar información al archivo.
        fw = new FileWriter(file.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(data);
        System.out.println("información agregada!");
        bw.close();
        fw.close();
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
    /*
    public String getResultatConversio() {
        return resultatConversio;
    }

    public void setResultatConversio(String resultatConversio) {
        this.resultatConversio = resultatConversio;
    }
*/
    public String getOperacio() {
        return operacio;
    }

    public void setOperacio(String operacio) {
        this.operacio = operacio;
    }

    public int getResultatDecimal() {
        return resultatDecimal;
    }

    public void setResultatDecimal(int resultatDecimal) {
        this.resultatDecimal = resultatDecimal;
    }

    public String getResultatOctal() {
        return resultatOctal;
    }

    public void setResultatOctal(String resultatOctal) {
        this.resultatOctal = resultatOctal;
    }

    public String getResultatHexacimal() {
        return resultatHexacimal;
    }

    public void setResultatHexacimal(String resultatHexacimal) {
        this.resultatHexacimal = resultatHexacimal;
    }

    public String getResultatBinari() {
        return resultatBinari;
    }

    public void setResultatBinari(String resultatBinari) {
        this.resultatBinari = resultatBinari;
    }
}
