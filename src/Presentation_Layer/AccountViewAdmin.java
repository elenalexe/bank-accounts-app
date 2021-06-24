package Presentation_Layer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data_Source_Logic_Layer.DataBaseConnection;
import Domain_Logic_Layer.AccountLogic;
import Domain_Logic_Layer.ClientLogic;

public class AccountViewAdmin extends JFrame{

    private JPanel contentPane;
    private JTable table;
    private JTable table1;
    private JButton buttonBack;

    public AccountViewAdmin()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 764, 621);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(32, 104, 510, 75);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][]
                {},
                new String[]
                        {
                                "Client Id", "Login Id", "Name", "Address", "Birthday"
                        }
                        ));
        scrollPane.setViewportView(table);

        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(32, 250,556, 233);
        contentPane.add(scrollPane1);

        table1 = new JTable();
        table1.setModel(new DefaultTableModel(new Object[][]{},
                new String[]
                        {
                                "Client Id", "Account Type", "Amount", "Date", "Account Id"
                        }
                        ));
        scrollPane1.setViewportView(table1);


        buttonBack = new JButton("BACK");
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonBack.setFont(new Font("Arial", Font.BOLD, 16));
        buttonBack.setBounds(636, 512, 85, 27);
        contentPane.add(buttonBack);

        AccountLogic.getAccount(table1);
        ClientLogic.getClient(table);

        JLabel labelNewLabel = new JLabel("Clients:");
        labelNewLabel.setBounds(32,58,100,25);
        labelNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        contentPane.add(labelNewLabel);

        JLabel labelNewlabel1 = new JLabel("Accounts:");
        labelNewlabel1.setBounds(32,200,100,25);
        labelNewlabel1.setFont(new Font("Arial", Font.PLAIN, 18));
        contentPane.add(labelNewlabel1);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try
                {
                    AccountViewAdmin frame = new AccountViewAdmin();
                    frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}

