/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Resources.*;
import Utility.*;
import Accounts.*;
import apexsystem.ResourceHandler;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lpjan
 */
public class ResourceListForm extends javax.swing.JFrame {

    private ResourceHandler resourceHandler;
    private long lastClickTime;
    private User user;
    
    /**
     * Creates new form ResourceListForm
     */
    public ResourceListForm(ResourceHandler resourceHandler, User user) {
        this.resourceHandler = resourceHandler;
        lastClickTime = 0;
        this.user = user;
        
        initComponents();
        
        user.Lock(resourceHandler.resourceList);
        FillTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        resourceTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(750, 500));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        resourceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "Category", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resourceTable.setCellSelectionEnabled(false);
        resourceTable.setRowSelectionAllowed(true);
        resourceTable.getTableHeader().setReorderingAllowed(false);
        resourceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resourceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(resourceTable);
        resourceTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (resourceTable.getColumnModel().getColumnCount() > 0) {
            resourceTable.getColumnModel().getColumn(0).setResizable(false);
            resourceTable.getColumnModel().getColumn(1).setResizable(false);
            resourceTable.getColumnModel().getColumn(2).setResizable(false);
            resourceTable.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resourceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resourceTableMouseClicked

        if (System.currentTimeMillis() - lastClickTime <= 500){
            System.out.println("Double Click");
            OpenItem();
        }
        
        lastClickTime = System.currentTimeMillis();
    }//GEN-LAST:event_resourceTableMouseClicked

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
            java.util.logging.Logger.getLogger(ResourceListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResourceListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResourceListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResourceListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }
    
    public void FillTable(){
        
        DefaultTableModel tableModel = (DefaultTableModel) resourceTable.getModel();
        tableModel.setRowCount(0);
              
        for (Resource resource : resourceHandler.resourceList){
            tableModel.addRow(new Object[]{resource.getName(), resource.getType().name(), Utility.GetTypeFromDD(resource.getCategory()), resource.getUserRating()});
        }
    }
    
    private void OpenItem(){ 
        ResourceInfoForm form = new ResourceInfoForm(resourceHandler.resourceList.get(resourceTable.getSelectedRow()), user, this);
        form.setVisible(true);
        form.setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resourceTable;
    // End of variables declaration//GEN-END:variables
}
