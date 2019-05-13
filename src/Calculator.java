import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator extends JFrame {
    private JPanel total;
    private JTextField pantallaOp;
    private JTextField pantallaRes;
    private JButton butIg;

    Calculator() {
        this.setContentPane(total);
        butIg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String operacio = pantallaOp.getText();
                String regEx = "[\\+\\-\\*\\/]";
                String split[] = operacio.split(regEx);
                int [] numbers = new int[split.length];
                List<String> signes = new ArrayList<>();

                for(int i = 0; i < split.length; i++) {
                    numbers[i] = Integer.parseInt(split[i]);
                }

                System.out.println("Funciona????" + Arrays.toString(numbers));
                for (int i = 0; i < operacio.length(); i++) {
                    char actual = operacio.charAt(i);
                    String actualString = Character.toString(actual);
                    if (actual == 42 || actual == 43 || actual == 45 || actual == 47) {
                        signes.add(actualString);
                    }
                }
                System.out.println("Funciona");
                System.out.println(numbers);
                System.out.println(signes);

                /*
                int b = -1;
                for (int i = 0; i < ar.length; i++, b++) {

                    if (ar.length != signes.size() && i == 0) {
                        ar[i] = split[i];
                        continue;
                    }
                    ar[i] = signes.get(b) + split[i];

                }
                */
                //calcula(numbers);

            }
        });
    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    public static int calcula(int [] numbers, String [] signes) {
        int resultat = 0;


        return resultat;
    }
}

