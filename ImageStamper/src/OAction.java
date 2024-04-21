import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class OAction implements ActionListener{

    JTextField value;

    public OAction(JTextField v){
        value = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser c = new JFileChooser();
				c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				c.setAcceptAllFileFilterUsed(false);
				c.setDialogTitle("Output Folder");
				int r = c.showOpenDialog(null);
        if(r == JFileChooser.APPROVE_OPTION) {
            String path = c.getSelectedFile().getPath();
            value.setText(path);
        }

    }
    
}
