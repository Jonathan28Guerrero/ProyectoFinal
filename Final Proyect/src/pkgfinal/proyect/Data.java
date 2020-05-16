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
        System.out.println(Exports.size());
        for(int i = 0; i<Exports.size();i++){
            ArrayList aux = (ArrayList) Exports.get(i);
            DestinationCountryList.add(aux.get(0));
            OriginalDeparmentList.add(aux.get(1));
            TransportationRouteList.add(aux.get(2));
            ExportationCodeList.add(aux.get(3));
        } 
        System.out.println(DestinationCountryList.size());
        
    }

   

   
    
}
