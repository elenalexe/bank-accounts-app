package Presentation_Layer;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Data_Source_Logic_Layer.DataBaseConnection;
import Domain_Logic_Layer.Login;
import Domain_Logic_Layer.LoginLogic;

public class UserLogin {

    private JFrame frame;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JRadioButton radioButtonAdministrator;
    private JRadioButton radioButtonClient;
    private JButton buttonLogin;
    private JButton buttonCancel;
    private JButton buttonReset;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    public UserLogin() {
        frame = new JFrame();
        frame.setBounds(200, 200, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel labelLogin = new JLabel("Login");
        labelLogin.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
        labelLogin.setBounds(250, 40, 101, 25);
        frame.getContentPane().add(labelLogin);

        JLabel labelUsername = new JLabel("Username");
        labelUsername.setFont(new Font("Arial", Font.PLAIN, 18));
        labelUsername.setBounds(105, 101, 104, 29);
        frame.getContentPane().add(labelUsername);

        JLabel labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 18));
        labelPassword.setBounds(105, 150, 104, 29);
        frame.getContentPane().add(labelPassword);

        textUsername = new JTextField();
        textUsername.setBounds(240, 101, 200, 25);
        textUsername.setColumns(10);
        frame.getContentPane().add(textUsername);

        textPassword = new JPasswordField();
        textPassword.setBounds(240, 150, 200, 25);
        frame.getContentPane().add(textPassword);

        radioButtonAdministrator = new JRadioButton("Administrator");
        buttonGroup.add(radioButtonAdministrator);
        radioButtonAdministrator.setFont(new Font("Arial", Font.PLAIN, 18));
        radioButtonAdministrator.setBounds(130, 217, 131, 29);
        frame.getContentPane().add(radioButtonAdministrator);

        radioButtonClient = new JRadioButton("Client");
        buttonGroup.add(radioButtonClient);
        radioButtonClient.setFont(new Font("Arial", Font.PLAIN, 18));
        radioButtonClient.setBounds(370, 217, 131, 29);
        frame.getContentPane().add(radioButtonClient);

        buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String user= textUsername.getText();

                try
                {

                    System.out.println("S5: "+user);
                    boolean admin= Domain_Logic_Layer.LoginLogic.verifyLoginAdmin(textUsername.getText(), textPassword.getText());
                    boolean client= Domain_Logic_Layer.LoginLogic.verifyLoginClient(textUsername.getText(), textPassword.getText());


                    int status= Domain_Logic_Layer.LoginLogic.getRole(admin, client);
                    Login loging_db= LoginLogic.getLoginByUsername(user);

                    if(status == 1 && radioButtonAdministrator.isSelected())
                    {
                        JOptionPane.showMessageDialog(null, "Login as Administrator successful");
                        frame.dispose();
                        AdministratorGUI a= new AdministratorGUI();
                        a.setVisible(true);
                    }
                    else if ((status == 1 && radioButtonClient.isSelected()) || (status == 0 && radioButtonAdministrator.isSelected()))
                    {
                        JOptionPane.showMessageDialog(null, "Login failed. Choose another role");
                    }
                    else if(status == 0 && radioButtonClient.isSelected())
                    {
                        JOptionPane.showMessageDialog(null, "Login as Client successful");
                        frame.dispose();
                        ClientGUI c = new ClientGUI(loging_db);
                        c.setVisible(true);
                    }

                    else
                        {
                        JOptionPane.showMessageDialog(null, "Invalid login");
                    }

                }
                catch(Exception exception)
                {
                    System.out.println(exception);
                }
            }
        });
        buttonLogin.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonLogin.setBounds(64, 284, 85, 29);
        frame.getContentPane().add(buttonLogin);

        buttonReset = new JButton("Reset");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                textUsername.setText(null);
                textPassword.setText(null);

            }
        });
        buttonReset.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonReset.setBounds(235, 284, 85, 29);
        frame.getContentPane().add(buttonReset);

        buttonCancel = new JButton("Cancel");
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame = new JFrame("Cancel");
                if(JOptionPane.showConfirmDialog(frame, "Do you want to cancel?", "Login System",
                        JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }
            }
        });
        buttonCancel.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonCancel.setBounds(405, 284, 95, 29);
        frame.getContentPane().add(buttonCancel);

        JSeparator separator1 = new JSeparator();
        separator1.setBounds(64, 260, 434, 2);
        frame.getContentPane().add(separator1);

        JSeparator separator2 = new JSeparator();
        separator2.setBounds(64, 80, 434, 2);
        frame.getContentPane().add(separator2);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin window = new UserLogin();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
