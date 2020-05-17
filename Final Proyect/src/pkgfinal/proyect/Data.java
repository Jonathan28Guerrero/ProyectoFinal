/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.proyect;

import java.util.ArrayList;

/**
 *
 * @author daniela
 */
public class Data {
    
    
    ArrayList DataList = new ArrayList();
    ArrayList FilteredData = new ArrayList();
    
    public void Data(ArrayList Births){
        DataList = Births;
        FilteredData = Births;
    }
    

}
