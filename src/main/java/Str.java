/*21.изменение надписи в графическом окне.  В центре верхней панели (JPanel)
"Вывод надписи" в графическом контексте выводится (с помощью метода drawString())
произвольная надпись. В нижней панели (JPanel) "Параметры надписи" задаются следующие
компоненты: надпись (JLabel) "Текст:", текстовое поле   (JTextField), надпись (JLabel)
"Цвет:", вращающийся список (JSpinner) со значениями: "Черный" (цвет по умолчанию),
"Красный", "Зеленый" и "Синий", надпись (JLabel) "Размер:", вращающийся список (JSpinner)
со значениями "10pt",  "12pt" (размер по умолчанию), "14pt" и "16pt", надпись (JLabel)
"Координата X:", текстовое поле   (JTextField),  надпись (JLabel) "Координата Y:",
текстовое поле   (JTextField), а также кнопка (JButton) "Вывести строку". Первоначально
текстовых полях "Координата X:" и "Координата Y:" устанавливаются координаты начала базовой
линии надписи (текстовые поля заданы как нередактируемые). При вводе данных надпись меняет
текст, цвет и/или размер. При щелчке мышью в области верхней панели в текстовых полях выводятся
координаты точки щелчка, и надпись перерисовывается в этой точке.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The class is used to store information about string and paint it
 * * <b>color</b>,<b>str</b>,<b>x</b>,<b>y</b>,<b>size</b>.
 * * @author Dudchenko Liudmila
 */
public class Str extends JComponent{
    /**Color*/
    private Color color;
    /**String*/
    private String str="";
    /**Coordinate X*/
    private int x;
    /**Coordinate Y*/
    private int y;
    /**Size*/
    private int size;

    /** Function for drawing string
     * @param g - Graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.setFont(new Font(g.getFont().getFontName(), g.getFont().getStyle(), size));
        g.drawString(str,x,y);
    }

    /**Method for getting value of field {@link Str#color}
     * @return It returns color of square
     */
    public Color getColor() {
        return color;
    }

    /**Method for setting value of field {@link Str#color}
     * @param color - color of round rectangle
     */
    public void setColor(String color) {
        if(color.equals("Красный")) {
            this.color = Color.RED;
        }
        else if(color.equals("Зелёный")) {
            this.color = Color.GREEN;
        }
        else if(color.equals("Синий")) {
            this.color = Color.BLUE;
        }
        else{
            this.color = Color.BLACK;
        }
    }

    /**Method for setting value of field {@link Str#size}
     * @param size - color of round rectangle
     */
    public void setSize(String size) {
        if(size.equals(" 10pt")) {
            this.size = 10;
        }
        else if(size.equals(" 12pt")) {
            this.size = 12;
        }
        else if(size.equals(" 14pt")) {
            this.size = 14;
        }
        else{
            this.size = 16;
        }
    }

    /**Method for getting value of field {@link Str#str}
     * @return It returns str
     */
    public String getStr() {
        return str;
    }

    /**Method for setting value of field {@link Str#str}
     * @param str - string
     */
    public void setStr(String str) {
        this.str = str;
    }

    /**Method for getting value of field {@link Str#x}
     * @return It returns X coordinate
     */
    public int getstrX() {
        return x;
    }

    /**Method for setting value of field {@link Str#x}
     * @param x - X coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**Method for getting value of field {@link Str#y}
     * @return It returns Y coordinate
     */
    public int getstrY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

/**
 * The class is used to store information about frame and create it
 * <b>frame</b>,<b>jPanel1</b>,<b>jPanel2</b>,<b>textField_text</b>,<b>jSpinnerColor</b>,<b>jSpinnerSizes</b>,
 * <b>textField_x</b>,<b>textField_y</b>,<b>jButton</b>,<b>ob</b>.
 * @author Dudchenko Liudmila
 */
class Frame21 extends JFrame implements ActionListener{
    /**Frame*/
    JFrame jFrame;
    /**First panel*/
    JPanel jPanel1;
    /**Second panel*/
    JPanel jPanel2;
    /**Text field for text*/
    JTextField textField_text;
    /**SpinnerColor*/
    JSpinner jSpinnerColor;
    /**SpinnerSizes*/
    JSpinner jSpinnerSizes;
    /**Text field for coordinate x*/
    JTextField textField_x;
    /**Text field for coordinate y*/
    JTextField textField_y;
    /**Button for changing string*/
    JButton jButton;
    /**String object*/
    Str ob;

    /** It creates a new empty object of frame with all components
     *@see Frame21#Frame21()
     */
    Frame21() {
        jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 500, dimension.height / 2 - 300, 1000, 600);
        jFrame.setTitle("Task 21");
        jPanel1 = new JPanel();
        jPanel1.setLayout(new GridLayout(1,1));
        jPanel1.setBorder(BorderFactory.createTitledBorder("Вывод надписи:"));

        jFrame.add(jPanel1,BorderLayout.CENTER);
        jPanel2 = new JPanel();
        jPanel2.setBorder(BorderFactory.createTitledBorder("Параметры надписи:"));
        jFrame.add(jPanel2,BorderLayout.SOUTH);
        //jPanel2.setBackground(Color.yellow);
        jPanel2.setLayout(new FlowLayout());

        JLabel label_text = new JLabel(" Текст: ");
        textField_text = new JTextField(10);
        jPanel2.add(label_text);
        jPanel2.add(textField_text);

        JLabel label_color = new JLabel(" Цвет: ");
        String[] arr_colors = {"  Чёрный","Красный","Зелёный","Синий"};
        SpinnerModel colors = new SpinnerListModel(arr_colors);
        jSpinnerColor = new JSpinner(colors);
        jPanel2.add(label_color);
        jPanel2.add(jSpinnerColor);

        JLabel label_size = new JLabel(" Размер: ");
        String[] arr_sizes = {" 10pt"," 12pt"," 14pt"," 16pt"};
        SpinnerModel sizes = new SpinnerListModel(arr_sizes);
        jSpinnerSizes = new JSpinner(sizes);
        jPanel2.add(label_size);
        jPanel2.add(jSpinnerSizes);

        JLabel label_x = new JLabel(" Координата Х: ");
        textField_x = new JTextField("70",10);
        textField_x.setEditable(false);
        jPanel2.add(label_x);
        jPanel2.add(textField_x);
        textField_x.setText("50");

        JLabel label_y = new JLabel(" Координата Y: ");
        textField_y = new JTextField("70",10);
        textField_y.setEditable(false);
        jPanel2.add(label_y);
        jPanel2.add(textField_y);
        textField_y.setText("50");

        jButton = new JButton("Вывести строку");
        jButton.addActionListener(this);
        jPanel2.add(jButton);

        ob = new Str();
        jPanel1.add(ob);
        jPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                ob.setX(e.getX());
                ob.setY(e.getY());
                textField_x.setText(Integer.toString(e.getX()));
                textField_y.setText(Integer.toString(e.getY()));
                ob.repaint();
            }
        });

        jFrame.revalidate();
    }

    /**Method for creating action for button
     * @param e - ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (textField_text.getText().trim().length() == 0) {
            System.out.println("Error input, empty text field!");
        } else {
            ob.setStr(textField_text.getText());
            ob.setColor((String) jSpinnerColor.getValue());
            ob.setSize((String) jSpinnerSizes.getValue());
            ob.setX(Integer.parseInt(textField_x.getText()));
            ob.setY(Integer.parseInt(textField_y.getText()));
            ob.repaint();
        }
    }
}
 /**The class for main method*/
class MainTask21 {
    public static void main(String[] args) {
        new Frame21();
    }
}