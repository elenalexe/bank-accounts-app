package Presentation_Layer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Domain_Logic_Layer.ClientLogic;
import Domain_Logic_Layer.AccountLogic;
import Domain_Logic_Layer.LoginLogic;

public class AdministratorGUI extends JFrame {

    private JPanel contentPane;
    private JButton buttonDeleteAccount;
    private JButton buttonUpdateClient;
    private JButton buttonAddClient;
    private JButton buttonExit;
    private JButton buttonUpdateAccount;
    private JButton buttonDeleteClient;
    private JTextField textDeleteAccount;
    private JTextField textDeleteClient;
    private JTextField textUpdateAll;
    private JLabel labelNewLabel;
    private JLabel labelinsertAccountId;
    private JLabel labelDeleteAccount;
    private JLabel labelUpdateClient;
    private JLabel labelUpdateAccount;
    private JSeparator separator;

    public AdministratorGUI()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 489);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton buttonViewClient = new JButton("View Client");
        buttonViewClient.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonViewClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountViewAdmin accountViewAdmin = new AccountViewAdmin();
                accountViewAdmin.setVisible(true);
            }
        });

        buttonViewClient.setBounds(24,100,160,30);
        contentPane.add(buttonViewClient);

        buttonAddClient = new JButton("Add Client");
        buttonAddClient.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonAddClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertClient insertClient = new InsertClient();
                insertClient.setVisible(true);
            }
        });

        buttonAddClient.setBounds(24,150,160,30);
        contentPane.add(buttonAddClient);


        buttonDeleteAccount = new JButton("Delete Account");
        buttonDeleteAccount.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonDeleteAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textDeleteAccount.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please write an Account Id");
                }
                else if (!(textDeleteAccount.getText().trim().isEmpty()))
                {
                    int i = Integer.parseInt(textDeleteAccount.getText());
                    boolean existingAccount = AccountLogic.verifyAccountIdForAllClients(i);
                    if(existingAccount)
                    {
                        JFrame frame = new JFrame("Delete account");
                        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to delete the account",
                                "Administrator System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
                        {
                            AccountLogic.deleteAccount(i);
                        }

                    }

                    else
                    {
                        JOptionPane.showMessageDialog(null, "This account is not registered");
                    }
                }
            }
        });

        buttonDeleteAccount.setBounds(24,200,160,30);
        contentPane.add(buttonDeleteAccount);

        textDeleteAccount = new JTextField();
        textDeleteAccount.setBounds(250,200,50,30);
        contentPane.add(textDeleteAccount);
        textDeleteAccount.setColumns(10);


        buttonDeleteClient = new JButton("Delete Client");
        buttonDeleteClient.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonDeleteClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textDeleteClient.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please write a Login Id");
                }
                else if(!(textDeleteClient.getText().trim().isEmpty()))
                {
                    int i = Integer.parseInt(textDeleteClient.getText());
                    boolean existingLogin = LoginLogic.verifyLoginIdForAllLogins(i);
                    if (existingLogin)
                    {
                        JFrame frame = new JFrame("Delete Account");
                        if (JOptionPane.showConfirmDialog(frame, "Do you want to delete this client?",
                                "Administrator System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
                        {
                            LoginLogic.deleteClientByLoginId(i);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The login Id is not existing");
                    }
                }

            }
        });

        buttonDeleteClient.setBounds(24,250,160,30);
        contentPane.add(buttonDeleteClient);

        textDeleteClient = new JTextField();
        textDeleteClient.setBounds(250,250,50,30);
        contentPane.add(textDeleteClient);
        textDeleteClient.setColumns(10);

        buttonUpdateClient = new JButton("Update Client");
        buttonUpdateClient.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonUpdateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textUpdateAll.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Write a Client Id");
                }
                else if (!(textUpdateAll.getText().trim().isEmpty()))
                {
                    int i = Integer.parseInt(textUpdateAll.getText());
                    boolean existingClient = ClientLogic.verifyClientIdForAllClients(i);
                    if(existingClient)
                    {
                        UpdateClient updateClient = new UpdateClient(i);
                        updateClient.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "There is not Client registered");
                    }
                }
            }
        });

        buttonUpdateClient.setBounds(24,300,160,30);
        contentPane.add(buttonUpdateClient);

        textUpdateAll = new JTextField();
        textUpdateAll.setBounds(250,300,50,30);
        contentPane.add(textUpdateAll);
        textUpdateAll.setColumns(10);


        labelNewLabel = new JLabel("Choose an option: ");
        labelNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
        labelNewLabel.setBounds(24,43,300,30);
        contentPane.add(labelNewLabel);

        labelinsertAccountId = new JLabel("Please insert a Login ID");
        labelinsertAccountId.setFont(new Font("Arial", Font.ITALIC, 10));
        labelinsertAccountId.setBounds(300,250,300,30);
        contentPane.add(labelinsertAccountId);

        labelDeleteAccount = new JLabel("Please insert an Account ID");
        labelDeleteAccount.setFont(new Font("Arial", Font.ITALIC, 10));
        labelDeleteAccount.setBounds(300,200,300,30);
        contentPane.add(labelDeleteAccount);

        labelUpdateClient = new JLabel("Please insert a Client ID");
        labelUpdateClient.setFont(new Font("Arial", Font.ITALIC,10));
        labelUpdateClient.setBounds(300,300,300,30);
        contentPane.add(labelUpdateClient);

        labelUpdateAccount = new JLabel("Please insert an Account ID");
        labelUpdateAccount.setFont(new Font("Arial", Font.ITALIC,10));
        labelUpdateAccount.setBounds(300,350,300,30);
        contentPane.add(labelUpdateAccount);



        separator = new JSeparator();
        separator.setBounds(24,75,454,2);
        contentPane.add(separator);

        buttonExit = new JButton("Exit");
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                if (JOptionPane.showConfirmDialog(frame, "Do you want to exit?",
                        "Administrator System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
                {
                    dispose();
                }
            }
        });

        buttonExit.setBounds(400,389,120,30);
        buttonExit.setFont(new Font("Arial", Font.PLAIN,18));
        contentPane.add(buttonExit);

        buttonUpdateAccount = new JButton("Update Account");
        buttonUpdateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textUpdateAll.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Insert an Account Id");
                }
                else if (!(textUpdateAll.getText().trim().isEmpty()))
                {
                    int i = Integer.parseInt(textUpdateAll.getText());
                    boolean existingAccount = AccountLogic.verifyAccountIdForAllClients(i);
                    if (existingAccount)
                    {
                        UpdateAccount updateAccount = new UpdateAccount(i);
                        updateAccount.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The account is not registered");
                    }
                }
            }
        });

        buttonUpdateAccount.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonUpdateAccount.setBounds(23,350,205,30);
        contentPane.add(buttonUpdateAccount);

        textUpdateAll = new JTextField();
        textUpdateAll.setColumns(10);
        textUpdateAll.setBounds(250,350,50,30);
        contentPane.add(textUpdateAll);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdministratorGUI frame = new AdministratorGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}

