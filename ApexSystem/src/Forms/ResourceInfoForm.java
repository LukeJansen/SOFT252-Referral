/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Resources.*;
import Accounts.*;
import Notifications.NotificationType;
import Utility.Utility;
import apexsystem.NotificationHandler;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

/**
 *
 * @author lpjan
 */
public class ResourceInfoForm extends javax.swing.JFrame {

    private Resource resource;
    private User user;
    private ResourceListForm form;
    private NotificationHandler notificationHandler;
    
    /**
     * Creates new form ResourceInfoForm
     */
    public ResourceInfoForm(Resource resource, User user, ResourceListForm form, NotificationHandler notificationHandler) {
        this.resource = resource;
        this.user = user;
        this.form = form;
        this.notificationHandler = notificationHandler;
        
        initComponents();
        
        FillLabels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RatingButtonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        RadioButton1 = new javax.swing.JRadioButton();
        RadioButton2 = new javax.swing.JRadioButton();
        RadioButton3 = new javax.swing.JRadioButton();
        RadioButton4 = new javax.swing.JRadioButton();
        RadioButton5 = new javax.swing.JRadioButton();
        AddRatingButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();
        NameLabel = new javax.swing.JLabel();
        TypeLabel = new javax.swing.JLabel();
        CategoryLabel = new javax.swing.JLabel();
        StatusLabel = new javax.swing.JLabel();
        RatingLabel = new javax.swing.JLabel();
        LoanButton = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();
        DueDateLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ExtensionButton = new javax.swing.JButton();
        RequestReturnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(359, 217));
        setType(java.awt.Window.Type.POPUP);

        jLabel1.setText("Name");

        jLabel2.setText("Resource Type");

        jLabel3.setText("Category");

        jLabel4.setText("Current Status");

        jLabel5.setText("User Rating");

        jLabel7.setText("Rate This Item");

        RatingButtonGroup.add(RadioButton1);
        RadioButton1.setText("1");

        RatingButtonGroup.add(RadioButton2);
        RadioButton2.setText("2");

        RatingButtonGroup.add(RadioButton3);
        RadioButton3.setText("3");

        RatingButtonGroup.add(RadioButton4);
        RadioButton4.setText("4");

        RatingButtonGroup.add(RadioButton5);
        RadioButton5.setText("5");

        AddRatingButton.setText("Add Rating");
        AddRatingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRatingButtonActionPerformed(evt);
            }
        });

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        NameLabel.setText("NULL");

        TypeLabel.setText("NULL");

        CategoryLabel.setText("NULL");

        StatusLabel.setText("NULL");

        RatingLabel.setText("NULL");

        LoanButton.setText("Loan Resource");
        LoanButton.setEnabled(false);
        LoanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanButtonActionPerformed(evt);
            }
        });

        ReturnButton.setText("Return Resource");
        ReturnButton.setEnabled(false);
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        DueDateLabel.setText("NULL");

        jLabel9.setText("Due Date");

        ExtensionButton.setText("Request Extension");
        ExtensionButton.setEnabled(false);
        ExtensionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtensionButtonActionPerformed(evt);
            }
        });

        RequestReturnButton.setText("Request Return");
        RequestReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestReturnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(StatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RatingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DueDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CategoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(34, 34, 34)
                        .addComponent(RadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RadioButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddRatingButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(LoanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ExtensionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RequestReturnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ReturnButton, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(CloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(CategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(StatusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(RatingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(DueDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(RadioButton1)
                    .addComponent(RadioButton2)
                    .addComponent(RadioButton3)
                    .addComponent(RadioButton4)
                    .addComponent(RadioButton5)
                    .addComponent(AddRatingButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExtensionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RequestReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        dispose();
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void AddRatingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRatingButtonActionPerformed
        for (Enumeration buttons = RatingButtonGroup.getElements(); buttons.hasMoreElements();){
            AbstractButton button = (AbstractButton) buttons.nextElement();
            
            if (button.isSelected()){
                resource.addRating(Integer.parseInt(button.getText()));
            }
        }
        
        RatingLabel.setText(resource.getUserRating());
        
        Enumeration<AbstractButton> enumeration = RatingButtonGroup.getElements();
        while (enumeration.hasMoreElements()) {
            enumeration.nextElement().setEnabled(false);
        }
        
        AddRatingButton.setEnabled(false);
        form.FillTable();
    }//GEN-LAST:event_AddRatingButtonActionPerformed

    private void LoanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanButtonActionPerformed
        if (resource.getStatus() == ResourceStatus.AVAILABLE && !user.isLocked()){
            resource.Loan(user);
            FillLabels();
        }
        else if (user.isLocked()){
            JOptionPane.showMessageDialog(this, "You are blocked from loaning resources due to an overdue resource.", "Blocked User", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoanButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        resource.CheckLoan();
        
        if (resource.getStatus() != ResourceStatus.AVAILABLE && resource.getLoanedUser().equals(user.getUserID())){
            if (resource.getStatus() == ResourceStatus.OVERDUE){
                 long daysOverdue = (System.currentTimeMillis() - resource.getDueDate()) / 1;
                 int payResponse = JOptionPane.showConfirmDialog(this, "This resource is " + daysOverdue + " days overdue. You owe £" + (daysOverdue * 0.1) + ". \nDo you agree to pay this?", "Overdue Loan Payment", JOptionPane.YES_NO_OPTION);
                 System.out.println(payResponse);
                 if (payResponse == 0){
                    resource.Return();
                    FillLabels();
                 }
            } else{
                resource.Return();
                FillLabels();
            }
            
        }
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void ExtensionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtensionButtonActionPerformed
        String input = JOptionPane.showInputDialog("How many days extension would you like to request?", 0);
        
        int days = 0;
        
        if (input != null){
        
            try{
                days = Integer.parseInt(input);
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Please enter a whole number only!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            resource.RequestExtension(days);
        }
    }//GEN-LAST:event_ExtensionButtonActionPerformed

    private void RequestReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestReturnButtonActionPerformed
        int input = JOptionPane.showConfirmDialog(this, "Do you want to request " + resource.getName() + " be returned?");
                
                if (input == 0){
                    notificationHandler.Add(user.getUserID(), "Return Request", "An Administrator has requested you return " + resource.getName() + ".", NotificationType.INFO);
                }
    }//GEN-LAST:event_RequestReturnButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ResourceInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResourceInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResourceInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResourceInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }
    
    private void FillLabels(){
        resource.CheckLoan();
        
        NameLabel.setText(resource.getName());
        TypeLabel.setText(resource.getType().name());
        CategoryLabel.setText(Utility.GetTypeFromDD(resource.getCategory()));
        StatusLabel.setText(resource.getStatus().name());
        
        String rating = "No User Ratings Yet!";
        
        if (!"-1.00".equals(resource.getUserRating())){
                rating = resource.getUserRating();
        }
        
        RatingLabel.setText(rating);
        
        String dueDate;
        if (resource.getLoanType() == LoanType.REFERENCE){
            dueDate = "Resource Cannot Be Loaned";
        }
        else if (resource.getDueDate() == 0){
            dueDate = "Resource is Not on Loan";
        }
        else {
            Date date = new Date(resource.getDueDate());
            dueDate = date.toString();
        }
        
        DueDateLabel.setText(dueDate);
        
        LoanButton.setEnabled(resource.getStatus() == ResourceStatus.AVAILABLE && resource.getLoanType() != LoanType.REFERENCE);
        ReturnButton.setEnabled(resource.getLoanedUser().equals(user.getUserID()) && resource.getStatus() != ResourceStatus.AVAILABLE);
        ExtensionButton.setEnabled(resource.getLoanedUser().equals(user.getUserID()) && resource.getStatus() != ResourceStatus.AVAILABLE);
        RequestReturnButton.setVisible(user.getClass() == Administrator.class && resource.getStatus() != ResourceStatus.AVAILABLE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddRatingButton;
    private javax.swing.JLabel CategoryLabel;
    private javax.swing.JButton CloseButton;
    private javax.swing.JLabel DueDateLabel;
    private javax.swing.JButton ExtensionButton;
    private javax.swing.JButton LoanButton;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JRadioButton RadioButton1;
    private javax.swing.JRadioButton RadioButton2;
    private javax.swing.JRadioButton RadioButton3;
    private javax.swing.JRadioButton RadioButton4;
    private javax.swing.JRadioButton RadioButton5;
    private javax.swing.ButtonGroup RatingButtonGroup;
    private javax.swing.JLabel RatingLabel;
    private javax.swing.JButton RequestReturnButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JLabel TypeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
