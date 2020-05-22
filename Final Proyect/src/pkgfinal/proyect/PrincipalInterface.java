/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.proyect;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;


/**
 *
 * @author daniela
 */
public class PrincipalInterface extends javax.swing.JFrame {
    
    File fileSelected;
    Graphics Graphic = new Graphics();
    ArrayList births;
    TakeFile fileData = new TakeFile();
    Data dataBirths = new Data();
    FilterData filter = new FilterData();
    int counter = 0;
    String prueba;
    int Value = 0;

    /**
     * Creates new form PrincipalInterface
     */
    public PrincipalInterface() {
        initComponents();
        ExtractFile();
        
    }
    
    public void seleccionarPelicula(int value) {
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccionar");
        BirthPlaceBox.setModel(modelo);
        if(value == 0){
        modelo.addElement("Institucion de salud");
        modelo.addElement("Domicilio");
        modelo.addElement("Otro");
        modelo.addElement("sin informacion");
        BirthPlaceBox.setModel(modelo);
        }
        if(value == 1 || value == 2){
        modelo.addElement("Hospital/clínica");
        modelo.addElement("Centro/puesto de salud");
        modelo.addElement("Casa/domicilio");
        modelo.addElement("Lugar de trabajo");
        modelo.addElement("Vía pública");
        modelo.addElement("Otro");
        modelo.addElement("sin informacion");
        
        BirthPlaceBox.setModel(modelo);
        }


    }
    public final void ExtractFile(){
        int[] columns = new int[4];
        String[] Options = {"Nacimientos","Defunciones", "Defunciones prenatales"};
        Value = JOptionPane.showOptionDialog(this, "¿Qué archivo desea analizar?", "Aceptar", WIDTH, HEIGHT, null,
                Options, Options[0]);
        switch(Value){
            case 0:
                columns[0] =9;
                columns[1] =0;
                columns[2] =3;
                columns[3] =5;
                break;
            case 1:
                columns[0] =7;
                columns[1] =0;
                columns[2] =3;
                columns[3] =10;
                break;
            case 2:
                columns[0] =7;
                columns[1] =0;
                columns[2] =3;
                columns[3] =10;
                break;
        }
        JFileChooser SelectFile = new JFileChooser();
        FileNameExtensionFilter Filter = new FileNameExtensionFilter("Archvos de texto", "csv");
        SelectFile.setFileFilter(Filter);
        int Result = SelectFile.showOpenDialog(this);
        fileSelected = SelectFile.getSelectedFile();
        
        try {
           births = fileData.CreateList(fileSelected, columns);
           dataBirths.Data((births));
           seleccionarPelicula(Value);
           SetToTable();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrincipalInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if((fileSelected==null)||(fileSelected.getName().equals(""))){
            JOptionPane.showMessageDialog(this,"Nombre de archivo invalido");
        }
        
    }
     public void SetToTable(){
        int Rows = dataBirths.FilteredData.size();
        int Columns = 4;
        ArrayList months = new ArrayList();
        Table.setModel(new DefaultTableModel(Rows, Columns));
        Table.setEnabled(false);
        if(counter == 0){
            for(int i=1; i<Rows; i++){
                ArrayList Row1 = (ArrayList) dataBirths.FilteredData.get(i);
                for(int a = 0; a<4; a++)
                    Table.setValueAt(Row1.get(a), i-1, a);
                    months.add(Row1.get(0));
            }
            paint(months);
        }
        else{
            for(int i=0; i<Rows; i++){
            ArrayList Row1 = (ArrayList) dataBirths.FilteredData.get(i);
            for(int a = 0; a<4; a++)
                Table.setValueAt(Row1.get(a), i, a);
            }
        }
        System.out.println("Tamaño luego de filtrar "+ counter + ": "+ Rows);
        counter++;
    }
     public void paint(ArrayList Months){
    
    ArrayList List = (ArrayList)Months;
    
            ChartPanel chartPanel=new ChartPanel(Graphic.MakeGraphic(List));
            //Graphic.MakeGraphic(List).removeLegend();
            add(chartPanel);
            chartPanel.setBounds(470, 80, 450, 400);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jComboBox1 = new javax.swing.JComboBox<>();
        DeparmentBox = new javax.swing.JComboBox<>();
        BirthPlaceBox = new javax.swing.JComboBox<>();
        MonthBox = new javax.swing.JComboBox<>();
        SexBox = new javax.swing.JComboBox<>();
        GraphicTipeBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DeparmentBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Antioquia", "Atlántico", "Bogotá", "Bolivar", "Boyaca", "Caldas", "Caqueta", "Cauca", "Cesar", "Cordoba", "Cundinamarca", "Choco", "Huila", "La guajira", "Magdalena", "Meta", "Nariño", "Norte de Santander", "Quindio", "Risaralda", "Santander", "Sucre", "Tolima", "Valle del Cauca", "Arauca", "Casanare", "Putumayo", "Archipiélago de San Andrés, Providencia y Santa Catalina", "Amazonas", "Guainía", "Guaviare", "Vaupés", "Vichada" }));
        DeparmentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeparmentBoxActionPerformed(evt);
            }
        });

        BirthPlaceBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BirthPlaceBoxActionPerformed(evt);
            }
        });

        MonthBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        MonthBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthBoxActionPerformed(evt);
            }
        });

        SexBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Femenino", "Masculino", "Indeterminado" }));
        SexBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SexBoxActionPerformed(evt);
            }
        });

        GraphicTipeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "Torta", "Barras", "Puntos", "Orizontal" }));
        GraphicTipeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicTipeBoxActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Table);

        jButton1.setText("Limpiar Filtros ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Departamento");

        jLabel2.setText("Sitio");

        jLabel3.setText("Mes");

        jLabel4.setText("Sexo");

        jMenu3.setText("File");

        jMenuItem1.setText("Nuevo");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DeparmentBox, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BirthPlaceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SexBox, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel4)))))
                .addContainerGap(528, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(GraphicTipeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(GraphicTipeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeparmentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BirthPlaceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SexBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addGap(131, 131, 131))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void SexBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SexBoxActionPerformed
        int sex = SexBox.getSelectedIndex();
        ArrayList aux = filter.Sex(sex, dataBirths.FilteredData);
        dataBirths.FilteredData = aux;
        SetToTable();
    }//GEN-LAST:event_SexBoxActionPerformed

    private void GraphicTipeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicTipeBoxActionPerformed
        int Tipe = GraphicTipeBox.getSelectedIndex();
        switch(Tipe) {
            case 0:
                break;
            case 1:
                break;
             case 2:
                break;
            case 3:
                break;
            case 4:
                break;   
        }
    }//GEN-LAST:event_GraphicTipeBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dataBirths.FilteredData = dataBirths.DataList;
        counter = 0;
        SetToTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BirthPlaceBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BirthPlaceBoxActionPerformed
        int place = BirthPlaceBox.getSelectedIndex();
        String [] Brirths = {"0","1","2","3","9"};
        String [] fetales1 = {"0","1","2","3","4","5","6","9"};
        if(Value == 0){
        ArrayList aux = filter.Place(Brirths ,place, dataBirths.FilteredData);
        dataBirths.FilteredData = aux;
        }
        else{
        ArrayList aux = filter.Place(fetales1 ,place, dataBirths.FilteredData);
        dataBirths.FilteredData = aux;
        }
        SetToTable();
    }//GEN-LAST:event_BirthPlaceBoxActionPerformed

    private void MonthBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthBoxActionPerformed
        int month = MonthBox.getSelectedIndex();
        ArrayList aux = filter.Month(month, dataBirths.FilteredData);
        dataBirths.FilteredData = aux;
        SetToTable();
    }//GEN-LAST:event_MonthBoxActionPerformed

    private void DeparmentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeparmentBoxActionPerformed
        int deparment = DeparmentBox.getSelectedIndex();
        ArrayList aux = filter.Deparment(deparment, dataBirths.FilteredData);
        dataBirths.FilteredData = aux;
        SetToTable();
    }//GEN-LAST:event_DeparmentBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BirthPlaceBox;
    private javax.swing.JComboBox<String> DeparmentBox;
    private javax.swing.JComboBox<String> GraphicTipeBox;
    private javax.swing.JComboBox<String> MonthBox;
    private javax.swing.JComboBox<String> SexBox;
    private javax.swing.JTable Table;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
