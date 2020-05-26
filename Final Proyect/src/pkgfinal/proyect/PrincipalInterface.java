/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.proyect;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
    Graphics graphic = new Graphics();
    ArrayList births;
    TakeFile fileData = new TakeFile();
    Data dataBirths = new Data();
    FilterData filter = new FilterData();
    int counter = 0;
    String prueba;
    int Value = 0;
    ExportFiles exportFile = new ExportFiles();
    //Karla
    int Tipe;
    int counter2 = 0;
    boolean BirthsDeats = false;
    boolean flagMonths =false;
    boolean flagDepartments=false;
    boolean flagPlaces=false;
    boolean flagSex=false;
    ChartPanel chartPanel;
    /**
     * Creates new form PrincipalInterface
     */
    public PrincipalInterface() {
        initComponents();
        ExtractFile();
        
    }
    
    public void selectModel(int value) {
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Seleccionar");
        BirthPlaceBox.setModel(model);
        if(value == 0){
        model.addElement("Institucion de salud");
        model.addElement("Domicilio");
        model.addElement("Otro");
        model.addElement("sin informacion");
        BirthPlaceBox.setModel(model);
        }
        if(value == 1 || value == 2){
        model.addElement("Hospital/clínica");
        model.addElement("Centro/puesto de salud");
        model.addElement("Casa/domicilio");
        model.addElement("Lugar de trabajo");
        model.addElement("Vía pública");
        model.addElement("Otro");
        model.addElement("sin informacion");
        
        BirthPlaceBox.setModel(model);
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
                BirthsDeats = true;
                break;
            case 1:
                columns[0] =7;
                columns[1] =0;
                columns[2] =3;
                columns[3] =10;
                BirthsDeats = false;
                break;
            case 2:
                columns[0] =7;
                columns[1] =0;
                columns[2] =3;
                columns[3] =10;
                BirthsDeats = false;
                break;
        }
        JFileChooser SelectFile = new JFileChooser();
        FileNameExtensionFilter Filter = new FileNameExtensionFilter("Archvos de CSV", "csv");
        SelectFile.setFileFilter(Filter);
        int Result = SelectFile.showOpenDialog(this);
        fileSelected = SelectFile.getSelectedFile();
        try {
           births = fileData.CreateList(fileSelected, columns);
           dataBirths.Data((births));
           selectModel(Value);
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
        Table.setModel(new DefaultTableModel(Rows, Columns));
        Table.setEnabled(false);
        if(counter == 0){
            for(int i=1; i<Rows; i++){
                ArrayList Row1 = (ArrayList) dataBirths.FilteredData.get(i);
                for(int a = 0; a<4; a++)
                    Table.setValueAt(Row1.get(a), i-1, a);
            }
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
        DepartmentBox = new javax.swing.JComboBox<>();
        BirthPlaceBox = new javax.swing.JComboBox<>();
        MonthBox = new javax.swing.JComboBox<>();
        SexBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        CleanFilters = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TipeBox = new javax.swing.JComboBox<>();
        Panel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        TopLabel = new javax.swing.JLabel();
        TopLabel2 = new javax.swing.JLabel();
        TopLabel3 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DepartmentBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Antioquia", "Atlántico", "Bogotá", "Bolivar", "Boyaca", "Caldas", "Caqueta", "Cauca", "Cesar", "Cordoba", "Cundinamarca", "Choco", "Huila", "La guajira", "Magdalena", "Meta", "Nariño", "Norte de Santander", "Quindio", "Risaralda", "Santander", "Sucre", "Tolima", "Valle del Cauca", "Arauca", "Casanare", "Putumayo", "Archipiélago de San Andrés, Providencia y Santa Catalina", "Amazonas", "Guainía", "Guaviare", "Vaupés", "Vichada" }));
        DepartmentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentBoxActionPerformed(evt);
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

        CleanFilters.setText("Limpiar Filtros ");
        CleanFilters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CleanFiltersActionPerformed(evt);
            }
        });

        jLabel1.setText("Departamento");

        jLabel2.setText("Sitio");

        jLabel3.setText("Mes");

        jLabel4.setText("Sexo");

        jLabel5.setText("Tipo de graficas:");

        TipeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Picos", "Barras", "Relieve" }));
        TipeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipeBoxActionPerformed(evt);
            }
        });

        Panel.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        jLabel6.setText("Top 3");

        jMenu3.setText("File");

        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenu5.setText("Guardar");

        jMenuItem4.setText("Tabla");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuItem5.setText("Gráfica");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenu3.add(jMenu5);

        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(MonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(DepartmentBox, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BirthPlaceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SexBox, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CleanFilters)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TopLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TopLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(TipeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TipeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DepartmentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BirthPlaceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SexBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CleanFilters)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(TopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TopLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TopLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void SexBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SexBoxActionPerformed
        if(SexBox.getSelectedIndex()!=0){
            flagSex = true ;
            counter2++;
            int sex = SexBox.getSelectedIndex();
            ArrayList aux = filter.Sex(sex, dataBirths.FilteredData);
            dataBirths.FilteredData = aux;
            SetToTable();
        }
    }//GEN-LAST:event_SexBoxActionPerformed

    private void CleanFiltersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CleanFiltersActionPerformed
        dataBirths.FilteredData = dataBirths.DataList;
        flagMonths = false ;
        flagPlaces=false ;
        flagDepartments=false;
        flagSex = false ;
        MonthBox.setSelectedIndex(0);
        DepartmentBox.setSelectedIndex(0);
        BirthPlaceBox.setSelectedIndex(0);
        SexBox.setSelectedIndex(0);
        counter = 0;
        counter2 = 0;
        SetToTable();
    }//GEN-LAST:event_CleanFiltersActionPerformed

    private void BirthPlaceBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BirthPlaceBoxActionPerformed
        if(BirthPlaceBox.getSelectedIndex()!=0){
            flagPlaces = true;
            counter2++;
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
        }
    }//GEN-LAST:event_BirthPlaceBoxActionPerformed

    private void MonthBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthBoxActionPerformed
        if(MonthBox.getSelectedIndex()!=0){
            flagMonths=true;
            counter2++;
            int month = MonthBox.getSelectedIndex();
            ArrayList aux = filter.Month(month, dataBirths.FilteredData);
            dataBirths.FilteredData = aux;
            SetToTable();
        }
    }//GEN-LAST:event_MonthBoxActionPerformed

    private void DepartmentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentBoxActionPerformed
        if(DepartmentBox.getSelectedIndex()!=0){
            flagDepartments = true ;
            counter2++;
            int deparment = DepartmentBox.getSelectedIndex();
            ArrayList aux = filter.Deparment(deparment, dataBirths.FilteredData);
            dataBirths.FilteredData = aux;
            SetToTable();
        }
    }//GEN-LAST:event_DepartmentBoxActionPerformed

    private void TipeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipeBoxActionPerformed
        Tipe = TipeBox.getSelectedIndex();
        System.out.println(counter2);
        if (counter2 != 3 || Tipe == 0 )
            JOptionPane.showMessageDialog(this, "Debe seleccionar 3 filtros o un tipo de gráfica");
        else{
            int aux = 0;
            if(flagMonths == false )aux = 0;
            if(flagDepartments== false )aux = 1;
            if(flagPlaces == false )aux = 2;
            if(flagSex == false )aux = 3;
            chartPanel=new ChartPanel(graphic.DoGraphic(Tipe, aux,dataBirths.FilteredData,BirthsDeats));
            Panel.removeAll();
            Panel.setLayout(new BorderLayout());
            Panel.add(chartPanel,BorderLayout.CENTER);
            Panel.validate();
            ArrayList listTop = graphic.SelectTop(dataBirths.FilteredData,aux,BirthsDeats);
            TopLabel.setText("1. " + listTop.get(0) + ": " + listTop.get(1));
            TopLabel2.setText("2. " + listTop.get(2) + ": " + listTop.get(3));
            TopLabel3.setText("3. " + listTop.get(4) + ": " + listTop.get(5));
        }
    }//GEN-LAST:event_TipeBoxActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        flagMonths = false ;
        flagPlaces=false ;
        flagDepartments=false;
        flagSex = false ;
        MonthBox.setSelectedIndex(0);
        DepartmentBox.setSelectedIndex(0);
        BirthPlaceBox.setSelectedIndex(0);
        SexBox.setSelectedIndex(0);
        counter = 0;
        counter2 = 0;
        ExtractFile();
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            exportFile.ExportFile(dataBirths.FilteredData);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalInterface.class.getName()).log(Level.SEVERE, null, ex);
        }// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        exportFile.ExportImage(Panel);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
    private javax.swing.JButton CleanFilters;
    private javax.swing.JComboBox<String> DepartmentBox;
    private javax.swing.JComboBox<String> MonthBox;
    private javax.swing.JPanel Panel;
    private javax.swing.JComboBox<String> SexBox;
    private javax.swing.JTable Table;
    private javax.swing.JComboBox<String> TipeBox;
    private javax.swing.JLabel TopLabel;
    private javax.swing.JLabel TopLabel2;
    private javax.swing.JLabel TopLabel3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
