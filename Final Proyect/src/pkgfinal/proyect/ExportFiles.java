/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.proyect;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class ExportFiles {
    public void ExportFile(ArrayList DataList) throws IOException{
        JFileChooser SelectFile = new JFileChooser();
        int Result = SelectFile.showOpenDialog(null);
        File FileSelected = SelectFile.getSelectedFile();
        try (FileWriter FW = new FileWriter(FileSelected.getPath()+".csv")) {
            for(int i=0; i<DataList.size(); i++){
                ArrayList Row = (ArrayList) DataList.get(i);
                for(int j=0; j<Row.size(); j++){
                    FW.append(Row.get(j)+"");
                    if(j!=(Row.size()-1))
                        FW.append(";");
                }
                FW.append("\n");
            }
            FW.flush();
            FW.close();
        }
    }
    public void ExportImage(JPanel Panel){
        BufferedImage imagen = new BufferedImage(750, 400, BufferedImage.TYPE_INT_ARGB);
        Panel.paint(imagen.getGraphics());
        JFileChooser SelectPath = new JFileChooser();
        int Result = SelectPath.showOpenDialog(null);
        File PathSelected = SelectPath.getSelectedFile();
        String path = PathSelected.getPath() + ".png";
        
        try {
            ImageIO.write(imagen, "png", new File(path));        // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(PrincipalInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
