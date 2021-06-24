package Presentation_Layer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Domain_Logic_Layer.AccountLogic;
import Domain_Logic_Layer.ClientLogic;
import Domain_Logic_Layer.LoginLogic;

public class InsertClient extends JFrame
{
    private JPanel contentPane;
    private JTextField textLoginId;
    private JTextField textClientId;
    private JTextField textUsername;
    private JTextField textPassword;
    private JTextField textName;
    private JTextField textAddress;
    private JTextField textBirthday;
    private JTextField textAccountId;
    private JTextField textDate;
    private JTextField textAmount;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final ButtonGroup buttonGroup1 = new ButtonGroup();
    private final JLabel labelNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertClient frame = new InsertClient();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public InsertClient()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,653,692);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setFont(new Font("Arial", Font.PLAIN,18));
        labelUsername.setBounds(40,100,100,27);
        contentPane.add(labelUsername);

        textUsername = new JTextField();
        textUsername.setText("");
        textUsername.setBounds(181,100,100,27);
        textUsername.setColumns(10);
        contentPane.add(textUsername);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setFont(new Font("Arial", Font.PLAIN,18));
        labelPassword.setBounds(40,135,100,25);
        contentPane.add(labelPassword);

        textPassword = new JTextField();
        textPassword.setText("");
        textPassword.setBounds(181,135,100,25);
        textPassword.setColumns(10);
        contentPane.add(textPassword);

        JLabel labelRole = new JLabel("Role:");
        labelRole.setFont(new Font("Arial", Font.PLAIN, 18));
        labelRole.setBounds(40,170,100,27);
        contentPane.add(labelRole);

        JRadioButton radioButtonAdministrator = new JRadioButton("Administrator");
        radioButtonAdministrator.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonGroup.add(radioButtonAdministrator);
        radioButtonAdministrator.setBounds(180, 170,150,25);
        contentPane.add(radioButtonAdministrator);

        JRadioButton radioButtonClient = new JRadioButton("Client");
        radioButtonClient.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonGroup.add(radioButtonClient);
        radioButtonClient.setBounds(350,170,100,25);
        contentPane.add(radioButtonClient);

        JLabel labelLoginId = new JLabel("Login Id:");
        labelLoginId.setFont(new Font("Arial", Font.PLAIN, 18));
        labelLoginId.setBounds(40,205,100,27);
        contentPane.add(labelLoginId);

        textLoginId = new JTextField();
        textLoginId.setBounds(181,205,100,25);
        textLoginId.setColumns(10);
        contentPane.add(textLoginId);

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(40,240,100,25);
        labelName.setFont(new Font("Arial", Font.PLAIN, 18));
        contentPane.add(labelName);

        textName = new JTextField();
        textName.setText("");
        textName.setBounds(181,240,100,25);
        textName.setColumns(10);
        contentPane.add(textName);

        JLabel labelAddress = new JLabel("Address:");
        labelAddress.setFont(new Font("Arial", Font.PLAIN, 18));
        labelAddress.setBounds(40,275,100,25);
        contentPane.add(labelAddress);

        textAddress = new JTextField();
        textAddress.setBounds(181,275,100,25);
        textAddress.setColumns(10);
        contentPane.add(textAddress);

        JLabel labelBirthday = new JLabel("Birthday:");
        labelBirthday.setBounds(40,310,100,25);
        labelBirthday.setFont(new Font("Arial", Font.PLAIN, 18));
        contentPane.add(labelBirthday);

        textBirthday = new JTextField();
        textBirthday.setText("");
        textBirthday.setBounds(181,310,100,25);
        textBirthday.setColumns(10);
        contentPane.add(textBirthday);

        JLabel labelClientId = new JLabel("Client Id:");
        labelClientId.setFont(new Font("Arial", Font.PLAIN, 18));
        labelClientId.setBounds(40,375,100, 25);
        contentPane.add(labelClientId);

        textClientId = new JTextField();
        textClientId.setBounds(181,375,100,25);
        textClientId.setColumns(10);
        contentPane.add(textClientId);

        JLabel labelType = new JLabel("Type:");
        labelType.setBounds(40,415,100,25);
        labelType.setFont(new Font("Arial", Font.PLAIN, 18));
        contentPane.add(labelType);

        JRadioButton radioButtonRon = new JRadioButton("RON");
        radioButtonRon.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
        buttonGroup1.add(radioButtonRon);
        radioButtonRon.setBounds(174,415,100,25);
        contentPane.add(radioButtonRon);

        JRadioButton radioButtonEuro = new JRadioButton("EURO");
        radioButtonEuro.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
        buttonGroup1.add(radioButtonEuro);
        radioButtonEuro.setBounds(300,415,100,25);
        contentPane.add(radioButtonEuro);

        JLabel labelAmount = new JLabel("Amount");
        labelAmount.setFont(new Font("Arial", Font.PLAIN, 18));
        labelAmount.setBounds(40,450,100,25);
        contentPane.add(labelAmount);

        textAmount = new JTextField();
        textAmount.setBounds(181,450,100,25);
        textAmount.setColumns(10);
        contentPane.add(textAmount);

        JLabel labelDate = new JLabel("Date:");
        labelDate.setBounds(40,485,100,25);
        labelDate.setFont(new Font("Arial", Font.PLAIN, 18));
        contentPane.add(labelDate);

        textDate = new JTextField();
        textDate.setText("");
        textDate.setBounds(181,485,100,25);
        textDate.setColumns(10);
        contentPane.add(textDate);

        JLabel labelAccountId = new JLabel("Account Id:");
        labelAccountId.setFont(new Font("Arial", Font.PLAIN, 18));
        labelAccountId.setBounds(40,520,120,25);
        contentPane.add(labelAccountId);

        textAccountId = new JTextField();
        textAccountId.setText("");
        textAccountId.setBounds(181,520,100,25);
        textAccountId.setColumns(10);
        contentPane.add(textAccountId);


        JButton button = new JButton("Confirm");
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int loginId = Integer.parseInt(textLoginId.getText());
                String username = textUsername.getText();
                String password = textPassword.getText();
                if(radioButtonAdministrator.isSelected())
                {
                    int role = 1;
                    LoginLogic.insertLogin(username,password,role,loginId);
                    JOptionPane.showMessageDialog(null,"A new Administrator account has been added successfully");
                    dispose();
                }
                else if (radioButtonClient.isSelected())
                {
                    int role = 0;
                    LoginLogic.insertLogin(username, password, role, loginId);
                    String name = textName.getText();
                    String address = textAddress.getText();
                    String birthday = textBirthday.getText();
                    int clientId = Integer.parseInt(textClientId.getText());
                    ClientLogic.insertClient(clientId, loginId, name, address, birthday);
                    int accountId = Integer.parseInt(textAccountId.getText());
                    Double amount = Double.parseDouble(textAmount.getText());
                    String date = textDate.getText();
                    String type;
                    if (radioButtonRon.isSelected())
                    {
                        type = radioButtonRon.getText();
                        AccountLogic.insertAccount(clientId, type, amount, date, accountId);
                        JOptionPane.showMessageDialog(null, "A new Client accountId has been added successfully");
                        dispose();
                    }
                    else if (radioButtonEuro.isSelected())
                    {
                        type = radioButtonEuro.getText();
                        AccountLogic.insertAccount(clientId, type, amount, date, accountId);
                        JOptionPane.showMessageDialog(null, "A new Client accountId has been added successfully");
                        dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Please select one of the two currencies: RON or EURO");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please select one of the two roles: Administrator or Client");
                }
            }
        });

        button.setBounds(500,485,110,25);
        contentPane.add(button);

        labelNewLabel = new JLabel("Insert Client");
        labelNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
        labelNewLabel.setBounds(40,20,300,30);
        contentPane.add(labelNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(40,54,560,2);
        contentPane.add(separator);

        JSeparator separator1 = new JSeparator();
        separator1.setBounds(40,590,560,2);
        contentPane.add(separator1);

        JButton button1 = new JButton("BACK");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        button1.setBounds(500,520,100,25);
        button1.setFont(new Font("Arial", Font.PLAIN, 18));
        contentPane.add(button1);


    }

}


