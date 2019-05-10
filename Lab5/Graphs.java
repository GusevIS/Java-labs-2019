import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Graphs extends JFrame implements ActionListener{
    private Lab1 lab1;
    private Lab2 lab2;
    private Lab3 lab3;
    private Lab4 lab4;
    private JTabbedPane pane = new JTabbedPane();
    private JPanel pLab1 = new JPanel();
    private JPanel pLab2 = new JPanel();
    private JPanel pLab3 = new JPanel();
    private JPanel pLab4 = new JPanel();
    private JButton buttonLab1 = new JButton("Lab 1");
    private JButton buttonLab2 = new JButton("Lab 2");
    private JButton buttonLab3 = new JButton("Lab 3");
    private JButton buttonLab4 = new JButton("Lab 4");

    private JTextArea taskArea1 = new JTextArea("Создать приложение с 3 параметрами. Необходимо определить могут ли быть введенные параметры сторонами треугольника и вывести сообщение в случае, если это невозможно , о причине. Вывести на дисплей введенные числа и полученный результат");
    private JTextArea taskArea2 = new JTextArea("Создать приложение с 2 классами- А, B и 2 интерфейсами I1, I2. Класс А является родительским для класса B, Интерфейс I1 является родительским для интерфейса I2. Класс A реализует интерфейс I1. Класс В реализует интерфейс I2. Интерфейс I1 содержит метод i1, класс А содержит метод а1, интерфейс I2 содержит метод i2. Класс B содержит метод b1. Все методы выводят строку с именем своего класса или интерфейса и именем метода. Создать минимальное число объектов для выполнения всех указанных 4 методов. и выполнить все эти методы. Присвоить переменным типа I1 каждый из созданных объектов и еще раз выполнить все прежние методы для переменной типа I1(используя приведение типов)");
    private JTextArea taskArea3 = new JTextArea("Создать 2 потока разными способами. Один из этих потоков увеличивает разделенную между потоками переменную на 1000, а другой на 10 . Потоки работают попеременно. Цикл для каждого потока выполняется число раз заданное параметром. Нужно выводить для каждого потока его имя и значение измененной переменной. Выполнить задание с использованием конструкции synchronized . Не использовать в этом задании флаги для синхронизации потоков, а только методы wait и notify. Также не использовать любые задержки для потоков после начала их работы в виде методов sleep, yield или wait c параметром");
    private JTextArea taskArea4 = new JTextArea("Создать приложение с 2 параметрами. 1 параметр задает количество cтудентов, 2-ой параметр задает количество преподавателей. каждый преподаватель строго по очереди приглашает любого студента. Как только студент получает приглашение , то поток студент заканчивается. Преподаватель становится после этого последним в очереди преподавателей на вызов студента . Потоки - преподаватели должны работать строго по очереди. Работа продолжается пока есть хоть один студент и если число преподавателей больше нуля. Использовать ограничения из задания 3. Выводить на дисплей имя преподавателя вместе с именем студента. Выглядеть это будет примерно так: преподаватель1- студент3 преподаватель2- студент1 преподаватель1- студент4 преподаватель2- студент2");

    public JTextArea textArea = new JTextArea("Enter arguments in the field above and choose a lab \n");
    private JScrollPane scrollPane = new JScrollPane (textArea);
    public JTextArea textArea2 = new JTextArea("Enter arguments in the field above and choose a lab \n");
    private JScrollPane scrollPane2 = new JScrollPane (textArea2);
    public JTextArea textArea3 = new JTextArea("Enter arguments in the field above and choose a lab \n");
    private JScrollPane scrollPane3 = new JScrollPane (textArea3);
    public JTextArea textArea4 = new JTextArea("Enter arguments in the field above and choose a lab \n");
    private JScrollPane scrollPane4 = new JScrollPane (textArea4);

    private JTextField inputArguments = new JTextField("", 1);
    private JTextField inputArguments3 = new JTextField("", 1);
    private JTextField inputArguments4 = new JTextField("", 1);

    public Graphs()
    {
        super("Lab 5");
        this.setBounds(100, 100, 350, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonLab1.addActionListener(this);
        buttonLab2.addActionListener(this);
        buttonLab3.addActionListener(this);
        buttonLab4.addActionListener(this);
        taskArea1.setLineWrap(true);
        taskArea2.setLineWrap(true);
        taskArea3.setLineWrap(true);
        taskArea4.setLineWrap(true);

        scrollPane.setPreferredSize(new Dimension(300, 400));
        taskArea1.setPreferredSize(new Dimension(300, 400));

        pLab1.add(buttonLab1);
        pLab1.add(inputArguments);
        pLab1.add(scrollPane);
        pLab1.add(taskArea1);
        pLab1.setLayout(new BoxLayout(pLab1, BoxLayout.Y_AXIS));

        scrollPane2.setPreferredSize(new Dimension(300, 400));
        pLab2.add(buttonLab2);
        pLab2.add(scrollPane2);
        pLab2.add(taskArea2);
        pLab2.setLayout(new BoxLayout(pLab2, BoxLayout.Y_AXIS));

        scrollPane3.setPreferredSize(new Dimension(300, 400));
        pLab3.add(buttonLab3);
        pLab3.add(inputArguments3);
        pLab3.add(scrollPane3);
        pLab3.add(taskArea3);
        pLab3.setLayout(new BoxLayout(pLab3, BoxLayout.Y_AXIS));

        scrollPane4.setPreferredSize(new Dimension(300, 400));
        pLab4.add(buttonLab4);
        pLab4.add(inputArguments4);
        pLab4.add(scrollPane4);
        pLab4.add(taskArea4);
        pLab4.setLayout(new BoxLayout(pLab4, BoxLayout.Y_AXIS));

        pane.addTab("Lab1", pLab1);
        pane.addTab("Lab2", pLab2);
        pane.addTab("Lab3", pLab3);
        pane.addTab("Lab4", pLab4);
        this.add(pane);
    }

    public void actionPerformed(ActionEvent action)
    {
        String [] arguments;
        switch (action.getActionCommand()) {
            case "Lab 1":
                textArea.setText(null);
                arguments = inputArguments.getText().split(" ");
                textArea.append("Lab 1 \n");
                lab1 = new Lab1(this);
                lab1.startLab1(arguments);
                break;
            case "Lab 2":
                textArea2.setText(null);
                textArea2.append("Lab 2 \n");
                lab2 = new Lab2(this);
                lab2.startLab2();
                break;
            case "Lab 3":
                textArea3.setText(null);
                arguments = inputArguments3.getText().split(" ");
                textArea3.append("Lab 3 \n");
                lab3 = new Lab3(this);
                lab3.startLab3(arguments);
                break;
            case "Lab 4":
                textArea4.setText(null);
                arguments = inputArguments4.getText().split(" ");
                textArea4.append("Lab 4 \n");
                lab4 = new Lab4(this);
                lab4.startLab4(arguments);
                break;
        }
    }

}
