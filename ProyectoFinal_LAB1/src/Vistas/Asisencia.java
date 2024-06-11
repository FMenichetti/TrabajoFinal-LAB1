/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import AccesoDatos.AccesoClase;
import AccesoDatos.AccesoInscripcion;
import AccesoDatos.AccesoMembresia;
import AccesoDatos.AccesoSocio;
import Entidades.Inscripcion;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabri
 */
public class Asisencia extends javax.swing.JInternalFrame {

    // entidades 
    Inscripcion i = null;
    Entidades.Membresia m = null;
    // accesos
    AccesoInscripcion acInscripcion = new AccesoInscripcion();
    AccesoClase acClase = new AccesoClase();
    AccesoSocio acSocio = new AccesoSocio();
    AccesoMembresia acMembresia = new AccesoMembresia();
    // jcalendar
    JTextFieldDateEditor editorJcalendar;
    //creamos nuevos colores, el original y el para el estado no editable
    Color verdeTransparente = new Color(28, 89, 59, 150);
    Color original = new Color(28, 89, 59);
    // TABLA
    private DefaultTableModel tabla;
    List<Inscripcion> inscripciones;

    public Asisencia() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(false);
        txtBuscarLista.setEditable(false); // empezar el txt en desabilitado
        // para no editar el txt del jcalendar
        editorJcalendar = (JTextFieldDateEditor) dcFecha.getDateEditor();
        editorJcalendar.setEditable(false);
        editorJcalendar.setBackground(verdeTransparente);
        noEditables();
        //---------------TABLA---------------------
        tabla = new DefaultTableModel();
        inscripciones = new ArrayList<>();
        //bloqueo de edicion de tabla
        pintarColumnasTabla();

        // INICIALIZAMOS COMBO BOX
        llenarComboBoxMembresias();
        // pintar txt buscar
        inicializarTxtFiltrar();
        // btn agregar membresia
        btnAgregarMembresia.setVisible(false);
        // fecha minima jcalendar
        LocalDate fechaMinima = LocalDate.of(2024, 1, 1);
        java.util.Date formatoParaElJc = java.sql.Date.valueOf(fechaMinima);
        dcFecha.setMinSelectableDate(formatoParaElJc);

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
        jLabel7 = new javax.swing.JLabel();
        lblIdSocio = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblIdClase = new javax.swing.JLabel();
        btnModificar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdClase = new javax.swing.JTextField();
        txtIdSocio = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        txtIdAsistencia1 = new javax.swing.JTextField();
        txtPases = new javax.swing.JTextField();
        lblPases = new javax.swing.JLabel();
        btnAgregarMembresia = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cbListar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsistencia = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarLista = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(214, 236, 225));
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Id Asistencia");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 110, 100, 30);

        lblIdSocio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblIdSocio.setText("Id Socio");
        jPanel1.add(lblIdSocio);
        lblIdSocio.setBounds(20, 210, 80, 30);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Fecha de Inscripcion");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 260, 170, 30);

        lblIdClase.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblIdClase.setText("Id Clase");
        jPanel1.add(lblIdClase);
        lblIdClase.setBounds(20, 160, 80, 30);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/MODIFICAR.png"))); // NOI18N
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        jPanel1.add(btnModificar);
        btnModificar.setBounds(270, 420, 100, 40);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel3.setText("Asistencia");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 30, 140, 36);

        txtIdClase.setBackground(new java.awt.Color(28, 89, 59));
        txtIdClase.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdClase.setForeground(new java.awt.Color(255, 255, 255));
        txtIdClase.setBorder(null);
        txtIdClase.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtIdClase.setOpaque(false);
        jPanel1.add(txtIdClase);
        txtIdClase.setBounds(100, 160, 80, 30);

        txtIdSocio.setBackground(new java.awt.Color(28, 89, 59));
        txtIdSocio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdSocio.setForeground(new java.awt.Color(255, 255, 255));
        txtIdSocio.setBorder(null);
        txtIdSocio.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtIdSocio.setOpaque(false);
        jPanel1.add(txtIdSocio);
        txtIdSocio.setBounds(100, 210, 80, 30);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/BUSCAR.png"))); // NOI18N
        btnBuscar.setText("jLabel1");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        jPanel1.add(btnBuscar);
        btnBuscar.setBounds(280, 100, 150, 50);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/NUEVO.png"))); // NOI18N
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        jPanel1.add(btnNuevo);
        btnNuevo.setBounds(30, 420, 99, 40);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/ELIMINAR_2_PULSADO.png"))); // NOI18N
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(390, 420, 99, 40);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/GUARDAR.png"))); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(150, 420, 100, 40);
        jPanel1.add(dcFecha);
        dcFecha.setBounds(210, 260, 180, 30);

        txtIdAsistencia1.setBackground(new java.awt.Color(28, 89, 59));
        txtIdAsistencia1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdAsistencia1.setForeground(new java.awt.Color(255, 255, 255));
        txtIdAsistencia1.setBorder(null);
        txtIdAsistencia1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtIdAsistencia1.setOpaque(false);
        jPanel1.add(txtIdAsistencia1);
        txtIdAsistencia1.setBounds(130, 110, 80, 30);

        txtPases.setBackground(new java.awt.Color(28, 89, 59));
        txtPases.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPases.setForeground(new java.awt.Color(255, 255, 255));
        txtPases.setBorder(null);
        txtPases.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtPases.setOpaque(false);
        jPanel1.add(txtPases);
        txtPases.setBounds(270, 310, 140, 30);

        lblPases.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblPases.setText("Cantidad de pases disponibles");
        jPanel1.add(lblPases);
        lblPases.setBounds(10, 310, 260, 30);

        btnAgregarMembresia.setText("Agregar");
        btnAgregarMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMembresiaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarMembresia);
        btnAgregarMembresia.setBounds(420, 310, 70, 30);

        jPanel2.setBackground(new java.awt.Color(214, 236, 225));

        cbListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbListarActionPerformed(evt);
            }
        });

        tblAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAsistenciaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAsistencia);
        if (tblAsistencia.getColumnModel().getColumnCount() > 0) {
            tblAsistencia.getColumnModel().getColumn(0).setResizable(false);
            tblAsistencia.getColumnModel().getColumn(1).setResizable(false);
            tblAsistencia.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel2.setText("Lista de Asistencias");

        txtBuscarLista.setBackground(new java.awt.Color(28, 89, 59));
        txtBuscarLista.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtBuscarLista.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscarLista.setBorder(null);
        txtBuscarLista.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtBuscarLista.setOpaque(false);
        txtBuscarLista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarListaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarListaFocusLost(evt);
            }
        });
        txtBuscarLista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarListaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbListar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(120, 120, 120))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscarLista)
                    .addComponent(cbListar))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        //BOTON GUARDAR
        if (reactivarBusqueda()) {
            btnGuardar.setEnabled(false); // al reactivar la busqueda desactivamos el btn guardar
            btnModificar.setEnabled(false);// al reactivar la busqueda desactivamos el btn modificar
            btnAgregarMembresia.setVisible(false);
            return;
        } else {
            btnEliminar.setEnabled(false); // se desactiva en el caso que no exista la asist a buscar
            int codigo;
            if (validaEntero(txtIdAsistencia1.getText())) {
                codigo = Integer.parseInt(txtIdAsistencia1.getText());
            } else {
                JOptionPane.showMessageDialog(null, "El id Asistencia debe ser numero entero");
                limpiarCampos();
                txtIdAsistencia1.requestFocus();
                return;
            }
            i = acInscripcion.buscarInscripcionPorId(codigo);
            if (i != null) {
                editables();

                Date fechaDeInscripcion = new Date(0);
                fechaDeInscripcion = Date.valueOf(i.getFechaInscripcion());
                txtIdClase.setText(i.getClase().getIdClase() + "");
                txtIdSocio.setText(i.getSocio().getIdSocio() + "");
                dcFecha.setDate(fechaDeInscripcion);
                // mostrar cantidad de pases restantes
                Entidades.Membresia me = new Entidades.Membresia();
                me = acMembresia.buscarMembresiaPorIdSocio(Integer.parseInt(txtIdSocio.getText()));
                if (me != null) {
                    txtPases.setText(me.getCantidadPases() + "");
                    btnAgregarMembresia.setVisible(false);
                } else {
                    txtPases.setText("No tiene Membresia");
                    btnAgregarMembresia.setVisible(true);
                }

                // cambiar estados de botones
                btnEliminar.setEnabled(true); // se activa en el caso que si exista la asist a buscar
                btnModificar.setEnabled(true);// se activa en el caso que si exista la asist a buscar
            } else {
                limpiarCampos();
            }
        }

    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        btnGuardar.setEnabled(true); // al hacer uno nuevo activamos el guardar
        btnEliminar.setEnabled(false); // y desactivamos el eliminar
        btnModificar.setEnabled(false); // tamb  el modificar
        limpiarCampos();
        txtIdClase.requestFocus();
        editables();
        txtIdAsistencia1.setText("Automatico");
        btnAgregarMembresia.setVisible(false);
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // boton guardar

        if (!btnGuardar.isEnabled()) {
            return;
        }
        paraGuardar();


    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // btn eliminar
        int codigo, confirm;
        if (!btnEliminar.isEnabled()) {
            return;
        }

        if (validaEntero(txtIdAsistencia1.getText())) {
            codigo = Integer.parseInt(txtIdAsistencia1.getText());
            // Preguntar al usuario si está seguro de eliminar la asistencia
            confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar la asistencia número " + codigo + "?", "Confirmar Modificación", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return; // Si el usuario no confirma, salir del método
            }
            acInscripcion.borrarInscripcion(codigo);
            limpiarCampos();
            btnEliminar.setEnabled(false); // si se encuentra y elimina una insc, se cambia el estado del btn
            btnModificar.setEnabled(false); // y el btn de modificar
        }


    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        if (!btnModificar.isEnabled()) {
            return;
        }
        paraModificar();
        //btnModificar.setEnabled(false); // se cambian los estados de los botones para no tener problemas
        //btnEliminar.setEnabled(false); // al intentar modificar o eliminar algo que no este escrito
    }//GEN-LAST:event_btnModificarMouseClicked

// -------------------- BUSQUEDA EN TABLA -----------------------

    private void txtBuscarListaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarListaKeyReleased
        String filtro = txtBuscarLista.getText().trim();
        String seleccion = (String) cbListar.getSelectedItem();

        List<Inscripcion> listaFiltrada = filtrarAsistencias(seleccion, filtro);
        listarTabla(listaFiltrada);
    }//GEN-LAST:event_txtBuscarListaKeyReleased

    private void cbListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbListarActionPerformed
        String seleccion = (String) cbListar.getSelectedItem();

        if (seleccion.equals("Id Asistencia")) {
            // Llamar al método para listar todas las membresías
            List<Inscripcion> inscripciones = acInscripcion.listarInscripciones();
            listarTabla(inscripciones);
            txtBuscarLista.setEditable(true);
        } else if (seleccion.equals("Clase")) {
            // Llamar al método para listar todas las membresías ordenadas por ID de socio
            List<Inscripcion> inscripciones = acInscripcion.listarAsistenciasPorIdClases();
            listarTabla(inscripciones);
            txtBuscarLista.setEditable(true);
        } else if (seleccion.equals("Socio")) {
            // Llamar al método para listar todas las membresías ordenadas por cantidad de pases
            List<Inscripcion> inscripciones = acInscripcion.listarAsistenciasPorIdSocio();
            listarTabla(inscripciones);
            txtBuscarLista.setEditable(true);
        } else if (seleccion.equals("Fecha")) {
            // Llamar al método para listar todas las membresías ordenadas por fecha de inicio
            List<Inscripcion> inscripciones = acInscripcion.listarAsistenciasPorFecha();
            listarTabla(inscripciones);
            txtBuscarLista.setEditable(true);
        }
    }//GEN-LAST:event_cbListarActionPerformed

    private void txtBuscarListaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarListaFocusGained
        if (txtBuscarLista.getText().equals("Escriba aquí...")) {
            txtBuscarLista.setText("");
            txtBuscarLista.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_txtBuscarListaFocusGained

    private void txtBuscarListaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarListaFocusLost
        if (txtBuscarLista.getText().isEmpty()) {
            txtBuscarLista.setText("Escriba aquí...");
            txtBuscarLista.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtBuscarListaFocusLost

    private void btnAgregarMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMembresiaActionPerformed
        // ----------------------------- AGREGAR MEMBRESIA ---------------------------------

    }//GEN-LAST:event_btnAgregarMembresiaActionPerformed
 // seleccionar row y mostar en txts
    private void tblAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAsistenciaMouseClicked
        if (evt.getClickCount() == 2) { //escuchar el doble click
            int row = tblAsistencia.getSelectedRow();
            if (row != -1) {
                //rescatamos la info de la columna inscripcion q es la 1
                int id = Integer.parseInt(tblAsistencia.getValueAt(row, 0).toString());

                try {
                    Inscripcion in = acInscripcion.buscarInscripcionPorId(id);
                    if (in != null) {
                        pintarTxtSegunTabla(in);
                        editables();
                        btnModificar.setEnabled(true);
                        btnEliminar.setEnabled(true);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese un ID válido");
                }
            }
        }
    }//GEN-LAST:event_tblAsistenciaMouseClicked

    public boolean verificarPases(int id) {
        Entidades.Membresia verPases = acMembresia.buscarMembresiaPorIdSocio(id);

        if (verPases.getCantidadPases() <= 0) {
            return false;
        } else {
            return true;
        }

    }

    public void restarPases(int id) {
        Entidades.Membresia restarPase = new Entidades.Membresia();
        restarPase = acMembresia.buscarMembresiaPorIdSocio(id);
        restarPase.setCantidadPases(restarPase.getCantidadPases() - 1);
        acMembresia.modificarMembresia(restarPase);

    }

    public void paraModificar() {
        int codigo, idClase, idSocio, confirm;
        Entidades.Clase c = new Entidades.Clase();
        Entidades.Socio s = new Entidades.Socio();
        Inscripcion nueva = new Inscripcion();
        if (validaEntero(txtIdAsistencia1.getText())) {
            codigo = Integer.parseInt(txtIdAsistencia1.getText());
            if (validarCampos()) {
                confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea modificar la asistencia número " + codigo + "?", "Confirmar Modificación", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) {
                    return; // Si el usuario no confirma, salir del método
                }
                idClase = Integer.parseInt(txtIdClase.getText());
                idSocio = Integer.parseInt(txtIdSocio.getText());
                c = acClase.buscarClase(idClase);
                s = acSocio.buscarSocio(idSocio);
                if (c == null) {
                    txtIdClase.requestFocus();
                    //txtIdClase.setText("");
                    return;
                }
                if (s == null) {
                    txtIdSocio.requestFocus();
                    //txtIdSocio.setText("");
                    return;
                }
                nueva.setIdInscripcion(codigo);
                nueva.setClase(c);
                nueva.setSocio(s);
                nueva.setFechaInscripcion(dcFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                acInscripcion.modificarInscripcion(nueva);
                limpiarCampos();
                noEditables();
                btnModificar.setEnabled(false); // se cambian los estados de los botones para no tener problemas
                btnEliminar.setEnabled(false); // al intentar modificar o eliminar algo que no este escrito
            }

        }
    }

    public void paraGuardar() { // validar que el miembro tenga pases disponibles
        Inscripcion nueva = new Inscripcion();
        int idSocio, idClase;
        if (validarCampos()) {
            idClase = Integer.parseInt(txtIdClase.getText());
            idSocio = Integer.parseInt(txtIdSocio.getText());
            Entidades.Clase c = acClase.buscarClase(idClase);
            Entidades.Socio s = acSocio.buscarSocio(idSocio);
            Entidades.Membresia me = acMembresia.buscarMembresiaPorIdSocio(idSocio);
            if (me == null) {
                JOptionPane.showMessageDialog(null, "El socio no tiene membresia");
                return;
            }
            if (c == null) {
                txtIdClase.requestFocus();
                //txtIdClase.setText("");
                return;
            }
            if (s == null) {
                txtIdSocio.requestFocus();
                //txtIdSocio.setText("");
                return;
            }
            if (!verificarPases(idSocio)) {
                JOptionPane.showMessageDialog(null, "El socio no tiene pasaes disponibles");
                return;
            }
            nueva.setClase(c);
            nueva.setSocio(s);
            nueva.setFechaInscripcion(dcFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            i = nueva;
            restarPases(idSocio);
            acInscripcion.guardarInscripcion(i);
            limpiarCampos();
        }
    }

    //REACTIVAR BOTON BUSCAR
    public boolean reactivarBusqueda() {
        if (!txtIdAsistencia1.isEditable()) {
            noEditables();
            txtIdAsistencia1.setEditable(true);
            txtIdAsistencia1.setText("");
            limpiarCampos();
            return true;
        }
        return false;
    }

// SETEAR EN EDITABLES LOS TXT
    public void editables() {
        txtIdClase.setEditable(true);
        txtIdSocio.setEditable(true);
        dcFecha.setEnabled(true); //?????
        txtIdClase.setBackground(original);
        txtIdSocio.setBackground(original);
        // siempre en false el txt pases
        txtPases.setEditable(false);
        txtPases.setBackground(verdeTransparente);
        // el id asistencia pasa a ser no editable
        txtIdAsistencia1.setEditable(false);

        txtIdAsistencia1.setBackground(verdeTransparente);
        editorJcalendar.setBackground(verdeTransparente);
    }

// SETEAR EN NO EDITABLE LOS TXT
    public void noEditables() {

        txtIdClase.setEditable(false);
        txtIdSocio.setEditable(false);
        dcFecha.setEnabled(false);
        txtIdClase.setBackground(verdeTransparente);
        txtIdSocio.setBackground(verdeTransparente);
        // siempre en false el txt pases
        txtPases.setEditable(false);
        txtPases.setBackground(verdeTransparente);
        // el id Asistencia pasa a ser editable
        txtIdAsistencia1.setEditable(true);
        txtIdAsistencia1.setText("");
        txtIdAsistencia1.setBackground(original);
    }

// VALIDAMOS TODOS LOS CAMPOS MENOS EL DE ID ASISTENCIA
    public boolean validarCampos() {

        // validamos txt id clase
        if (txtIdClase.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene el campo id Clase");
            return false;
        }
        if (!validaEntero(txtIdClase.getText())) {
            JOptionPane.showMessageDialog(null, "El campo id Clase debe de ser un entero");
            return false;
        }
        // validamos txt id socio
        if (txtIdSocio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene el campo id Socio");
            return false;
        }
        if (!validaEntero(txtIdSocio.getText())) {
            JOptionPane.showMessageDialog(null, "El campo id socio debe de ser un entero");
            return false;
        }

        // verificamos la fecha 
        if (editorJcalendar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene el campo fecha");
            return false;
        }
        return true;
    }

    //METODO PARA VALIDAR Entero
    private boolean validaEntero(String nro) {

        Pattern patron = Pattern.compile("^[0-9]+$");
        Matcher m = patron.matcher(nro);
        return m.matches();
    }

    // limpiar campos
    public void limpiarCampos() {
        editorJcalendar.setText("");
        txtIdClase.setText("");
        txtIdAsistencia1.setText("");
        txtIdSocio.setText("");
        txtPases.setText("");

    }

    // -------------------------------TABLA-------------------------------------
    private void pintarColumnasTabla() {
        tblAsistencia.setModel(tabla);
        tabla.addColumn("Id Asistencia");
        tabla.addColumn("Clase");
        tabla.addColumn("Socio");
        tabla.addColumn("Fecha");
        tblAsistencia.setDefaultEditor(Object.class, null);

    }

    //Limpieza de la tabla
    public void limpiarTabla() {
        int filas = tabla.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            tabla.removeRow(i);
        }
    }

    //cargar datos a los campos de textos
    private void pintarTxtSegunTabla(Inscripcion in) {
        if (in != null) {
            txtIdAsistencia1.setText(String.valueOf(in.getIdInscripcion()));
            txtIdClase.setText(String.valueOf(in.getClase().getIdClase()));
            txtIdSocio.setText(String.valueOf(in.getSocio().getIdSocio()));
            //convertir LocalDate a Date
            Date fecha = Date.valueOf(in.getFechaInscripcion());
            editorJcalendar.setDate(fecha);
            Entidades.Membresia me = new Entidades.Membresia();
            me = acMembresia.buscarMembresiaPorIdSocio(Integer.parseInt(txtIdSocio.getText()));
            if (me != null ) {
                txtPases.setText(String.valueOf(me.getCantidadPases()));
            }else{
                txtPases.setText("No tiene Membresia");
            }

        }
    }

    // ---------------------- empezamos a pintar las row segun los metodos de ac ------------------------------
    //filtrado por criterio
    private List<Inscripcion> filtrarAsistencias(String criterio, String filtro) {

        return acInscripcion.listarInscripciones().stream()
                .filter(i -> {
                    switch (criterio) {
                        case "Id Asistencia":
                            return String.valueOf(i.getIdInscripcion()).contains(filtro);
                        case "Clase":
                            return i.getClase().getNombre().toLowerCase().contains(filtro.toLowerCase());
                        case "Socio":
                            String nombreCompleto = i.getSocio().getNombre() + " " + i.getSocio().getApellido();
                            return nombreCompleto.toLowerCase().contains(filtro.toLowerCase());
                        case "Fecha":
                            return i.getFechaInscripcion().toString().contains(filtro);
                        default:
                            return false;
                    }
                })
                .collect(Collectors.toList());
    }

    //pintar tabla
    public void listarTabla(List<Inscripcion> listaAsistencias) {
        limpiarTabla(); // Limpiar la tabla antes de agregar nuevas filas
        for (Inscripcion ins : listaAsistencias) {
            tabla.addRow(new Object[]{
                ins.getIdInscripcion(),
                ins.getClase().getNombre(),
                ins.getSocio().getNombre() + " " + ins.getSocio().getApellido(),
                ins.getFechaInscripcion()
            });
        }

    }

    //llenar combo membresias
    private void llenarComboBoxMembresias() {
        cbListar.addItem("Seleccione aquí...");
        cbListar.addItem("Id Asistencia");
        cbListar.addItem("Clase");
        cbListar.addItem("Socio");
        cbListar.addItem("Fecha");
    }

    //iniciar campo de filtro dinamico
    private void inicializarTxtFiltrar() {
        txtBuscarLista.setText("Escriba aquí...");
        txtBuscarLista.setForeground(Color.GRAY);

        txtBuscarLista.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarListaFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarListaFocusLost(evt);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMembresia;
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnModificar;
    private javax.swing.JLabel btnNuevo;
    private javax.swing.JComboBox<String> cbListar;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdClase;
    private javax.swing.JLabel lblIdSocio;
    private javax.swing.JLabel lblPases;
    private javax.swing.JTable tblAsistencia;
    private javax.swing.JTextField txtBuscarLista;
    private javax.swing.JTextField txtIdAsistencia1;
    private javax.swing.JTextField txtIdClase;
    private javax.swing.JTextField txtIdSocio;
    private javax.swing.JTextField txtPases;
    // End of variables declaration//GEN-END:variables
}
