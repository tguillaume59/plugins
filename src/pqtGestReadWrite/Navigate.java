package pqtGestReadWrite;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Guillaume Floran Axel 
 */
public class Navigate {

    public Navigate() {
    }
    
    /**
     * This method is for found a file with an OpenDialog
     * @return the cannonical path of this file
     * @throws IOException 
     */
    public String NavigateInFinderCannonical() throws IOException {
        String cannonicalPath="";
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.FILES_ONLY) {
            cannonicalPath = chooser.getSelectedFile().getCanonicalPath();
        }
        return cannonicalPath;
    }
    /**
     * this method open a save dialog for user writte the name of file that he want
     * and after open a savedialog for the user can choose where he want save is file
     * @return the canonical path : path + file name + extension txt
     * @throws IOException 
     */
    public String NavigateInFinderDirectory() throws IOException {
        String path="";
        String filename = showDialogForNamingFile();
        if(filename != null){
            JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File fileLu = chooser.getCurrentDirectory();
                path = fileLu.getPath() + "/" + filename + ".txt";
            }
        }
        return path;
    }
    
    public String showDialogForNamingFile(){
       String filename = JOptionPane.showInputDialog("Donnez un nom a votre fichier");
       return filename;
    }
    
    
}
