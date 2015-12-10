/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pqtPluginsTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import plugins.caesarCode13;

/**
 *
 * @author guillaume
 */
public class codeCaesar13Test {
    
    caesarCode13 objCaesar;
    
    @Before
    public void setUp() {
        objCaesar = new caesarCode13();
    }
    
    @Test
    public void transform(){
        String s1 = "abcd";
        String s2 = objCaesar.transform(s1);
        assertEquals(s2, "nopq");
    }
    
}
