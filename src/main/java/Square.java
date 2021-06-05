/*7.Вывод фигур в графическом окне. В окне определена строка меню
 (JMenuBar), в которой определены два меню (JMenu) – "Цвет и "Вывод".
 В меню "Цвет" определены четыре пункта меню (JRadioButtonMenuItem):
 Черный" (цвет по умолчанию),  "Красный", "Зеленый" и "Синий".  В
 меню "Вывод" определены три пункта меню (JCheckBoxMenuItem): "Квадрат",
 Круг",  и "Треугольник". В панели (JPanel) окна выводятся в графическом
 контексте (с помощью методов drawRect(), drawOval() и drawPolygon()) три
 фигуры: прямоугольник, круг и треугольник. При выборе пункта первого
 меню все фигуры заполняются заданным цветом. Команды второго меню отключают
 или включают вывод соответствующей фигуры на экран.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * The class is used to store information about geometry object: square and paint it
 * * <b>color</b>,<b>fill</b>.
 * * @author Dudchenko Liudmila
 */

public class Square extends JComponent{
    /**Color*/
    private Color color;
    /**Fill*/
    private boolean fill = false;

    /** Function for painting square
     * @param g - Graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawRect(30,50,100,100);
        if(fill==true) {
            g.fillRect(30, 50, 100, 100);
        }
    }

    /** Function for setting value of field {@link Square#color}
     */
    void setColor(Color color){
        this.color = color;
    }
    /** Function for getting value of field {@link Square#color}
     * @return It returns color of square
     */
    public Color getColor() {
        return color;
    }
    /** Function for setting value of field {@link Square#fill}
     */
    public boolean isFill() {
        return fill;
    }
    /** Function for getting value of field {@link Square#fill}
     */
    public void setFill(boolean fill) {
        this.fill = fill;
    }
}

/**
 * The class is used to store information about geometry object: Oval and paint it
 * * <b>color</b>,<b>fill</b>.
 * * @author Dudchenko Liudmila
 */

class Oval extends JComponent{
    /**Color*/
    private Color color;
    /**Fill*/
    private boolean fill = false;

    /** Function for painting oval
     * @param g - Graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawOval(30,50,100,100);
        if(fill==true) {
            g.fillOval(30, 50, 100, 100);
        }
    }

    /** Function for setting value of field {@link Oval#color}
     */
    void setColor(Color color){
        this.color = color;
    }

    /** Function for getting value of field {@link Oval#color}
     * @return It returns color of oval
     */
    public Color getColor() {
        return color;
    }
    /** Function for getting value of field {@link Oval#fill}
     * @return It returns whether oval is filled with color or not
     */
    public boolean isFill() {
        return fill;
    }
    /** Function for setting value of field {@link Oval#fill}
     */
    public void setFill(boolean fill) {
        this.fill = fill;
    }
}

/**
 * The class is used to store information about geometry object: square and paint it
 * * <b>color</b>,<b>fill</b>.
 * * @author Dudchenko Liudmila
 */
class Triangle extends JComponent{
    /**Color*/
    private Color color;
    /**Fill*/
    private boolean fill = false;

    /** Function for painting triangle
     * @param g - Graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        int[] x ={30,80,130};
        int[] y = {150,50,150};
        g.drawPolygon(x,y,3);
        if(fill == true) {
            g.fillPolygon(x, y, 3);
        }
    }

    /** Function for setting value of field {@link Triangle#color}
     */
    void setColor(Color color){
        this.color = color;
    }

    /** Function for getting value of field {@link Triangle#color}
     * @return color of oval
     */
    public Color getColor() {
        return color;
    }

    /** Function for getting value of field {@link Triangle#fill}
     * @return It returns whether oval is filled with color or not
     */
    public boolean isFill() {
        return fill;
    }

    /** Function for setting value of field {@link Triangle#fill}
     */
    public void setFill(boolean fill) {
        this.fill = fill;
    }
}

/**
 * The class is used to store information about frame and create it
 * * <b>frame</b>,<b>jPanel</b>,<b>jMenuBar</b>,<b>color</b>,<b>output</b>,<b>jRadioButtonMenuItemBlack</b>,
 * <b>jRadioButtonMenuItemRed</b>,<b>jRadioButtonMenuItemGreen</b>,<b>jRadioButtonMenuItemBlue</b>,<b>buttonGroup</b>,
 * <b>jCheckBoxMenuItemRect</b>,<b>jCheckBoxMenuItemOval</b>,<b>jCheckBoxMenuItemTriangle</b>,
 * <b>obs</b>,<b>obt</b>,<b>obo</b>,
 * * @author Dudchenko Liudmila
 */
class Frame7 extends JFrame implements ActionListener, ItemListener {
    /**Frame*/
    JFrame frame;
    /**Panel*/
    JPanel jPanel;
    /**MenuBar*/
    JMenuBar jMenuBar;
    /**Menu color*/
    JMenu color;
    /**Menu output*/
    JMenu output;
    /**RadioButton for black color*/
    JRadioButtonMenuItem jRadioButtonMenuItemBlack;
    /**RadioButton for red color*/
    JRadioButtonMenuItem jRadioButtonMenuItemRed;
    /**RadioButton for green color*/
    JRadioButtonMenuItem jRadioButtonMenuItemGreen;
    /**RadioButton for blue color*/
    JRadioButtonMenuItem jRadioButtonMenuItemBlue;
    /**Button Group for radiobuttons*/
    ButtonGroup buttonGroup;
    /**CheckBox for rectangle*/
    JCheckBoxMenuItem jCheckBoxMenuItemRect;
    /**CheckBox for Oval*/
    JCheckBoxMenuItem jCheckBoxMenuItemOval;
    /**Checkbox for Triangle*/
    JCheckBoxMenuItem jCheckBoxMenuItemTriangle;
    /**Square object*/
    Square obs;
    Square obs2;
    /**Triangle object*/
    Triangle obt;
    /**Oval object*/
    Oval obo;

    /** It creates a new empty object of frame with all components
     *@see Frame7#Frame7()
     */
    Frame7() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2-250, dimension.height/2-150,500,300);
        frame.setTitle("Task 7");

        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1,0));
        frame.add(jPanel);

        jMenuBar = new JMenuBar();
        color = new JMenu("Цвет");
        output = new JMenu("Вывод");

        jMenuBar.add(color);
        jMenuBar.add(output);

        jRadioButtonMenuItemBlack = new JRadioButtonMenuItem("Чёрный");
        jRadioButtonMenuItemRed = new JRadioButtonMenuItem("Красный");
        jRadioButtonMenuItemGreen = new JRadioButtonMenuItem("Зелёный");
        jRadioButtonMenuItemBlue = new JRadioButtonMenuItem("Синий");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButtonMenuItemBlack);
        buttonGroup.add(jRadioButtonMenuItemRed);
        buttonGroup.add(jRadioButtonMenuItemGreen);
        buttonGroup.add(jRadioButtonMenuItemBlue);

        color.add(jRadioButtonMenuItemBlack);
        color.add(jRadioButtonMenuItemRed);
        color.add(jRadioButtonMenuItemGreen);
        color.add(jRadioButtonMenuItemBlue);

        jCheckBoxMenuItemRect = new JCheckBoxMenuItem("Квадрат");
        jCheckBoxMenuItemOval = new JCheckBoxMenuItem("Круг");
        jCheckBoxMenuItemTriangle = new JCheckBoxMenuItem("Треугольник");

        output.add(jCheckBoxMenuItemRect);
        output.add(jCheckBoxMenuItemOval);
        output.add(jCheckBoxMenuItemTriangle);

        jCheckBoxMenuItemOval.setState(true);
        jCheckBoxMenuItemRect.setState(true);
        jCheckBoxMenuItemTriangle.setState(true);

        jRadioButtonMenuItemBlack.setSelected(true);

        jRadioButtonMenuItemBlack.addActionListener(this);
        jRadioButtonMenuItemBlue.addActionListener(this);
        jRadioButtonMenuItemRed.addActionListener(this);
        jRadioButtonMenuItemGreen.addActionListener(this);

        jCheckBoxMenuItemRect.addItemListener(this);
        jCheckBoxMenuItemOval.addItemListener(this);
        jCheckBoxMenuItemTriangle.addItemListener(this);

        frame.setJMenuBar(jMenuBar);
        obs = new Square();
        obt = new Triangle();
        obo = new Oval();

        jPanel.add(obs);
        jPanel.add(obt);
        jPanel.add(obo);

        frame.revalidate();

    }

    /**Method for creating action for button
     * @param e - ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        obs.setFill(true);
        obt.setFill(true);
        obo.setFill(true);
        if(jRadioButtonMenuItemBlack.isSelected()){
            obs.setColor(Color.BLACK);
            obt.setColor(Color.BLACK);
            obo.setColor(Color.BLACK);
        }
        else if(jRadioButtonMenuItemRed.isSelected()){
            obs.setColor(Color.RED);
            obt.setColor(Color.RED);
            obo.setColor(Color.RED);
        }
        else if(jRadioButtonMenuItemBlue.isSelected()){
            obs.setColor(Color.BLUE);
            obt.setColor(Color.BLUE);
            obo.setColor(Color.BLUE);
        }
        else{
            obs.setColor(Color.GREEN);
            obt.setColor(Color.GREEN);
            obo.setColor(Color.GREEN);
        }
        obs.repaint();
        obt.repaint();
        obo.repaint();
    }

    /**Function for creating action for checkboxes
     * @param e - ActionEvent object
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(jCheckBoxMenuItemRect.isSelected()){
            obs.setVisible(true);
        }
        else{
            obs.setVisible(false);
        }
        if(jCheckBoxMenuItemTriangle.isSelected()){
            obt.setVisible(true);
        }
        else{
            obt.setVisible(false);
        }
        if(jCheckBoxMenuItemOval.isSelected()){
            obo.setVisible(true);
        }
        else{
            obo.setVisible(false);
        }
    }

}

/**The class for main method*/
class MainTask7 {
    public static void main(String[] args) {
        new Frame7();
    }
}


