package com.vista;

import com.modelo.Producto;
import java.awt.event.KeyEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import com.controlador.dao.CtrlProductoDao;
import com.controlador.view.CtrlProductView;
import com.modelo.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

public class gestionProducto extends javax.swing.JInternalFrame {

    private final CtrlProductoDao cpdao; //Controlador de inserciones o eliminaciones en la base de datos
    private final TableColumnModel columnModel;
    private final CtrlProductView cpv; //Controlador de la vista
    private int num = 0;
    private Usuario usr;

    public gestionProducto(Usuario obj) {

        //Incio de los componentes de la vista
        initComponents();

        //Iniciacion de variables necesarias para la logica de negocio
        columnModel = jtb_productos.getColumnModel();
        cpv = new CtrlProductView();
        cpdao = new CtrlProductoDao();
        this.usr = obj;

        //Inciciacion de metodos para la experiencia de usuario
        this.listar(); //Muestra y da formato a los valores de la base de datos
        this.iniciar();

        //Valores por default de la vista
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        editProducto.setEnabled(false);
        deleteProducto.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_productos = new javax.swing.JTable();
        newProducto = new javax.swing.JButton();
        saveProducto = new javax.swing.JButton();
        editProducto = new javax.swing.JButton();
        deleteProducto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setFocusable(false);
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(992, 623));
        setName(""); // NOI18N
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(992, 623));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Registro de Productos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setText("Llene la información respectiva de los productos.");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Código de Producto *");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Descripción *");

        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoKeyPressed(evt);
            }
        });

        jtb_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_productos);

        newProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/nuevo_norm.png"))); // NOI18N
        newProducto.setBorder(null);
        newProducto.setBorderPainted(false);
        newProducto.setContentAreaFilled(false);
        newProducto.setFocusPainted(false);
        newProducto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/nuevo_press.png"))); // NOI18N
        newProducto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/nuevo_roll.png"))); // NOI18N
        newProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newProductoMousePressed(evt);
            }
        });

        saveProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/save_norm.png"))); // NOI18N
        saveProducto.setBorder(null);
        saveProducto.setBorderPainted(false);
        saveProducto.setContentAreaFilled(false);
        saveProducto.setFocusPainted(false);
        saveProducto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/save_press.png"))); // NOI18N
        saveProducto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/save_roll.png"))); // NOI18N
        saveProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveProductoMousePressed(evt);
            }
        });

        editProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/editar_norm.png"))); // NOI18N
        editProducto.setBorder(null);
        editProducto.setBorderPainted(false);
        editProducto.setContentAreaFilled(false);
        editProducto.setFocusPainted(false);
        editProducto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/editar_press.png"))); // NOI18N
        editProducto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/editar_roll.png"))); // NOI18N
        editProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editProductoMousePressed(evt);
            }
        });

        deleteProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/eliminar_norm.png"))); // NOI18N
        deleteProducto.setBorder(null);
        deleteProducto.setBorderPainted(false);
        deleteProducto.setContentAreaFilled(false);
        deleteProducto.setFocusPainted(false);
        deleteProducto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/eliminar_press.png"))); // NOI18N
        deleteProducto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/eliminar_roll.png"))); // NOI18N
        deleteProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteProductoMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Precio *");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                        .addGap(682, 682, 682))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_codigo)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_descripcion)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_precio)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1))
                        .addGap(55, 55, 55))))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(newProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(90, 90, 90)
                .addComponent(saveProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(90, 90, 90)
                .addComponent(editProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(90, 90, 90)
                .addComponent(deleteProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveProducto)
                    .addComponent(newProducto)
                    .addComponent(editProducto)
                    .addComponent(deleteProducto))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProductoMousePressed

        num = 1;
        activar();
        editProducto.setEnabled(false);
        saveProducto.setEnabled(true);
        deleteProducto.setEnabled(false);

    }//GEN-LAST:event_editProductoMousePressed

    private void deleteProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteProductoMousePressed

        int fila = jtb_productos.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        } else {
            int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?", "Eliminar Producto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == 0) {
                if (cpdao.deleteProduct(jtb_productos.getValueAt(jtb_productos.getSelectedRow(), 1).toString()) > 0) {
                    JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
                    listar();
                    limpiar();
                    deleteProducto.setEnabled(false);
                    editProducto.setEnabled(false);
                    saveProducto.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "No es posible eliminar el producto.");
                }
            }
        }
    }//GEN-LAST:event_deleteProductoMousePressed

    private void saveProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveProductoMousePressed

        String codigo = txt_codigo.getText();
        String descripcion = txt_descripcion.getText();
        double precio = Double.parseDouble(txt_precio.getText());

        if (num == 0) {

            this.newP(codigo, descripcion, precio);

        } else {

            int row = jtb_productos.getSelectedRow();
            
            //codigo, descripcion(Nueva),codigo_old (Codigo viejo)
            String codigo_old = jtb_productos.getValueAt(row, 1).toString();

            //comprobar si no han sufrido cambios los codigos
            if (!codigo.equals(codigo_old)) { 
                
                //comprobar si ya existe un producto con el mismo codigo que no sea el mismo
                if (!cpdao.existeProduct(codigo.trim())) {
                    this.updateProducto(codigo, descripcion, codigo_old, precio);
                } else {
                    JOptionPane.showMessageDialog(null, "No se"
                            + " pudieron realizar los cambios, ya existe otro producto con la misma referencia");
                }
            }else{
                this.updateProducto(codigo, descripcion, codigo_old, precio);
            }

        }

    }//GEN-LAST:event_saveProductoMousePressed

    private void newProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProductoMousePressed

        this.activar();

    }//GEN-LAST:event_newProductoMousePressed

    private void jtb_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_productosMouseClicked

        editProducto.setEnabled(true);
        deleteProducto.setEnabled(true);

        int row = jtb_productos.getSelectedRow();
        txt_codigo.setText(jtb_productos.getValueAt(row, 1).toString());
        txt_descripcion.setText(jtb_productos.getValueAt(row, 2).toString());
        txt_precio.setText(jtb_productos.getValueAt(row, 3).toString());


    }//GEN-LAST:event_jtb_productosMouseClicked

    private void txt_codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            txt_descripcion.requestFocus();

        }
    }//GEN-LAST:event_txt_codigoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteProducto;
    private javax.swing.JButton editProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb_productos;
    private javax.swing.JButton newProducto;
    private javax.swing.JButton saveProducto;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables

    //Logica visual y de experiencia
    private void limpiar() {

        txt_codigo.setText("");
        txt_descripcion.setText("");
        txt_precio.setText("");
        txt_codigo.requestFocus();

    }

    private void listar() {
        jtb_productos.setModel(cpv.getDatosProductos());
        columnModel.getColumn(1).setPreferredWidth(600);
    }

    private void iniciar() {
        txt_codigo.setEditable(false);
        txt_descripcion.setEditable(false);
        txt_precio.setEditable(false);
        saveProducto.setEnabled(false);
    }

    private void activar() {
        txt_codigo.setEditable(true);
        txt_descripcion.setEditable(true);
        txt_precio.setEditable(true);
        txt_codigo.requestFocus();
        saveProducto.setEnabled(true);
    }

    //Logica de negocio de cada uno de los metodos
    private void newP(String codigo, String descripcion, double precio) { //Conexion con el controlador
        //de producto dao

        Producto obj = new Producto();
        obj.setReferencia(codigo);
        obj.setDescripcion(descripcion);
        obj.setPrecio(precio);
        CtrlProductoDao dao = new CtrlProductoDao();

        if (!dao.existeProduct(obj.getReferencia().trim())) {
            if (dao.createProduct(obj)) {
                if(dao.verificarCodigoInventario(codigo)==0){
                    dao.insertarProductoInventario(codigo,usr);
                }
                JOptionPane.showMessageDialog(null, "Producto registrado con éxito.");

            } else {

                JOptionPane.showMessageDialog(null, "No se pudo registrar el producto.");

            }
        } else {
            JOptionPane.showMessageDialog(null, "El producto ya fue registrado");
        }
        this.listar();
        this.limpiar();
        this.iniciar();
        editProducto.setEnabled(false);
    }

    private void updateProducto(String codigo, String descripcion, String codigo_old, double precio) {
        int respuesta = cpdao.updateProduct(codigo, descripcion, codigo_old, precio);

        if (respuesta > 0) {
            JOptionPane.showMessageDialog(null, "Producto actualizado con éxito");
            listar();
            limpiar();
            iniciar();
            num = 0;
        } else {
            JOptionPane.showMessageDialog(null, "El producto no pudo ser actualizado");
        }
    }
}
