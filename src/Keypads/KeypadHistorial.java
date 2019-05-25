package Keypads;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public KeypadHistorial(JTextField jtfOp, JTextField jtfRes) throws BadLocationException, FileNotFoundException {
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
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).

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
                    // En el finally cerramos el fichero, para asegurarnos
                    // que se cierra tanto si todo va bien como si salta
                    // una excepcion.
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

    void LimpiarJTable() {
        int a = modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public JPanel getTotalHistorial() {
        return totalHistorial;
    }

    public void setTotalHistorial(JPanel totalHistorial) {
        this.totalHistorial = totalHistorial;
    }
}
