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
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

public class VistaMembresia extends javax.swing.JInternalFrame {

    // ==================== ATRIBUTOS ====================
    private final AccesoMembresia accesoMembresia;
    private final AccesoSocio accesoSocio;
    private DefaultTableModel modeloTabla;

    // ==================== CONSTRUCTOR ====================
    public VistaMembresia() {
        initComponents();

        inicializarTxtFiltrar();

        //inicializar vista
        inicializarVista();
        inicializarTabla();
        tblTablaMembresia.setDefaultEditor(Object.class, null);

        accesoSocio = new AccesoSocio();
        accesoMembresia = new AccesoMembresia();

        // Deshabilitar botones guardar y modificar al abrir la vista
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(false);

        //llenar combos
        llenarComboPases();
        llenarComboBoxMembresias();

        // Configurar JDateChooser
        configurarJDateChooser();

        // Eliminar el borde del JInternalFrame
        quitarBordeJInternalFrame();

    }

    // ==================== METODOS ========================
    //hacer foco en idSocio
    private void inicializarVista() {
        // Solicitar foco en txtIdSocio después de que el componente sea visible
        SwingUtilities.invokeLater(() -> {
            txtIdSocio.requestFocusInWindow();
            bloquearCamposInicio();
            txtFiltrar.setEnabled(false);
            btnBuscar.setEnabled(true);
        });
    }

    //inicializar tabla
    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID Membresia");
        modeloTabla.addColumn("ID Socio");
        modeloTabla.addColumn("Cantidad de Pases");
        modeloTabla.addColumn("Fecha de Inicio");
        modeloTabla.addColumn("Fecha de Fin");
        modeloTabla.addColumn("Costo");
        tblTablaMembresia.setModel(modeloTabla); // Asociar el modelo de tabla a la tabla visual

    }

    //limpiar campos
    private void limpiarCampos() {
        txtIdMembresia.setText("");
        txtIdSocio.setText("");
        llenarComboPases();
        txtFechaInicio.setDate(null);
        txtFechaFin.setDate(null);
        txtPrecio.setText("");
        txtIdSocio.requestFocus();
    }

    //limpiar tabla
    public void limpiarTabla() {
        int rowCount = modeloTabla.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }

    //cargar datos a los campos de textos
    private void cargarDatos(Membresia membresia) {
        if (membresia != null) {
            txtIdMembresia.setText(String.valueOf(membresia.getIdMembresia()));
            cbCantidadPases.setSelectedItem(String.valueOf(membresia.getCantidadPases()));

            //Convertir LocalDate a Date
            Date fechaInicio = Date.valueOf(membresia.getFechaInicio());
            Date fechaFin = Date.valueOf(membresia.getFechaFin());

            txtFechaInicio.setDate(fechaInicio);
            txtFechaFin.setDate(fechaFin);
            txtPrecio.setText(String.valueOf(membresia.getCosto()));

        }
    }

    //bloquear todos los campos excepto txtIdSocio al iniciar
    private void bloquearCamposInicio() {
        txtIdMembresia.setEditable(false);
        txtFechaInicio.setEnabled(false);
        txtFechaFin.setEnabled(false);
        cbCantidadPases.setEnabled(false);
        txtPrecio.setEditable(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
    }

    //habilitar campos
    private void habilitarCampos() {
        txtIdSocio.setEditable(true);
        cbCantidadPases.setEnabled(true);
        txtFechaInicio.setEnabled(true);
        txtFechaFin.setEnabled(true);
        txtPrecio.setEditable(true);
    }

    //configuar calendario
    private void configurarJDateChooser() {
        JTextFieldDateEditor editorFechaInicio = (JTextFieldDateEditor) txtFechaInicio.getDateEditor();
        editorFechaInicio.setEditable(false);
        JTextFieldDateEditor editorFechaFin = (JTextFieldDateEditor) txtFechaFin.getDateEditor();
        editorFechaFin.setEditable(false);
    }

    //eliminar bordes internal frame
    private void quitarBordeJInternalFrame() {
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
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

    //llenar combo membresias
    private void llenarComboBoxMembresias() {
        cbMembresias.addItem("Seleccione aquí...");
        cbMembresias.addItem("Membresia");
        cbMembresias.addItem("Socio");
        cbMembresias.addItem("Cantidad de pases");
        cbMembresias.addItem("Fecha de inicio");
        cbMembresias.addItem("Fecha de fin");
        cbMembresias.addItem("Precio");
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

    //iniciar campo de filtro dinamico
    private void inicializarTxtFiltrar() {
        txtFiltrar.setText("Escriba aquí...");
        txtFiltrar.setForeground(Color.GRAY);

        txtFiltrar.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFiltrarFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFiltrarFocusLost(evt);
            }
        });
    }

    //listar tabla
    public void listarTabla(List<Membresia> listaMembresias) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblTablaMembresia.getModel();
        limpiarTabla(); // Limpiar la tabla antes de agregar nuevas filas

        for (Membresia membresia : listaMembresias) {
            modeloTabla.addRow(new Object[]{
                membresia.getIdMembresia(),
                membresia.getIdSocio(),
                membresia.getCantidadPases(),
                membresia.getFechaInicio(),
                membresia.getFechaFin(),
                membresia.getCosto(),
                membresia.getEstado()
            });
        }
    }

    //filtrado por criterio
    private List<Membresia> filtrarMembresias(String criterio, String filtro) {
        return accesoMembresia.listarMembresia().stream()
                .filter(m -> {
                    switch (criterio) {
                        case "Membresia":
                            return String.valueOf(m.getIdMembresia()).contains(filtro);
                        case "Socio":
                            return String.valueOf(m.getIdSocio()).contains(filtro);
                        case "Cantidad de pases":
                            return String.valueOf(m.getCantidadPases()).contains(filtro);
                        case "Fecha de inicio":
                            return m.getFechaInicio().toString().contains(filtro);
                        case "Fecha de fin":
                            return m.getFechaFin().toString().contains(filtro);
                        case "Precio":
                            return String.valueOf(m.getCosto()).contains(filtro);
                        default:
                            return false;
                    }
                })
                .collect(Collectors.toList());
    }

    private boolean validarFechas() {
        java.util.Date fechaInicioUtil = txtFechaInicio.getDate();
        java.util.Date fechaFinUtil = txtFechaFin.getDate();

        if (fechaInicioUtil != null && fechaFinUtil != null) {
            java.sql.Date fechaInicio = new java.sql.Date(fechaInicioUtil.getTime());
            java.sql.Date fechaFin = new java.sql.Date(fechaFinUtil.getTime());

            if (fechaInicio.after(fechaFin)) {
                JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser posterior a la fecha de fin.", "Error de fecha", JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (fechaFin.equals(fechaInicio)) {
                JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser igual a la fecha de fin.", "Error de fecha", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                // Las fechas son válidas
                return true;
            }
        } else {
            // Una o ambas fechas son nulas
            JOptionPane.showMessageDialog(this, "Por favor, seleccione la fecha de inicio y la fecha de fin.", "Error de fecha", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // ==================== INIT COMPONENTS ====================

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMembresia = new javax.swing.JLabel();
        lblCantidadPases = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        lblSocio = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();
        btnModificar = new javax.swing.JLabel();
        txtIdMembresia = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtIdSocio = new javax.swing.JTextField();
        txtFechaFin = new com.toedter.calendar.JDateChooser();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        cbCantidadPases = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cbMembresias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTablaMembresia = new javax.swing.JTable();
        txtFiltrar = new javax.swing.JTextField();
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

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Botones_internos/ELIMINAR_2_PULSADO.png"))); // NOI18N
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
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
        cbCantidadPases.setBounds(260, 240, 110, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 530, 680);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(null);

        cbMembresias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMembresiasActionPerformed(evt);
            }
        });
        jPanel2.add(cbMembresias);
        cbMembresias.setBounds(246, 86, 200, 30);

        tblTablaMembresia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Membresía", "Socio", "Pases", "Inicio", "Fin", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTablaMembresia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMembresiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTablaMembresia);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(44, 152, 407, 463);

        txtFiltrar.setText("Escriba aquí...");
        txtFiltrar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFiltrarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFiltrarFocusLost(evt);
            }
        });
        txtFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarKeyReleased(evt);
            }
        });
        jPanel2.add(txtFiltrar);
        txtFiltrar.setBounds(48, 80, 180, 46);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel2.setText("LISTA DE MEMBRESÍAS");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(75, 17, 338, 36);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(532, 0, 510, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ==================== BOTONES ====================

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        if (!btnBuscar.isEnabled()) {
            return; // No hacer nada si el botón de buscar está desactivado
        }
        String idSocioStr = txtIdSocio.getText().trim();
        if (idSocioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo ID Socio está vacío");
            return;
        }

        try {
            int idSocio = Integer.parseInt(idSocioStr);
            Membresia membresia = accesoMembresia.buscarMembresiaPorIdSocio(idSocio);
            if (membresia != null) {
                cargarDatos(membresia);
                habilitarCampos();
                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
            } else {
                // Preguntar al usuario si está seguro de crear una nueva membresía
                int confirm = JOptionPane.showConfirmDialog(this, "No se encontró una membresía para este ID. ¿Desea crear una membresía nueva?", "Confirmar creación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Guardar el ID antes de limpiar el campo
                    String idSocioPrevio = txtIdSocio.getText();
                    limpiarCampos();
                    // Restaurar el ID previo
                    txtIdSocio.setText(idSocioPrevio);
                    habilitarCampos();
                    btnGuardar.setEnabled(true);
                    btnModificar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    btnBuscar.setEnabled(false);

                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Ingrese un ID válido");
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        limpiarCampos();
        habilitarCampos();
        btnGuardar.setEnabled(true);
        btnBuscar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtIdSocio.requestFocusInWindow();
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if (!btnGuardar.isEnabled()) {
            return; // No hacer nada si el botón de guardar está desactivado
        }
        //chequear campos competos
        if (comprobarCamposCompletos() && validarFechas()) {
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
                System.out.println("a ver");
                inicializarVista();

            } catch (NumberFormatException e) {
                // Manejar el caso en que el ID del socio ingresado no sea un número válido
                JOptionPane.showMessageDialog(this, "El ID del socio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            limpiarCampos();
            inicializarVista();
        }

    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        if (!btnModificar.isEnabled()) {
            return; // No hacer nada si el botón de modificar está desactivado
        }
        // Comprobar si todos los campos están completos
        if (!comprobarCamposCompletos()) {
            return; // Si algún campo está incompleto, salir del método
        }

        try {
            // Recolectar los datos de los campos
            int idMembresia = Integer.parseInt(txtIdMembresia.getText());
            int idSocio = Integer.parseInt(txtIdSocio.getText());
            int cantidadPases = Integer.parseInt((String) cbCantidadPases.getSelectedItem());
            LocalDate fechaInicio = txtFechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaFin = txtFechaFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            double precio = Double.parseDouble(txtPrecio.getText());

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
            inicializarVista();
            btnModificar.setEnabled(false);

        } catch (NumberFormatException e) {
            // Manejar el caso en que el ID del socio ingresado no sea un número válido
            JOptionPane.showMessageDialog(this, "El ID del socio y el ID de la membresía deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si hay un error
        }

        // Limpiar los campos después de guardar la membresía
        limpiarCampos();

        // Inicializar vista de nuevo
        inicializarVista();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        if (!btnEliminar.isEnabled()) {
            return; // No hacer nada si el botón de eliminar está desactivado
        }

        String idSocioStr = txtIdSocio.getText().trim();
        if (idSocioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe elegir una membresía para eliminar");
            return;
        }
        try {
            int idSocio = Integer.parseInt(idSocioStr); // Esto debe ser el ID de socio
            Membresia membresia = accesoMembresia.buscarMembresiaPorIdSocio(idSocio); // Buscar membresía por ID de membresía
            if (membresia != null) {
                cargarDatos(membresia);
                // Preguntar al usuario si está seguro de eliminar la membresía

                int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar la membresía número " + membresia.getIdMembresia() + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) {
                    return; // Si el usuario no confirma, salir del método
                }

                // Llamar al método para eliminar la membresía en la base de datos
                accesoMembresia.eliminarMembresia(membresia.getIdMembresia());

                // Limpiar los campos después de eliminar la membresía
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la membresía con el ID proporcionado.");
            }
        } catch (NumberFormatException e) {
            // Manejar el caso en que el ID de la membresía ingresado no sea un número válido
            JOptionPane.showMessageDialog(this, "El ID de la membresía debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    // ==================== EVENTOS =======================

    private void cbMembresiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMembresiasActionPerformed
        String seleccion = (String) cbMembresias.getSelectedItem();

        if (seleccion.equals("Membresia")) {
            // Llamar al método para listar todas las membresías
            List<Membresia> membresias = accesoMembresia.listarMembresia();
            listarTabla(membresias);
            txtFiltrar.setEnabled(true);
        } else if (seleccion.equals("Socio")) {
            // Llamar al método para listar todas las membresías ordenadas por ID de socio
            List<Membresia> membresias = accesoMembresia.listarMembresiaPorIdSocio();
            listarTabla(membresias);
            txtFiltrar.setEnabled(true);
        } else if (seleccion.equals("Cantidad de pases")) {
            // Llamar al método para listar todas las membresías ordenadas por cantidad de pases
            List<Membresia> membresias = accesoMembresia.listarMembresiaPorCantidadPases();
            listarTabla(membresias);
            txtFiltrar.setEnabled(true);
        } else if (seleccion.equals("Fecha de inicio")) {
            // Llamar al método para listar todas las membresías ordenadas por fecha de inicio
            List<Membresia> membresias = accesoMembresia.listarMembresiaPorFechaInicio();
            listarTabla(membresias);
            txtFiltrar.setEnabled(true);
        } else if (seleccion.equals("Fecha de fin")) {
            // Llamar al método para listar todas las membresías ordenadas por fecha de fin
            List<Membresia> membresias = accesoMembresia.listarMembresiaPorFechaFin();
            listarTabla(membresias);
            txtFiltrar.setEnabled(true);
        } else if (seleccion.equals("Precio")) {
            // Llamar al método para listar todas las membresías ordenadas por precio
            List<Membresia> membresias = accesoMembresia.listarMembresiaPorCosto();
            listarTabla(membresias);
            txtFiltrar.setEnabled(true);
        }
    }//GEN-LAST:event_cbMembresiasActionPerformed

    private void txtFiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarKeyReleased
        String filtro = txtFiltrar.getText().trim();
        String seleccion = (String) cbMembresias.getSelectedItem();

        List<Membresia> listaFiltrada = filtrarMembresias(seleccion, filtro);
        listarTabla(listaFiltrada);
    }//GEN-LAST:event_txtFiltrarKeyReleased

    private void txtFiltrarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFiltrarFocusGained
        if (txtFiltrar.getText().equals("Escriba aquí...")) {
            txtFiltrar.setText("");
            txtFiltrar.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtFiltrarFocusGained

    private void txtFiltrarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFiltrarFocusLost
        if (txtFiltrar.getText().isEmpty()) {
            txtFiltrar.setText("Escriba aquí...");
            txtFiltrar.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtFiltrarFocusLost

    private void tblTablaMembresiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMembresiaMouseClicked
        if (evt.getClickCount() == 2) { //escuchar el doble click
            int row = tblTablaMembresia.getSelectedRow();
            if (row != -1) {
                //rescatamos la info de la columna socio q es la 1
                int idSocio = (int) tblTablaMembresia.getValueAt(row, 1);

                try {
                    Membresia membresia = accesoMembresia.buscarMembresiaPorIdSocio(idSocio);
                    if (membresia != null) {
                        cargarDatos(membresia);
                        txtIdSocio.setText(String.valueOf(idSocio)); //pintar idSocio 
                        habilitarCampos();
                        btnModificar.setEnabled(true);
                        btnEliminar.setEnabled(true);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese un ID válido");
                }
            }
        }

    }//GEN-LAST:event_tblTablaMembresiaMouseClicked


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
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblMembresia;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSocio;
    private javax.swing.JTable tblTablaMembresia;
    private com.toedter.calendar.JDateChooser txtFechaFin;
    private com.toedter.calendar.JDateChooser txtFechaInicio;
    private javax.swing.JTextField txtFiltrar;
    private javax.swing.JTextField txtIdMembresia;
    private javax.swing.JTextField txtIdSocio;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
