package Keypads;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

/**
 * Classe KeypadHistorial que ens permet veure el resultat de cada operació. Aquestes dades es guardaran inclos una
 * vegada s'ha tancat el programa (Es guarda per sempre i no per sessio). Es carrega a la classe Calculator.
 * @author Samuel Romero Marín
 */
public class KeypadHistorial extends JPanel {

    private JPanel totalHistorial;
    private JTable table;
    private JButton actualitzaHistorialButton;
    String data[][];
    String col[];
    DefaultTableModel modelo;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    JScrollPane pane;

    /**
     * Constructor KeypadHistorial que ens permet carregar tots els items del keypad i donar funcions a cada un del botons
     * d'aquest keypad.
     * @param jtfOp Parametre JTextField del input on s'ingressa l'operacio a calcular de la classe Calculator.
     * @param jtfRes Parametre JtextField del input on es retorna el resultat que s'ha calculat la classe Calulcator.
     */
    public KeypadHistorial(JTextField jtfOp, JTextField jtfRes){
        totalHistorial = new JPanel();

        modelo = new DefaultTableModel();
        modelo.addColumn("Historial");
        table = new JTable(modelo);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        add(new JScrollPane(table), BorderLayout.CENTER);

        table.setBounds(100, 100, 100, 80);
        totalHistorial.add(table);
        setVisible(true);
        setSize(300, 300);



        actualitzaHistorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    archivo = new File("C:\\Users\\Samuel Romero Marín\\Desktop\\historialCalc.txt");
                    fr = new FileReader(archivo);
                    br = new BufferedReader(fr);

                    // Lectura del fichero
                    String linea;
                    String dadesArxiu = "";
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                        dadesArxiu = linea;
                    }
                    LimpiarJTable();
                    String[] split = dadesArxiu.split("\\|");
                    System.out.println(Arrays.toString(split));
                    modelo = (DefaultTableModel) table.getModel();


                    for (int i = 0; i < split.length; i++) {
                        String actual = split[i];
                        modelo.addRow(new Object[]{actual});
                    }

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } finally {
                    try {
                        if (null != fr) {
                            fr.close();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * Metode void LimpiarjTable que ens permetra netetjar totes les files de la taula del historial cada vegada que
     * actualitzem les dades
     */
    void LimpiarJTable() {
        int a = modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    /**
     * Metode getter que ens permet aconsguir el JPanel amb tots els items corresponents per posteriorment carregar-ho
     * a la Classe Calculator
     * @return Retorna un JPanel de tot el keypadHistorial
     */
    public JPanel getTotalHistorial() {
        return totalHistorial;
    }

}
