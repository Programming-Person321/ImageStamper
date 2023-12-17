import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Start {
	
	private static JFrame frame = new JFrame();
	private static JLabel xcomp = new JLabel("X Position (Relative to Center)");
	private static JLabel ycomp = new JLabel("Y Position (Relative to Center)");
	private static JLabel fcomp = new JLabel("Font Size");

    private static JLabel rColourComp = new JLabel("R Colour Value");
	private static JLabel gColourComp = new JLabel("G Colour Value");
	private static JLabel bColourComp = new JLabel("B Colour Value");
	private static JTextField xvalue = new JTextField("0", 10);
	private static JTextField yvalue = new JTextField("0", 10);
	private static JTextField fontSize = new JTextField("30", 10);

    private static JTextField rvalue = new JTextField("0", 10);
	private static JTextField gvalue = new JTextField("0", 10);
	private static JTextField bvalue = new JTextField("30", 10);
    private static JButton submit = new JButton("Print Images");
    
    public static int getxValue() {
    	return Integer.parseInt(xvalue.getText());
    }
    
    public static int getyValue() {
    	return Integer.parseInt(yvalue.getText());
    }
    
    public static int getFontSize() {
    	return Integer.parseInt(fontSize.getText());
    }


    public static int getRValue(){
        return Integer.parseInt(rvalue.getText());
    }
    public static int getGValue(){
        return Integer.parseInt(gvalue.getText());
    }
    public static int getBValue(){
        return Integer.parseInt(bvalue.getText());
    }

	public static void main(String[] args) {
		
		frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        frame.add(xcomp);
        frame.add(xvalue);
        frame.add(ycomp);
        frame.add(yvalue);
        frame.add(fcomp);
        frame.add(fontSize);

        frame.add(rColourComp);
        frame.add(rvalue);
        frame.add(gColourComp);
        frame.add(gvalue);
        frame.add(bColourComp);
        frame.add(bvalue);
        frame.add(submit);
        submit.addActionListener(new Processing());
        frame.setVisible(true);
	}
}