package pqtGestPlugins;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Guillaume Florian Axel
 */
public class PluginFilter implements FilenameFilter {

    File directory;
    String extension;

    public PluginFilter(File prmDir, String prmExtension) {
        directory = prmDir;
        extension = prmExtension;
    }
    /**
     * Test if the file in parameter is compatible with the extention found
     * @param dir the path where is the test's file
     * @param name the name of the file
     * @return True or False , true if file is accept
     */
    @Override
    public boolean accept(File dir, String name) {
        boolean valRetour = false;

        String lowercaseName = name.toLowerCase();
        if (lowercaseName.endsWith(extension)) {
            valRetour = true;
        }
        return valRetour;
    }
    /**
     * Search in the path given by constructor if there are file with the 
     * good extension
     * @return a vector of files with the compatibles files
     */
    public File[] lookForNewFile() {
        FilenameFilter textFilter = new PluginFilter(directory, extension);
        File[] files = directory.listFiles(textFilter);
        /*for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("directory:");
            } else {
                System.out.print("     file:");
            }
            try{
                System.out.println(file.getCanonicalPath());
            }catch( Exception e ){
                
            }
        }*/
        return files;
    }

}
