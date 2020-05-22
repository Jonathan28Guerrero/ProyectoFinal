/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.proyect;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author daniela
 */
public class Graphics {
    
    public JFreeChart MakeGraphic(ArrayList Datos){
       //DefaultPieDataset dataset = new DefaultPieDataset();
       int enero = 0, febrero = 0,marzo = 0,abril= 0,mayo= 0,junio= 0,julio= 0,agosto= 0,septiembre= 0,octubre= 0,noviembre= 0,diciembre= 0; 
       DefaultPieDataset maindataset = new DefaultPieDataset();
       for(int i=0;i<Datos.size();i++){
           String datos = String.valueOf(Datos.get(i));
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
       maindataset.setValue("Enero" + String.valueOf(enero), enero);
       maindataset.setValue("Febrero" + String.valueOf(febrero), febrero);
       maindataset.setValue("marzo" + String.valueOf(marzo), marzo);
       maindataset.setValue("abril" + String.valueOf(abril), abril);
       maindataset.setValue("mayo" + String.valueOf(mayo), mayo);
       maindataset.setValue("junio" + String.valueOf(junio), junio);
       maindataset.setValue("julio" + String.valueOf(julio), julio);
       maindataset.setValue("agosto" + String.valueOf(agosto), agosto);
       maindataset.setValue("septiembre" + String.valueOf(septiembre), septiembre);
       maindataset.setValue("octubre" + String.valueOf(octubre), octubre);
       maindataset.setValue("noviembre" + String.valueOf(noviembre), noviembre);
       maindataset.setValue("diciembre" + String.valueOf(diciembre), diciembre);
        //maindataset.setValue((Comparable) Datos,Datos.size());
        //dataset(maindataset);
        JFreeChart chart = ChartFactory.createPieChart3D("Nacimientos", maindataset, true, true, true);
                //PlotOrientation.VERTICAL, true, true, false); 
                
                return (chart);
    }
    }

