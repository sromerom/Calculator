package Calculadora;

import Keypads.KeypadBase;
import Keypads.KeypadRomans;
import Keypads.KeypadNormal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
    //private JComboBox aux;
    private CardLayout cl;
    private String opcioElegida;

    private enum tipusOperacions {
        POLINOMI,
        ROMANS,
        RPN,
        VECTORS,
        MATRIUS,
        FRACCIONS,
        CANVI_UNITATS,
        CANVI_MONETARI
    }

    private enum enumTipusBase {
        DECIMAL,
        OCTAL,
        HEXADECIMAL,
        BINARI
    }

    final static String KEYPAD_NORMAL = "Keypad per defecte";
    final static String KEYPAD_ROMANS = "Keypad per operacions amb numeros romans";
    final static String KEYPAD_BASE = "Keypad per operacions amb diferent base (decimal, octal, hexacimal)";

    public Calculator() {

        tipusOp.setUI(new BasicComboBoxUI());
        tipusBase.setUI(new BasicComboBoxUI());
        pantallaRes.setBorder(new EmptyBorder(0,0,0,0));
        pantallaOp.setBorder(new EmptyBorder(0,0,0,0));

        tipusOp.addItem(tipusOperacions.POLINOMI);
        tipusOp.addItem(tipusOperacions.ROMANS);
        tipusOp.addItem(tipusOperacions.RPN);
        tipusOp.addItem(tipusOperacions.VECTORS);
        tipusOp.addItem(tipusOperacions.MATRIUS);
        tipusOp.addItem(tipusOperacions.FRACCIONS);
        tipusOp.addItem(tipusOperacions.CANVI_UNITATS);
        tipusOp.addItem(tipusOperacions.CANVI_MONETARI);

        tipusBase.addItem(enumTipusBase.DECIMAL);
        tipusBase.addItem(enumTipusBase.OCTAL);
        tipusBase.addItem(enumTipusBase.HEXADECIMAL);
        tipusBase.addItem(enumTipusBase.BINARI);


        // Accion a realizar cuando el JComboBox cambia de item seleccionado.
        tipusOp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opcioElegida = tipusOp.getSelectedItem().toString();
                System.out.println(opcioElegida);
                switch (opcioElegida) {
                    case "Tipus operacio":
                        break;
                    case "POLINOMI":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("POLINOMI");
                        break;
                    case "ROMANS":
                        cl.show(keypad, KEYPAD_ROMANS);
                        System.out.println("ROMANS");
                        break;
                    case "RPN":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("RPN");
                        break;
                    case "VECTORS":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("VECTORS");
                        break;
                    case "MATRIUS":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("MATRIUS");
                        break;
                    case "FRACCIONS":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("FRACCIONS");
                        break;

                    case "CANVI_UNITATS":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("CANVI UNITATS");
                        break;
                    case "CANVI_MONETARI":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("CANVI MONETARI");
                        break;
                    default:
                        // code block
                }
            }
        });

        tipusBase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcioElegidaBase = tipusBase.getSelectedItem().toString();
                switch (opcioElegidaBase) {
                    case "DECIMAL":
                        cl.show(keypad, KEYPAD_BASE);
                        System.out.println("Card 1");
                        break;
                    case "OCTAL":
                        cl.show(keypad, KEYPAD_BASE);
                        System.out.println("OEEEO");
                        break;
                    case "HEXADECIMAL":
                        cl.show(keypad, KEYPAD_BASE);
                        System.out.println("Card 1");
                        break;
                    case "BINARI":
                        cl.show(keypad, KEYPAD_BASE);
                        System.out.println("Card 1");
                        break;
                    default:

                }
            }
        });

        keypad = new JPanel();
        kn = new KeypadNormal(pantallaOp, pantallaRes, "ROMANS");
        kr = new KeypadRomans(pantallaOp, pantallaRes, "ROMANS");
        kb = new KeypadBase(pantallaOp, pantallaRes, "BINARI");

        total.add(keypad, BorderLayout.CENTER);
        cl = new CardLayout(0, 0);
        keypad.setLayout(cl);
        keypad.add(kn.getNumpadBasic(), KEYPAD_NORMAL);
        keypad.add(kr.getNumpadRomans(), KEYPAD_ROMANS);
        keypad.add(kb.getNumpadBase(), KEYPAD_BASE);

        /*
        tipusOp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (tipusOp.getSelectedIndex() > 0) {
                        aux.setModel(new DefaultComboBoxModel(addItemsSubcombobox(tipusOp.getSelectedItem().toString())));
                    }
                }
            }
        });
        */
    }

    public String [] addItemsSubcombobox(String tipusOpcioString) {
        String [] valuesSubCombo = new String[3];
        if (tipusOpcioString.equals("POLINOMI")) {
            valuesSubCombo[0] = "Suma";
            valuesSubCombo[1] = "Resta";
            valuesSubCombo[2] = "Multiplicacio";
        }
        return valuesSubCombo;
    }
    public JPanel getTotal() {
        return total;
    }

    public void setTotal(JPanel total) {
        this.total = total;
    }
}

