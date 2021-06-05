/*17.Рисование фигуры в графическом окне. В верхней панели (JPanel)
"Вывод дуги" в графическом контексте рисуется (с помощью метода drawArc())
дуга. В нижней панели (JPanel) "Параметры дуги" задаются следующие компоненты:
надпись (JLabel)   "Координата X:", текстовое поле   (JTextField), надпись
(JLabel)   "Координата Y:", текстовое поле   (JTextField),  надпись (JLabel)
 "Ширина:", текстовое поле   (JTextField), надпись (JLabel)   "Высота:",
 текстовое поле (JTextField), надпись (JLabel)   "Начальный угол:", текстовое
 поле   (JTextField), надпись (JLabel)   "Конечный угол:", текстовое поле
(JTextField) и кнопка (JButton) "Вывести дугу". При вводе данных (в пикселях
и в градусах – для углов) и при нажатии кнопки "Вывести дугу" дуга перерисовывается
с заданными параметрами. При вводе данных проверяется, все ли данные введены и
являются ли данные целыми числами. Значения углов должны являться положительными
или отрицательными целыми числами в диапазоне (по абсолютной величине) от 0 до 360.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class is used to store information about geometry object: arc and paint it
 * * <b>x</b>,<b>y</b>,<b>width</b>,<b>height</b>,<b>start_angle</b>,<b>end_angle</b>.
 * * @author Dudchenko Liudmila
 */
public class Arc extends JComponent{
    /**X coordinate*/
    private int x;
    /**Y coordinate*/
    private int y;
    /**Width*/
    private int width;
    /**Height*/
    private int height;
    /**Start angle*/
    private int start_angle;
    /**Arc angle*/
    private int end_angle;

    /** Function for painting arc
     * @param g - Graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawArc(x,y,width,height,start_angle,end_angle);
    }

    /** Method for getting value of field {@link Arc#x}
     * @return x coordinate
     */
    public int getarcX() {
        return x;
    }

    /*Method for setting value of field {@link Arc#x}
     * @param x - x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /** Method for getting value of field {@link Arc#width}
     * @return width of arc
     */
    public int getarcWidth() {
        return width;
    }

    /** Method for setting value of field {@link Arc#width}
     * @param width - width of arc
     */
    public void setWidth(int width) {
        if(width>=0) {
            this.width = width;
        }
        else{
            System.out.println("Width must be positive!");
        }
    }

    /** Method for getting value of field {@link Arc#y}
     * @return y coordinate
     */
    public int getarcY() {
        return y;
    }

    /*Method for setting value of field {@link Arc#y}
     * @param y - y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /** Method for getting value of field {@link Arc#height}
     * @return height of arc
     */
    public int getarcHeight() {
        return height;
    }

    /** Method for setting value of field {@link Arc#height}
     * @param height - height of arc
     */
    public void setHeight(int height) {
        if(height>=0) {
            this.height = height;
        }
        else{
            System.out.println("Height must be positive!");
        }
    }

    /** Method for getting value of field {@link Arc#start_angle}
     * @return start angle of arc
     */
    public int getStart_angle() {
        return start_angle;
    }

    /** Method for setting value of field {@link Arc#start_angle}
     * @param start_angle - start angle of arc
     */
    public void setStart_angle(int start_angle) {
        if(Math.abs(start_angle)>=0&&Math.abs(start_angle)<=360) {
            this.start_angle = start_angle;
        }
        else{
            System.out.println("The angles must be betweeon 0 and 360!");
        }
    }

    /** Method for getting value of field {@link Arc#end_angle}
     * @return end angle of arc
     */
    public int getEnd_angle() {
        return end_angle;
    }

    /** Method for setting value of field {@link Arc#end_angle}
     * @param end_angle - start angle of arc
     */
    public void setEnd_angle(int end_angle) {
        if(Math.abs(end_angle)>=0&&Math.abs(end_angle)<=360) {
            this.end_angle = end_angle;
        }
        else{
            System.out.println("The angles must be betweeon 0 and 360!");
        }
    }
}

/**
 * The class is used to store information about frame and create it
 * <b>frame</b>,<b>jPanel1</b>,<b>jPanel2</b>,<b>textField_x</b>,<b>textField_y</b>,<b>textField_width</b>,
 * <b>textField_height</b>,<b>textField_start_angle</b>,<b>textField_end_angle</b>,<b>jButton</b>,<b>ob</b>.
 * @author Dudchenko Liudmila
 */
class Frame17 extends JFrame implements ActionListener {
    /**Frame*/
    JFrame jFrame;
    /**First panel*/
    JPanel jPanel1;
    /**Second panel*/
    JPanel jPanel2;
    /**Text field for coordinate x*/
    JTextField textField_x;
    /**Text field for coordinate y*/
    JTextField textField_y;
    /**Text field for width of arc*/
    JTextField textField_width;
    /**Text field for height of arc*/
    JTextField textField_height;
    /**Text field for start angle of arc*/
    JTextField textField_start_angle;
    /**Text field for end angle of arc*/
    JTextField textField_end_angle;
    /**Button for changing arc*/
    JButton jButton;
    /**Arc object */
    Arc ob;

    /** It creates a new empty object of frame with all components
     *@see Frame17#Frame17()
     */
    Frame17(){
        jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 525, dimension.height / 2 - 300, 1050, 600);
        jFrame.setTitle("Task15");
        jPanel1 = new JPanel(new GridLayout(1,1));
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.PAGE_AXIS));

        jFrame.add(jPanel1,BorderLayout.CENTER);
        jPanel1.setBorder(BorderFactory.createTitledBorder("Вывод дуги: "));
        jPanel2 = new JPanel();
        jFrame.add(jPanel2,BorderLayout.SOUTH);
        //jPanel2.setBackground(Color.yellow);
        jPanel2.setBorder(BorderFactory.createTitledBorder("Параметры дуги:"));
        jPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label_x = new JLabel(" Координата Х: ");
        textField_x = new JTextField(5);
        jPanel2.add(label_x);
        jPanel2.add(textField_x);
        JLabel label_y = new JLabel(" Координата Y: ");
        textField_y = new JTextField(5);
        jPanel2.add(label_y);
        jPanel2.add(textField_y);
        JLabel label_width = new JLabel(" Ширина: ");
        textField_width = new JTextField(5);
        jPanel2.add(label_width);
        jPanel2.add(textField_width);
        JLabel label_height = new JLabel(" Высота: ");
        textField_height = new JTextField(5);
        jPanel2.add(label_height);
        jPanel2.add(textField_height);
        JLabel label_start_angle = new JLabel(" Начальный угол: ");
        textField_start_angle = new JTextField(5);
        jPanel2.add(label_start_angle);
        jPanel2.add(textField_start_angle);
        JLabel label_end_angle = new JLabel(" Конечный угол: ");
        textField_end_angle = new JTextField(5);
        jPanel2.add(label_end_angle);
        jPanel2.add(textField_end_angle);
        jButton = new JButton("Вывести дугу");
        jButton.addActionListener(this);
        jPanel2.add(jButton);
        ob = new Arc();
        jPanel1.add(ob);
        jFrame.revalidate();
    }

    /**Method for creating action for button
     * @param e - ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String width=textField_width.getText();
        String height = textField_height.getText();
        String x=textField_x.getText();;
        String y=textField_y.getText();
        String start_angle=textField_start_angle.getText();
        String end_angle=textField_end_angle.getText();
        if(width.trim().length()==0||height.trim().length()==0||x.trim().length()==0||y.trim().length()==0||start_angle.trim().length()==0||end_angle.trim().length()==0){
            System.out.println("Error input, empty text field!");
        }
        else{
            if(!height.matches("^(\\+?|-?)\\d+$")||!width.matches("^(\\+?|-?)\\d+$")||!x.matches("^(\\+?|-?)\\d+$")||!y.matches("^(\\+?|-?)\\d+$")||!start_angle.matches("^(\\+?|-?)\\d+$")||!end_angle.matches("^(\\+?|-?)\\d+$")){
                System.out.println("Error input, only integers!");
            }
            else {
                ob.setX(Integer.parseInt(x));
                ob.setY(Integer.parseInt(y));
                ob.setHeight(Integer.parseInt(height));
                ob.setWidth(Integer.parseInt(width));
                ob.setStart_angle(Integer.parseInt(start_angle));
                ob.setEnd_angle(Integer.parseInt(end_angle)-Integer.parseInt(start_angle));
                ob.repaint();
            }
        }
    }
}

/**The class for main method*/
class MainTask17{
    public static void main(String[] args) {
        new Frame17();
    }
}