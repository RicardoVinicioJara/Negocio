/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidades.Persona;
import Entidades.Telefono;
import Negocio.ContactosON;
import Utils.MyExpetion;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.eclipse.persistence.jpa.jpql.parser.KeyExpression;

/**
 *
 * @author vinic
 */
public class VistaPersonas extends javax.swing.JFrame {

    /**
     * Creates new form VistaPersonas
     */
    private List<Telefono> listTelefono;
    public ContactosON contactosON;
    private int codAux;
    
    public VistaPersonas() throws Exception {
        initComponents();
        listTelefono = new ArrayList<>();
        contactosON = new ContactosON();
        codAux = -500;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controladorCliente = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panelesCrudCliente = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnAgregarTelefono = new javax.swing.JButton();
        telefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        direcion6 = new javax.swing.JLabel();
        comboTelefono = new javax.swing.JComboBox<String>();
        agregarClientes = new javax.swing.JLabel();
        agregarClientes1 = new javax.swing.JLabel();
        btnGuardar1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        listadeClientes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaContacos = new javax.swing.JTable();
        listadeClientes1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        buscarclientes = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        ingreseCedula = new javax.swing.JLabel();
        panelBuscarCliente = new javax.swing.JPanel();
        nombre2 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtNombreB = new javax.swing.JTextField();
        listadeClientes2 = new javax.swing.JLabel();
        nombre6 = new javax.swing.JLabel();
        txtCedulaB = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaContacosB = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        controladorCliente.setFont(new java.awt.Font("Sitka Heading", 2, 24)); // NOI18N
        controladorCliente.setText("CONTROLADOR PERSONAS");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clienteP.png"))); // NOI18N

        panelesCrudCliente.setBackground(new java.awt.Color(0, 204, 102));
        panelesCrudCliente.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panelesCrudClienteStateChanged(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        nombre.setText("NOMBRE:   ");
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 150, -1));

        cedula.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        cedula.setText("CEDULA:   ");
        jPanel1.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 140, -1));

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 146, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 146, -1));

        btnAgregarTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregarTelefono.setForeground(new java.awt.Color(0, 0, 255));
        btnAgregarTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnAgregarTelefono.setText("AGREGAR");
        btnAgregarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        telefono.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        telefono.setText("TELEFONO:");
        jPanel1.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 120, -1));

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 146, -1));

        direcion6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        direcion6.setText("ROL:");
        jPanel1.add(direcion6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 80, -1));

        comboTelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboTelefono.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "CONVENCIONAL", "CELULAR" }));
        jPanel1.add(comboTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 150, -1));

        agregarClientes.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        agregarClientes.setText("TELEFONO");
        jPanel1.add(agregarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        agregarClientes1.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        agregarClientes1.setText("PERSONA");
        jPanel1.add(agregarClientes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        btnGuardar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardar1.setForeground(new java.awt.Color(0, 0, 255));
        btnGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar1.setText("GUARDAR");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 23, 490, 390));

        panelesCrudCliente.addTab("CREAR", jPanel2);

        tabla.setBackground(new java.awt.Color(204, 255, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cedula", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        listadeClientes.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        listadeClientes.setText("LISTA DE PERSONAS");

        tablaContacos.setBackground(new java.awt.Color(204, 255, 255));
        tablaContacos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Telefono", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaContacos);

        listadeClientes1.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        listadeClientes1.setText("CONTACTOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(listadeClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(listadeClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(listadeClientes)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listadeClientes1)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        panelesCrudCliente.addTab("LISTAR ", jPanel3);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscarclientes.setFont(new java.awt.Font("Trebuchet MS", 3, 24)); // NOI18N
        buscarclientes.setText("BUSCAR CLIENTES");
        jPanel6.add(buscarclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 298, 37));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel6.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 64, 153, -1));

        ingreseCedula.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        ingreseCedula.setText("INGRESE CEDULA: ");
        jPanel6.add(ingreseCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 62, 164, 20));

        nombre2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        nombre2.setText("NOMBRE: ");

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        txtNombreB.setEditable(false);

        listadeClientes2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        listadeClientes2.setText("CONTACTOS");

        nombre6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        nombre6.setText("CEDULA:");

        txtCedulaB.setEditable(false);

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/garbage.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        tablaContacosB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NUMERO", "TIPO"
            }
        ));
        tablaContacosB.setEnabled(false);
        jScrollPane4.setViewportView(tablaContacosB);

        javax.swing.GroupLayout panelBuscarClienteLayout = new javax.swing.GroupLayout(panelBuscarCliente);
        panelBuscarCliente.setLayout(panelBuscarClienteLayout);
        panelBuscarClienteLayout.setHorizontalGroup(
            panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                        .addComponent(nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30)
                        .addGap(238, 238, 238))
                    .addGroup(panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                            .addComponent(nombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addGroup(panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCedulaB, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombreB, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addComponent(listadeClientes2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(btnActualizar)
                            .addGap(87, 87, 87)
                            .addComponent(btnEliminar))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelBuscarClienteLayout.setVerticalGroup(
            panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarClienteLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nombre2)
                        .addComponent(txtNombreB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre6)
                    .addComponent(txtCedulaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(listadeClientes2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(196, 196, 196))
        );

        jPanel6.add(panelBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 550, 400));

        panelesCrudCliente.addTab("BUSCAR", jPanel6);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(controladorCliente)
                .addGap(151, 151, 151)
                .addComponent(jLabel17)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelesCrudCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(controladorCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelesCrudCliente))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed

    }//GEN-LAST:event_txtCedulaKeyPressed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        //        if (evt.getKeyCode() != KeyEvent.VK_DELETE) {
        //            if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
        //                evt.consume();
        //            }
        //        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnAgregarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTelefonoActionPerformed
        if (validarTelefono()) {
            listTelefono.add(addTelefono());
            limpiarTelefono();
        }
    }//GEN-LAST:event_btnAgregarTelefonoActionPerformed
    public boolean validarTelefono() {
        
        if (txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingresar un numero de telefono");
            return false;
        }
        if (comboTelefono.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecionar Tipo de telefono");
            return false;
        }
        return true;
    }
    
    public Telefono addTelefono() {
        return new Telefono(0, txtTelefono.getText(), comboTelefono.getSelectedItem().toString(), 0);
    }
    
    public void limpiarTelefono() {
        txtTelefono.setText("");
        comboTelefono.setSelectedIndex(0);
    }
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_DELETE) {
            if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_DELETE) {
            if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void panelesCrudClienteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panelesCrudClienteStateChanged
        int x = panelesCrudCliente.getSelectedIndex();
        if (x == 1) {
            try {
                limpiarTablaCotacto();
                limpiarTabla();
                List<Persona> lista = contactosON.listarContactos();
                DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                int index = 0;
                for (Persona u : lista) {
                    model.insertRow(index, new Object[]{u.getId(), u.getCedula(), u.getNombre()});
                    index++;
                }
            } catch (MyExpetion ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            
        }
    }//GEN-LAST:event_panelesCrudClienteStateChanged
    
    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
    
    public void limpiarTablaCotacto() {
        DefaultTableModel modelo = (DefaultTableModel) tablaContacos.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
    
    public void limpiarTablaCotactoB() {
        DefaultTableModel modelo = (DefaultTableModel) tablaContacosB.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        if (validarPersona()) {
            try {
                contactosON.guardadoContacto(addPersona());
                JOptionPane.showMessageDialog(this, "Contacto Ingresado");
                limpiarCrear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            
        }
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        try {
            List<Telefono> lista = contactosON.listarTelefonos(Integer.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0) + ""));
            limpiarTablaCotacto();
            DefaultTableModel model = (DefaultTableModel) tablaContacos.getModel();
            int index = 0;
            for (Telefono u : lista) {
                model.insertRow(index, new Object[]{u.getId(), u.getNumero(), u.getTipo()});
                index++;
            }
        } catch (MyExpetion ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_tablaMouseClicked

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            try {
                Persona p = contactosON.buscarPersonaCedula(txtBuscar.getText());
                codAux = p.getId();
                txtNombreB.setText(p.getNombre());
                txtCedulaB.setText(p.getCedula());
                List<Telefono> lista = p.getListaTelefonos();
                if (!lista.isEmpty()) {
                    limpiarTablaCotactoB();
                    DefaultTableModel model = (DefaultTableModel) tablaContacosB.getModel();
                    int index = 0;
                    for (Telefono u : lista) {
                        model.insertRow(index, new Object[]{u.getId(), u.getNumero(), u.getTipo()});
                        index++;
                    }
                    btnEliminar.setEnabled(true);
                    btnActualizar.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "La persona no tiene telefonos");
                    btnEliminar.setEnabled(true);
                    btnActualizar.setEnabled(true);
                }
            } catch (MyExpetion ex) {
                limpiarBuscar();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Seguro desea Eliminar") == JOptionPane.OK_OPTION) {
            try {
                Persona p = contactosON.buscarPersonaCedula(txtCedulaB.getText());
                contactosON.eliminarPersona(p);
                limpiarBuscar();
                JOptionPane.showMessageDialog(this, "Persona Eliminada");
            } catch (MyExpetion e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    public void limpiarBuscar() {
        txtBuscar.setText("");
        txtCedulaB.setText("");
        txtNombreB.setText("");
        limpiarTablaCotactoB();
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnActualizar.setText("ACTUALIZAR");
    }
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (btnActualizar.getText().equals("ACTUALIZAR")) {
            btnActualizar.setText("GUARDAR");
            btnEliminar.setEnabled(true);
            txtCedulaB.setEditable(true);
            txtNombreB.setEditable(true);
            tablaContacosB.setEnabled(true);
        } else {
            try {
                Persona p = new Persona(codAux, txtCedulaB.getText(), txtNombreB.getText(), listaTelefonos());
                contactosON.actualizarContacto(p);
                JOptionPane.showMessageDialog(this, "Persona Actualizada");
                limpiarBuscar();
            } catch (MyExpetion e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed
    public void limpiarCrear() {
        listTelefono.clear();
        txtCedula.setText("");
        txtNombre.setText("");
        limpiarTelefono();
        comboTelefono.setSelectedIndex(0);
    }
    
    public List<Telefono> listaTelefonos() {
        List<Telefono> lista = new ArrayList<>();
        for (int i = 0; i < tablaContacosB.getRowCount(); i++) {
            int id = (int) tablaContacosB.getValueAt(i, 0);
            String numero = (String) tablaContacosB.getValueAt(i, 1);
            String tipo = (String) tablaContacosB.getValueAt(i, 2);
            lista.add(new Telefono(id, numero, tipo, codAux));
        }
        return lista;
    }
    
    public Persona addPersona() {
        return new Persona(0, txtCedula.getText(), txtNombre.getText(), listTelefono);
    }
    
    public boolean validarPersona() {
        if (txtCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingres una cedula");
            return false;
        }
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingres un Nombre");
            return false;
        }
        if (listTelefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Agrenar un telefono o mas ...");
            return false;
        }
        return true;
    }

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
            java.util.logging.Logger.getLogger(VistaPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaPersonas().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(VistaPersonas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agregarClientes;
    private javax.swing.JLabel agregarClientes1;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarTelefono;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JLabel buscarclientes;
    private javax.swing.JLabel cedula;
    private javax.swing.JComboBox<String> comboTelefono;
    private javax.swing.JLabel controladorCliente;
    private javax.swing.JLabel direcion6;
    private javax.swing.JLabel ingreseCedula;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel listadeClientes;
    private javax.swing.JLabel listadeClientes1;
    private javax.swing.JLabel listadeClientes2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel nombre2;
    private javax.swing.JLabel nombre6;
    private javax.swing.JPanel panelBuscarCliente;
    private javax.swing.JTabbedPane panelesCrudCliente;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaContacos;
    private javax.swing.JTable tablaContacosB;
    private javax.swing.JLabel telefono;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedulaB;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreB;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
