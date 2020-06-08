/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igu.User;

import data.userData;
import entities.User;
import igu.util.Config;
import igu.util.alerts.ConfirmDialog;
import igu.util.alerts.ErrorAlert;
import igu.util.alerts.SuccessAlert;
import javax.swing.ListSelectionModel;


import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;
//import java.sql.Date;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Asullom
 */
public class userPanel extends javax.swing.JPanel {

    
    SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");
   
    
   

    public userPanel() {
        initComponents();
        //AWTUtilities.setOpaque(this, false);
         
        
        //String fecha =dformat.format(borndateField.getDate());
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
         
        this.id.setText("");
        paintTable("");

        tabla.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (tabla.getRowCount() > 0) {
                    int[] row = tabla.getSelectedRows();
                    if (row.length > 0) {
                        String ids = (String) tabla.getValueAt(row[0], 1);
                        id.setText("" + ids);
                        String nombress = (String) tabla.getValueAt(row[0], 2);
                        nombres.setText("" + nombress);
                        String lastnameFields = (String) tabla.getValueAt(row[0], 3);
                        lastnameField.setText("" + lastnameFields);
                        String phones=(String)tabla.getValueAt(row[0], 4);
                        phoneField.setText(""+phones);
                        String infoadics=(String)tabla.getValueAt(row[0], 5);
                        infoadicField.setText(""+infoadics);
                        System.out.println("Table element selected es: " + ids);
                        guardarButton.setText("MODIFICAR");
                    }
                } else {
                    System.out.println("eee");
                }
            }

        });

        this.nombres.requestFocus();

    }

    private void paintTable(String buscar) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        List<User> lis = userData.list(buscar);
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String datos[] = new String[7];
        int cont = 0;
        for (User d : lis) {
            //modelo.addRow(new Object[]{d.getId(), d.getName(), d.getLastname()});
            datos[0] = ++cont + "";
            datos[1] = d.getId() + "";
            datos[2] = d.getName();
            datos[3] = d.getLastname();
            datos[4] = d.getPhone();
            datos[5] = d.getSex();
            datos[6] = d.getInfoadic();
            modelo.addRow(datos);
        }
        tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        
    }

    private void limpiarCampos() {
        this.nombres.requestFocus();
        this.nombres.setText("");
        this.lastnameField.setText("");
        this.phoneField.setText("");
        //this.sexField.setText("");
        paintTable("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buscarField = new javax.swing.JTextField();
        aSIconButton4 = new igu.util.buttons.ASIconButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        nuevoButton = new igu.util.buttons.ASIconButton();
        guardarButton = new igu.util.buttons.ASIconButton();
        eliminarButton = new igu.util.buttons.ASIconButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        infoadicField = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombres = new javax.swing.JTextField();
        id = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sexField = new javax.swing.JComboBox();
        phoneField = new javax.swing.JTextField();
        lastnameField = new javax.swing.JTextField();
        infoadicLabel = new javax.swing.JLabel();
        borndateField = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(58, 159, 171));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Usuario");

        buscarField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        buscarField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarFieldKeyReleased(evt);
            }
        });

        aSIconButton4.setText("Excel");
        aSIconButton4.setColorHover(new java.awt.Color(0, 102, 102));
        aSIconButton4.setColorNormal(new java.awt.Color(153, 153, 153));
        aSIconButton4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        aSIconButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aSIconButton4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Buscar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 578, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aSIconButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aSIconButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));

        jPanel4.setBackground(new java.awt.Color(58, 159, 171));

        tabla.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº", "ID", "NOMBRES", "APELLIDOS", "TELEFONO", "SEXO", "Info__adic"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setDoubleBuffered(true);
        tabla.setRowHeight(25);
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(58, 159, 171));

        panel.setBackground(new java.awt.Color(255, 255, 255));

        nuevoButton.setText("NUEVO");
        nuevoButton.setColorHover(new java.awt.Color(0, 102, 102));
        nuevoButton.setColorNormal(new java.awt.Color(153, 153, 153));
        nuevoButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        nuevoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoButtonActionPerformed(evt);
            }
        });

        guardarButton.setText("GUARDAR");
        guardarButton.setColorHover(new java.awt.Color(0, 102, 102));
        guardarButton.setColorNormal(new java.awt.Color(153, 153, 153));
        guardarButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setText("ELIMINAR");
        eliminarButton.setColorHover(new java.awt.Color(0, 102, 102));
        eliminarButton.setColorNormal(new java.awt.Color(153, 153, 153));
        eliminarButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        infoadicField.setColumns(20);
        infoadicField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoadicField.setRows(5);
        jScrollPane2.setViewportView(infoadicField);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Apellidos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombres");

        nombres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        id.setText("id");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Telefono");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Sexo");

        sexField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino", "Otro" }));

        phoneField.setPreferredSize(new java.awt.Dimension(100, 20));
        phoneField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneFieldKeyTyped(evt);
            }
        });

        lastnameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameFieldActionPerformed(evt);
            }
        });

        infoadicLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoadicLabel.setText("Info Adicional");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Fecha de nacimiento");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(nuevoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(id))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(infoadicLabel)
                            .addComponent(jLabel7))
                        .addGap(54, 54, 54)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastnameField)
                                .addComponent(phoneField, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                .addComponent(sexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(borndateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nuevoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(borndateField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(infoadicLabel)
                        .addGap(72, 72, 72))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        if (this.tabla.getRowCount() < 1) {
            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("LA TABLA ESTA VACÍA");
            er.msj1.setText("");
            er.setVisible(true);
        } else {
            System.out.println("id: " + this.id.getText());
            if (this.id.getText().equals("")) {
                ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("SELECCIONA UN");
                er.msj1.setText("REGISTRO");
                er.setVisible(true);
            } else {
                System.out.println("DELETE ");
                ConfirmDialog cd = new ConfirmDialog(new JFrame(), true);
                cd.titulo.setText("DELETE...");
                cd.msj.setText("ESTAS SEGURO ELIMINAR?!");
                cd.msj1.setText("");
                cd.setVisible(true);
                if (cd.YES_OPTION) {
                    int opcion = userData.eliminar(Integer.parseInt(this.id.getText()));
                    if (opcion != 0) {
                        limpiarCampos();
                        this.id.setText("");
                        this.nombres.setText("");
                        this.lastnameField.setText("");
                        this.phoneField.setText("");
                        this.infoadicField.setText("");
                        //this.sexField.setText("");
                        this.nombres.requestFocus();
                        this.guardarButton.setText("REGISTRAR");
                    }
                }
            }
        }

    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void nuevoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoButtonActionPerformed
        // TODO add your handling code here:
        //this.tituloLabel.setText("REGISTRAR");
        this.guardarButton.setText("REGISTRAR");
        this.id.setText("");
        this.nombres.setText("");
        this.lastnameField.setText("");
        this.phoneField.setText("");
        this.infoadicField.setText("");
        //this.sexField.setText("");
        this.nombres.requestFocus();

    }//GEN-LAST:event_nuevoButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed

        if (this.nombres.getText().equals("")) {
            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("FALTAN CAMPOS DE LLENAR");
            er.msj1.setText("");
            er.setVisible(true);

        } else {

            System.out.println("id: " + this.id.getText());
            User s = new User();

            s.setName(this.nombres.getText());
            s.setLastname(this.lastnameField.getText());
            s.setPhone(this.phoneField.getText());
            s.setSex(this.sexField.getSelectedItem().toString());
            //s.setBorndate((Date) this.borndateField.getDate());
            s.setInfoadic(this.infoadicField.getText());
            
            
             /*try {
                date = dformat.parse(test);
                if (!dformat.format(date).equals(test)) {
                    throw new ParseException(test + " is not a valid format for " + Config.DEFAULT_DATE_STRING_FORMAT_PE, 0);
                }
            } catch (ParseException ex1) {
                System.out.println("panel.ParseException error: " + ex1);
                ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("FECHA NO VÁLIDO " + ex1);
                er.msj1.setText("" + test + " is not a valid format for " + Config.DEFAULT_DATE_STRING_FORMAT_PE);
                er.setVisible(true);
            }
            s.setBorndate(date);*/
            if (this.id.getText().equals("")) {
                int opcion = userData.registrar(s);
                if (opcion != 0) {
                    limpiarCampos();
                    this.id.setText("");
                    this.nombres.setText("");
                    this.lastnameField.setText("");
                    this.phoneField.setText("");
                    this.infoadicField.setText("");
                    //this.sexField.setText("");
                    this.nombres.requestFocus();
                    SuccessAlert sa = new SuccessAlert(new JFrame(), true);
                    sa.titulo.setText("¡HECHO!");
                    sa.msj.setText("SE HA REGISTRADO UN");
                    sa.msj1.setText("NUEVO PRODUCTO");
                    sa.setVisible(true);
                }
            } else {
                s.setId(Integer.parseInt(this.id.getText()));
                int opcion = userData.actualizar(s);
                if (opcion != 0) {
                    
                    SuccessAlert sa = new SuccessAlert(new JFrame(), true);
                    sa.titulo.setText("¡HECHO!");
                    sa.msj.setText("SE HAN GUARDADO LOS CAMBIOS");
                    sa.msj1.setText("EN PRODUCTO");
                    sa.setVisible(true);
                    limpiarCampos();
                    this.id.setText("");
                    this.nombres.setText("");
                    this.lastnameField.setText("");
                    this.phoneField.setText("");
                    //this.sexField.setText("");
                    this.nombres.requestFocus();
                }
            }

        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void aSIconButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aSIconButton4ActionPerformed
        
    }//GEN-LAST:event_aSIconButton4ActionPerformed

    private void buscarFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarFieldKeyReleased
        // TODO add your handling code here:
        //Opciones.listar(this.buscarField.getText());
        paintTable(this.buscarField.getText());
    }//GEN-LAST:event_buscarFieldKeyReleased

    private void phoneFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneFieldKeyTyped
        // TODO add your handling code here:
        String filterStr = "0123456789.";
        char c = (char) evt.getKeyChar();
        if (filterStr.indexOf(c) < 0) {
            evt.consume();
        }
    }//GEN-LAST:event_phoneFieldKeyTyped

    private void lastnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private igu.util.buttons.ASIconButton aSIconButton4;
    public static com.toedter.calendar.JDateChooser borndateField;
    private javax.swing.JTextField buscarField;
    private igu.util.buttons.ASIconButton eliminarButton;
    private igu.util.buttons.ASIconButton guardarButton;
    private javax.swing.JLabel id;
    private javax.swing.JTextArea infoadicField;
    private javax.swing.JLabel infoadicLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lastnameField;
    private javax.swing.JTextField nombres;
    private igu.util.buttons.ASIconButton nuevoButton;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JComboBox sexField;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
