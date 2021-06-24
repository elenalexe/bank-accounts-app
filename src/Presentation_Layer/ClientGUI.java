package Presentation_Layer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Domain_Logic_Layer.ClientLogic;
import Domain_Logic_Layer.Login;

public class ClientGUI extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login l= new Login();
                    ClientGUI frame = new ClientGUI(l);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public ClientGUI(Login log) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 451, 353);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        int login= log.getLoginId();
        int client_id=ClientLogic.getClientId(log.getLoginId());
        System.out.println("S1:"+log.getLoginId());
        System.out.println("S2: "+client_id);
        JButton btnVizualizareCont = new JButton("View Accounts");
        btnVizualizareCont.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVizualizareCont.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                AccountView acc= new AccountView(client_id);
                acc.setVisible(true);
            }
        });
        btnVizualizareCont.setBounds(40, 90, 200, 30);
        contentPane.add(btnVizualizareCont);

        JLabel lblNewLabel = new JLabel("Choose an option");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
        lblNewLabel.setBounds(40, 30, 350, 30);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("Transfer Money");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MoneyTransfer money= new MoneyTransfer(client_id);
                money.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
        btnNewButton.setBounds(40, 140, 200, 30);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Exit");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame= new JFrame();
                if(JOptionPane.showConfirmDialog(frame, "Do you want to exit?", "Client System", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }

            }
        });
        btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 18));
        btnNewButton_1.setBounds(40, 241, 200, 30);
        contentPane.add(btnNewButton_1);

        JSeparator separator = new JSeparator();
        separator.setBounds(40, 65, 360, 2);
        contentPane.add(separator);

        JButton btnNewButton_2 = new JButton("Add Account");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertAccount a= new InsertAccount(login);
                a.setVisible(true);
            }
        });
        btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 18));
        btnNewButton_2.setBounds(40, 194, 200, 30);
        contentPane.add(btnNewButton_2);


    }
}
