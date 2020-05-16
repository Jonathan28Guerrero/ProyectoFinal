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
    
    ArrayList DestinationCountryList = new ArrayList();
    ArrayList OriginalDeparmentList = new ArrayList();
    ArrayList TransportationRouteList = new ArrayList();
    ArrayList ExportationCodeList = new ArrayList();
    
    public void Data(ArrayList Exports){
        
        for(int i = 0; i<Exports.size();i++){
            ArrayList aux = (ArrayList) Exports.get(i);
            DestinationCountryList = (ArrayList) aux.get(0);
            OriginalDeparmentList = (ArrayList) aux.get(1);
            TransportationRouteList = (ArrayList) aux.get(2);
            ExportationCodeList = (ArrayList) aux.get(3);
        } 
        
    }

   

   
    
}
