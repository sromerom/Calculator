import Keypads.KeypadBase;
import Keypads.KeypadRomans;
import Keypads.KeypadNormal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Calculator extends JFrame {

    //Keypads a carregar
    KeypadNormal kn;
    KeypadRomans kr;
    KeypadBase kb;

    //JPanel principals
    private JPanel total;
    private JPanel pantalla;
    private JPanel keypad;
    private JPanel opcions;
    private JTextField pantallaOp;
    private JTextField pantallaRes;
    private JComboBox tipusOp;
    private JComboBox tipusBase;
    private CardLayout cl;

    final static String KEYPAD_NORMAL = "Keypad per defecte";
    final static String KEYPAD_ROMANS = "Keypad per operacions amb numeros romans";
    final static String KEYPAD_BASE = "Keypad per operacions amb diferent base (decimal, octal, hexacimal)";

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
                System.out.println(opcioElegida);
                switch (opcioElegida) {
                    case "Tipus operacio":
                        break;
                    case "Polinomi":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("Card 1");
                        break;
                    case "Romans":
                        cl.show(keypad, KEYPAD_ROMANS);
                        System.out.println("Card 2");
                        break;
                    case "RPN":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("Card 1");
                        break;
                    case "Vectors":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("Card 1");
                        break;
                    case "Matrius":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("Card 1");
                        break;
                    case "Fraccions":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("Card 1");
                        break;

                    case "Canvi unitats":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("Card 1");
                        break;
                    case "Canvi diners":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("Card 1");
                        break;
                    default:
                        // code block
                }
            }
        });

        tipusBase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcioElegida = tipusBase.getSelectedItem().toString();
                switch (opcioElegida) {
                    case "Tipus operacio":
                        break;
                    case "Base 2":
                        cl.show(keypad, KEYPAD_ROMANS);
                        System.out.println("Card 1");
                        break;
                    case "Base 8":
                        cl.show(keypad, KEYPAD_ROMANS);
                        System.out.println("Card 1");
                        break;
                    case "Base 16":
                        cl.show(keypad, KEYPAD_ROMANS);
                        System.out.println("Card 1");
                        break;
                    default:

                }
            }
        });


        keypad = new JPanel();
        kn = new KeypadNormal(pantallaRes);
        kr = new KeypadRomans();
        //kb = new KeypadBase();

        total.add(keypad, BorderLayout.CENTER);
        cl = new CardLayout(0, 0);
        keypad.setLayout(cl);
        keypad.add(kn.getNumpadBasic(), KEYPAD_NORMAL);
        keypad.add(kr.getNumpadRomans(), KEYPAD_ROMANS);


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

