/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoDatos.AccesoMembresia;
import AccesoDatos.AccesoSocio;
import Entidades.Membresia;
import Entidades.Socio;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Fabri
 */
public class VistaSocio extends javax.swing.JInternalFrame {

    private Socio socio = null;
    private Membresia membresia = null;
    private AccesoSocio as = null;
    private AccesoMembresia am = null;
    private DefaultTableModel tabla;

    public VistaSocio() {
        initComponents();
        as = new AccesoSocio();
        am = new AccesoMembresia();
        ocultarModificar();
        ocultarEliminar();
        txtIdSocio.requestFocus();
        desactivarCampos();
        btnGuardar.setEnabled(false);
        //===========Lado Derecho===========
        tabla = new DefaultTableModel();
        pintarColumnasTabla();
        limpiarTabla();
        txtFiltro.setEnabled(false);
        // ======== QUITAR BORDES INTERNAL FRAME =========
        quitarBordeJInternalFrame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtIdSocio = new javax.swing.JTextField();
        lblIdSocio = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblDniSocio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDniSocio = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JLabel();
        btnModificar = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbFiltro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFiltro = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(214, 236, 225));
        jPanel1.setLayout(null);

        txtIdSocio.setBackground(new java.awt.Color(28, 89, 59));
        txtIdSocio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtIdSocio.setForeground(new java.awt.Color(255, 255, 255));
        txtIdSocio.setBorder(null);
        txtIdSocio.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtIdSocio.setOpaque(false);
        txtIdSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdSocioKeyReleased(evt);
            }
        });
        jPanel1.add(txtIdSocio);
        txtIdSocio.setBounds(150, 110, 60, 30);

        lblIdSocio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblIdSocio.setText("ID SOCIO");
        jPanel1.add(lblIdSocio);
        lblIdSocio.setBounds(20, 110, 120, 35);

        lblNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNombre.setText("NOMBRE");
        jPanel1.add(lblNombre);
        lblNombre.setBounds(20, 230, 120, 35);

        lblApellido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblApellido.setText("APELLIDO");
        jPanel1.add(lblApellido);
        lblApellido.setBounds(20, 290, 120, 35);

        lblEdad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblEdad.setText("EDAD");
        jPanel1.add(lblEdad);
        lblEdad.setBounds(20, 350, 120, 35);

        lblDniSocio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDniSocio.setText("DNI SOCIO");
        jPanel1.add(lblDniSocio);
        lblDniSocio.setBounds(20, 170, 120, 35);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel3.setText("SOCIO");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(230, 20, 95, 36);

        lblCorreo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblCorreo.setText("CORREO");
        jPanel1.add(lblCorreo);
        lblCorreo.setBounds(20, 410, 120, 35);

        lblTelefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTelefono.setText("TELEFONO");
        jPanel1.add(lblTelefono);
        lblTelefono.setBounds(20, 470, 120, 35);

        txtTelefono.setBackground(new java.awt.Color(28, 89, 59));
        txtTelefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBorder(null);
        txtTelefono.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtTelefono.setOpaque(false);
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(150, 470, 200, 35);

        txtCorreo.setBackground(new java.awt.Color(28, 89, 59));
        txtCorreo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setBorder(null);
        txtCorreo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtCorreo.setOpaque(false);
        jPanel1.add(txtCorreo);
        txtCorreo.setBounds(150, 410, 200, 30);

        txtEdad.setBackground(new java.awt.Color(28, 89, 59));
        txtEdad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtEdad.setForeground(new java.awt.Color(255, 255, 255));
        txtEdad.setBorder(null);
        txtEdad.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtEdad.setOpaque(false);
        jPanel1.add(txtEdad);
        txtEdad.setBounds(150, 350, 60, 30);

        txtApellido.setBackground(new java.awt.Color(28, 89, 59));
        txtApellido.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setBorder(null);
        txtApellido.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtApellido.setOpaque(false);
        jPanel1.add(txtApellido);
        txtApellido.setBounds(150, 290, 200, 30);

        txtNombre.setBackground(new java.awt.Color(28, 89, 59));
        txtNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(null);
        txtNombre.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtNombre.setOpaque(false);
        jPanel1.add(txtNombre);
        txtNombre.setBounds(150, 230, 200, 30);

        txtDniSocio.setBackground(new java.awt.Color(28, 89, 59));
        txtDniSocio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtDniSocio.setForeground(new java.awt.Color(255, 255, 255));
        txtDniSocio.setBorder(null);
        txtDniSocio.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtDniSocio.setOpaque(false);
        jPanel1.add(txtDniSocio);
        txtDniSocio.setBounds(150, 170, 200, 30);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/ELIMINAR_2_PULSADO.png"))); // NOI18N
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(400, 600, 100, 40);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/BUSCAR.png"))); // NOI18N
        btnBuscar.setText("jLabel1");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        jPanel1.add(btnBuscar);
        btnBuscar.setBounds(320, 100, 150, 50);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/NUEVO.png"))); // NOI18N
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        jPanel1.add(btnNuevo);
        btnNuevo.setBounds(30, 600, 100, 40);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/MODIFICAR.png"))); // NOI18N
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        jPanel1.add(btnModificar);
        btnModificar.setBounds(280, 600, 100, 40);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/GUARDAR.png"))); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(150, 600, 100, 40);

        jPanel2.setBackground(new java.awt.Color(214, 236, 225));

        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "IDSocio", "DNI", "Nombre", "Apellido" }));
        cbFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFiltroItemStateChanged(evt);
            }
        });

        tbFiltro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Socio", "Dni", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFiltro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFiltroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFiltro);

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel2.setText("LISTA DE MEMBRESÍAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:
        if ( !txtIdSocio.isEnabled() ) {
        txtIdSocio.setEnabled(true);
        txtIdSocio.requestFocus();
            return;
        }
        socio = null;
        try {
            //Le doy prioridad al campo ID
            if (validaLleno(txtIdSocio.getText()) && validaEnteroPositivo(txtIdSocio.getText())) {
                socio = as.buscarSocio(Integer.parseInt(txtIdSocio.getText()));
            } else if (validaLleno(txtDniSocio.getText()) && validaEnteroPositivo(txtDniSocio.getText())) {
                socio = as.buscarSocioPorDni(txtDniSocio.getText());
            } else {
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Debe completar con enteros positivos el campo Id o Dni para realizar la busqueda");
            }
            if (socio != null) {
                cargarDatosTxt(socio);
                ocultarModificar();
            }

        } catch (Exception e) {
            System.out.println("" + e);
        }

    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        // TODO add your handling code here:

        try {
            limpiarCampos();
            activarCampos();
            btnGuardar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            txtIdSocio.setEnabled(false);
            txtIdSocio.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "" + e);
        }
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        // TODO add your handling code here:
        boolean flag = false;
        //Modifica socio con ID y estado true
        if (!btnModificar.isEnabled()) {
            return;
        }
        socio = new Socio();
        try {
            if (!camposLlenos()) {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos");
                return;
            }
            //modificar Socio(socio);
            if (cargarSocio(socio)) {

               flag = as.modificarSocio(socio);
            }
            txtIdSocio.requestFocus();
            if( flag )limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar socio: " + e);
        }

    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // TODO add your handling code here:
        boolean flag = false;
        if (!btnEliminar.isEnabled()) {
            return;
        }
        socio = new Socio();
        try {
            if (txtIdSocio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe completar el campo ID para eliminacion de Socio");
                txtIdSocio.setText("");
                txtIdSocio.requestFocus();
                return;
            }
            if ( !validaEnteroPositivo(txtIdSocio.getText()) ) {
                JOptionPane.showMessageDialog(this, "El campo id debe ser un numero natural");
                txtIdSocio.setText("");
                txtIdSocio.requestFocus();
                return;
            }
            socio = (((Socio) as.buscarSocio(Integer.parseInt(txtIdSocio.getText()))));
            membresia = am.buscarMembresiaPorIdSocio(socio.getIdSocio());

            if (socio == null) {
                return;
            }
            cargarDatosTxt(socio);
            // Mostrar el cuadro de diálogo de confirmación
            int opcion = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar al socio con ID; " + socio.getIdSocio(), "Confirma eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcion == 0) {
                flag = as.eliminarSocio(socio.getIdSocio());
            }
            txtIdSocio.requestFocus();
            if (flag) {
                am.eliminarMembresia(membresia.getIdMembresia());
                limpiarCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar socio: " + e);
        }

    }//GEN-LAST:event_btnEliminarMouseClicked

    private void txtIdSocioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdSocioKeyReleased
        // TODO add your handling code here:
       ocultarGuardar();
        ocultarEliminar();
        ocultarModificar();
        limpiarCamposMenosId();
    }//GEN-LAST:event_txtIdSocioKeyReleased

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        boolean flag = false;
        if (!btnGuardar.isEnabled()) {
            return;
        }
        socio = new Socio();
        try {
            if (!camposLlenos()) {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos");
                return;
            }
            //cargarSocio(socio);
            if (cargarSocio(socio)) {
               flag =  as.guardarSocio(socio);
            }
            txtIdSocio.requestFocus();
            if(flag )limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar socio: " + e);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void cbFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFiltroItemStateChanged
        // TODO add your handling code here:
        String seleccion = (String) cbFiltro.getSelectedItem();
        txtFiltro.setText("");
        txtFiltro.requestFocus();
        //Listar completo en todas las opciones
        switch (seleccion) {
            case "IDSocio":
                listarTabla( as.listarSocioIdOrdenado() );
                break;
            case "DNI":
               listarTabla( as.listarSocioDniOrdenado() );
                break;
            case "Nombre":
                listarTabla( as.listarSocioNombreOrdenado() );
                break;
            case "Apellido":
                listarTabla( as.listarSocioApellidoOrdenado() );
                break;
        }
        txtFiltro.setEnabled(true);
    }//GEN-LAST:event_cbFiltroItemStateChanged

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        String seleccion = (String) cbFiltro.getSelectedItem();
        String text = txtFiltro.getText();
        
        if (text.trim().length() == 0) {
            return;
        } 
        //Listar where txt == 
        switch (seleccion) {
            case "IDSocio":
                listarTabla( as.listarSocioIdFiltro(Integer.parseInt(text)));
                break;
            case "DNI":
                listarTabla( as.listarSocioDniFiltro(text));
                break;
            case "Nombre":
                 listarTabla( as.listarSocioNombreFiltro(text));
                break;
            case "Apellido":
                 listarTabla( as.listarSocioApellidoFiltro(text));
                break;
        
        }
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void tbFiltroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFiltroMouseClicked
        // TODO add your handling code here:
          socio = new Socio();

        if (evt.getClickCount() == 2) {
            int filaSeleccionada = tbFiltro.getSelectedRow();

            if (filaSeleccionada != -1) {
                int id = (Integer) tabla.getValueAt(filaSeleccionada, 0);

                socio = as.buscarSocio(id);
                cargarDatosTxt(socio);
                activarCampos();
                ocultarModificar();
                ocultarEliminar();
            }
    }     
    }//GEN-LAST:event_tbFiltroMouseClicked

///=============Metodos================
    private void cargarDatosTxt(Socio socio) {
        txtIdSocio.setText(String.valueOf(socio.getIdSocio()));
        txtDniSocio.setText(socio.getDni());
        txtNombre.setText(socio.getNombre());
        txtApellido.setText(socio.getApellido());
        txtEdad.setText(String.valueOf(socio.getEdad()));
        txtCorreo.setText(socio.getCorreo());
        txtTelefono.setText(socio.getTelefono());
    }

    private boolean camposLlenos() { //Menos id
        return !txtDniSocio.getText().isEmpty()
                && !txtNombre.getText().isEmpty()
                && !txtApellido.getText().isEmpty()
                && !txtEdad.getText().isEmpty()
                && !txtCorreo.getText().isEmpty()
                && !txtTelefono.getText().isEmpty();
    }

    private boolean cargarSocio(Socio socio) { //Sin ID

        boolean validaciones = true;

        //Carga de ID
        if (!txtIdSocio.getText().isEmpty() && validaEnteroPositivo(txtIdSocio.getText())) {
            socio.setIdSocio(Integer.parseInt(txtIdSocio.getText()));
        }

        //Validaciones campos solo letras
        if (validaSoloLetras(txtNombre.getText()) && validaSoloLetras(txtApellido.getText()) && validaciones) {
            socio.setNombre(txtNombre.getText());
            socio.setApellido(txtApellido.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Los campos nombre y apellido reciben solo letras");
            return false;
        }
        //validacion correo
        if (validaEmail(txtCorreo.getText()) && validaciones) {
            socio.setCorreo(txtCorreo.getText());
        } else {
            JOptionPane.showMessageDialog(this, "El campo correo debe tener la sintaxis 'correo@correo.com' ");
            return false;
        }

        //Validacion edad
        if (validaNatural(txtEdad.getText()) && validaciones) {
            socio.setEdad(Integer.parseInt(txtEdad.getText()));
        } else {
            JOptionPane.showMessageDialog(this, "El campo edad debe ser numerico y estar entre 1-99");
            return false;
        }

        //Validacion de telefono y dni
        if (validaEnteroPositivo(txtTelefono.getText()) && validaEnteroPositivo(txtDniSocio.getText()) && validaciones) {
            socio.setDni(txtDniSocio.getText());
            socio.setTelefono(txtTelefono.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Los campos Telefono y Dni solo permiten enteros positivos");
            return false;
        }
        socio.setEstado(true);

        ocultarModificar();

        return validaciones;
    }

    private void limpiarCampos() {
        txtIdSocio.setText("");
        txtDniSocio.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
    }
    private void limpiarCamposMenosId() {
        txtDniSocio.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
    }

    //=================Manejo de Botones================
    private void ocultarGuardar() {
        if (!txtIdSocio.getText().isEmpty()) {
            btnGuardar.setEnabled(false);
        } else {
            btnGuardar.setEnabled(true);
        }
    }

    private void ocultarModificar() {
        if (!txtIdSocio.getText().isEmpty() && !txtDniSocio.getText().isEmpty()) {
            btnModificar.setEnabled(true);
        } else {
            btnModificar.setEnabled(false);
        }
    }

    private void ocultarEliminar() {
        if (!txtIdSocio.getText().isEmpty()) {
            btnEliminar.setEnabled(true);
        } else {
            btnEliminar.setEnabled(false);
        }
    }
      private void ocultarBotonesMenosNuevo(){
        
           btnGuardar.setEnabled(false);
           btnModificar.setEnabled(false);
           btnEliminar.setEnabled(false);
    }

    private void desactivarCampos() {

        txtNombre.setEditable(false);
        txtApellido.setEditable(false);
        txtEdad.setEditable(false);
        txtCorreo.setEditable(false);
        txtTelefono.setEditable(false);
    }

    private void activarCampos() {

        txtNombre.setEditable(true);
        txtApellido.setEditable(true);
        txtEdad.setEditable(true);
        txtCorreo.setEditable(true);
        txtTelefono.setEditable(true);
    }
    
    private void resetFiltros() {
        txtFiltro.setText("");
        cbFiltro.setSelectedIndex(0);
    }

    //=========================Metodos de Validaciones====================
    //Valida un campo lleno
    private boolean validaLleno(String txt) {
        return !txt.isEmpty();
    }

    //valida entre 1-99
    private boolean validaNatural(String nro) {
        Pattern patron = Pattern.compile("^(?:[1-9]|[1-9][0-9])$");
        Matcher m = patron.matcher(nro);
        return m.matches();
    }

    //Metodo valida email con @ y .com
    private boolean validaEmail(String email) {
        Pattern patron = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.com$");
        Matcher m = patron.matcher(email);
        return m.matches();
    }

    //Metodo valida letras
    private boolean validaSoloLetras(String texto) {
        Pattern patron = Pattern.compile("^[a-zA-Z\\s]+$");
        Matcher m = patron.matcher(texto);
        return m.matches();
    }

    private boolean validaEnteroPositivo(String nro) {
        Pattern patron = Pattern.compile("^\\d+$");
        Matcher m = patron.matcher(nro);
        return m.matches();
    }

    //================Metodos tabla====================
    private void pintarColumnasTabla() {
        tabla = (DefaultTableModel) tbFiltro.getModel();

    }

    //Limpieza de la tabla
    public void limpiarTabla() {
        int filas = tabla.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            tabla.removeRow(i);
        }
    }

    public void listarTabla(List<Socio> lista) {
        limpiarTabla();
        for (Socio s : lista ) {

            tabla.addRow(new Object[]{s.getIdSocio(), s.getDni(), s.getNombre(), s.getApellido()});
        }
    }
// ================ QUITAR BORDES DE JINTERNAL ====================================
    private void quitarBordeJInternalFrame() {
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
    }
    // Método para manejar el evento de cambio en el JComboBox
// Método para manejar el evento de entrada en el JTextField

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnModificar;
    private javax.swing.JLabel btnNuevo;
    private javax.swing.JComboBox<String> cbFiltro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDniSocio;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblIdSocio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tbFiltro;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDniSocio;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtIdSocio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
