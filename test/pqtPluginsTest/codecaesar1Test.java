/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pqtPluginsTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import plugins.caesarCode1;

/**
 *
 * @author guillaume
 */
public class codecaesar1Test {
    
    caesarCode1 objCeasar ;
    
    @Before
    public void setUp() {
        objCeasar = new caesarCode1();
    }
    
    @Test
    public void transform(){
        String s1 = "abcd";
        String s2 = objCeasar.transform(s1);
        assertEquals(s2, "bcde");
    }
    
}
