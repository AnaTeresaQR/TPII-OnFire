package views;

import controllers.ManageSalesController;
import controllers.PrincipalController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author
 */
public class ShowOwnSalesView extends javax.swing.JFrame {

    private PrincipalController controller;//ya no se usaría en esta ventana
    private int selection;
    private ManageSalesController manageSalesController;

    public ShowOwnSalesView(PrincipalController controller, ManageSalesController manageSalesController) {
        initComponents();
        this.controller = controller;
        this.manageSalesController = manageSalesController;
        // initSaleApproveList(sales);
        this.setLocationRelativeTo(null);
        initOwnSalesList();
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
        SaleApproveList = new javax.swing.JList<>();
        lbContactLisr = new javax.swing.JLabel();
        bt_back = new javax.swing.JButton();
        bt_show = new javax.swing.JButton();
        jb_deleteSale = new javax.swing.JButton();
        bt_addSale = new javax.swing.JButton();
        bt_modify = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        SaleApproveList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(SaleApproveList);

        lbContactLisr.setText("Contact List");

        bt_back.setText("Regresar");
        bt_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backActionPerformed(evt);
            }
        });

        bt_show.setText("Ver ");
        bt_show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_showActionPerformed(evt);
            }
        });

        jb_deleteSale.setText("Eliminar");

        bt_addSale.setText("Agregar");
        bt_addSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addSaleActionPerformed(evt);
            }
        });

        bt_modify.setText("Modificar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(lbContactLisr, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_back)
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jb_deleteSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bt_modify)
                            .addComponent(bt_addSale))
                        .addGap(44, 44, 44)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbContactLisr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_modify)
                    .addComponent(jb_deleteSale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_addSale)
                    .addComponent(bt_back)
                    .addComponent(bt_show))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backActionPerformed
        this.selection = 0;
        try {
           
            controller.processConfirmationAction(false);
             controller.selectAction(selection);
            controller.showMenu(controller, this);
        } catch (IOException ex) {
            System.out.println("" + ex.getMessage());
        }
    }//GEN-LAST:event_bt_backActionPerformed

    private void bt_showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_showActionPerformed


    }//GEN-LAST:event_bt_showActionPerformed

    private void bt_addSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addSaleActionPerformed
        this.selection = 4;
        try {
            controller.selectAction(selection);
//            manageSalesController.selectActionAddSale(selection);
            controller.showAddSale(manageSalesController, this);
        } catch (IOException ex) {
            Logger.getLogger(UserMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_addSaleActionPerformed

    private void initSaleApproveList(ArrayList registeredSales) {

        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < registeredSales.size(); i++) {
            model.addElement(registeredSales.get(i));

        }
        SaleApproveList.setModel(model);
    }
    
    private void initOwnSalesList(){
        DefaultListModel model = new DefaultListModel();
        Map<String, String> sale = controller.getOwnSalesTree();
        
        Iterator<String> iteratorList;
        
        List list = new ArrayList(sale.values());
        iteratorList = list.iterator();
        
        
        while (iteratorList.hasNext()) {
            model.addElement("INFO: " +iteratorList.next());
            
            System.out.println("initSaleWaitingList -> Agrego elementos");
        }
        
        SaleApproveList.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> SaleApproveList;
    private javax.swing.JButton bt_addSale;
    private javax.swing.JButton bt_back;
    private javax.swing.JButton bt_modify;
    private javax.swing.JButton bt_show;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_deleteSale;
    private javax.swing.JLabel lbContactLisr;
    // End of variables declaration//GEN-END:variables
}
