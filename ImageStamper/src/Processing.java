import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Processing implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {

			String path = Start.getImagePath();
			System.out.println("Selected File: " + path);
			
			try {
				

					ArrayList<String> names = new ArrayList<String>();


						Scanner scam = new Scanner(new File(Start.getNamesPath()));
						while(scam.hasNextLine()) {
							String line = scam.nextLine();
							names.add(line);
						}
							
							InputStream myStream = new BufferedInputStream(new FileInputStream(Start.getFontPath()));
			                Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
			                Font font = ttfBase.deriveFont(Font.PLAIN, Start.getFontSize());
			                
			                
			                
						
							System.out.println("Status: Starting");
							for(int in = 0; in < names.size(); in++) {
								System.out.println("Printing: " + names.get(in));
								
								Image i = ImageIO.read(new File(path));
								BufferedImage image = null;
								
								image = new BufferedImage(i.getWidth(null), i.getHeight(null), BufferedImage.TYPE_INT_ARGB);
								Graphics2D g = image.createGraphics();
								RenderingHints rh = new RenderingHints(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
								g.setRenderingHints(rh);
								g.drawImage(i, 0, 0, i.getWidth(null), i.getHeight(null), null);
								
								
								g.setColor(new Color(Start.getRValue(), Start.getGValue(), Start.getBValue()));
								g.setFont(font); 
								g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
								
								Rectangle rect = new Rectangle(0, 0, i.getWidth(null), i.getHeight(null));
							    FontMetrics metrics = g.getFontMetrics(font);
							    int x = rect.x + (rect.width - metrics.stringWidth(names.get(in))) / 2;
							    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
							    g.setFont(font);	    
								g.drawString(names.get(in), x+Start.getxValue(), y+Start.getyValue());
								
								File file = new File(Start.getOutputPath() + "//" + names.get(in) + ".png");
								ImageIO.write(image, "png", file);
							}
						

						scam.close();
					
				
				
				System.out.println("Status: Done");
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane error = new JOptionPane(e.getMessage());
				JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
			}

}
}