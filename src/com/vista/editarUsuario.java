package com.vista;

import com.controlador.dao.CtrlUsuarioDao;
import com.modelo.Hash;
import com.modelo.Usuario;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class editarUsuario extends javax.swing.JInternalFrame {

    private Usuario user;
    CtrlUsuarioDao ctrl = new CtrlUsuarioDao();

    public editarUsuario() {

        initComponents();
        this.iniciar();

    }

    public editarUsuario(Usuario usr) {
        
        this.user = usr;
        initComponents();
        this.iniciar();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        saveChanges = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        changeUsername = new javax.swing.JRadioButton();
        changePassword = new javax.swing.JRadioButton();
        changeBoth = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setFocusable(false);
        setFrameIcon(null);
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(992, 623));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Editar usuario");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel3.setText("Llene la información respectiva de su usuario.");

        saveChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/save_norm.png"))); // NOI18N
        saveChanges.setBorder(null);
        saveChanges.setBorderPainted(false);
        saveChanges.setContentAreaFilled(false);
        saveChanges.setFocusPainted(false);
        saveChanges.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/save_press.png"))); // NOI18N
        saveChanges.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/save_roll.png"))); // NOI18N
        saveChanges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveChangesMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Nuevo nombre de usuario *");

        txt_username.setEditable(false);
        txt_username.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_username.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usernameKeyPressed(evt);
            }
        });

        password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        password.setText("Nueva contraseña *");

        txt_password.setEditable(false);
        txt_password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_password.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });

        changeUsername.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(changeUsername);
        changeUsername.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        changeUsername.setText("Cambiar nombre de usuario");
        changeUsername.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        changeUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeUsernameActionPerformed(evt);
            }
        });

        changePassword.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(changePassword);
        changePassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        changePassword.setText("Cambiar contraseña");
        changePassword.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });

        changeBoth.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(changeBoth);
        changeBoth.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        changeBoth.setText("Ambos");
        changeBoth.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        changeBoth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBothActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Elija una opción:");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(changeBoth)
                                    .addComponent(changeUsername)
                                    .addComponent(changePassword)
                                    .addComponent(jLabel5))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_username)
                                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(saveChanges, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(password)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(changeUsername)
                        .addGap(9, 9, 9)
                        .addComponent(changePassword)
                        .addGap(9, 9, 9)
                        .addComponent(changeBoth)))
                .addGap(18, 18, 18)
                .addComponent(saveChanges)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveChangesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveChangesMousePressed

        if (!txt_username.isEditable() && txt_password.isEditable()) {
            // cambiar contraseña
            this.changePassword();
        } else if (!txt_password.isEditable() && txt_username.isEditable()) {
            //cambiar username
            this.changeUsername();
        } else {
            //cambiar ambos
            this.changeBoth();
        }

    }//GEN-LAST:event_saveChangesMousePressed

    private void txt_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_password.requestFocus();
        }

    }//GEN-LAST:event_txt_usernameKeyPressed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //this.update();
        }
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void changeUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUsernameActionPerformed
        this.isSelect();
    }//GEN-LAST:event_changeUsernameActionPerformed

    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        this.isSelect();
    }//GEN-LAST:event_changePasswordActionPerformed

    private void changeBothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBothActionPerformed
        this.isSelect();
    }//GEN-LAST:event_changeBothActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton changeBoth;
    private javax.swing.JRadioButton changePassword;
    private javax.swing.JRadioButton changeUsername;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel password;
    private javax.swing.JButton saveChanges;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

    private void iniciar() {

        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        changeBoth.setSelected(true);
        this.isSelect();
    }

    private void isSelect() {

        if (changeUsername.isSelected()) {
            txt_username.setEditable(true);
            txt_password.setEditable(false);

        } else if (changePassword.isSelected()) {
            txt_username.setEditable(false);
            txt_password.setEditable(true);
        } else {
            txt_username.setEditable(true);
            txt_password.setEditable(true);
        }
    }

    private void changePassword() {

        String username = this.user.getUserName();
        if (!txt_password.getText().isEmpty()) {
            String pass = new String(txt_password.getPassword());
            String newPass = Hash.sha1(pass); //Cifrado de la contraseña
            int res = ctrl.changePassword(username, newPass);
            if(res>0){
                JOptionPane.showMessageDialog(null,"Datos actualizados correctamente");
            }else{
                JOptionPane.showMessageDialog(null,"Ocurrio un error al moemnto de actualizar sus datos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La contraseña no puede quedar vacía");
        }

    }

    private void changeUsername() {

        String username_old = this.user.getUserName();

        if (!txt_username.getSelectedText().isEmpty()) {

            String username_new = txt_username.getSelectedText();
            int res = ctrl.changeUsername(username_old, username_new);
            if(res>0){
                JOptionPane.showMessageDialog(null,"Datos actualizados correctamente");
            }else{
                JOptionPane.showMessageDialog(null,"Ocurrio un error al moemnto de actualizar sus datos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no puede estar en blanco");
        }

    }

    private void changeBoth() {

        String username_old = this.user.getUserName();
        
        if (!txt_username.getSelectedText().isEmpty() && !txt_password.getText().isEmpty()) {
            
            String pass = new String(txt_password.getPassword());
            String newPass = Hash.sha1(pass); //Cifrado de la contraseña
            String username_new = txt_username.getSelectedText();
            int res =ctrl.changeBoth(username_old, username_new, newPass);
            if(res>0){
                JOptionPane.showMessageDialog(null,"Datos actualizados correctamente");
            }else{
                JOptionPane.showMessageDialog(null,"Ocurrio un error al moemnto de actualizar sus datos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no puede estar en blanco");
        }
    }
}
