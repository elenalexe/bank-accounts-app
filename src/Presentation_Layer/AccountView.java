package Presentation_Layer;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import Data_Source_Logic_Layer.DataBaseConnection;
import Domain_Logic_Layer.AccountLogic;

public class AccountView  extends JFrame{

    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                try
                {
                    int x = 0;
                    AccountView frame = new AccountView(x);
                    frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        });
    }

    public AccountView(int clientId)
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 681, 480);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(45, 88, 452, 313);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][]
                {

                }, new String[]
                {
                        "AccountId", "Type", "Amount", "Date"
                }));
        scrollPane.setViewportView(table);

        JLabel labelNewLabel = new JLabel("Accounts:");
        labelNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
        labelNewLabel.setBounds(45, 34, 150, 30);
        contentPane.add(labelNewLabel);

        JButton buttonNewButton = new JButton("BACK");
        buttonNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });

        AccountLogic.getAccount(clientId, table);

        buttonNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
        buttonNewButton.setBounds(554, 374, 85, 27);
        contentPane.add(buttonNewButton);
    }
}
