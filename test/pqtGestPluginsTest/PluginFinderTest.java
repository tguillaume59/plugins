package pqtGestPluginsTest;

import apple.laf.JRSUIConstants;
import java.io.File;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pqtGestPlugins.PluginFinder;

public class PluginFinderTest {
    
    PluginFinder objFinder;
    
    @Before
    public void init() {
        objFinder = new PluginFinder("./build/dropinsTest", ".txt", new JMenu(), new JTextArea());
        assertNotNull(objFinder);
    }
    
    @Test
    public void substringFileNameTest(){
        File test = new File("fichier.txt");
        String retour = objFinder.substringFileName(test);
        assertEquals("fichier", retour);
    }
    
    @Test
    public void addMenuTest(){
        File fTest = new File("LowerCases.txt");
        assertEquals(objFinder.menu.getComponentCount(),0);
        objFinder.AddMenu(fTest);
        int count = objFinder.menu.getMenuComponentCount();
        assertEquals(count, 1);
    }
    
    @Test
    public void deleteMenuTest(){
        int count = 0;
        File fTest = new File("LowerCases.txt");
        objFinder.AddMenu(fTest);
        count = objFinder.menu.getMenuComponentCount();
        assertEquals(count, 1);
        
        objFinder.deleteMenu(fTest);
        count = objFinder.menu.getMenuComponentCount();
        assertEquals(count, 1);
        
    }
    
    @Test
    public void LookForNewPlugIntest(){
        
    }
    
    @Test
    public void LookForDeletingPlugIn(){
        
    }
    
}
