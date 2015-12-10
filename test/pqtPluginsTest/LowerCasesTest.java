package pqtPluginsTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import plugins.LowerCases;
public class LowerCasesTest {
    
    LowerCases objLowerCase;
    
    @Before
    public void init() {
        objLowerCase = new LowerCases();
    }
    
    @Test
    public void stringIsInLowerCases(){
        String s1 = "ABCDE";
        String s2;
        s2 = objLowerCase.transform(s1);
        assertEquals(s2, "abcde");
    }
    
}
