package pqtGestReadWrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Guillaume 
 */
public class SaveFile {
    /**
     * the name of the file when it was save by the user
     */
    String fileName;
    String filePath;
    String cannonicalPath;

    /**
     * constructor without parameter
     * initialyse file name with empty string
     */
    public SaveFile() {
        fileName = "";
        filePath = "";
        cannonicalPath = "";
        
    }
    

    /**
     * Save the file in the default directory
     * @param prmContent the content of the TextArea 
     * @param prmCannonicalPath the cannonical pathof the file we save
     */
    public void save(String prmContent, String prmCannonicalPath) {
        BufferedWriter out =null;
        try {
            // Create file
            FileWriter fstream = new FileWriter(prmCannonicalPath);
            out = new BufferedWriter(fstream);
            out.write(prmContent);
            out.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
