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
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TopLabel = new javax.swing.JLabel();
        TopLabel2 = new javax.swing.JLabel();
        TopLabel3 = new javax.swing.JLabel();
        SexBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1300, 650));
        setMinimumSize(new java.awt.Dimension(1300, 650));
        setPreferredSize(new java.awt.Dimension(1300, 650));
        getContentPane().setLayout(null);

        DepartmentBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Antioquia", "Atlántico", "Bogotá", "Bolivar", "Boyaca", "Caldas", "Caqueta", "Cauca", "Cesar", "Cordoba", "Cundinamarca", "Choco", "Huila", "La guajira", "Magdalena", "Meta", "Nariño", "Norte de Santander", "Quindio", "Risaralda", "Santander", "Sucre", "Tolima", "Valle del Cauca", "Arauca", "Casanare", "Putumayo", "Archipiélago de San Andrés, Providencia y Santa Catalina", "Amazonas", "Guainía", "Guaviare", "Vaupés", "Vichada" }));
        DepartmentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentBoxActionPerformed(evt);
            }
        });
        getContentPane().add(DepartmentBox);
        DepartmentBox.setBounds(145, 110, 100, 25);

        BirthPlaceBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BirthPlaceBoxActionPerformed(evt);
            }
        });
        getContentPane().add(BirthPlaceBox);
        BirthPlaceBox.setBounds(260, 110, 100, 25);

        MonthBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        MonthBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthBoxActionPerformed(evt);
            }
        });
        getContentPane().add(MonthBox);
        MonthBox.setBounds(30, 110, 100, 25);

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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 150, 450, 210);

        CleanFilters.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CleanFilters.setText("Limpiar Filtros ");
        CleanFilters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CleanFiltersActionPerformed(evt);
            }
        });
        getContentPane().add(CleanFilters);
        CleanFilters.setBounds(350, 370, 120, 25);

        jLabel1.setText("Departamento:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(145, 80, 100, 20);

        jLabel2.setText("Sitio:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 80, 100, 20);

        jLabel3.setText("Mes:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 80, 100, 20);

        jLabel4.setText("Sexo:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(375, 80, 100, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Tipo de gráfica:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1045, 110, 100, 25);

        TipeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Picos", "Barras", "Relieve" }));
        TipeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipeBoxActionPerformed(evt);
            }
        });
        getContentPane().add(TipeBox);
        TipeBox.setBounds(1150, 110, 100, 25);

        Panel.setBorder(new javax.swing.border.MatteBorder(null));
        Panel.setPreferredSize(new java.awt.Dimension(750, 400));

        jLabel8.setText("               ");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        getContentPane().add(Panel);
        Panel.setBounds(500, 150, 750, 400);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Top 3");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(140, 440, 150, 20);

        TopLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TopLabel);
        TopLabel.setBounds(140, 470, 150, 20);

        TopLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TopLabel2);
        TopLabel2.setBounds(140, 500, 150, 20);

        TopLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TopLabel3);
        TopLabel3.setBounds(140, 530, 150, 20);

        SexBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Femenino", "Masculino", "Indeterminado" }));
        SexBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SexBoxActionPerformed(evt);
            }
        });
        getContentPane().add(SexBox);
        SexBox.setBounds(375, 110, 100, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Análisis de Nacimientos y Defunciones (DANE)");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 20, 1220, 40);

        jMenu3.setText("Archivo");

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

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Código de departamentos");

        jMenuItem9.setText("05. Antioquia");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("08. Atlantico");
        jMenu4.add(jMenuItem10);

        jMenuItem11.setText("11. Bogotá");
        jMenu4.add(jMenuItem11);

        jMenuItem7.setText("13. Bolivar");
        jMenu4.add(jMenuItem7);

        jMenuItem15.setText("15. Boyacá");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        jMenuItem13.setText("17. Caldas");
        jMenu4.add(jMenuItem13);

        jMenuItem16.setText("18. Caquetá");
        jMenu4.add(jMenuItem16);

        jMenuItem14.setText("19. Cauca");
        jMenu4.add(jMenuItem14);

        jMenuItem23.setText("20. Cesar");
        jMenu4.add(jMenuItem23);

        jMenuItem26.setText("23. Cordova");
        jMenu4.add(jMenuItem26);

        jMenuItem35.setText("25. Cundinamarca");
        jMenu4.add(jMenuItem35);

        jMenuItem36.setText("27. Choco");
        jMenu4.add(jMenuItem36);

        jMenuItem27.setText("41. Huila");
        jMenu4.add(jMenuItem27);

        jMenuItem17.setText("44. Guajira");
        jMenu4.add(jMenuItem17);

        jMenuItem29.setText("47. Magdalena");
        jMenu4.add(jMenuItem29);

        jMenuItem34.setText("50. Meta");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem34);

        jMenuItem30.setText("52. Nariño");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem30);

        jMenuItem24.setText("54. Norte de Santander");
        jMenu4.add(jMenuItem24);

        jMenuItem33.setText("63. Quindio");
        jMenu4.add(jMenuItem33);

        jMenuItem31.setText("66. Risaralda");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem31);

        jMenuItem32.setText("68. Santander");
        jMenu4.add(jMenuItem32);

        jMenuItem28.setText("70. Sucre");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem28);

        jMenuItem18.setText("73. Tolima");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem18);

        jMenuItem22.setText("76. Valle");
        jMenu4.add(jMenuItem22);

        jMenuItem25.setText("81. Arauca ");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem25);

        jMenuItem19.setText("85. Casanare ");
        jMenu4.add(jMenuItem19);

        jMenuItem12.setText("86. Putumayo");
        jMenu4.add(jMenuItem12);

        jMenuItem21.setText("88. San Andres");
        jMenu4.add(jMenuItem21);

        jMenuItem20.setText("91. Amazonas");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem20);

        jMenuItem2.setText("94. Guainia");
        jMenu4.add(jMenuItem2);

        jMenuItem8.setText("95. Guaviare");
        jMenu4.add(jMenuItem8);

        jMenuItem37.setText("97. Vaupes");
        jMenu4.add(jMenuItem37);

        jMenuItem6.setText("99. Vichada");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

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

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem20ActionPerformed

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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
