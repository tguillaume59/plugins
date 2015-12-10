package pqtGestPlugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import plugins.Plugin;

/**
 *
 * @author Guillaume Floran Axel
 */
public class PluginFinder {

    PluginFilter objFilter;
    public JMenu menu;
    JTextArea objTextArea;
    ArrayList<File> listFiles;

    public PluginFinder(String prmDir, String prmExtension, JMenu prmMenu, JTextArea prmTextArea) {
        menu = prmMenu;
        listFiles = new ArrayList<>();
        objFilter = new PluginFilter(new File(prmDir), prmExtension);
        objTextArea = prmTextArea;
    }

    /**
     * This function was call by the timer every second to found if new plugin
     * was add in the directory.
     */
    public void LookForNewPlugIn() {
        boolean inListPlugIn;
        //devrait retourner la list des files trouvés
        File[] filesRecu = objFilter.lookForNewFile();
        //analiser si un nouveau pluggin a été ajouté
        for (File f : filesRecu) {
            inListPlugIn = false;
            for (int i = 0; i < listFiles.size(); i++) {
                if (!listFiles.isEmpty()) {
                    File filelu = listFiles.get(i);
                    if (filelu.getName().equals(f.getName())) {
                        inListPlugIn = true;
                    }
                }

            }
            if (inListPlugIn == false) {
                listFiles.add(f);
                AddMenu(f);
                System.out.println("new file found : " + f.getName());
            }
        }

    }

    /**
     * This method look in the directory if a plugin in the list is again in the
     * directory. If it isn't yet, we delete this in the list and in the menu
     */
    public void LookForDeletingPlugIn() {
        boolean inListPlugIn;
        // retourne la list des files trouvés
        File[] filesRecu = objFilter.lookForNewFile();
        //analise si un nouveau pluggin a été ajouté
        ArrayList<File> listTmp = new ArrayList<>();

        for (File f : listFiles) {
            inListPlugIn = false;

            for (int i = 0; i < filesRecu.length; i++) {
                if (filesRecu.length != 0) {
                    File filelu = filesRecu[i];

                    if (filelu.getName().equals(f.getName())) {
                        inListPlugIn = true;
                    }
                }
            }

            if (inListPlugIn == false) {
                System.out.println("file deleted found : " + f.getName());
                //erreur exception ici
                listTmp.add(f);
                deleteMenu(f);
            }
        }

        listFiles.removeAll(listTmp);
    }

    /**
     * add a new item in the menu with the new plugin found
     *
     * @param prmFile
     */
    public void AddMenu(File prmFile) {
        String lblMenu = substringFileName(prmFile);

        // Récupération du nom du plugin
        Class<? extends Plugin> itemClass;
        Plugin objectPlugin;
        try {
            //verifier que ca hérite bien de pluggin

            //si oui
            itemClass = (Class<? extends Plugin>) Class.forName("plugins." + lblMenu);
            /*pour verifier l'heredité*/
            /*if (itemClass.isAssignableFrom("plugins".getClass())) {*/
                objectPlugin = itemClass.newInstance();

                //créer un item et l'ajouter
                JMenuItem item;
                item = new JMenuItem(objectPlugin.getLabel());
                menu.add(item);

                item.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        objTextArea.setText(objectPlugin.transform(objTextArea.getText()));
                    }
                });
            /*}*/
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(PluginFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteMenu(File prmFile) {
        String nameFile = substringFileName(prmFile);
        String tmpTest;
        JMenuItem jmenuItem;

        for (int i = 0; i < menu.getItemCount(); i++) {
            jmenuItem = menu.getItem(i);
            tmpTest = jmenuItem.getText();
            if (nameFile.equals(tmpTest)) {
                menu.remove(i);
            }
        }
    }

    public String substringFileName(File prmFile) {
        char caract = 'a';
        int i = 0;

        while (caract != '.') {
            caract = prmFile.getName().charAt(i);
            i++;
        }

        return prmFile.getName().substring(0, i - 1);
    }
}
