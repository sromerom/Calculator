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
                        // code block
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
                        // code block
                }

            }

            recorrNumbers++;
            aux++;

        }
        return resultat;
    }
}

