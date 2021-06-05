# Swing
Building GUIs with Swing Tools  

Square.java:  
Displaying figures in the graphics window. The window defines a menu bar (JMenuBar) that defines
two menus (JMenu) - "Color and" Output. Four menu items (JRadioButtonMenuItem) are defined in the
"Color" menu: "Black" (default color), "Red" , Green, and Blue. The Output menu defines three menu items 
(JCheckBoxMenuItem): Square, Circle, and Triangle. The JPanel draws windows in a graphics context (using
the drawRect (), drawOval () and drawPolygon ()) three shapes: rectangle, circle and triangle. When you 
select the first menu item, all shapes are filled with the specified color. 
Commands of the second menu disable or enable the display of the corresponding shape on the screen.

RoundRect.java:  
Change the shape in the graphics window. Draw (using the drawRoundRect () method) a rounded rectangle in the center of the Render Rectangle JPanel in the graphics context. The following components are set in the lower panel (JPanel) "Rectangle Parameters": a label (JLabel) "Color:", a rotating list (JSpinner) with values: "Black" (default color), "Red", "Green" and "Blue ", caption (JLabel)" Rounding width ", text field (JTextField), caption (JLabel)" Rounding height: ", text field (JTextField) and button (JButton)" Change rectangle ". When typing data in rotary lists, entering data in text fields (in pixels) and clicking the Change Rectangle button, the rectangle is redrawn with the specified color and with the specified new values for the width and height of the roundings. Before displaying the shape, it checks to see if all data has been entered in the text boxes and whether it is integers.

Arc.java:  
Drawing a shape in the graphics window. In the top panel (JPanel) "Draw Arc" in the graphics context, an arc is drawn (using the drawArc () method). In the lower panel (JPanel) "Arc parameters" the following components are set: label (JLabel) "Coordinate X:", text field (JTextField), label (JLabel) "Coordinate Y:", text field (JTextField), label (JLabel) "Width:", text box (JTextField), label (JLabel) "Height:", text box (JTextField), label (JLabel) "Start angle:", text box (JTextField), label (JLabel) "End angle: ", a text field (JTextField) and a button (JButton)" Draw arc ". When you enter data (in pixels and in degrees - for angles) and when you click the "Draw Arc" button, the arc is redrawn with the specified parameters. During data entry, it is checked whether all data has been entered and whether the data is whole numbers. Angle values must be positive or negative integers in the range (in absolute value) from 0 to 360.

Str.java:  
Changing the inscription in the graphics window. In the center of the top panel (JPanel) "Label Display" in the graphics context (using the drawString () method) an arbitrary label is displayed. In the lower panel (JPanel) "Label parameters" the following components are set: label (JLabel) "Text:", text field (JTextField), label (JLabel) "Color:", rotating list (JSpinner) with values: "Black" ( default color), "Red", "Green" and "Blue", label (JLabel) "Size:", rotating list (JSpinner) with values "10pt", "12pt" (default size), "14pt" and "16pt", label (JLabel) "Coordinate X:", text field (JTextField), label (JLabel) "Coordinate Y:", text field (JTextField), and button (JButton) "Display string". Initially, the text boxes "X Coordinate:" and "Y Coordinate:" are set to the coordinates of the start of the baseline of the label (the text boxes are set as non-editable). As you enter data, the caption changes text, color and / or size. When you click in the area of the top panel, the coordinates of the clicked point are displayed in the text boxes, and the label is redrawn at this point.

