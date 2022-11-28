package com.vista;

import com.controlador.dao.CtrlUsuarioDao;
import com.controlador.view.CtrlUserView;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import com.modelo.Hash;
import com.modelo.Usuario;
import java.util.ArrayList;
import javax.swing.table.TableColumnModel;

public class gestionUsuario extends javax.swing.JInternalFrame {

    CtrlUsuarioDao ctrl = new CtrlUsuarioDao();
    CtrlUserView cuw = new CtrlUserView();
    private final TableColumnModel columnModel;
    private int num = 0;

    public gestionUsuario() {

        initComponents();
        columnModel = jtb_usuarios.getColumnModel();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        this.llenarCombo();
        this.listar();
        this.iniciar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_fullname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_usuarios = new javax.swing.JTable();
        newUsuario = new javax.swing.JButton();
        saveUsuario = new javax.swing.JButton();
        editUsuario = new javax.swing.JButton();
        deleteUsuario = new javax.swing.JButton();
        typeUser = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        passwordField_password = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setFocusable(false);
        setFrameIcon(null);
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(992, 623));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Registro de usuarios");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setText("Llene la información respectiva de los usuarios.");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre completo *");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Tipo de usuario *");

        txt_fullname.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_fullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fullnameKeyPressed(evt);
            }
        });

        jtb_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_usuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_usuarios);

        newUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/nuevo_norm.png"))); // NOI18N
        newUsuario.setBorder(null);
        newUsuario.setBorderPainted(false);
        newUsuario.setContentAreaFilled(false);
        newUsuario.setFocusPainted(false);
        newUsuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/nuevo_press.png"))); // NOI18N
        newUsuario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/nuevo_roll.png"))); // NOI18N
        newUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newUsuarioMousePressed(evt);
            }
        });

        saveUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/save_norm.png"))); // NOI18N
        saveUsuario.setBorder(null);
        saveUsuario.setBorderPainted(false);
        saveUsuario.setContentAreaFilled(false);
        saveUsuario.setFocusPainted(false);
        saveUsuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/save_press.png"))); // NOI18N
        saveUsuario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/save_roll.png"))); // NOI18N
        saveUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveUsuarioMousePressed(evt);
            }
        });

        editUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/editar_norm.png"))); // NOI18N
        editUsuario.setBorder(null);
        editUsuario.setBorderPainted(false);
        editUsuario.setContentAreaFilled(false);
        editUsuario.setFocusPainted(false);
        editUsuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/editar_press.png"))); // NOI18N
        editUsuario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/editar_roll.png"))); // NOI18N
        editUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editUsuarioMousePressed(evt);
            }
        });

        deleteUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/eliminar_norm.png"))); // NOI18N
        deleteUsuario.setBorder(null);
        deleteUsuario.setBorderPainted(false);
        deleteUsuario.setContentAreaFilled(false);
        deleteUsuario.setFocusPainted(false);
        deleteUsuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/eliminar_press.png"))); // NOI18N
        deleteUsuario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/eliminar_roll.png"))); // NOI18N
        deleteUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteUsuarioMousePressed(evt);
            }
        });

        typeUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tipo de usuario" }));
        typeUser.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nombre de usuario *");

        txt_username.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usernameKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Contraseña *");

        passwordField_password.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(682, 682, 682))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_username)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_fullname)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(typeUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(passwordField_password)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(newUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(90, 90, 90)
                .addComponent(saveUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(90, 90, 90)
                .addComponent(editUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(90, 90, 90)
                .addComponent(deleteUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(typeUser)
                    .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveUsuario)
                    .addComponent(newUsuario)
                    .addComponent(editUsuario)
                    .addComponent(deleteUsuario))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editUsuarioMousePressed
        num = 1;
        this.activar();
        editUsuario.setEnabled(false);
        saveUsuario.setEnabled(true);
        deleteUsuario.setEnabled(false);
    }//GEN-LAST:event_editUsuarioMousePressed

    private void deleteUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteUsuarioMousePressed
        int fila = jtb_usuarios.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        } else {
            int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?", "Eliminar Producto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == 0) {
                
                //respuestaBD es la respuesta que nos da la base de datos
                int respuestaBD = ctrl.eliminar(jtb_usuarios.getValueAt(jtb_usuarios.getSelectedRow(), 2).toString());
                
                if ( respuestaBD> 0) {
                    
                    JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
                    listar();
                    limpiar();
                    deleteUsuario.setEnabled(false);
                    editUsuario.setEnabled(false);
                    saveUsuario.setEnabled(false);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No es posible eliminar el usuario");
                }
            }
        }
    }//GEN-LAST:event_deleteUsuarioMousePressed

    private void saveUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveUsuarioMousePressed

        if (num == 0) {

            this.Signin();

        } else {

            this.updateValidate();

        }


    }//GEN-LAST:event_saveUsuarioMousePressed

    private void newUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newUsuarioMousePressed

        this.activar();
        this.limpiar();
        saveUsuario.setEnabled(true);

    }//GEN-LAST:event_newUsuarioMousePressed

    private void jtb_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_usuariosMouseClicked

        editUsuario.setEnabled(true);
        deleteUsuario.setEnabled(true);

        int row = jtb_usuarios.getSelectedRow();
        txt_fullname.setText(jtb_usuarios.getValueAt(row, 1).toString());
        txt_username.setText(jtb_usuarios.getValueAt(row, 2).toString());
        passwordField_password.setText("");
        typeUser.setSelectedItem((String) jtb_usuarios.getValueAt(row, 3));

    }//GEN-LAST:event_jtb_usuariosMouseClicked

    private void txt_fullnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fullnameKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_username.requestFocus();
        }

    }//GEN-LAST:event_txt_fullnameKeyPressed

    private void txt_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            passwordField_password.requestFocus();
        }

    }//GEN-LAST:event_txt_usernameKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteUsuario;
    private javax.swing.JButton editUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb_usuarios;
    private javax.swing.JButton newUsuario;
    private javax.swing.JPasswordField passwordField_password;
    private javax.swing.JButton saveUsuario;
    private javax.swing.JTextField txt_fullname;
    private javax.swing.JTextField txt_username;
    private javax.swing.JComboBox<String> typeUser;
    // End of variables declaration//GEN-END:variables

    //Logica visual y de experiencia
    private void activar() {

        txt_fullname.setEditable(true);
        txt_username.setEditable(true);
        passwordField_password.setEditable(true);
        typeUser.setEnabled(true);
        txt_fullname.requestFocus();

    }

    private void limpiar() {

        txt_fullname.setText("");
        txt_username.setText("");
        txt_fullname.requestFocus();
        passwordField_password.setText("");
        typeUser.setSelectedIndex(0);

    }

    private void iniciar() {
        txt_fullname.setEditable(false);
        txt_username.setEditable(false);
        passwordField_password.setEditable(false);
        typeUser.setEnabled(false);
        editUsuario.setEnabled(false);
        deleteUsuario.setEnabled(false);
        saveUsuario.setEnabled(false);
    }

    private void listar() {
        jtb_usuarios.setModel(cuw.getDatosUsers());
        columnModel.getColumn(1).setPreferredWidth(600);
    }

    private void llenarCombo() {

        ArrayList<String> obj = cuw.getTypeUsers();

        for (String i : obj) {

            typeUser.addItem(i);
        }

    }

    //Logica de negocio de cada uno de los metodos y sus respectivas validaciones
    private void Signin() {

        //Validacion de los campos vacios
        if (!txt_fullname.getText().isEmpty()
                && !txt_username.getText().isEmpty()
                && typeUser.getSelectedIndex() != 0
                && !passwordField_password.getText().isEmpty()) {

            String username = txt_username.getText();

            //Validacion de existencia de usuario
            if (!ctrl.existeUser(username)) {

                String pass = new String(passwordField_password.getPassword());
                String newPass = Hash.sha1(pass); //Cifrado de la contraseña

                Usuario usr = new Usuario();

                usr.setUserName(txt_username.getText().trim());
                usr.setFullname(txt_fullname.getText());
                usr.setTypeUserId(typeUser.getSelectedIndex());
                usr.setPassword(newPass);

                if (ctrl.signinUser(usr)) {//LLamada al metodo DAO

                    JOptionPane.showMessageDialog(null, "El usuario fue creado exitosamente");
                    this.listar();
                    this.limpiar();
                    this.iniciar();
                    num = 0;

                } else {

                    JOptionPane.showMessageDialog(null, "Ocurrio un error intentelo nuevamente");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un usuario con este username, favor utilice otro");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");

        }
    }

    private void updateValidate() {

        //Validacion de los campos vacios
        if (!txt_fullname.getText().isEmpty()
                && !txt_username.getText().isEmpty()
                && typeUser.getSelectedIndex() != 0
                && !passwordField_password.getText().isEmpty()) {

            int row = jtb_usuarios.getSelectedRow();
            String username = txt_username.getText();

            //codigo, descripcion(Nueva),codigo_old (Codigo viejo)
            String username_old = jtb_usuarios.getValueAt(row, 2).toString();

            //comprobar si no han sufrido cambio el username
            if (!username.equals(username_old)) {

                //Validacion de existencia de usuario
                if (!ctrl.existeUser(username.trim())) {
                    this.update(username_old);

                } else {

                    JOptionPane.showMessageDialog(null, "Ya existe un usuario con este username, favor utilice otro");
                }
            } else {

                this.update(username_old);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar");
        }
    }

    private void update(String username_old) {

        String pass = new String(passwordField_password.getPassword());
        String newPass = Hash.sha1(pass); //Cifrado de la nueva contraseña

        Usuario usr = new Usuario();

        usr.setUserName(txt_username.getText().trim());
        usr.setFullname(txt_fullname.getText());
        usr.setTypeUserId(typeUser.getSelectedIndex());
        usr.setPassword(newPass);

        int res = ctrl.actualizar(usr, username_old);//LLamada al metodo DAO

        if (res > 0) {

            JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito");
            listar();
            limpiar();
            iniciar();
            num = 0;

        } else {

            JOptionPane.showMessageDialog(null, "El usuario no pudo ser actualizado");

        }
    }
}
