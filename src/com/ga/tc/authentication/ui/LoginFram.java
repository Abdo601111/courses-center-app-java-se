/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ga.tc.authentication.ui;

import com.ga.tc.authentication.bao.UserBao;
import com.ga.tc.authentication.bao.UserBaoImpl;
import com.ga.tc.authentication.dto.UserInfoDto;
import com.ga.tc.common.Constants;
import com.ga.tc.common.GenericDto;
import com.ga.tc.common.ui.MainFrame;
import java.awt.ComponentOrientation;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author pc
 */
public class LoginFram extends javax.swing.JFrame {
    private UserBao business = new UserBaoImpl();
    /**
     * Creates new form LoginFram
     */
    public LoginFram() {
        initComponents();
        errorLbl.setVisible(false);
        Locale.setDefault(Locale.ENGLISH);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userEmailTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        errorLbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        localCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/ga/tc/common/lang"); // NOI18N
        jLabel1.setText(bundle.getString("logn_lbl.uName")); // NOI18N

        jLabel2.setText(bundle.getString("logn_lbl.pass")); // NOI18N

        loginButton.setText(bundle.getString("logn_lbl.loginBtn")); // NOI18N
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        errorLbl.setForeground(new java.awt.Color(255, 0, 102));
        errorLbl.setText(bundle.getString("logn_msg.validation_msg")); // NOI18N
        errorLbl.setToolTipText(bundle.getString("logn_msg.validation_msg")); // NOI18N

        jButton1.setText(bundle.getString("logn_lbl.pass_forgot")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        fillInLocalCombo();
        localCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localComboActionPerformed(evt);
            }
        });

        jLabel3.setText(bundle.getString("logn_lbl.language")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(errorLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(userEmailTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                .addComponent(passwordTxt)
                                .addComponent(localCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(errorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(localCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(loginButton))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try{
            StringBuilder msg = new StringBuilder("");
            if("".equals(userEmailTxt.getText().trim())){
                msg.append("-Enter User Email.\n");
            }
            if("".equals(passwordTxt.getText().trim())){
                msg.append("-Enter Password.\n");
            }
            if(!msg.toString().equals("")){
                //errorLbl.setText(msg.toString());
                errorLbl.setVisible(true);
            }else{
                ///connect to back end and authenticate user
                UserInfoDto userInfo =  business.authenticateUser(userEmailTxt.getText().trim(), passwordTxt.getText().trim());
                if(userInfo != null){
                    //open the main screen
                    UIManager.setLookAndFeel(userInfo.getLaf());
                    userInfo.setPassword(passwordTxt.getText().trim());
                    userInfo.setEmail(userEmailTxt.getText().trim());
                    new MainFrame(userInfo).setVisible(true);
                    this.dispose();
                    
                }else{
                    
//                    errorLbl.setText("Invalid Email / Password");
                    userEmailTxt.setText("");
                    passwordTxt.setText("");
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error Ocuured :"+
                    e.getMessage(), "Error" ,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            
            try{
                String email = JOptionPane.showInputDialog(this, "Enter you email!!");
                /**
                 * send an email to the given mail if and only if its there in our db
                 */
                boolean foundInDB = true
                        ;

                if(foundInDB)
                    JOptionPane.showMessageDialog(this, "An email is just sent to ur email!!!",
                            "Check ur mail box", JOptionPane.INFORMATION_MESSAGE);
                else{
                    JOptionPane.showMessageDialog(this, "The mail address you provided doesn't exist in our system",
                            "Mail not found", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
    }//GEN-LAST:event_jButton1ActionPerformed
    //private Locale defLocal;
    private void localComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localComboActionPerformed
        try{
            GenericDto selected = (GenericDto)localCombo.getSelectedItem();
            LoginFram newLogin = new LoginFram();
            if(selected.getValue() == Constants.LOCAL_AR){
                Locale.setDefault(new Locale("ar", "EG"));
                newLogin.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            } else{
                Locale.setDefault(Locale.ENGLISH);
                newLogin.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            }
            this.dispose();
            newLogin.setVisible(true);
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_localComboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LoginFram login = null;
       try {
            login = new LoginFram();
            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
            login.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(login, "Look & Feel not Found", "LAF Missing", JOptionPane.ERROR_MESSAGE);
        }
        
                

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<GenericDto> localCombo;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JTextField userEmailTxt;
    // End of variables declaration//GEN-END:variables

    private void fillInLocalCombo() {
        Vector<GenericDto> items = new Vector<>();
        items.addElement(new GenericDto("العربية", Constants.LOCAL_AR));
        items.addElement(new GenericDto("English", Constants.LOCAL_EN));
        localCombo = new JComboBox<>(items);
    }
}
