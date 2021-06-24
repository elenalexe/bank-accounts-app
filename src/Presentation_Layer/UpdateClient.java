package Presentation_Layer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Domain_Logic_Layer.AccountLogic;
import Domain_Logic_Layer.ClientLogic;

public class UpdateClient extends JFrame {

    private JPanel contentPane;
    private JTextField textName;
    private JTextField textAddress;
    private JTextField textBirthday;

    public UpdateClient(int i)
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,500,268);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelName = new JLabel("Name: ");
        labelName.setBounds(25,50,100,27);
        labelName.setFont(new Font("Arial", Font.PLAIN,18));
        contentPane.add(labelName);

        textName = new JTextField();
        textName.setBounds(140,50,96,25);
        textName.setColumns(10);
        contentPane.add(textName);

        JLabel labelAddress = new JLabel("Address: ");
        labelAddress.setBounds(25,90,100,27);
        labelAddress.setFont(new Font("Arial", Font.PLAIN,18));
        contentPane.add(labelAddress);

        textAddress = new JTextField();
        textAddress.setBounds(140,90,96,25);
        textAddress.setColumns(10);
        contentPane.add(textAddress);

        JLabel labelBirthday = new JLabel("Birthday: ");
        labelBirthday.setBounds(25,170,120,27);
        labelBirthday.setFont(new Font("Arial", Font.PLAIN, 18));
        contentPane.add(labelBirthday);

        textBirthday = new JTextField();
        textBirthday.setBounds(140,170,96,25);
        textBirthday.setColumns(10);
        contentPane.add(textBirthday);

        JButton button = new JButton("Confirm");
        button.setFont(new Font("Arial", Font.BOLD,18));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                String address = textAddress.getText();
                String birthday = textBirthday.getText();

                JFrame frame = new JFrame();
                if (JOptionPane.showConfirmDialog(frame, "Do you want to update the client details?", "Account System",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
                {
                    ClientLogic.updateClientByClientId(i, name, address, birthday);
                    JOptionPane.showMessageDialog(null, "The Client details has been updated");
                    dispose();
                }
            }
        });
        button.setBounds(300,130,150,27);
        contentPane.add(button);

        JButton button1 = new JButton("BACK");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        button1.setBounds(300,170,100,27);
        button1.setFont(new Font("Arial", Font.BOLD,18));
        contentPane.add(button1);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    int x=0;
                    UpdateClient frame = new UpdateClient(x);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
