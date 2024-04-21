import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NAction implements ActionListener{

    JTextField value;

    public NAction(JTextField v){
        value = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser c2 = new JFileChooser();
        c2.setDialogTitle("Text");
        FileNameExtensionFilter f2 = new FileNameExtensionFilter("text files", "txt");
        c2.setFileFilter(f2);

        int e3 = c2.showOpenDialog(null);
        if(e3 == JFileChooser.APPROVE_OPTION) {
            String path = c2.getSelectedFile().getPath();
            value.setText(path);
        }

    }
    
}
