package Vistas;

import AccesoDatos.AccesoMembresia;
import AccesoDatos.AccesoSocio;
import Entidades.Membresia;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import Entidades.Socio;

public class VistaMembresia extends javax.swing.JInternalFrame {

    //Atributos
    private AccesoMembresia accesoMembresia;
    private AccesoSocio accesoSocio;

    //Constructor
    public VistaMembresia() {
        initComponents();
        accesoSocio = new AccesoSocio();

        //llenar combo de pases
        llenarComboPases();

        // Configurar JDateChooser
        JTextFieldDateEditor editorFechaInicio = (JTextFieldDateEditor) txtFechaInicio.getDateEditor();
        editorFechaInicio.setEditable(false);
        JTextFieldDateEditor editorFechaFin = (JTextFieldDateEditor) txtFechaFin.getDateEditor();
        editorFechaFin.setEditable(false);

        accesoMembresia = new AccesoMembresia();

        // Eliminar el borde del JInternalFrame
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);

        // Solicitar foco en txtIdSocio después de que el componente sea visible
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                txtIdSocio.requestFocusInWindow();
                bloquearCamposInicio();
            }
        });
    }

    //Metodos
    //limpiar campos
    private void limpiarCampos() {
        txtIdMembresia.setText("");
        txtIdSocio.setText("");
        txtCantidadPases.setText("");
        txtFechaInicio.setDate(null);
        txtFechaFin.setDate(null);
        txtPrecio.setText("");
        rBtnEstado.setSelected(false);
    }

    //cargar datos a los campos de textos
    private void cargarDatos(Membresia membresia) {
        if (membresia != null) {
            txtIdMembresia.setText(String.valueOf(membresia.getIdMembresia()));
            txtCantidadPases.setText(String.valueOf(membresia.getCantidadPases()));

            //Convertir LocalDate a Date
            Date fechaInicio = Date.valueOf(membresia.getFechaInicio());
            Date fechaFin = Date.valueOf(membresia.getFechaFin());

            txtFechaInicio.setDate(fechaInicio);
            txtFechaFin.setDate(fechaFin);

            txtPrecio.setText(String.valueOf(membresia.getCosto()));
            rBtnEstado.setSelected(membresia.getEstado());

            // El metodo de busqueda de membresias siempre va a traer los que etan activos
            rBtnEstado.setSelected(true);

            JOptionPane.showMessageDialog(this, "Membresía cargada correctamente");
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró la membresía");
        }
    }

    // Bloquear todos los campos excepto txtIdSocio al iniciar
    private void bloquearCamposInicio() {
        txtIdMembresia.setEditable(false);
        txtFechaInicio.setEnabled(false);
        txtFechaFin.setEnabled(false);
        txtCantidadPases.setEditable(false);
        cbCantidadPases.setEnabled(false);
        txtPrecio.setEditable(false);
        rBtnEstado.setEnabled(false);
    }

    // Habilitar campos
    private void habilitarCampos() {
        txtIdSocio.setEditable(true);
        cbCantidadPases.setEnabled(true);
        txtFechaInicio.setEnabled(true);
        txtFechaFin.setEnabled(true);
        txtPrecio.setEditable(true);
        rBtnEstado.setEnabled(true);
    }

    //llenar combo de pases
    private void llenarComboPases() {
        // Crear un modelo de datos para el ComboBox con los valores deseados
        String[] opciones = {"Selecciona uno...", "8", "12", "20"};
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>(opciones);
        cbCantidadPases.setModel(modeloCombo);
        cbCantidadPases.setSelectedIndex(0); // Esto asegura que el primer elemento sea el seleccionado por defecto

        // Establecer un renderizador personalizado para el ComboBox
        cbCantidadPases.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index == 0) {
                    setForeground(Color.LIGHT_GRAY); // Establece el color gris claro solo para el primer elemento
                }
                return this;
            }
        });
    }

    //chequeo de campos 
    private boolean comprobarCamposCompletos() {
        // Verificar si el campo txtIdSocio está vacío
        if (txtIdSocio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete el campo ID Socio.");
            return false;
        }

        // Verificar si el campo cbCantidadPases no ha sido seleccionado
        if (cbCantidadPases.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione la cantidad de pases.");
            return false;
        }

        // Verificar si el campo txtFechaInicio no ha sido seleccionado
        if (txtFechaInicio.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione la fecha de inicio.");
            return false;
        }

        // Verificar si el campo txtFechaFin no ha sido seleccionado
        if (txtFechaFin.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione la fecha de fin.");
            return false;
        }

        // Verificar si el campo txtPrecio está vacío
        if (txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete el campo Precio.");
            return false;
        }

        // Todos los campos están completos
        return true;
    }

    //Botones

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMembresia = new javax.swing.JLabel();
        lblCantidadPases = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblSocio = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        rBtnEstado = new javax.swing.JRadioButton();
        btnEliminar = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();
        btnModificar = new javax.swing.JLabel();
        txtIdMembresia = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtIdSocio = new javax.swing.JTextField();
        txtCantidadPases = new javax.swing.JTextField();
        txtFechaFin = new com.toedter.calendar.JDateChooser();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        cbCantidadPases = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cbMembresias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTablaMembresia = new javax.swing.JTable();
        txtListarMembresias = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        lblMembresia.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblMembresia.setText("ID MEMBRESÍA");
        jPanel1.add(lblMembresia);
        lblMembresia.setBounds(50, 110, 140, 22);

        lblCantidadPases.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblCantidadPases.setText("CANTIDAD DE PASES");
        jPanel1.add(lblCantidadPases);
        lblCantidadPases.setBounds(50, 250, 184, 22);

        lblFechaInicio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblFechaInicio.setText("FECHA INICIO");
        jPanel1.add(lblFechaInicio);
        lblFechaInicio.setBounds(50, 330, 130, 22);

        lblFechaFin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblFechaFin.setText("FECHA FIN");
        jPanel1.add(lblFechaFin);
        lblFechaFin.setBounds(50, 400, 100, 22);

        lblEstado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblEstado.setText("ESTADO");
        jPanel1.add(lblEstado);
        lblEstado.setBounds(50, 550, 80, 22);

        lblSocio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblSocio.setText("ID SOCIO");
        jPanel1.add(lblSocio);
        lblSocio.setBounds(50, 180, 90, 22);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/BUSCAR.png"))); // NOI18N
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        jPanel1.add(btnBuscar);
        btnBuscar.setBounds(340, 140, 160, 70);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel3.setText("MEMBRESÍA");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(180, 20, 178, 36);

        lblPrecio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblPrecio.setText("PRECIO");
        jPanel1.add(lblPrecio);
        lblPrecio.setBounds(50, 480, 80, 22);
        jPanel1.add(rBtnEstado);
        rBtnEstado.setBounds(160, 550, 19, 20);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/ELIMINAR_2_PULSADO.png"))); // NOI18N
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(400, 600, 110, 50);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/NUEVO.png"))); // NOI18N
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        jPanel1.add(btnNuevo);
        btnNuevo.setBounds(30, 600, 110, 50);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/GUARDAR.png"))); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(150, 600, 110, 50);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/MODIFICAR.png"))); // NOI18N
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        jPanel1.add(btnModificar);
        btnModificar.setBounds(270, 600, 110, 50);

        txtIdMembresia.setBackground(new java.awt.Color(28, 89, 59));
        txtIdMembresia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdMembresia.setBorder(null);
        txtIdMembresia.setOpaque(true);
        jPanel1.add(txtIdMembresia);
        txtIdMembresia.setBounds(200, 100, 60, 30);

        txtPrecio.setEditable(true);
        txtPrecio.setBackground(new java.awt.Color(28, 89, 59));
        txtPrecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPrecio.setBorder(null);
        jPanel1.add(txtPrecio);
        txtPrecio.setBounds(130, 480, 100, 30);

        txtIdSocio.setBackground(new java.awt.Color(28, 89, 59));
        txtIdSocio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtIdSocio.setBorder(null);
        jPanel1.add(txtIdSocio);
        txtIdSocio.setBounds(150, 170, 60, 30);

        txtCantidadPases.setEditable(true);
        txtCantidadPases.setBackground(new java.awt.Color(28, 89, 59));
        txtCantidadPases.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCantidadPases.setBorder(null);
        jPanel1.add(txtCantidadPases);
        txtCantidadPases.setBounds(250, 240, 60, 30);

        txtFechaFin.setBackground(new java.awt.Color(28, 89, 59));
        txtFechaFin.setDateFormatString("dd/MM/yyyy");
        txtFechaFin.setInheritsPopupMenu(true);
        txtFechaFin.setOpaque(false);
        jPanel1.add(txtFechaFin);
        txtFechaFin.setBounds(180, 400, 150, 26);

        txtFechaInicio.setBackground(new java.awt.Color(28, 89, 59));
        txtFechaInicio.setDateFormatString("dd/MM/yyyy");
        txtFechaInicio.setInheritsPopupMenu(true);
        txtFechaInicio.setOpaque(false);
        jPanel1.add(txtFechaInicio);
        txtFechaInicio.setBounds(190, 330, 150, 26);

        cbCantidadPases.setBackground(new java.awt.Color(28, 89, 59));
        cbCantidadPases.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbCantidadPases.setForeground(new java.awt.Color(28, 89, 59));
        cbCantidadPases.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "12", "20" }));
        cbCantidadPases.setToolTipText("");
        jPanel1.add(cbCantidadPases);
        cbCantidadPases.setBounds(340, 240, 140, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 530, 680);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(null);

        cbMembresias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbMembresias);
        cbMembresias.setBounds(246, 90, 167, 26);

        tblTablaMembresia.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTablaMembresia);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(44, 152, 407, 463);

        txtListarMembresias.setText("Escriba aquí...");
        jPanel2.add(txtListarMembresias);
        txtListarMembresias.setBounds(22, 80, 206, 46);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel2.setText("LISTA DE MEMBRESÍAS");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(75, 17, 338, 36);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(532, 0, 510, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        if (txtIdSocio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ERROR: El campo ID Socio está vacío");
        } else {
            try {
                int id = Integer.valueOf(txtIdSocio.getText());
                Membresia membresia = accesoMembresia.buscarMembresiaPorIdSocio(id);
                cargarDatos(membresia);
                habilitarCampos();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Ingrese un ID válido");
            } catch (Exception a) {
                JOptionPane.showMessageDialog(rootPane, "ERROR: " + a);
            }
        }
        
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        limpiarCampos();
        habilitarCampos();
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // Comprobar si todos los campos están completos
        if (!comprobarCamposCompletos()) {
            return; // Si algún campo está incompleto, salir del método
        } else {
            // Recolectar los datos de los campos
            String idSocioStr = txtIdSocio.getText();
            String cantidadPasesString = (String) cbCantidadPases.getSelectedItem();
            int cantidadPases = Integer.parseInt(cantidadPasesString);
            LocalDate fechaInicio = txtFechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaFin = txtFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            double precio = Double.parseDouble(txtPrecio.getText());

            try {
                // Convertir el ID del socio de cadena de texto a entero
                int idSocio = Integer.parseInt(idSocioStr);

                // Buscar el socio correspondiente al ID ingresado
                Socio socio = accesoSocio.buscarSocio(idSocio);
                if (socio == null) {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún socio con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear una nueva instancia de Membresia con el socio encontrado y los datos recolectados
                Membresia nuevaMembresia = new Membresia(socio, cantidadPases, fechaInicio, fechaFin, precio, true);

                // Llamar al método para crear la membresía en la base de datos o donde sea necesario
                accesoMembresia.crearMembresia(nuevaMembresia);

            } catch (NumberFormatException e) {
                // Manejar el caso en que el ID del socio ingresado no sea un número válido
                JOptionPane.showMessageDialog(this, "El ID del socio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si hay un error
            }
        }

        // Limpiar los campos después de guardar la membresía
        limpiarCampos();
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        // Comprobar si todos los campos están completos
    if (!comprobarCamposCompletos()) {
        return; // Si algún campo está incompleto, salir del método
    } else {
        // Recolectar los datos de los campos
        String idMembresiaStr = txtIdMembresia.getText();
        String idSocioStr = txtIdSocio.getText();
        String cantidadPasesString = (String) cbCantidadPases.getSelectedItem();
        int cantidadPases = Integer.parseInt(cantidadPasesString);
        LocalDate fechaInicio = txtFechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaFin = txtFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        double precio = Double.parseDouble(txtPrecio.getText());

        try {
            // Convertir el ID de la membresía y del socio de cadena de texto a entero
            int idMembresia = Integer.parseInt(idMembresiaStr);
            int idSocio = Integer.parseInt(idSocioStr);

            // Buscar la membresía correspondiente al ID ingresado
            Membresia membresiaExistente = accesoMembresia.buscarMembresiaPorIdSocio(idSocio);
            if (membresiaExistente == null) {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna membresía con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buscar el socio correspondiente al ID ingresado
            Socio socio = accesoSocio.buscarSocio(idSocio);
            if (socio == null) {
                JOptionPane.showMessageDialog(this, "No se encontró ningún socio con el ID proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Preguntar al usuario si está seguro de modificar la membresía
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea modificar la membresía número " + idMembresia + "?", "Confirmar Modificación", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return; // Si el usuario no confirma, salir del método
            }

            // Crear una nueva instancia de Membresia con el socio encontrado y los datos recolectados
            Membresia membresiaModificada = new Membresia(idMembresia, socio, cantidadPases, fechaInicio, fechaFin, precio, true);

            // Llamar al método para modificar la membresía en la base de datos
            accesoMembresia.modificarMembresia(membresiaModificada);

            // Limpiar los campos después de modificar la membresía
            limpiarCampos();

        } catch (NumberFormatException e) {
            // Manejar el caso en que el ID del socio ingresado no sea un número válido
            JOptionPane.showMessageDialog(this, "El ID del socio y el ID de la membresía deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si hay un error
        }
    }

        // Limpiar los campos después de guardar la membresía
        limpiarCampos();
    }//GEN-LAST:event_btnModificarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnModificar;
    private javax.swing.JLabel btnNuevo;
    private javax.swing.JComboBox<String> cbCantidadPases;
    private javax.swing.JComboBox<String> cbMembresias;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidadPases;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblMembresia;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSocio;
    private javax.swing.JRadioButton rBtnEstado;
    private javax.swing.JTable tblTablaMembresia;
    private javax.swing.JTextField txtCantidadPases;
    private com.toedter.calendar.JDateChooser txtFechaFin;
    private com.toedter.calendar.JDateChooser txtFechaInicio;
    private javax.swing.JTextField txtIdMembresia;
    private javax.swing.JTextField txtIdSocio;
    private javax.swing.JTextField txtListarMembresias;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
