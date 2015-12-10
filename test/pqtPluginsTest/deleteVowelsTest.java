package pqtPluginsTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import plugins.deleteVowels;

/**
 *
 * @author guillaume
 */
public class deleteVowelsTest {

    deleteVowels objDelete;
    
    @Before
    public void init() {
        objDelete = new deleteVowels();
    }
    
    @Test
    public void StringIsWithoutVowels(){
        String s1 = "aBAeCEyHYuFUiKIoLO";
        String s2;
        
        s2 = objDelete.transform(s1);
        assertEquals(s2,"BCHFKL");
    }
    
}
