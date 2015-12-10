package pqtPluginsTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import plugins.UpperCases;

public class UpperCasesTest {
    
    UpperCases objUpperCases;
    
    @Before
    public void init() {
        objUpperCases = new UpperCases();
    }
    
    @Test
    public void StringIsInUpperCases(){
        String s1 = "abcde";
        String s2;
        
        s2 = objUpperCases.transform(s1);
        assertEquals(s2, "ABCDE");
    }
    
}
