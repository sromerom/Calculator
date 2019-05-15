import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Policy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator extends JFrame {
    private JPanel total;
    private JPanel pantalla;
    private JPanel keypad;
    private JPanel opcions;
    private JTextField pantallaOp;
    private JTextField pantallaRes;
    private JComboBox tipusOp;
    private JComboBox tipusBase;
    panel0 p1;
    panel2 p2;
    private CardLayout cl;

    final static String PANTALLA1 = "Pantalla 1";
    final static String PANTALLA2 = "Pantalla 2";
    final static String PANTALLA3 = "Pantalla 3";

    Calculator() {
        this.setContentPane(total);
        tipusOp.addItem("Polinomi");
        tipusOp.addItem("Romans");
        tipusOp.addItem("RPN");
        tipusOp.addItem("Vectors");
        tipusOp.addItem("Matrius");
        tipusOp.addItem("Fraccions");
        tipusOp.addItem("Canvi unitats");
        tipusOp.addItem("Canvi diners");

        tipusBase.addItem("Base 2");
        tipusBase.addItem("Base 8");
        tipusBase.addItem("Base 16");



        // Accion a realizar cuando el JComboBox cambia de item seleccionado.
        tipusOp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcioElegida = tipusOp.getSelectedItem().toString();
                switch (opcioElegida) {
                    case "bàsic":

                        /*
                        butIg.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {

                                String operacio = pantallaOp.getText();
                                String regEx = "[\\+\\-\\*\\/]";
                                String split[] = operacio.split(regEx);
                                int[] numbers = new int[split.length];
                                List<String> signes = new ArrayList<>();

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

                                System.out.println("Numbers: " + Arrays.toString(numbers));
                                System.out.println("Signes: " + signes);

                                int resultat = calcula(numbers, signes);

                                String resultatString = String.valueOf(resultat);
                                pantallaRes.setText(resultatString);
                                System.out.println("Resultat: " + resultat);


                            }

                        });
                        */

                        break;
                    case "Polinomi":
                        cl.show(keypad, PANTALLA1);
                        System.out.println("Card 1");
                        break;
                    case "Romans":
                        cl.show(keypad, PANTALLA2);
                        System.out.println("Card 2");
                        break;
                    case "RPN":

                        break;
                    case "Vectors":

                        break;
                    case "Matrius":

                        break;
                    case "Fraccions":

                        break;

                    case "Canvi unitats":

                        break;
                    case "Canvi diners":
                        System.out.println();
                        break;
                    default:
                        // code block
                }
            }
        });

        keypad = new JPanel();
        p1 = new panel0();
        p2 = new panel2();

        total.add(keypad, BorderLayout.CENTER);
        cl = new CardLayout(0, 0);
        keypad.setLayout(cl);
        keypad.add(p1.getFf(), PANTALLA1);
        keypad.add(p2.getFff(), PANTALLA2);
    }

    public static int calcula(int[] numbers, List<String> signes) {
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

    public JPanel getTotal() {
        return total;
    }

    public void setTotal(JPanel total) {
        this.total = total;
    }
}

