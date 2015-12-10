package pqtGestReadWrite;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JTextArea;

/**
 *
 * @author Guillaume
 */
public class OpenFile {

    JTextArea txtAreaIHM;

    public OpenFile(JTextArea prmTxtArea) {
        txtAreaIHM = prmTxtArea;
    }
    
    /**
     * Open a file txt and write the content line after line with
     * a buffer
     * @param prmFile : the cannonical path of the file 
     */
    public void Open(String prmFile) {
        try {
            InputStream ips = new FileInputStream(prmFile);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            while ((ligne = br.readLine()) != null) {
                txtAreaIHM.setText(txtAreaIHM.getText() + ligne + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
