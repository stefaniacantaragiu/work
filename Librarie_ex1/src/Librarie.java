import lib_app.TextPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Librarie extends JFrame {
    String tipCarte[] = {"Beletristica", "Istorie"};
    String afisare[] = {"Toate", "Beletristica", "Istorie"};
    String columns[] = {"Nume", "Autor", "Pret", "Isbn", "Tag"};
    String data[][]= {

    };
    String[] motivSters = {"Autor", "ISBN"};

    private Librarie ()  {
        super("Librarie");
        JPanel j= new JPanel();
        pack();

        //setLayout(new BorderLayout());
        JComboBox cb = new JComboBox(tipCarte);
        JComboBox cb1 = new JComboBox(afisare);
        JComboBox cmbSters = new JComboBox(motivSters);



        JTextField textFieldNume = new JTextField("Nume");
        JTextField textFieldAutor = new JTextField("Autor");
        JTextField textFieldIsbn = new JTextField("Isbn");
        JTextField textFieldPret = new JTextField("Pret");
        JTextField textFieldInfo = new JTextField("Info");
        JTextField fieldDelete = new JTextField();



        JLabel label = new JLabel();
        DefaultTableModel listTableModel = new DefaultTableModel(data, columns);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(listTableModel);
        JTable tabel = new JTable(listTableModel);
        tabel.setRowSorter(sorter);

        tabel.setFillsViewportHeight(true);
        tabel.setAutoCreateRowSorter(true);



        JScrollPane sp = new JScrollPane(tabel);


        //sp.setViewportView(tabel);

        cb.setBounds(700, 100, 100, 30);
        cb1.setBounds(700, 150, 100, 30);
        label.setBounds(700, 350, 500, 30);
        tabel.setBounds(20, 100, 500, 500);

        textFieldNume.setBounds(20,20,50,30);
        textFieldAutor.setBounds(80,20,50,30);
        textFieldIsbn.setBounds(150,20,50,30);
        textFieldPret.setBounds(220,20,50,30);
        textFieldInfo.setBounds(280,20,50,30);

        fieldDelete.setBounds(850, 300, 100, 30);
        fieldDelete.setText("<sterge>");

        cmbSters.setBounds(700, 300, 100, 30);

        tabel.setFillsViewportHeight(true);
        tabel.setAutoCreateRowSorter(true);




        JButton b1 = new JButton("Add");
        JButton b2 = new JButton("Buy");
        JButton b3 = new JButton("Print");


        b1.addActionListener(new ActionListener() {


            public void actionPerformed (ActionEvent e) {
                boolean flag = false;
                if (cb.getSelectedIndex() == 0) {
                    for (int d = 0; d < tabel.getRowCount(); d++) {
                        if (tabel.getValueAt(d, 2).equals(textFieldIsbn.getText())) {
                            label.setText("Cartea exista deja in librarie!");
                            flag = true;
                            break;
                        }
                    }
                    if (tabel.getRowCount() >= 100) {
                        label.setText("Pragul maxim de o 100 de carti a fost atins!");
                    } else if (!flag) {
                        label.setText("Adauga Carte Beletristica");
                        listTableModel.addRow(new Object[]{textFieldNume.getText(), textFieldAutor.getText(), textFieldIsbn.getText(), textFieldPret.getText(), textFieldInfo.getText(), "Istorie"});
                        textFieldAutor.setText("Autor");
                        textFieldNume.setText("Titlu");
                        textFieldIsbn.setText("ISBN");
                        textFieldPret.setText("Pret");
                        textFieldInfo.setText("Tag");
                    }
                } else if (cb.getSelectedIndex() == 1) {
                    for (int d = 0; d < tabel.getRowCount(); d++) {
                        if (tabel.getValueAt(d, 2).equals(textFieldIsbn.getText())) {
                            label.setText("Cartea exista deja in librarie!");
                            flag = true;
                            break;
                        }
                    }
                    if (tabel.getRowCount() >= 100) {
                        label.setText("Pragul maxim de o 100 de carti a fost atins!");
                    } else if (!flag) {
                        label.setText("Adauga Carte Istorie");
                        listTableModel.addRow(new Object[]{textFieldNume.getText(), textFieldAutor.getText(), textFieldIsbn.getText(), textFieldPret.getText(), textFieldInfo.getText(), "Beletristica"});
                        textFieldAutor.setText("Autor");
                        textFieldNume.setText("Titlu");
                        textFieldIsbn.setText("ISBN");
                        textFieldPret.setText("Pret");
                        textFieldInfo.setText("Tag");
                    }
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (cmbSters.getSelectedIndex() == 0) {
                    label.setText("Se va sterge dupa Autor");
                    for (int d = tabel.getRowCount() - 1; d >= 0; d--) {
                        if (tabel.getValueAt(d, 1).equals(fieldDelete.getText())) {
                            listTableModel.removeRow(d);
                            listTableModel.getDataVector();
                        }
                    }
                    fieldDelete.setText("<sterge>");
                } else if (cmbSters.getSelectedIndex() == 1) {
                    label.setText("Se va sterge dupa ISBN");
                    for (int d = 0; d < tabel.getRowCount(); d++) {
                        if (tabel.getValueAt(d, 2).equals(fieldDelete.getText())) {
                            listTableModel.removeRow(d);
                            break;
                        }
                    }
                    fieldDelete.setText("<sterge>");
                }

            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                RowFilter<DefaultTableModel, Object> rf = null;
                if (cb1.getSelectedIndex() == 2) {
                    label.setText("Afiseaza cartile de Istorie.");
                    rf = RowFilter.regexFilter(".*Istorie.*");
                    sorter.setRowFilter(rf);
                    tabel.setRowSorter(sorter);
                } else if (cb1.getSelectedIndex() == 1) {
                    label.setText("Afiseaza cartile de Beletristica.");
                    rf = RowFilter.regexFilter(".*Beletristica.*");
                    sorter.setRowFilter(rf);
                    tabel.setRowSorter(sorter);
                } else {
                    label.setText("Afiseaza toate cartile.");
                    sorter.setRowFilter(null);
                    tabel.setRowSorter(sorter);
                }

            }
        });
        b1.setBounds(850, 100, 100, 30);
        add(b1);
        b2.setBounds(850, 150, 100, 30);
        add(b2);
        b3.setBounds(850, 200, 100, 30);
        add(b3);

        add(textFieldAutor);
        add(textFieldNume);
        add(textFieldIsbn);
        add(textFieldPret);
        add(textFieldInfo);
        add(fieldDelete);


        add(cb);
        add(cb1);
        add(cmbSters);
        add(label);
        add(tabel);




        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setResizable(true);
        setLayout(null);
        setVisible(true);



    }




    public static void main (String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run () {

                new Librarie();

            }
        });


    }
}
