/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoDatos.AccesoClase;
import AccesoDatos.AccesoClase;
import AccesoDatos.AccesoEntrenador;
import Entidades.Clase;
import Entidades.Entrenador;
import Entidades.Clase;
import java.time.LocalTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabri
 */
public class VistaClase extends javax.swing.JInternalFrame {

    private Clase clase = null;
    private AccesoClase ac = null;
    private AccesoEntrenador ae = null;
    private DefaultTableModel tabla;

    public VistaClase() {
        initComponents();
        ac = new AccesoClase();
        ae = new AccesoEntrenador();
        //cargarEntrenadoresCombo();
        ocultarModificar();
        ocultarEliminar();
        txtIdClase.requestFocus();
        desactivarCampos();
        btnGuardar.setEnabled(false);
        //===========Lado Derecho===========
        tabla = new DefaultTableModel();
        pintarColumnasTabla();
        limpiarTabla();
        txtFiltro.setEnabled(false);
        // --------- quitar bodreds de internal
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
        lblIdClase = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblEntrenador = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        lblCapacidad = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHorario = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCapacidad = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();
        txtIdClase = new javax.swing.JTextField();
        btnModificar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        cbEntrenadores = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbFiltro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFiltro = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(214, 236, 225));
        jPanel1.setLayout(null);

        lblIdClase.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblIdClase.setForeground(new java.awt.Color(28, 89, 59));
        lblIdClase.setText("ID CLASE");
        jPanel1.add(lblIdClase);
        lblIdClase.setBounds(20, 110, 120, 35);

        lblNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(28, 89, 59));
        lblNombre.setText("NOMBRE");
        jPanel1.add(lblNombre);
        lblNombre.setBounds(20, 180, 120, 35);

        lblEntrenador.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblEntrenador.setForeground(new java.awt.Color(28, 89, 59));
        lblEntrenador.setText("ENTRENADOR");
        jPanel1.add(lblEntrenador);
        lblEntrenador.setBounds(20, 380, 130, 35);

        lblHorario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblHorario.setForeground(new java.awt.Color(28, 89, 59));
        lblHorario.setText("HORARIO");
        jPanel1.add(lblHorario);
        lblHorario.setBounds(20, 240, 120, 35);

        lblCapacidad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblCapacidad.setForeground(new java.awt.Color(28, 89, 59));
        lblCapacidad.setText("CAPACIDAD");
        jPanel1.add(lblCapacidad);
        lblCapacidad.setBounds(20, 310, 120, 35);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(28, 89, 59));
        jLabel3.setText("CLASES");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(165, 20, 160, 36);

        txtHorario.setBackground(new java.awt.Color(28, 89, 59));
        txtHorario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtHorario.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario.setBorder(null);
        txtHorario.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtHorario.setOpaque(false);
        jPanel1.add(txtHorario);
        txtHorario.setBounds(140, 240, 200, 30);

        txtNombre.setBackground(new java.awt.Color(28, 89, 59));
        txtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(null);
        txtNombre.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtNombre.setOpaque(false);
        jPanel1.add(txtNombre);
        txtNombre.setBounds(140, 180, 200, 30);

        txtCapacidad.setBackground(new java.awt.Color(28, 89, 59));
        txtCapacidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCapacidad.setForeground(new java.awt.Color(255, 255, 255));
        txtCapacidad.setBorder(null);
        txtCapacidad.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtCapacidad.setOpaque(false);
        jPanel1.add(txtCapacidad);
        txtCapacidad.setBounds(140, 310, 200, 30);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/BUSCAR.png"))); // NOI18N
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

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/GUARDAR.png"))); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(150, 600, 100, 40);

        txtIdClase.setBackground(new java.awt.Color(28, 89, 59));
        txtIdClase.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdClase.setForeground(new java.awt.Color(255, 255, 255));
        txtIdClase.setBorder(null);
        txtIdClase.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtIdClase.setOpaque(false);
        txtIdClase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdClaseKeyReleased(evt);
            }
        });
        jPanel1.add(txtIdClase);
        txtIdClase.setBounds(140, 110, 70, 30);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/MODIFICAR.png"))); // NOI18N
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        jPanel1.add(btnModificar);
        btnModificar.setBounds(280, 600, 100, 40);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/ELIMINAR_2_PULSADO.png"))); // NOI18N
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(400, 600, 100, 40);

        cbEntrenadores.setBackground(new java.awt.Color(28, 89, 59));
        cbEntrenadores.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbEntrenadores.setForeground(new java.awt.Color(28, 89, 59));
        jPanel1.add(cbEntrenadores);
        cbEntrenadores.setBounds(170, 380, 200, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/Brackground_internal.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-3, -4, 530, 700);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 520, 700);

        jPanel2.setBackground(new java.awt.Color(214, 236, 225));
        jPanel2.setLayout(null);

        cbFiltro.setBackground(new java.awt.Color(28, 89, 59));
        cbFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbFiltro.setForeground(new java.awt.Color(28, 89, 59));
        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "IdClase", "Nombre", "Horario", "Capacidad", "Entrenador" }));
        cbFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFiltroItemStateChanged(evt);
            }
        });
        jPanel2.add(cbFiltro);
        cbFiltro.setBounds(259, 80, 167, 30);

        tbFiltro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Clase", "Nombre", "Hora", "Capacidad", "Entrenador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(40, 150, 420, 463);

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });
        jPanel2.add(txtFiltro);
        txtFiltro.setBounds(35, 80, 206, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(28, 89, 59));
        jLabel2.setText("LISTA DE CLASES");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(125, 26, 258, 36);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/Brackground_internal.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, -4, 520, 710);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(506, 0, 530, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:

        if (!txtIdClase.isEnabled()) {
            txtIdClase.setEnabled(true);
            btnGuardar.setEnabled(false);
            txtIdClase.requestFocus();
            return;
        }
        clase = null;
        try {
            if (validaLleno(txtIdClase.getText()) && validaEnteroPositivo(txtIdClase.getText())) {
                clase = ac.buscarClase(Integer.parseInt(txtIdClase.getText()));

            } else {
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Debe completar con enteros positivos el campo Id para realizar la busqueda");
            }
            if (clase != null) {
                cargarDatosTxt(clase);
                ocultarModificar();
                activarCampos();
            }
            if (clase == null) {
                btnModificar.setEnabled(false);
                txtIdClase.setText("");
                txtIdClase.requestFocus();
            }
            resetFiltros();

        } catch (Exception e) {
            System.out.println("" + e);
        }

    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        // TODO add your handling code here:
        try {
            cargarEntrenadoresCombo();
            limpiarCampos();
            activarCampos();
            ocultarGuardar();
            txtIdClase.setEnabled(false);
            txtIdClase.requestFocus();
            resetFiltros();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "" + e);
        }
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        boolean flag = false;
        // TODO add your handling code here:
        if (!btnModificar.isEnabled()) {
            return;
        }
        clase = new Clase();
        try {
            if (!camposLlenos()) {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos");
                txtIdClase.setText("");
                txtIdClase.requestFocus();
                return;
            }
            if ( !validaNatural(txtIdClase.getText()) ) {
                JOptionPane.showMessageDialog(this, "El campo id debe ser un numero natural");
                txtIdClase.setText("");
                txtIdClase.requestFocus();
                return;
            }
            //modificar Clase(clase);
            if (cargarClase(clase)) {

                flag = ac.modificarClase(clase);
            }
            txtIdClase.requestFocus();
            if (flag) {
                limpiarCampos();
                ocultarBotonesMenosNuevo();
                resetFiltros();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar clase: " + e);
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

        // TODO add your handling code here:
        boolean flag = false;
        if (!btnEliminar.isEnabled()) {
            return;
        }
        clase = new Clase();
        try {
            if (txtIdClase.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe completar el campo ID para eliminacion de Clase");
                txtIdClase.setText("");
                txtIdClase.requestFocus();
                return;
            }
            if ( !validaNatural(txtIdClase.getText()) ) {
                JOptionPane.showMessageDialog(this, "El campo id debe ser un numero natural");
                txtIdClase.setText("");
                txtIdClase.requestFocus();
                return;
            }
            
            
                
                clase = (((Clase) ac.buscarClase(Integer.parseInt(txtIdClase.getText()))));
            
            if (clase == null) {
                return;
            }
            cargarDatosTxt(clase);
            // Mostrar el cuadro de diálogo de confirmación
            int opcion = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar al clase con ID; " + clase.getIdClase(), "Confirma eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcion == 0) {
                ac.eliminarClase(clase.getIdClase());
            }
            if (flag) {
            txtIdClase.requestFocus();
            ocultarBotonesMenosNuevo();
                ocultarBotonesMenosNuevo();
                resetFiltros();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar clase: " + e);
        }

    }//GEN-LAST:event_btnEliminarMouseClicked

    private void txtIdClaseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClaseKeyReleased
        // TODO add your handling code here:
        ocultarGuardar();
        ocultarEliminar();
        ocultarModificar();
        limpiarCamposMenosId();
    }//GEN-LAST:event_txtIdClaseKeyReleased

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
        boolean flag = false;
        if (!btnGuardar.isEnabled()) {
            return;
        }
        clase = new Clase();
        try {
            if (!camposLlenos()) {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos");
                return;
            }
            //cargarClase(clase);
            if (cargarClase(clase)) {
                flag = ac.guardarClase(clase);

            }
            txtIdClase.requestFocus();
            if (flag) {
                ocultarBotonesMenosNuevo();
                resetFiltros();
                limpiarCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar clase: " + e);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void cbFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFiltroItemStateChanged
        // TODO add your handling code here:
        String seleccion = (String) cbFiltro.getSelectedItem();
        txtFiltro.setText("");
        txtFiltro.requestFocus();
        //Listar completo en todas las opciones
        switch (seleccion) {
            case "IdClase":
                listarTabla(ac.listarClaseIdOrdenado());
                break;
            case "Nombre":
                listarTabla(ac.listarClaseNombreOrdenado());
                break;
            case "Horario":
                listarTabla(ac.listarClaseHorarioOrdenado());
                break;
            case "Capacidad":
                listarTabla(ac.listarClaseCapacidadOrdenado());
                break;
            case "Entrenador":
                listarTabla(ac.listarClaseEntrenadorOrdenado());
                break;
            default:
                listarTabla(ac.listarClases());
                break;
        }
        txtFiltro.setEnabled(true);
    }//GEN-LAST:event_cbFiltroItemStateChanged

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        String seleccion = (String) cbFiltro.getSelectedItem();
        String text = txtFiltro.getText();

        if (text.trim().length() == 0) {
            listarTabla(ac.listarClases());
            return;
        }
        //Listar where txt == 
        switch (seleccion) {
            case "IdClase":
                listarTabla(ac.listarClaseIdFiltro(Integer.parseInt(text)));
                break;
            case "Capacidad":
                listarTabla(ac.listarClaseCapacidadFiltro(Integer.parseInt(text)));
                break;
            case "Nombre":
                listarTabla(ac.listarClaseNombreFiltro(text));
                break;
            case "Entrenador":
                listarTabla(ac.listarClaseEntrenadorFiltro(text));
                break;
            case "Horario":
                listarTabla(ac.listarClaseHorarioFiltro(Integer.parseInt(text)));
                break;
            default:
                listarTabla(ac.listarClases());
                break;

        }
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void tbFiltroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFiltroMouseClicked
        // TODO add your handling code here:
        clase = new Clase();

        if (evt.getClickCount() == 2) {
            int filaSeleccionada = tbFiltro.getSelectedRow();

            if (filaSeleccionada != -1) {
                int id = (Integer) tabla.getValueAt(filaSeleccionada, 0);

                clase = ac.buscarClase(id);
                cargarDatosTxt(clase);
                activarCampos();
                ocultarModificar();
                ocultarEliminar();
            }
    }//GEN-LAST:event_tbFiltroMouseClicked
    }
//=================Metodos=============================

    private boolean cargarClase(Clase clase) { //Sin ID

        boolean validaciones = true;
        Entrenador entrenador = new Entrenador();

        //Carga de ID
        if (!txtIdClase.getText().isEmpty() && validaEnteroPositivo(txtIdClase.getText())) {
            clase.setIdClase(Integer.parseInt(txtIdClase.getText()));
        }

        //Validaciones campos solo letras
        if (validaSoloLetras(txtNombre.getText()) && validaciones) {
            clase.setNombre(txtNombre.getText());

        } else {
            JOptionPane.showMessageDialog(this, "El campo nombre recibe solo letras");
            return false;
        }

        //Validacion numerica
        if (validaNatural(txtCapacidad.getText()) && validaciones) {
            clase.setCapacidad(Integer.parseInt(txtCapacidad.getText().trim()));
        } else {
            JOptionPane.showMessageDialog(this, "El campo capacidad  debe ser numerico y estar entre 1-99");
            return false;
        }

        //Validacion Hora
        if (validaHora(txtHorario.getText().substring(0, 2)) && validaciones) {
            clase.setHorario(LocalTime.of(Integer.parseInt((txtHorario.getText().substring(0, 2))), 0));
        } else {
            JOptionPane.showMessageDialog(this, "El campo horario debe ser un numero de dos digitos y estar entre 00 y 23");
            return false;
        }

        //Validacion cb entrenadores
        if (validaciones && cbEntrenadores.getSelectedIndex() > 0) {
            entrenador = (Entrenador) cbEntrenadores.getSelectedItem();
            clase.setEntrenador(entrenador);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un entrenador");
            return false;
        }

        clase.setEstado(true);

        ocultarModificar();

        return validaciones;
    }

    private void cargarEntrenadoresCombo() {
        // Despliegue de lista de entrenadores
        cbEntrenadores.removeAllItems();
        for (Entrenador e : ae.listarEntrenador()) {
            cbEntrenadores.addItem(e);
        }
        cbEntrenadores.setSelectedIndex(1);
    }

    //=================Manejo de Botones================
    private void ocultarGuardar() {
        if (!txtIdClase.getText().isEmpty()) {
            btnGuardar.setEnabled(false);
        } else {
            btnGuardar.setEnabled(true);
        }
    }

    private void ocultarModificar() {
        if (!txtIdClase.getText().isEmpty()) {
            btnModificar.setEnabled(true);
        } else {
            btnModificar.setEnabled(false);
        }
    }

    private void ocultarEliminar() {
        if (!txtIdClase.getText().isEmpty()) {
            btnEliminar.setEnabled(true);
        } else {
            btnEliminar.setEnabled(false);
        }
    }

    private void ocultarBotonesMenosNuevo() {

        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    private void desactivarCampos() {

        txtNombre.setEditable(false);
        txtCapacidad.setEditable(false);
        //txtEntrenador.setEditable(false);
        txtHorario.setEditable(false);
    }

    private void activarCampos() {

        txtNombre.setEditable(true);
        txtCapacidad.setEditable(true);
        //txtEntrenador.setEditable(true);
        txtHorario.setEditable(true);
    }

    private void limpiarCampos() {
        txtIdClase.setText("");
        txtCapacidad.setText("");
        txtNombre.setText("");
        cbEntrenadores.setSelectedIndex(-1);
        txtHorario.setText("");
    }

    private void limpiarCamposMenosId() {
        txtCapacidad.setText("");
        txtNombre.setText("");
        cbEntrenadores.setSelectedIndex(-1);
        txtHorario.setText("");
    }

    private void cargarDatosTxt(Clase clase) {
        txtIdClase.setText(String.valueOf(clase.getIdClase()));
        txtCapacidad.setText(String.valueOf(clase.getCapacidad()));
        txtNombre.setText(clase.getNombre());
        txtHorario.setText(String.valueOf(clase.getHorario() + " Hs"));
        cargarEntrenadoresCombo();
        // Establecer el entrenador seleccionado en el JComboBox
        for (int i = 0; i < cbEntrenadores.getItemCount(); i++) {
            Entrenador entrenador = (Entrenador) cbEntrenadores.getItemAt(i);
            if (entrenador.getIdEntrenador() == clase.getEntrenador().getIdEntrenador()) {
                cbEntrenadores.setSelectedIndex(i);
                break;
            }
        }

    }

    private boolean camposLlenos() { //Menos id
        return !txtCapacidad.getText().isEmpty()
                && !txtNombre.getText().isEmpty()
                //&& !txtEntrenador.getText().isEmpty()
                && !txtHorario.getText().isEmpty();
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

    //valida Hora de 00 a 24
    private boolean validaHora(String nro) {
        Pattern patron = Pattern.compile("^(?:[01]?[0-9]|2[0-3])$");
        Matcher m = patron.matcher(nro);
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

    public void listarTabla(List<Clase> lista) {
        limpiarTabla();
        for (Clase s : lista) {

            tabla.addRow(new Object[]{s.getIdClase(), s.getNombre(), s.getHorario(), s.getCapacidad(), s.getEntrenador().getNombre() + " " + s.getEntrenador().getApellido()});
        }
    }
// ================= sacar bordes de internal ================

    private void quitarBordeJInternalFrame() {
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnModificar;
    private javax.swing.JLabel btnNuevo;
    private javax.swing.JComboBox<Entrenador> cbEntrenadores;
    private javax.swing.JComboBox<String> cbFiltro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCapacidad;
    private javax.swing.JLabel lblEntrenador;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblIdClase;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tbFiltro;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtIdClase;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
