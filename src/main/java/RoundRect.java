/*15.изменение фигуры в графическом окне. В центре верхней панели
 (JPanel) "Вывод прямоугольника" в графическом контексте рисуется
 (с помощью метода drawRoundRect()) прямоугольник со скругленными
 вершинами.  В нижней панели (JPanel) "Параметры прямоугольника"
 задаются следующие компоненты: надпись (JLabel) "Цвет:",
 вращающийся список (JSpinner) со значениями: "Черный" (цвет по
 умолчанию),  "Красный", "Зеленый" и "Синий", надпись (JLabel)
 "Ширина закругления", текстовое поле   (JTextField), надпись
 (JLabel)  "Высота закругления:", текстовое поле   (JTextField)
 и кнопка (JButton) "изменить прямоугольник". При наборе данных
 во вращающихся списках, вводе данных в текстовых полях (в пикселях)
 и при нажатии кнопки "изменить прямоугольник" прямоугольник
 перерисовывается заданным цветом и с заданным новыми значениями
 ширины и высоты закруглений. Перед выводом фигуры выполняется проверка,
  введены ли в текстовых полях все данные и являются ли они целыми числами. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class is used to store information about geometry object: rounded rectangle and paint it
 * * <b>color</b>,<b>arcWidth</b>,<b>arcHeight</b>
 * * @author Dudchenko Liudmila
 */
public class RoundRect extends JComponent{
    /**Color*/
    private Color color;
    /**Arc Width*/
    private int arcWidth;
    /**Arc Height*/
    private int arcHeight;

    /**Method for setting value of field {@link RoundRect#color}
     * @param color - color of rectangle
     */
    void setColor(String color){
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

    /** Method for painting rounded rectangle
     * @param g - Graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawRoundRect(300, 20, 200, 100, arcWidth, arcHeight);
        g.fillRoundRect(300, 20, 200, 100, arcWidth, arcHeight);
    }

    /**Method for setting value of field {@link RoundRect#arcWidth}
     * @param arcWidth - Arc Width
     */
    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
    }

    /**Method for setting value of field {@link RoundRect#arcHeight}
     * @param arcHeight - Arc Height
     */
    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
    }

    /**Method for getting value of field {@link RoundRect#color}
     * @return It returns color of square
     */
    public Color getColor() {
        return color;
    }

    /**Method for setting value of field {@link RoundRect#color}
     * @param color - color of round rectangle
     */
    public void setColor(Color color) {
        this.color = color;
    }
}

/**
 * The class is used to store information about frame and create it
 * <b>frame</b>,<b>jPanel1</b>,<b>jPanel2</b>,<b>jSpinnerColor</b>,<b>textField_width</b>,<b>textField_height</b>,
 * <b>jButton</b>,<b>ob</b>.
 * @author Dudchenko Liudmila
 */
class Frame extends JFrame implements ActionListener{
    /**Frame*/
    JFrame jFrame;
    /**Panel1*/
    JPanel jPanel1;
    /**Panel2*/
    JPanel jPanel2;
    /**SpinnerColor*/
    JSpinner jSpinnerColor;
    /**Text field for inputing width*/
    JTextField textField_width;
    /**Text field for inputing height*/
    JTextField textField_height;
    /**Button for changing rectangle*/
    JButton jButton;
    /**Rectangle object*/
    RoundRect ob;

    /** It creates a new empty object of frame with all components
     *@see Frame#Frame()
     */
    Frame(){
        jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 425, dimension.height / 2 - 150, 850, 300);
        jFrame.setTitle("Task15");
        jPanel1 = new JPanel();
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.PAGE_AXIS));

        jFrame.add(jPanel1,BorderLayout.CENTER);
        jPanel1.setBorder(BorderFactory.createTitledBorder("Вывод прямоугольника:"));
        jPanel2 = new JPanel();
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.PAGE_AXIS));
        jFrame.add(jPanel2,BorderLayout.SOUTH);
        //jPanel2.setBackground(Color.yellow);
        jPanel2.setBorder(BorderFactory.createTitledBorder("Параметры прямоугольника:"));
        jPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelColor = new JLabel("Цвет: ");
        jPanel2.add(labelColor);
        String[] arr_colors = {"  Чёрный","Красный","Зелёный","Синий"};
        SpinnerModel colors = new SpinnerListModel(arr_colors);
        jSpinnerColor = new JSpinner(colors);
        jPanel2.add(jSpinnerColor);
        JLabel label_width = new JLabel(" Ширина закругления: ");
        textField_width = new JTextField(10);
        jPanel2.add(label_width);
        jPanel2.add(textField_width);
        JLabel label_height = new JLabel(" Высота закругления: ");
        textField_height = new JTextField(10);
        jPanel2.add(label_height);
        jPanel2.add(textField_height);
        jButton = new JButton("изменить прямоугольник");
        jButton.addActionListener(this);
        jPanel2.add(jButton);
        ob = new RoundRect();
        jPanel1.add(ob);
        jFrame.revalidate();
    }

    /**Method for creating action for button
     * @param e - ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String width=textField_height.getText();
        String height=textField_width.getText();
        if(width.trim().length()==0||height.trim().length()==0){
            System.out.println("Error input, empty text field!");
        }
        else {
            if(!height.matches("^(\\+?|-?)\\d+$")||!width.matches("^(\\+?|-?)\\d+$")){
                System.out.println("Error input, only integers!");
            }
            else {
                ob.setArcHeight(Integer.parseInt(height));
                ob.setArcWidth(Integer.parseInt(width));
                ob.setColor((String) jSpinnerColor.getValue());
                ob.repaint();
            }
        }
    }
}

/**The class for main method*/
class MainTask15 {
    public static void main(String[] args) {
      new Frame();
    }
}
