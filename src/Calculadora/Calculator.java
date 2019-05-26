package Calculadora;

import Keypads.KeypadBase;
import Keypads.KeypadHistorial;
import Keypads.KeypadRomans;
import Keypads.KeypadNormal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * La classe calculator ens un extends d'un JFrame que ens permetra inicialitzar aquest JFrame en un classe apart
 * anomenada CalculatorMain.
 * En aquest JFrame trobarem tot el contingut que du la calculadora com podria ser els JCombobox, Keypads...
 * En aquesta classe també trobarem la logica de cada un dels JCombobox i la carrega de cada un del keypads, ja que
 * aquest es troben en un conjunt de classes.
 *
 * @author Samuel Romero Marín
 */
public class Calculator extends JFrame {

    //Keypads a carregar
    KeypadNormal kn;
    KeypadRomans kr;
    KeypadBase kb;
    KeypadHistorial kh;

    //JPanel principals
    private JPanel total;
    private JPanel pantalla;
    private JPanel keypad;
    private JPanel opcions;
    private JTextField pantallaOp;
    private JTextField pantallaRes;
    private JComboBox tipusOp;
    private JComboBox tipusBase;
    private JComboBox historial;
    //private JComboBox aux;
    private CardLayout cl;
    public static String opcioElegida;
    public static String opcioBaseElegida;


    private enum tipusOperacions {
        PER_DEFECTE,
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

    /**
     * Constructor de la classe Calculator que ens permet carregar tot el contingut que trobarem a la calculadora. En
     * aquest constructor tambe carregarem les opcions de cada un dels JComboBox(tipus Base, tipus operacio i el
     * historial) i instanciarem cada un dels keypads per poder utilitzar-los segons el value actual del JComboBox en
     * concret
     */
    public Calculator() {
        tipusOp.setUI(new BasicComboBoxUI());
        tipusBase.setUI(new BasicComboBoxUI());
        pantallaRes.setBorder(new EmptyBorder(0, 0, 0, 0));
        pantallaOp.setBorder(new EmptyBorder(0, 0, 0, 0));

        tipusOp.addItem(tipusOperacions.POLINOMI);
        tipusOp.addItem(tipusOperacions.ROMANS);
        tipusOp.addItem(tipusOperacions.RPN);
        tipusOp.addItem(tipusOperacions.VECTORS);
        tipusOp.addItem(tipusOperacions.MATRIUS);
        tipusOp.addItem(tipusOperacions.FRACCIONS);
        tipusOp.addItem(tipusOperacions.CANVI_UNITATS);
        tipusOp.addItem(tipusOperacions.CANVI_MONETARI);

        historial.addItem("KEYPAD");
        historial.addItem("HISTORIAL");


        tipusBase.addItem(enumTipusBase.DECIMAL);
        tipusBase.addItem(enumTipusBase.OCTAL);
        tipusBase.addItem(enumTipusBase.HEXADECIMAL);
        tipusBase.addItem(enumTipusBase.BINARI);

        opcioElegida = tipusOperacions.PER_DEFECTE.toString();

        tipusOp.addActionListener(new ActionListener() {

            /**
             * Action Performed per el JComboBox de tipus operacio que ens permetra canviar entre keypad i operacio a fer
             * segons la opcio elegida. Si canviam a "ROMANS" podrem canviar el keypad a un de personalitzat i la
             * calculadora es posara en mode "Calcular Romans".
             * @param e Parametre Action Performed JComboBox tipusOp
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                String opcioElegida2 = tipusOp.getSelectedItem().toString();
                switch (opcioElegida2) {
                    case "POLINOMI":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("POLINOMI");
                        opcioElegida = opcioElegida2;
                        break;
                    case "ROMANS":
                        cl.show(keypad, KEYPAD_ROMANS);
                        System.out.println("ROMANS");
                        opcioElegida = opcioElegida2;
                        break;
                    case "RPN":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("RPN");
                        opcioElegida = opcioElegida2;
                        break;
                    case "VECTORS":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("VECTORS");
                        opcioElegida = opcioElegida2;
                        break;
                    case "MATRIUS":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("MATRIUS");
                        opcioElegida = opcioElegida2;
                        break;
                    case "FRACCIONS":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("FRACCIONS");
                        opcioElegida = opcioElegida2;
                        break;

                    case "CANVI_UNITATS":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("CANVI UNITATS");
                        opcioElegida = opcioElegida2;
                        break;
                    case "CANVI_MONETARI":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("CANVI MONETARI");
                        opcioElegida = opcioElegida2;
                        break;
                    default:
                        opcioElegida = tipusOperacions.PER_DEFECTE.toString();
                        break;
                }
            }
        });


        tipusBase.addActionListener(new ActionListener() {
            /**
             * Action Performed per el JComboBox de tipus base que ens permetra canviar entre keypad i tambe convertir
             * numeros entre qualsevol base, segons la opcio elegida. Si canviam a "OCTAL" podrem canviar el keypad a un
             * de personalitzat i la calculadora es posara en mode "Calcular OCTAL".
             * @param e Parametre Action Performed JComboBox tipusBase
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcioElegidaBase2 = tipusBase.getSelectedItem().toString();
                switch (opcioElegidaBase2) {
                    case "DECIMAL":
                        cl.show(keypad, KEYPAD_BASE);
                        System.out.println("DECIMAL");
                        opcioBaseElegida = opcioElegidaBase2;
                        break;
                    case "OCTAL":
                        cl.show(keypad, KEYPAD_BASE);
                        System.out.println("OCTAL");
                        opcioBaseElegida = opcioElegidaBase2;
                        break;
                    case "HEXADECIMAL":
                        cl.show(keypad, KEYPAD_BASE);
                        System.out.println("HEXADECIMAL");
                        opcioBaseElegida = opcioElegidaBase2;
                        break;
                    case "BINARI":
                        cl.show(keypad, KEYPAD_BASE);
                        System.out.println("BINARI");
                        opcioBaseElegida = opcioElegidaBase2;
                        break;
                    default:

                }
            }
        });

        historial.addActionListener(new ActionListener() {
            /**
             * Action performed que ens carregara una nova finestra especialitzada nomes dissenyada per consultar el
             * historial. Podrem estar canviant entre aquesta finestra y el keypad.
             *
             * @param e Parametre Action Performed JComboBox historial
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcioHistorial = historial.getSelectedItem().toString();
                switch (opcioHistorial) {
                    case "KEYPAD":
                        cl.show(keypad, KEYPAD_NORMAL);
                        System.out.println("DECIMAL");
                        opcioBaseElegida = opcioHistorial;
                        break;
                    case "HISTORIAL":
                        cl.show(keypad, "KEYPAD_HISTORIAL");
                        System.out.println("OCTAL");
                        opcioBaseElegida = opcioHistorial;
                        break;
                    default:
                        break;

                }
            }
        });

        keypad = new JPanel();

        kn = new KeypadNormal(pantallaOp, pantallaRes);
        kr = new KeypadRomans(pantallaOp, pantallaRes);
        kb = new KeypadBase(pantallaOp, pantallaRes);
        kh = new KeypadHistorial(pantallaOp, pantallaRes);
        total.add(keypad, BorderLayout.CENTER);
        cl = new CardLayout(0, 0);
        keypad.setLayout(cl);
        keypad.add(kn.getNumpadBasic(), KEYPAD_NORMAL);
        keypad.add(kr.getNumpadRomans(), KEYPAD_ROMANS);
        keypad.add(kb.getNumpadBase(), KEYPAD_BASE);
        keypad.add(kh.getTotalHistorial(), "KEYPAD_HISTORIAL");

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

    public String[] addItemsSubcombobox(String tipusOpcioString) {
        String[] valuesSubCombo = new String[3];
        if (tipusOpcioString.equals("POLINOMI")) {
            valuesSubCombo[0] = "Suma";
            valuesSubCombo[1] = "Resta";
            valuesSubCombo[2] = "Multiplicacio";
        }
        return valuesSubCombo;
    }


    /**
     * Metode getter per aconseguir el JPanel que te el contingut de la calculadora
     * @return Retorna el JPanel "Total"
     */
    public JPanel getTotal() {
        return total;
    }

}

