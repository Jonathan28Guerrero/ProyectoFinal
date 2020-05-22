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
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author daniela
 */
public class Graphics {
    
    public JFreeChart MakeGraphic(ArrayList Datos,String Tipo_de_Filtro,String Top){
       XYSeriesCollection dataset = new XYSeriesCollection();
       XYSeries maindataset = new XYSeries("meses");
        for(int i=2; i< Datos.size();i++){ 
            maindataset.add(i-1,Float.valueOf((String)Datos.get(i)));
        }
        dataset.addSeries(maindataset);
        JFreeChart chart= ChartFactory.createXYLineChart((String)Datos.get(0), "meses", "Cantidad", dataset,
                PlotOrientation.VERTICAL, true, true, false);
        return chart;
    }

    JFreeChart MakeGraphic(ArrayList List) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
