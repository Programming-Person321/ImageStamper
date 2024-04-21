import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

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

    private static JPanel mainPanel = new JPanel(new GridBagLayout());

    private static JLabel icomp = new JLabel("Base Image:");
    private static JTextField ivalue = new JTextField("Please Choose a Path", 25);
    private static JLabel ocomp = new JLabel("Output Folder:");
    private static JTextField ovalue = new JTextField("Please Choose a Path", 25);
    private static JLabel ncomp = new JLabel("Names List:");
    private static JTextField nvalue = new JTextField("Please Choose a Path", 25);
    private static JLabel pcomp = new JLabel("Font File:");
    private static JTextField pvalue = new JTextField("Please Choose a Path", 25);

    private static JButton ichoose = new JButton("choose");
    private static JButton ochoose = new JButton("choose");
    private static JButton nchoose = new JButton("choose");
    private static JButton pchoose = new JButton("choose");
    
    public static int getxValue() {
    	return Integer.parseInt(xvalue.getText());
    }
    public static int getyValue() {
    	return Integer.parseInt(yvalue.getText());
    }
    public static int getFontSize() {
    	return Integer.parseInt(fontSize.getText());
    }
    public static String getImagePath() {
    	return ivalue.getText();
    }
    public static String getOutputPath() {
    	return ovalue.getText();
    }
    public static String getNamesPath() {
    	return nvalue.getText();
    }
    public static String getFontPath() {
    	return pvalue.getText();
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

        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception e) {}
		
		frame.setSize(850, 350);
        frame.setMinimumSize(new Dimension(850, 350));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel, BorderLayout.CENTER);

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(10, 10, 10, 10);


        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(xcomp, c);
        c.gridy = 1;
        mainPanel.add(ycomp, c);
        c.gridy = 2;
        mainPanel.add(fcomp, c);

        c.gridy = 3;
        mainPanel.add(rColourComp, c);
        c.gridy = 4;
        mainPanel.add(gColourComp, c);
        c.gridy = 5;
        mainPanel.add(bColourComp, c);



        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(xvalue, c);
        c.gridy = 1;
        mainPanel.add(yvalue, c);
        c.gridy = 2;
        mainPanel.add(fontSize, c);

        c.gridy = 3;
        mainPanel.add(rvalue, c);
        c.gridy = 4;
        mainPanel.add(gvalue, c);
        c.gridy = 5;
        mainPanel.add(bvalue, c);


        c.gridx = 2;
        c.gridy = 0;
        mainPanel.add(icomp, c);
        c.gridy = 1;
        mainPanel.add(ocomp, c);
        c.gridy = 2;
        mainPanel.add(ncomp, c);
        c.gridy = 3;
        mainPanel.add(pcomp, c);

        c.gridx = 3;
        c.gridy = 0;
        mainPanel.add(ivalue, c);
        c.gridy = 1;
        mainPanel.add(ovalue, c);
        c.gridy = 2;
        mainPanel.add(nvalue, c);
        c.gridy = 3;
        mainPanel.add(pvalue, c);

        c.gridx = 4;
        c.gridy = 0;
        mainPanel.add(ichoose, c);
        c.gridy = 1;
        mainPanel.add(ochoose, c);
        c.gridy = 2;
        mainPanel.add(nchoose, c);
        c.gridy = 3;
        mainPanel.add(pchoose, c);

        ichoose.addActionListener(new IAction(ivalue));
        ochoose.addActionListener(new OAction(ovalue));
        nchoose.addActionListener(new NAction(nvalue));
        pchoose.addActionListener(new FAction(pvalue));


        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 3;
        c.gridheight = 2;
        c.fill = GridBagConstraints.BOTH;
        mainPanel.add(submit, c);



        submit.addActionListener(new Processing());
        frame.setVisible(true);
	}
}