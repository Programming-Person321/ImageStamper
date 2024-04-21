import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FAction implements ActionListener{

    JTextField value;

    public FAction(JTextField v){
        value = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser c4 = new JFileChooser();
        FileNameExtensionFilter f4 = new FileNameExtensionFilter("font files", "ttf");
        c4.setDialogTitle("Font");
        c4.setFileFilter(f4);

        int e4 = c4.showOpenDialog(null);
        if(e4 == JFileChooser.APPROVE_OPTION) {
            String path = c4.getSelectedFile().getPath();
            value.setText(path);
        }

    }
    
}
