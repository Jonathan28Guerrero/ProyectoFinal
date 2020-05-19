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
public class FilterData {
    
    public ArrayList Month(int i,ArrayList DataList){
        String selection;
        if(i>=0 && i<=9)
            selection = "0"+i;
        else
            selection = ""+i;
        int column = 0;
        if(!"00".equals(selection))
            return Filter(selection,column,DataList);
        else
            return DataList;
    }
    
    public ArrayList Deparment(int i,ArrayList DataList){
    
        String selection = "0";
        
        int column = 1;
        switch(i) {
                case 0:
                     break;
                case 1:
                    selection = "05";
                    break;
                 case 2:
                    selection = "08";
                    break;
                case 3:
                    selection = "11";
                    break;
                case 4:
                    selection = "13";
                    break;
                 case 5:
                    selection = "15";
                    break;
                case 6:
                    selection = "17";
                    break;
                case 7:
                    selection = "18";
                    break;
                 case 8:
                    selection = "19";
                    break;
                case 9:
                    selection = "20";
                    break;
                case 10:
                    selection = "23";
                    break;
                 case 11:
                    selection = "25";
                    break;
                case 12:
                    selection = "27";
                    break;
                case 13:
                    selection = "41";
                    break;
                 case 14:
                    selection = "44";
                    break;
                case 15:
                    selection = "47";
                    break;
                case 16:
                    selection = "50";
                    break;
                case 17:
                    selection = "52";
                    break;
                case 18:
                    selection = "54";
                    break;
                case 19:
                    selection = "63";
                    break;
                 case 20:
                    selection = "66";
                    break;
                case 21:
                    selection = "68";
                    break;
                case 22:
                    selection = "70";
                    break;
                 case 23:
                    selection = "73";
                    break;
                case 24:
                    selection = "76";
                    break;
                case 25:
                    selection = "81";
                    break;
                case 26:
                    selection = "85";
                    break;
                case 27:
                    selection = "86";
                    break;
                 case 28:
                    selection = "88";
                    break;
                case 29:
                    selection = "91";
                    break;
                case 30:
                    selection = "94";
                    break;
                 case 31:
                    selection = "95";
                    break;
                case 32:
                    selection = "97";
                    break;
                case 33:
                    selection = "99";
                    break;
        }
        if(!"0".equals(selection))
            return Filter(selection,column,DataList);
        else
            return DataList;
    }
    
    public ArrayList BirthPlace(int i,ArrayList DataList){
    
        String selection = "0";
        int column = 2;
        switch(i) {
                case 0:
                     break;
                case 1:
                    selection = "1";
                    break;
                 case 2:
                    selection = "2";
                    break;
                case 3:
                    selection = "3";
                    break;
                case 4:
                    selection = "9";
                    break;
        }
        if(!"0".equals(selection))
            return Filter(selection,column,DataList);
        else
            return DataList;
    }
    
    public ArrayList Sex(int i,ArrayList DataList){
        String selection = ""+i;
        int column = 3;
        if(!"0".equals(selection))
            return Filter(selection,column,DataList);
        else
            return DataList;
    }
    
    public ArrayList Filter(String selection, int column, ArrayList DataList){
        ArrayList Aux1 = new ArrayList();
        for(int i = 0;i< DataList.size();i++){
            ArrayList Aux2 = (ArrayList) DataList.get(i);
            if(Aux2.get(column).equals(selection))
                Aux1.add(Aux2);
        }
        return Aux1;
    }
}
