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
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Processing implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Base Image");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif", "bmp");
		chooser.setFileFilter(filter);
		
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			String path = chooser.getSelectedFile().getPath();
			System.out.println("Selected File: " + path);
			
			try {
				
				JFileChooser c = new JFileChooser();
				c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				c.setAcceptAllFileFilterUsed(false);
				c.setDialogTitle("Output Folder");
				int r = c.showOpenDialog(null);
				if(r == JFileChooser.APPROVE_OPTION) {
					ArrayList<String> names = new ArrayList<String>();

					JFileChooser c2 = new JFileChooser();
					c2.setDialogTitle("Text");
					FileNameExtensionFilter f2 = new FileNameExtensionFilter("text files", "txt");
					c2.setFileFilter(f2);

					int e3 = c2.showOpenDialog(null);
					if(e3 == JFileChooser.APPROVE_OPTION) {
						Scanner scam = new Scanner(new File(c2.getSelectedFile().getPath()));
						while(scam.hasNextLine()) {
							String line = scam.nextLine();
							names.add(line);
						}
						
						JFileChooser c4 = new JFileChooser();
						FileNameExtensionFilter f4 = new FileNameExtensionFilter("font files", "ttf");
						c4.setDialogTitle("Font");
						c4.setFileFilter(f4);

						int e4 = c4.showOpenDialog(null);
						if(e4 == JFileChooser.APPROVE_OPTION) {
							
							InputStream myStream = new BufferedInputStream(new FileInputStream(c4.getSelectedFile().getPath()));
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
								
								
								g.setColor(new Color(Start.getRValue(), Start.getBValue(), Start.getGValue()));
								g.setFont(font); 
								g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
								
								Rectangle rect = new Rectangle(0, 0, i.getWidth(null), i.getHeight(null));
							    FontMetrics metrics = g.getFontMetrics(font);
							    int x = rect.x + (rect.width - metrics.stringWidth(names.get(in))) / 2;
							    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
							    g.setFont(font);	    
								g.drawString(names.get(in), x+Start.getxValue(), y+Start.getyValue());
								
								File file = new File(c.getSelectedFile().getPath() + "//" + names.get(in) + ".png");
								ImageIO.write(image, "png", file);
							}
						}
					}
				}
				
				System.out.println("Status: Done");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
