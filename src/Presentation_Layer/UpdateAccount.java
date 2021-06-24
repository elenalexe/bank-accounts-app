package Presentation_Layer;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

import Domain_Logic_Layer.AccountLogic;

public class UpdateAccount  extends  JFrame{

    private JPanel contentPane;
    private JTextField textClientId;
    private JTextField textType;
    private JTextField textAmount;
    private JTextField textDate;

    public UpdateAccount(int accountId)
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelClientId = new JLabel("Client Id:");
        labelClientId.setBounds(35,60,100,30);
        labelClientId.setFont(new Font("Arial", Font.PLAIN,18));
        contentPane.add(labelClientId);

        JLabel labelType = new JLabel("Type:");
        labelType.setBounds(35,110,45,30);
        labelType.setFont(new Font("Arial", Font.PLAIN,18));
        contentPane.add(labelType);

        JLabel labelAmount = new JLabel("Amount:");
        labelAmount.setBounds(35,160,100,30);
        labelAmount.setFont(new Font("Arial", Font.PLAIN,18));
        contentPane.add(labelAmount);

        JLabel labelDate = new JLabel("Date:");
        labelDate.setBounds(35,210,100,30);
        labelDate.setFont(new Font("Arial", Font.PLAIN,18));
        contentPane.add(labelDate);

        textClientId = new JTextField();
        textClientId.setBounds(123, 60, 96, 30);
        textClientId.setColumns(10);
        contentPane.add(textClientId);


        textType = new JTextField();
        textType.setBounds(123, 110, 96, 30);
        textType.setColumns(10);
        contentPane.add(textType);


        textAmount = new JTextField();
        textAmount.setBounds(123, 160, 96, 30);
        textAmount.setColumns(10);
        contentPane.add(textAmount);


        textDate = new JTextField();
        textDate.setBounds(123, 210, 96, 30);
        textDate.setColumns(10);
        contentPane.add(textDate);

        JButton buttonConfirm = new JButton("Confirm");
        buttonConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int clientId= Integer.parseInt(textClientId.getText());
                String type= textType.getText();
                Double amount= Double.parseDouble(textAmount.getText());
                String date= textDate.getText();
                JFrame frame= new JFrame();
                if(JOptionPane.showConfirmDialog(frame, "Do you want to update this Account?", "Account System",
                        JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
                    AccountLogic.updateAccountByAccountId(clientId, type, amount, date, accountId);
                    JOptionPane.showMessageDialog(null, "The Account has been updated successfully!");
                    dispose();
                }
            }
        });
        buttonConfirm.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonConfirm.setBounds(291, 160, 100, 30);
        contentPane.add(buttonConfirm);

        JButton buttonBack = new JButton("BACK");
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonBack.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonBack.setBounds(291, 210, 100, 30);
        contentPane.add(buttonBack);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    int x=0;
                    UpdateAccount frame = new UpdateAccount(x);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
