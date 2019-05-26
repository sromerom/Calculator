package Calculs;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * La classe Calcul ens permetra fer tota la logica respecte als calculs que es podran fer en la calculadora. Segons
 * els tipus de calcul elegit en els JComboBox anterior es fara una operacio o una altra. En cada tipus de calcul podrem
 * instanciar el tipus de operacio en concret o simplement no fer-ho.
 *
 * Aquesta classe s'instanciara en els keypads corresponents
 * @author Samuel Romero Marín
 * @version 0.7.0
 * @since 0.7.0
 */
public class Calcul {
    private String operacio;
    private String tipusCalcul;
    private int[] numbers;
    private List<String> signes;
    private String resultatString = "";
    private String signePolinomi = "";
    //private String resultatConversio;
    private int resultatDecimal;
    private String resultatOctal;
    private String resultatHexacimal;
    private String resultatBinari;
    private BufferedWriter bw = null;
    private FileWriter fw = null;

    /**
     * Constructor de la classe calcul a on ens permetra saber quin calcul ha elegit l'usuari i executar la corresponent
     * logica
     * @param operacio Parametre String a on l'usuari ha introduit l'operacio a calcular
     * @param tipusCalcul Parametre String del tipus de calcul que ha elegit l'usuari
     */
    public Calcul(String operacio, String tipusCalcul) {
        this.operacio = operacio;
        this.tipusCalcul = tipusCalcul;

        switch (tipusCalcul) {
            case "POLINOMI":

                Polynomial[] resultat = calculPolinomi(operacio);
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
                    resultatString = "[[0,0][0,0]]";
                } else {
                    resultatString = Arrays.deepToString(m.getResultat());
                }
                break;
            case "OCTAL":

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
                    String[] split = operacio.split("sin");
                    double number = Integer.parseInt(split[1].replaceAll(" ", ""));
                    double res = Math.sin(number);
                    resultatString = Double.toString(res);

                } else if (operacio.contains("cos")) {
                    String[] split = operacio.split("cos");
                    double number = Integer.parseInt(split[1].replaceAll(" ", ""));
                    double res = Math.cos(number);
                    resultatString = Double.toString(res);
                } else if (operacio.contains("log")) {
                    String[] split = operacio.split("log");
                    double number = Integer.parseInt(split[1].replaceAll(" ", ""));
                    double res = Math.log10(number);
                    resultatString = Double.toString(res);
                } else if (operacio.contains("ln")) {
                    String[] split = operacio.split("ln");
                    double number = Integer.parseInt(split[1].replaceAll(" ", ""));
                    double res = Math.log(number);
                    resultatString = Double.toString(res);

                } else if (operacio.contains("exp")) {
                    String[] split = operacio.split("exp");
                    System.out.println(Arrays.toString(split));

                    int numInicial = Integer.parseInt(split[0]);
                    int numZeros = Integer.parseInt(split[1]);
                    String resultatExp = Integer.toString(numInicial);
                    for (int i = 0; i < numZeros; i++) {
                        resultatExp = resultatExp + 0;
                    }

                    resultatString = resultatExp;

                } else if (operacio.contains("!")) {
                    String[] split = operacio.split("!");
                    System.out.println(Arrays.toString(split));

                    double factorial = 1;
                    double numeroIntroduit = Double.parseDouble(split[0]);

                    while (numeroIntroduit != 0) {
                        factorial = factorial * numeroIntroduit;
                        numeroIntroduit--;
                    }

                    resultatString = Double.toString(factorial);
                } else {
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

    /**
     * Metode void que ens permet crear el fitxer a on es guardaran totes les operacions que faci l'usuari.
     * Aquest metode afegira al fitxer cada operació que facem.
     * @throws Exception Llançar excepcio per tal d'evitar possibles exceptions del OutputStream
     */
    public void historial() throws Exception {
        String data;
        if (tipusCalcul.equals("DECIMAL") || tipusCalcul.equals("OCTAL") || tipusCalcul.equals("HEXADECIMAL") || tipusCalcul.equals("BINARI")) {
            data = tipusCalcul + ": " + "Decimal: " + getResultatDecimal() + " Octal: " + getResultatOctal() + " Hexadecimal: " + getResultatHexacimal() + " Binari" + getResultatBinari() + "|";
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

    /**
     * Metode separa que ens permetra separar el String que ens passa l'usuari en un array de numeros i una llista de
     * signes
     * @param operacio Parametre operacio que ens passa l'usuari
     */
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

    /**
     * Metode calculSimple que ens permet fer calculs basics de sumar, restar, multiplicacio i divisio sense tenir en
     * compte prioritats ni parentesis
     * @param numbers Parametre numbers que ens passen una array de numbers creat anteriorment amb el metode separa()
     * @param signes Parametre signes que ens passen una llista de signes creat anteriorment amb el metode separa()
     * @return Retornara el resultat total de l'operacio que ha introduit l'usuari
     */
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

    /**
     * Metode que ens permetra aconseguir tots els polinomis que ha introduit l'usuari en el String "Operacio"
     * @param polinomi Parametre polinomi del String que ens passa l'usuari (operacio)
     * @return Retorna un array de Polynomials de tots els polinomis que l'usuari ha introduit
     */
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

    /**
     * Metode getter per aconsguir el resultat que s'ha calculat
     * @return Retorna el resultat que s'ha d'enssenyar per pantalla
     */
    public String getResultatString() {
        return resultatString;
    }

    /**
     * Metode setter per assignar un valor al resultat que posteriorment entregarem a l'usuari com resultat
     * @param resultatString Parametre del actual resultatString
     */
    public void setResultatString(String resultatString) {
        this.resultatString = resultatString;
    }


    /**
     * Metode getter per aconseguir el l'operacio String que ha introduit l'usuari
     * @return Retorna l'operació en string que ha introduit l'usuari
     */
    public String getOperacio() {
        return operacio;
    }


    /**
     * Metode getter per aconseguir el resultat en decimal en cas que l'usuari estigui fent operacions ens base 2, 8, 16
     * @return Retorna l'equivalent del numero intrduit en decimal
     */
    public int getResultatDecimal() {
        return resultatDecimal;
    }


    /**
     * Metode getter per aconseguir el resultat en octal en cas que l'usuari estigui fent operacions ens base 2, 8, 16
     * @return Retorna l'equivalent del numero intrduit en octal
     */
    public String getResultatOctal() {
        return resultatOctal;
    }


    /**
     * Metode getter per aconseguir el resultat en hexadecimal en cas que l'usuari estigui fent operacions ens base 2, 8, 16
     * @return Retorna l'equivalent del numero intrduit en hexadecimal
     */
    public String getResultatHexacimal() {
        return resultatHexacimal;
    }


    /**
     * Metode getter per aconseguir el resultat en binari en cas que l'usuari estigui fent operacions ens base 2, 8, 16
     * @return Retorna l'equivalent del numero intrduit en binari
     */
    public String getResultatBinari() {
        return resultatBinari;
    }

}
