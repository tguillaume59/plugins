package pqtGestPluginsTest;

import java.io.File;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pqtGestPlugins.PluginFilter;

public class PluginFilterTest {
    
    PluginFilter objFilter;
    
    @Before
    public void init() {
        File fileTest = new File("./build/dropinsTest");
        objFilter = new PluginFilter(fileTest, ".txt");
        assertNotNull(objFilter);
    }
    
    @Test
    public void AcceptTestTrue(){
        File fileTest = new File("./build/dropinsTest");
        Boolean valRet = objFilter.accept(fileTest, "test.txt");
        assertEquals(valRet, true);
    }
    
    @Test
    public void AcceptTestFalse(){
        File fileTest = new File("./build/dropinsTest");
        Boolean valRet = objFilter.accept(fileTest, "test.png");
        assertEquals(valRet, false);
    }
    
    /*il faut un fichier txt dans le dossier dropinsTest pour valider le test*/
    @Test
    public void lookForNewFileTest(){
        File fileRetour[] = null;
        assertNull(fileRetour);
        fileRetour = objFilter.lookForNewFile();
        assertNotNull(fileRetour);
        
    }
    
}
