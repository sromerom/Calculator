package Keypads;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Calculs.Calcul;
import Calculadora.Calculator;

/**
 * Classe KeypadNormal que ens permet crear un keypadNormal a on es faran tots calculs per defecte per posteriorment
 * carregar-lo en la classe Calculator segons el tipus d'operacio que haguem escollit.
 * @author Samuel Romero Marín
 *
 */
public class KeypadNormal extends JPanel {

    boolean primeraVegada = true;
    private Calcul calcul;

    //private String resultat = "";
    private JPanel numpadBasic;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a0Button;
    private JButton a2Button;
    private JButton a5Button;
    private JButton a8Button;
    private JButton dotButton;
    private JButton eqButton;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton EXPButton;
    private JButton mulButton;
    private JButton sumButton;
    private JButton sinButton;
    private JButton cosButton;
    private JButton resButton;
    private JButton divButton;
    private JButton DELButton;
    private JButton xButton;
    private JButton lnButton;
    private JButton logButton;
    private JButton fXButton;
    private JButton parlButton;
    private JButton parrButton;
    private JButton corlButton;
    private JButton corrButton;
    private String numPantalla;

    /**
     * Constructor KeypadNormal que ens permet carregar tots els items del keypad i donar funcions a cada un del botons
     * d'aquest keypad.
     * @param jtfOp Parametre JTextField del input on s'ingressa l'operacio a calcular de la classe Calculator.
     * @param jtfRes Parametre JtextField del input on es retorna el resultat que s'ha calculat la classe Calulcator.
     */
    public KeypadNormal(JTextField jtfOp, JTextField jtfRes) {


        numpadBasic = new JPanel();
        //System.out.println(calc.getOpcioElegida());
        eqButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPantalla = jtfOp.getText();
                System.out.println("Tipus opcio " + Calculator.opcioElegida);
                calcul = new Calcul(numPantalla, Calculator.opcioElegida);
                jtfRes.setText(calcul.getResultatString());
                numPantalla = "";

            }
        });


        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "0";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "0";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "1";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "1";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "2";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "2";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "3";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "3";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "4";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "4";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "5";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "5";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "6";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "6";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "7";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "7";
                    jtfOp.setText(numPantalla);
                }
            }
        });


        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "8";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "8";
                    jtfOp.setText(numPantalla);
                }
            }
        });


        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "9";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "9";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "+";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "+";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        resButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "-";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "-";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "*";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "*";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "/";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "/";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = ".";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += ".";
                    jtfOp.setText(numPantalla);
                }
            }
        });


        DELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                numPantalla = "";
                jtfOp.setText(numPantalla);
            }
        });

        xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "!";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "!";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        lnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "ln";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "ln";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "log";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "log";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "sin";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "sin";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "cos";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "cos";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        parlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "(";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "(";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        parrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = ")";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += ")";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        EXPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "exp";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "exp";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        corlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "{";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "{";
                    jtfOp.setText(numPantalla);
                }
            }
        });

        corrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (primeraVegada) {
                    numPantalla = "}";
                    primeraVegada = false;
                    jtfOp.setText(numPantalla);
                } else {
                    numPantalla += "}";
                    jtfOp.setText(numPantalla);
                }
            }
        });

    }

    public JPanel getNumpadBasic() {
        return numpadBasic;
    }

}
