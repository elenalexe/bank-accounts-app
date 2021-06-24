package Presentation_Layer;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.sql.*;

import Data_Source_Logic_Layer.AccountMapper;
import Data_Source_Logic_Layer.DataBaseConnection;
import Domain_Logic_Layer.AccountLogic;

public class MoneyTransfer extends JFrame {

    private JPanel contentPane;
    private JTextField txtContDestinatar;
    private JTextField txtSumaTransferata;
    private JButton btnNewButton;
    private JTextField txtContExpeditor;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    int x=0;
                    MoneyTransfer frame = new MoneyTransfer(x);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MoneyTransfer(int id_client) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblContID = new JLabel("Destinator Account:");
        lblContID.setFont(new Font("Arial", Font.PLAIN, 18));
        lblContID.setBounds(20, 98, 170, 30);
        contentPane.add(lblContID);

        JLabel lblSuma = new JLabel("Amount of Money:");
        lblSuma.setFont(new Font("Arial", Font.PLAIN, 18));
        lblSuma.setBounds(20, 140, 150, 30);
        contentPane.add(lblSuma);

        txtContDestinatar = new JTextField();
        txtContDestinatar.setBounds(183, 98, 111, 27);
        contentPane.add(txtContDestinatar);
        txtContDestinatar.setColumns(10);

        txtSumaTransferata = new JTextField();
        txtSumaTransferata.setBounds(183, 140, 111, 27);
        contentPane.add(txtSumaTransferata);
        txtSumaTransferata.setColumns(10);

        btnNewButton = new JButton("Confirm");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id_expd= Integer.parseInt(txtContExpeditor.getText());
                int id_dest= Integer.parseInt(txtContDestinatar.getText());
                String type_expd= AccountLogic.getTypeByIdAccount(id_expd);
                String type_dest= AccountLogic.getTypeByIdAccount(id_dest);
                boolean r= AccountLogic.verifyAccountId(id_client, id_expd);
                boolean exista_cont_in_sistem= AccountLogic.verifyAccountIdForAllClients(id_dest);
                if(r) {
                    if(exista_cont_in_sistem) {
                        if(type_expd.equals(type_dest)) {
                            double suma_expd= AccountMapper.getAmountByAccountId(id_expd);
                            double suma_dest= AccountMapper.getAmountByAccountId(id_dest);
                            double suma_expd_acum= Double.parseDouble(txtSumaTransferata.getText());
                            if(suma_expd_acum>0) {
                                if(suma_expd >= suma_expd_acum) {
                                    AccountLogic.UpdateAmount(id_dest,  suma_dest + suma_expd_acum);
                                    AccountLogic.UpdateAmount(id_expd, suma_expd-suma_expd_acum);
                                    JOptionPane.showMessageDialog(null, "Successful transaction");
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Insufficient funds");
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "You can't transfer a negative sum");
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "The accounts have different currency types. Cannot execute the transaction!");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "There is no such destination account registered");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "There is no such account registered for the client "+id_client+"!");
                }}
        });
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
        btnNewButton.setBounds(300, 202, 110, 27);
        contentPane.add(btnNewButton);

        JLabel lblContExpeditor = new JLabel("Sender Account:");
        lblContExpeditor.setFont(new Font("Arial", Font.PLAIN, 18));
        lblContExpeditor.setBounds(20, 56, 150, 30);
        contentPane.add(lblContExpeditor);

        txtContExpeditor = new JTextField();
        txtContExpeditor.setBounds(183, 56, 111, 27);
        contentPane.add(txtContExpeditor);
        txtContExpeditor.setColumns(10);

        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 18));
        btnNewButton_1.setBounds(20, 202, 85, 27);
        contentPane.add(btnNewButton_1);


    }
}
