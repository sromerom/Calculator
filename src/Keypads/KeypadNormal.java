package Keypads;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Calculs.Calcul;

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
    private JButton delButton;
    private JButton resetButton;
    private String numPantalla;
    public KeypadNormal() {
        numpadBasic = new JPanel();
    }

    public KeypadNormal(JTextField jtfOp, JTextField jtfRes) {
        numpadBasic = new JPanel();

        eqButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                calcul = new Calcul(numPantalla);
                int calculActual = calcul.calculSimple(calcul.getNumbers(), calcul.getSignes());
                String calculActualString = Integer.toString(calculActual);
                jtfRes.setText(calculActualString);

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

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                char eliminar = numPantalla.charAt(numPantalla.length() - 1);
                String eliminarString = Character.toString(eliminar);
                String stringNou = numPantalla.replaceAll(eliminarString, "");
                numPantalla = stringNou;
                jtfOp.setText(stringNou);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                numPantalla = "";
                jtfOp.setText(numPantalla);
            }
        });

    }

    public JPanel getNumpadBasic() {
        return numpadBasic;
    }

    public void setNumpadBasic(JPanel numpadBasic) {
        this.numpadBasic = numpadBasic;
    }

    public JButton getA1Button() {
        return a1Button;
    }

    public JButton getA4Button() {
        return a4Button;
    }

    public JButton getA7Button() {
        return a7Button;
    }

    public JButton getA0Button() {
        return a0Button;
    }

    public JButton getA2Button() {
        return a2Button;
    }

    public JButton getA5Button() {
        return a5Button;
    }

    public JButton getA8Button() {
        return a8Button;
    }

    public JButton getDotButton() {
        return dotButton;
    }

    public JButton getEqButton() {
        return eqButton;
    }

    public JButton getA9Button() {
        return a9Button;
    }

    public JButton getA6Button() {
        return a6Button;
    }

    public JButton getA3Button() {
        return a3Button;
    }

    public JButton getEXPButton() {
        return EXPButton;
    }

    public JButton getMulButton() {
        return mulButton;
    }

    public JButton getSumButton() {
        return sumButton;
    }

    public JButton getSinButton() {
        return sinButton;
    }

    public JButton getCosButton() {
        return cosButton;
    }

    public JButton getResButton() {
        return resButton;
    }

    public JButton getDivButton() {
        return divButton;
    }

    public JButton getDELButton() {
        return DELButton;
    }

    public JButton getxButton() {
        return xButton;
    }

    public JButton getLnButton() {
        return lnButton;
    }

    public JButton getLogButton() {
        return logButton;
    }

    public JButton getfXButton() {
        return fXButton;
    }

    public JButton getParlButton() {
        return parlButton;
    }

    public JButton getParrButton() {
        return parrButton;
    }

    public JButton getDelButton() {
        return delButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }
}
