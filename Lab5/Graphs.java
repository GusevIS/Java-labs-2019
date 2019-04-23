import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Graphs extends JFrame implements ActionListener{
    private Lab1 lab1;
    private Lab2 lab2;
    private Lab3 lab3;
    private Lab4 lab4;
    private JButton buttonLab1 = new JButton("Lab 1");
    private JButton buttonLab2 = new JButton("Lab 2");
    private JButton buttonLab3 = new JButton("Lab 3");
    private JButton buttonLab4 = new JButton("Lab 4");

    public JTextArea textArea = new JTextArea("Enter arguments in the field above and choose a lab \n");
    private JScrollPane scrollPane = new JScrollPane (textArea);

    private JTextField inputArguments = new JTextField("", 1);

    public Graphs()
    {
        super("Lab 5");
        this.setBounds(100, 100, 350, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6, 1));

        buttonLab1.addActionListener(this);
        buttonLab2.addActionListener(this);
        buttonLab3.addActionListener(this);
        buttonLab4.addActionListener(this);

        container.add(buttonLab1);
        container.add(buttonLab2);
        container.add(buttonLab3);
        container.add(buttonLab4);
        container.add(inputArguments);
        container.add(scrollPane);
    }

    public void sendMessageToTextArea(String message)
    {
        textArea.append(message);
    }

    public void actionPerformed(ActionEvent action)
    {
        textArea.setText(null);
        String [] arguments;
        arguments = inputArguments.getText().split(" ");
        switch (action.getActionCommand()) {
            case "Lab 1":
                textArea.append("Lab 1 \n");
                lab1 = new Lab1(this);
                lab1.startLab1(arguments);
                break;
            case "Lab 2":
                textArea.append("Lab 2 \n");
                lab2 = new Lab2(this);
                lab2.startLab2(arguments);
                break;
            case "Lab 3":
                textArea.append("Lab 3 \n");
                lab3 = new Lab3(this);
                lab3.startLab3(arguments);
                break;
            case "Lab 4":
                textArea.append("Lab 4 \n");
                lab4 = new Lab4(this);
                lab4.startLab4(arguments);
                break;
        }
    }

}
