/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.proyect;

import java.util.ArrayList;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.TableOrder;

/**
 *
 * @author daniela
 */
public class Graphics {
    public JFreeChart DoGraphic(int Tipe,int column,ArrayList Data,boolean BirthsDead){
        String xname = "Grafico";
        if (column==0)xname = "Meses";
        if (column==1)xname = "Departamentos";
        if (column==2)xname = "Sitios";
        if (column==3)xname = "Sexo";
        if(Tipe == 1){
            JFreeChart chart = ChartFactory.createAreaChart(xname, xname, "Cantidad", SelectDataPie(Data,column,BirthsDead));
            return (chart); 
        }
        else if(Tipe == 2){
            JFreeChart chart = ChartFactory.createBarChart3D(xname, xname, "Cantidad", SelectDataPie(Data,column,BirthsDead));
            return (chart);
        }
        if(Tipe == 3){
            JFreeChart chart;
            chart = ChartFactory.createStackedAreaChart(xname, xname, "Cantidad", SelectDataPie(Data,column,BirthsDead));
            return (chart);
        }
        return null;
    }
    public DefaultCategoryDataset SelectDataPie(ArrayList Data, int aux, boolean BirthsDead){
        
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        switch(aux){
                case 0 :
                    dataSet = Months(Data) ;
                    break;
                case 1:
                    dataSet = Departments(Data) ;
                    break;
                case 2:
                    if (BirthsDead == true)dataSet = Places(Data) ;
                    else dataSet = Places1(Data) ;
                    break;
                case 3:
                    dataSet = Sex(Data) ;
                    break;
        }
        return dataSet;
        
    }
    public  DefaultCategoryDataset Months(ArrayList Datos_meses){
        int enero = 0, febrero = 0,marzo = 0,abril= 0,mayo= 0,junio= 0,julio= 0,agosto= 0,septiembre= 0,octubre= 0,noviembre= 0,diciembre= 0; 
       DefaultCategoryDataset maindataset = new DefaultCategoryDataset();
       for(int i=0;i<Datos_meses.size();i++){
           ArrayList aux = (ArrayList) Datos_meses.get(i);   
           String datos = String.valueOf(aux.get(0));
           int NewDates = Integer.parseInt(datos);
           if (NewDates == 01)enero++;  
           if (NewDates == 02)febrero++;
           if (NewDates == 03)marzo++;
           if (NewDates == 04)abril++;
           if (NewDates == 05)mayo++;
           if (NewDates == 06)junio++;
           if (NewDates == 07)julio++;
           if (NewDates == 8)agosto++;
           if (NewDates == 9)septiembre++;
           if (NewDates == 10)octubre++;
           if (NewDates == 11)noviembre++;
           if (NewDates == 12)diciembre++;
       }
       maindataset.setValue(enero , String.valueOf(enero), "enero");
       maindataset.setValue(febrero , String.valueOf(febrero), "febrero");
       maindataset.setValue(marzo , String.valueOf(marzo), "marzo");
       maindataset.setValue(abril , String.valueOf(abril), "abril");
       maindataset.setValue(mayo , String.valueOf(mayo), "mayo");
       maindataset.setValue(junio , String.valueOf(junio), "junio");
       maindataset.setValue(julio , String.valueOf(julio), "julio");
       maindataset.setValue(agosto , String.valueOf(agosto), "agosto");
       maindataset.setValue(septiembre, String.valueOf(septiembre), "septiembre");
       maindataset.setValue(octubre, String.valueOf(octubre), "octubre");
       maindataset.setValue(noviembre , String.valueOf(noviembre), "noviembre");
       maindataset.setValue(diciembre , String.valueOf(diciembre), "diciembre");
        return maindataset;
    }
    public  DefaultCategoryDataset Departments(ArrayList Datos_dep){
         int antioquia = 0,atlantico = 0,barranquilla=0,bogota=0,bolivar=0,boyaca=0,calda=0,
        caqueta=0,cauca=0,cesar=0,cordova=0,cundinamarca=0,choco=0,
        huila=0,guajira=0,magdalena=0,meta=0,nariño=0,nortsant=0,
        quindio=0,risaralda=0,santander=0,sucre=0,tolima=0,
        valle=0,arauca=0,casanare=0,putumayo=0,sanandres=0,
        amazonas=0,guainia=0,guaviare=0,vaupes=0,vichada=0;
         
            DefaultCategoryDataset maindataset = new DefaultCategoryDataset();
            
            for(int i=0;i<Datos_dep.size();i++){
            ArrayList aux = (ArrayList) Datos_dep.get(i);
            String datos = String.valueOf(aux.get(1));
               int NewDates = Integer.parseInt(datos);
               
                if (NewDates == 05)antioquia++;
                if (NewDates == 8)atlantico++;
                if (NewDates == 11)bogota++;
                if (NewDates == 13)bolivar++;
                if (NewDates == 15)boyaca++;
                if (NewDates == 17)calda++;
                if (NewDates == 18)caqueta++;
                if (NewDates == 19)cauca++;
                if (NewDates == 20)cesar++;
                if (NewDates == 23)cordova++;
                if (NewDates == 25)cundinamarca++;
                if (NewDates == 27)choco++;
                if (NewDates == 41)huila++;
                if (NewDates == 44)guajira++;
                if (NewDates == 47)magdalena++;
                if (NewDates == 50)meta++;
                if (NewDates == 52)nariño++;
                if (NewDates == 54)nortsant++;
                if (NewDates == 63)quindio++;
                if (NewDates == 66)risaralda++;
                if (NewDates == 68)santander++;
                if (NewDates == 70)sucre++;
                if (NewDates == 73)tolima++;
                if (NewDates == 76)valle++;
                if (NewDates == 81)arauca++;
                if (NewDates == 85)casanare++;
                if (NewDates == 86)putumayo++;
                if (NewDates == 88)sanandres++;
                if (NewDates == 91)amazonas++;
                if (NewDates == 94)guainia++;
                if (NewDates == 95)guaviare++;
                if (NewDates == 97)vaupes++;
                if (NewDates == 99)vichada++;
                
            }
            maindataset.setValue(antioquia , String.valueOf(antioquia), "antioquia");
            maindataset.setValue(atlantico , String.valueOf(atlantico), "atlantico");
            maindataset.setValue(bogota, String.valueOf(bogota), "bogota");
            maindataset.setValue(bolivar, String.valueOf(bolivar), "bolivar");
            maindataset.setValue(boyaca, String.valueOf(boyaca), "boyaca");
            maindataset.setValue(calda, String.valueOf(calda), "calda");
            maindataset.setValue(caqueta, String.valueOf(caqueta), "caqueta");
            maindataset.setValue(cauca, String.valueOf(cauca), "cauca");
            maindataset.setValue(cesar , String.valueOf(cesar), "cesar");
            maindataset.setValue(cordova , String.valueOf(cordova), "cordova");
            maindataset.setValue(cundinamarca , String.valueOf(cundinamarca), "cundinamarca");
            maindataset.setValue(choco , String.valueOf(choco), "choco");
            maindataset.setValue(huila , String.valueOf(huila), "huila");
            maindataset.setValue(guajira , String.valueOf(guajira), "guajira");
            maindataset.setValue(magdalena , String.valueOf(magdalena), "magdalena");
            maindataset.setValue(meta , String.valueOf(meta), "meta");
            maindataset.setValue(nariño , String.valueOf(nariño), "nariño");
            maindataset.setValue(nortsant , String.valueOf(nortsant), "nortsant");
            maindataset.setValue(quindio , String.valueOf(quindio), "quindio");
            maindataset.setValue(risaralda , String.valueOf(risaralda), "risaralda");
            maindataset.setValue(santander , String.valueOf(santander), "santander");
            maindataset.setValue(sucre , String.valueOf(sucre), "sucre");
            maindataset.setValue(tolima , String.valueOf(tolima), "tolima");
            maindataset.setValue(valle , String.valueOf(valle), "valle");
            maindataset.setValue(arauca , String.valueOf(arauca), "arauca");
            maindataset.setValue(casanare , String.valueOf(casanare), "casanare");
            maindataset.setValue(putumayo , String.valueOf(putumayo), "putumayo");
            maindataset.setValue(sanandres , String.valueOf(sanandres), "sanandres");
            maindataset.setValue(amazonas , String.valueOf(amazonas), "amazonas");
            maindataset.setValue(guainia , String.valueOf(guainia), "guainia");
            maindataset.setValue(guaviare , String.valueOf(guaviare), "guaviare");
            maindataset.setValue(vaupes , String.valueOf(vaupes), "vaupes");
            maindataset.setValue(vichada , String.valueOf(vichada), "vichada");
        return maindataset;
    }
    public  DefaultCategoryDataset Places(ArrayList Datos_sit){
        
        DefaultCategoryDataset maindataset = new DefaultCategoryDataset();
        
        int Hospital = 0, Domicilio = 0 , Otro = 0 ,Sin_información = 0;
            
            for(int i=0;i<Datos_sit.size();i++){
            ArrayList aux = (ArrayList) Datos_sit.get(i);
            String datos = String.valueOf(aux.get(2));
               int NewDates = Integer.parseInt(datos);
        
                    if (NewDates == 1) Hospital++; 
                    if (NewDates == 2) Domicilio++;
                    if (NewDates == 3) Otro++;
                    if (NewDates == 9) Sin_información++;
            }
            maindataset.setValue(Hospital,  String.valueOf(Hospital), "Institución_de_salud");
            maindataset.setValue(Domicilio, String.valueOf(Domicilio),"Domicilio");
            maindataset.setValue(Otro, String.valueOf(Otro),"Otro");
            maindataset.setValue(Sin_información, String.valueOf(Sin_información), "Sin información");
            
        return maindataset;
    }
    public  DefaultCategoryDataset Places1(ArrayList Datos_sit){
        
        DefaultCategoryDataset maindataset = new DefaultCategoryDataset();
        
        int Hospital_Clínica = 0, Centro_PuestoDeSalud = 0,CasaDomicilio = 0, Lugar_de_trabajo = 0 ,Vía_pública = 0, Otro = 0 ,Sin_información = 0;
            
            for(int i=0;i<Datos_sit.size();i++){
            ArrayList aux = (ArrayList) Datos_sit.get(i);
            String datos = String.valueOf(aux.get(2));
               int NewDates = Integer.parseInt(datos);
        
                    if (NewDates == 1 ) Hospital_Clínica++; 
                    if (NewDates == 2) Centro_PuestoDeSalud++; 
                    if (NewDates == 3) CasaDomicilio++; 
                    if (NewDates == 4) Lugar_de_trabajo++; 
                    if (NewDates == 5) Vía_pública++; 
                    if (NewDates == 6) Otro++; 
                    if (NewDates == 9) Sin_información++;
            }
            maindataset.setValue(Hospital_Clínica,  String.valueOf(Hospital_Clínica), "Hospital_Clínica");
            maindataset.setValue(Centro_PuestoDeSalud, String.valueOf(Centro_PuestoDeSalud), "Centro_PuestoDeSalud");
            maindataset.setValue(CasaDomicilio, String.valueOf(CasaDomicilio), "CasaDomicilio");
            maindataset.setValue(Lugar_de_trabajo, String.valueOf(Lugar_de_trabajo), "Lugar_de_trabajo");
            maindataset.setValue(Vía_pública, String.valueOf(Vía_pública), "Vía_pública");
            maindataset.setValue(Otro, String.valueOf(Otro), "Otro");
            maindataset.setValue(Sin_información, String.valueOf(Sin_información), "Sin_información");
            
        return maindataset;
    }
    public  DefaultCategoryDataset Sex(ArrayList Datos_sexo){
        
        DefaultCategoryDataset maindataset = new DefaultCategoryDataset();
        
        int Masculino=0,Femenino=0,Indeterminado=0;
        
        for(int i=0;i<Datos_sexo.size();i++){
            ArrayList aux = (ArrayList) Datos_sexo.get(i);
            String datos = String.valueOf(aux.get(3));
            int NewDates = Integer.parseInt(datos);
        
            if (NewDates ==1) Masculino++;
            if (NewDates ==2) Femenino++;
            if (NewDates ==3) Indeterminado++;
        }        
        maindataset.setValue(Masculino , String.valueOf(Masculino), "Masculino");
        maindataset.setValue(Femenino , String.valueOf(Femenino), "Femenino");
        maindataset.setValue(Indeterminado, String.valueOf(Indeterminado), "Indeterminado");
        return  maindataset;
    }
    
    
    
    public ArrayList SelectTop(ArrayList Data, int aux, boolean BirthsDead){
        
        ArrayList list = new ArrayList();
        switch(aux){
                case 0 :
                    list = TopMonths(Data) ;
                    break;
                case 1:
                    list = TopDepartments(Data) ;
                    break;
                case 2:
                    if (BirthsDead == true)list = TopPlace1(Data);
                    else list = TopPlace2(Data);
                    break;
                case 3:
                    list = TopSex(Data) ;
                    break;
        }
        return list;
        
    }
    public ArrayList TopMonths(ArrayList Datos_meses){
           int enero = 0, febrero = 0,marzo = 0,abril= 0,mayo= 0,junio= 0,julio= 0,agosto= 0,septiembre= 0,octubre= 0,noviembre= 0,diciembre= 0; 
          for(int i=0;i<Datos_meses.size();i++){
              ArrayList aux = (ArrayList) Datos_meses.get(i);   
              String datos = String.valueOf(aux.get(0));
              int NewDates = Integer.parseInt(datos);
              if (NewDates == 01)enero++;  
              if (NewDates == 02)febrero++;
              if (NewDates == 03)marzo++;
              if (NewDates == 04)abril++;
              if (NewDates == 05)mayo++;
              if (NewDates == 06)junio++;
              if (NewDates == 07)julio++;
              if (NewDates == 8)agosto++;
              if (NewDates == 9)septiembre++;
              if (NewDates == 10)octubre++;
              if (NewDates == 11)noviembre++;
              if (NewDates == 12)diciembre++;
          }
          ArrayList months = new ArrayList();
          months.add(enero);
          months.add(febrero);
          months.add(marzo);
          months.add(abril);
          months.add(mayo);
          months.add(junio);
          months.add(julio);
          months.add(agosto);
          months.add(septiembre);
          months.add(octubre);
          months.add(noviembre);
          months.add(diciembre);
          ArrayList aux = new ArrayList();
          int top1 = 0, top2 = 0, top3 = 0;
          String Top1 = "", Top2 = "", Top3 = "";
          for (int i=0; i<13; i++){
              for(int j=0; j<12; j++){
                  if((int) months.get(j) > top1)
                    top1 = (int) months.get(j);
                  if(((int) months.get(j) < top1) && ((int) months.get(j) > top3) && ((int) months.get(j) > top2))
                    top2 = (int) months.get(j);
                  if(((int) months.get(j) < top1) && ((int) months.get(j) < top2) && ((int) months.get(j) > top3))
                    top3 = (int) months.get(j);
              }
          }
          Top1 = NamesMonths(top1, months);
          Top2 = NamesMonths(top2, months);
          Top3 = NamesMonths(top3, months);
          aux.add(Top1);
          aux.add(top1);
          aux.add(Top2);
          aux.add(top2);
          aux.add(Top3);
          aux.add(top3);
          return aux;
    }
    public String NamesMonths(int top, ArrayList list){
        if((int) list.get(0) == top) return "Enero";
        if((int) list.get(1) == top) return "Febrero";
        if((int) list.get(2) == top) return "Marzo";
        if((int) list.get(3) == top) return "Abril";
        if((int) list.get(4) == top) return "Mayo";
        if((int) list.get(5) == top) return "Junio";
        if((int) list.get(6) == top) return "Julio";
        if((int) list.get(7) == top) return "Agosto";
        if((int) list.get(8) == top) return "Septiembre";
        if((int) list.get(9) == top) return "Octubre";
        if((int) list.get(10) == top) return "Noviembre";
        if((int) list.get(11) == top) return "Diciembre";
        return "";
    }
    public ArrayList TopDepartments(ArrayList Datos_dep){
        int antioquia = 0,atlantico = 0,barranquilla=0,bogota=0,bolivar=0,boyaca=0,calda=0,
        caqueta=0,cauca=0,cesar=0,cordova=0,cundinamarca=0,choco=0,
        huila=0,guajira=0,magdalena=0,meta=0,nariño=0,nortsant=0,
        quindio=0,risaralda=0,santander=0,sucre=0,tolima=0,
        valle=0,arauca=0,casanare=0,putumayo=0,sanandres=0,
        amazonas=0,guainia=0,guaviare=0,vaupes=0,vichada=0;
        for(int i=0;i<Datos_dep.size();i++){
            ArrayList aux = (ArrayList) Datos_dep.get(i);
            String datos = String.valueOf(aux.get(1));
               int NewDates = Integer.parseInt(datos);
                if (NewDates == 05)antioquia++;
                if (NewDates == 8)atlantico++;
                if (NewDates == 11)bogota++;
                if (NewDates == 13)bolivar++;
                if (NewDates == 15)boyaca++;
                if (NewDates == 17)calda++;
                if (NewDates == 18)caqueta++;
                if (NewDates == 19)cauca++;
                if (NewDates == 20)cesar++;
                if (NewDates == 23)cordova++;
                if (NewDates == 25)cundinamarca++;
                if (NewDates == 27)choco++;
                if (NewDates == 41)huila++;
                if (NewDates == 44)guajira++;
                if (NewDates == 47)magdalena++;
                if (NewDates == 50)meta++;
                if (NewDates == 52)nariño++;
                if (NewDates == 54)nortsant++;
                if (NewDates == 63)quindio++;
                if (NewDates == 66)risaralda++;
                if (NewDates == 68)santander++;
                if (NewDates == 70)sucre++;
                if (NewDates == 73)tolima++;
                if (NewDates == 76)valle++;
                if (NewDates == 81)arauca++;
                if (NewDates == 85)casanare++;
                if (NewDates == 86)putumayo++;
                if (NewDates == 88)sanandres++;
                if (NewDates == 91)amazonas++;
                if (NewDates == 94)guainia++;
                if (NewDates == 95)guaviare++;
                if (NewDates == 97)vaupes++;
                if (NewDates == 99)vichada++;
            }
        ArrayList departments = new ArrayList();
        departments.add(antioquia);
        departments.add(atlantico);
        departments.add(bogota);
        departments.add(bolivar);
        departments.add(boyaca);
        departments.add(calda);
        departments.add(caqueta);
        departments.add(cauca);
        departments.add(cesar);
        departments.add(cordova);
        departments.add(cundinamarca);
        departments.add(choco);
        departments.add(huila);
        departments.add(guajira);
        departments.add(magdalena);
        departments.add(meta);
        departments.add(nariño);
        departments.add(nortsant);
        departments.add(quindio);
        departments.add(risaralda);
        departments.add(santander);
        departments.add(sucre);
        departments.add(tolima);
        departments.add(valle);
        departments.add(arauca);
        departments.add(casanare);
        departments.add(putumayo);
        departments.add(sanandres);
        departments.add(amazonas);
        departments.add(guainia);
        departments.add(guaviare);
        departments.add(vaupes);
        departments.add(vichada);
          ArrayList aux = new ArrayList();
          int top1 = 0, top2 = 0, top3 = 0;
          String Top1 = "", Top2 = "", Top3 = "";
          for (int i=0; i<33; i++){
              for(int j=0; j<33; j++){
                  if((int) departments.get(j) > top1)
                    top1 = (int) departments.get(j);
                  if(((int) departments.get(j) < top1) && ((int) departments.get(j) > top3) && ((int) departments.get(j) > top2))
                    top2 = (int) departments.get(j);
                  if(((int) departments.get(j) < top1) && ((int) departments.get(j) < top2) && ((int) departments.get(j) > top3))
                    top3 = (int) departments.get(j);
              }
          }
          Top1 = NamesDepartments(top1, departments);
          Top2 = NamesDepartments(top2, departments);
          Top3 = NamesDepartments(top3, departments);
          aux.add(Top1);
          aux.add(top1);
          aux.add(Top2);
          aux.add(top2);
          aux.add(Top3);
          aux.add(top3);
          return aux;
    }
    public String NamesDepartments(int top, ArrayList list){
                if (top == (int) list.get(0)) return "Antioquia";
                if (top == (int) list.get(1)) return "Atlantico";
                if (top == (int) list.get(2)) return "Bogotá";
                if (top == (int) list.get(3)) return "Bolivar";
                if (top == (int) list.get(4)) return "Boyacá";
                if (top == (int) list.get(5)) return "Caldas";
                if (top == (int) list.get(6)) return "Caquetá";
                if (top == (int) list.get(7)) return "Cauca";
                if (top == (int) list.get(8)) return "Cesar";
                if (top == (int) list.get(9)) return "Cordoba";
                if (top == (int) list.get(10)) return "Cundinamarca";
                if (top == (int) list.get(11)) return "Chocó";
                if (top == (int) list.get(12)) return "Huila";
                if (top == (int) list.get(13)) return "Guajira";
                if (top == (int) list.get(14)) return "Magdalena";
                if (top == (int) list.get(15)) return "Meta";
                if (top == (int) list.get(16)) return "Nariño";
                if (top == (int) list.get(17)) return "Norte de Santander";
                if (top == (int) list.get(18)) return "Quindio";
                if (top == (int) list.get(19)) return "Risaralda";
                if (top == (int) list.get(20)) return "Santander";
                if (top == (int) list.get(21)) return "Sucre";
                if (top == (int) list.get(22)) return "Tolima";
                if (top == (int) list.get(23)) return "Valle";
                if (top == (int) list.get(24)) return "Arauca";
                if (top == (int) list.get(25)) return "Casanare";
                if (top == (int) list.get(26)) return "Putumayo";
                if (top == (int) list.get(27)) return "San Andres";
                if (top == (int) list.get(28)) return "Amazonas";
                if (top == (int) list.get(29)) return "Guainia";
                if (top == (int) list.get(30)) return "Guaviare";
                if (top == (int) list.get(31)) return "Vaupes";
                if (top == (int) list.get(32)) return "Vichada";
                return "";
    }
    public ArrayList TopPlace1(ArrayList Datos_sit){
            int Hospital = 0, Domicilio = 0 , Otro = 0 ,Sin_información = 0;
            for(int i=0;i<Datos_sit.size();i++){
                ArrayList aux = (ArrayList) Datos_sit.get(i);
                String datos = String.valueOf(aux.get(2));
                int NewDates = Integer.parseInt(datos);
                if (NewDates == 1) Hospital++; 
                if (NewDates == 2) Domicilio++;
                if (NewDates == 3) Otro++;
                if (NewDates == 9) Sin_información++;
            }
            ArrayList place = new ArrayList();
            place.add(Hospital);
            place.add(Domicilio);
            place.add(Otro);
            place.add(Sin_información);
            ArrayList aux = new ArrayList();
            int top1 = 0, top2 = 0, top3 = 0;
            String Top1 = "", Top2 = "", Top3 = "";
            for (int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                  if((int) place.get(j) > top1)
                    top1 = (int) place.get(j);
                  if(((int) place.get(j) < top1) && ((int) place.get(j) > top3) && ((int) place.get(j) > top2))
                    top2 = (int) place.get(j);
                  if(((int) place.get(j) < top1) && ((int) place.get(j) < top2) && ((int) place.get(j) > top3))
                    top3 = (int) place.get(j);
                }
            }
            Top1 = NamesPlace(top1, place);
            Top2 = NamesPlace(top2, place);
            Top3 = NamesPlace(top3, place);
            aux.add(Top1);
            aux.add(top1);
            aux.add(Top2);
            aux.add(top2);
            aux.add(Top3);
            aux.add(top3);
            return aux;
    }
    public String NamesPlace(int top, ArrayList list){
        if (top == (int) list.get(0)) return "Institución de salud";
        if (top == (int) list.get(1)) return "Domicilio";
        if (top == (int) list.get(2)) return "Otro";
        if (top == (int) list.get(3)) return "Sin Información";
        return "";
    }
    public ArrayList TopPlace2(ArrayList Datos_sit){
            int Hospital_Clínica = 0, Centro_PuestoDeSalud = 0,CasaDomicilio = 0, Lugar_de_trabajo = 0 ,Vía_pública = 0, Otro = 0 ,Sin_información = 0;
            for(int i=0;i<Datos_sit.size();i++){
            ArrayList aux = (ArrayList) Datos_sit.get(i);
            String datos = String.valueOf(aux.get(2));
               int NewDates = Integer.parseInt(datos);
                    if (NewDates == 1 ) Hospital_Clínica++; 
                    if (NewDates == 2) Centro_PuestoDeSalud++; 
                    if (NewDates == 3) CasaDomicilio++; 
                    if (NewDates == 4) Lugar_de_trabajo++; 
                    if (NewDates == 5) Vía_pública++; 
                    if (NewDates == 6) Otro++; 
                    if (NewDates == 9) Sin_información++;
            }
            ArrayList place = new ArrayList();
            place.add(Hospital_Clínica);
            place.add(Centro_PuestoDeSalud);
            place.add(CasaDomicilio);
            place.add(Lugar_de_trabajo);
            place.add(Vía_pública);
            place.add(Otro);
            place.add(Sin_información);
            ArrayList aux = new ArrayList();
            int top1 = 0, top2 = 0, top3 = 0;
            String Top1 = "", Top2 = "", Top3 = "";
            for (int i=0; i<7; i++){
                for(int j=0; j<7; j++){
                  if((int) place.get(j) > top1)
                    top1 = (int) place.get(j);
                  if(((int) place.get(j) < top1) && ((int) place.get(j) > top3) && ((int) place.get(j) > top2))
                    top2 = (int) place.get(j);
                  if(((int) place.get(j) < top1) && ((int) place.get(j) < top2) && ((int) place.get(j) > top3))
                    top3 = (int) place.get(j);
                }
            }
            Top1 = NamesPlace2(top1, place);
            Top2 = NamesPlace2(top2, place);
            Top3 = NamesPlace2(top3, place);
            aux.add(Top1);
            aux.add(top1);
            aux.add(Top2);
            aux.add(top2);
            aux.add(Top3);
            aux.add(top3);
            return aux;
    }
    public String NamesPlace2(int top, ArrayList list){
        if (top == (int) list.get(0)) return "Hospital/Clínica";
        if (top == (int) list.get(1)) return "Centro de salud";
        if (top == (int) list.get(2)) return "Casa/Domicilio";
        if (top == (int) list.get(3)) return "Lugar de trabajo";
        if (top == (int) list.get(4)) return "Vía pública";
        if (top == (int) list.get(5)) return "Otro";
        if (top == (int) list.get(6)) return "Sin información";
        return "";
    }
    public ArrayList TopSex(ArrayList Datos_sexo){
        int Masculino=0,Femenino=0,Indeterminado=0;
        for(int i=0;i<Datos_sexo.size();i++){
            ArrayList aux = (ArrayList) Datos_sexo.get(i);
            String datos = String.valueOf(aux.get(3));
            int NewDates = Integer.parseInt(datos);
            if (NewDates ==1) Masculino++;
            if (NewDates ==2) Femenino++;
            if (NewDates ==3) Indeterminado++;
        }
        ArrayList place = new ArrayList();
        place.add(Masculino);
        place.add(Femenino);
        place.add(Indeterminado);
        ArrayList aux = new ArrayList();
        int top1 = 0, top2 = 0, top3 = 0;
        String Top1 = "", Top2 = "", Top3 = "";
        for (int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                  if((int) place.get(j) > top1)
                    top1 = (int) place.get(j);
                  if(((int) place.get(j) < top1) && ((int) place.get(j) > top3) && ((int) place.get(j) > top2))
                    top2 = (int) place.get(j);
                  if(((int) place.get(j) < top1) && ((int) place.get(j) < top2) && ((int) place.get(j) > top3))
                    top3 = (int) place.get(j);
                }
            }
        Top1 = NamesSex(top1, place);
        Top2 = NamesSex(top2, place);
        Top3 = NamesSex(top3, place);
        aux.add(Top1);
        aux.add(top1);
        aux.add(Top2);
        aux.add(top2);
        aux.add(Top3);
        aux.add(top3);
        return aux;
    }
    public String NamesSex(int top, ArrayList list){
        if (top == (int) list.get(0)) return "Masculino";
        if (top == (int) list.get(1)) return "Femenino";
        if (top == (int) list.get(2)) return "Indeterminado";
        return "";
    }
    }

