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
    
    ArrayList DepartmentList = new ArrayList();
    ArrayList BirthSiteList = new ArrayList();
    ArrayList MonthList = new ArrayList();
    ArrayList SexList = new ArrayList();
    
    public void Data(ArrayList Exports){
        System.out.println(Exports.size());
        for(int i = 0; i<Exports.size();i++){
            ArrayList aux = (ArrayList) Exports.get(i);
            DepartmentList.add(aux.get(0));
            BirthSiteList.add(aux.get(1));
            MonthList.add(aux.get(2));
            SexList.add(aux.get(3));
        } 
        
    }

   

   
    
}
