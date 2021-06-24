package Presentation_Layer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Domain_Logic_Layer.AccountLogic;
import Domain_Logic_Layer.ClientLogic;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertAccount extends JFrame {

    private JPanel contentPane;
    private JTextField textClientID;
    private JTextField textAccountID;
    private JTextField textAmount;
    private JTextField textDate;


    public InsertAccount(int login_id) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 517, 346);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Client ID:");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNewLabel.setBounds(37, 90, 100, 30);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Account ID:");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(37, 130, 100, 30);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Type:");
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(37, 170, 100, 30);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Amount:");
        lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(37, 210, 100, 30);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Date:");
        lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNewLabel_4.setBounds(37, 250, 100, 30);
        contentPane.add(lblNewLabel_4);

        textClientID = new JTextField();
        textClientID.setBounds(147, 90, 100, 25);
        contentPane.add(textClientID);
        textClientID.setColumns(10);

        textAccountID = new JTextField();
        textAccountID.setBounds(147, 130, 100, 25);
        contentPane.add(textAccountID);
        textAccountID.setColumns(10);

        JRadioButton ron = new JRadioButton("RON");
        ron.setFont(new Font("Arial", Font.PLAIN, 18));
        ron.setBounds(147, 170, 103, 25);
        contentPane.add(ron);

        JRadioButton euro = new JRadioButton("EURO");
        euro.setFont(new Font("Arial", Font.PLAIN, 18));
        euro.setBounds(271, 170, 103, 30);
        contentPane.add(euro);

        textAmount = new JTextField();
        textAmount.setBounds(147, 210, 100, 25);
        contentPane.add(textAmount);
        textAmount.setColumns(10);

        textDate = new JTextField();
        textDate.setBounds(147, 250, 100, 25);
        contentPane.add(textDate);
        textDate.setColumns(10);

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        back.setFont(new Font("Arial", Font.PLAIN, 18));
        back.setBounds(362, 253, 100, 25);
        contentPane.add(back);

        JButton confirm = new JButton("Confirm");
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int client_id= Integer.parseInt(textClientID.getText());
                boolean client_ok= ClientLogic.verifyClientIdByLoginId(login_id, client_id);
                int account_id=Integer.parseInt(textAccountID.getText());
                Double amount= Double.parseDouble(textAmount.getText());
                String date= textDate.getText();
                if(client_ok) {
                    if(ron.isSelected()) {
                        String type= ron.getText();
                        int ok=AccountLogic.insertAccount(client_id, type, amount, date,account_id);
                        if(ok==1) {
                            JOptionPane.showMessageDialog(null, "A new RON account has been successfully added");
                            dispose();}
                        else {
                            JOptionPane.showMessageDialog(null, "We could not add a new RON account");
                        }
                    }
                    else if(euro.isSelected()) {
                        String type= euro.getText();
                        int ok=AccountLogic.insertAccount(client_id, type, amount, date, account_id);
                        if(ok==1) {
                            JOptionPane.showMessageDialog(null, "A new EURO account has been successfully added");
                            dispose();}
                        else {
                            JOptionPane.showMessageDialog(null, "We could not add a new EURO account");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please select a currency!");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "You can't add a new account for this clientID!");
                }
            }
        });
        confirm.setFont(new Font("Arial", Font.PLAIN, 18));
        confirm.setBounds(362, 213, 100, 25);
        contentPane.add(confirm);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    int x=0;
                    InsertAccount frame = new InsertAccount(x);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
