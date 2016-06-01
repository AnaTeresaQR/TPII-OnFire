package views;

import controllers.ManageSalesController;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana Teresa
 */
public class RegisterSaleView extends javax.swing.JFrame {

    private String brand;
    private String model;
    private int year;
    private String carId;
    private String color;
    private String description;
    private int days;
    private int minOffer;
    private int typeSale;

    private ManageSalesController controller;

    /**
     * Creates new form RegisterUserView
     *
     * @param controller
     */
    public RegisterSaleView(ManageSalesController controller) {
        this.controller = controller;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initVariables() {
        this.brand = jT_brand.getText();
        this.model = jT_Model.getText();
        this.year = Integer.parseInt(jT_Year.getText());
        this.carId = jT_CarId.getText();
        this.color = jT_Color.getText();
        this.description = jT_Description.getText();
        this.days = Integer.parseInt(jT_Days.getText());
        this.minOffer = Integer.parseInt(jT_MinOffer.getText());
        this.typeSale = jC_TypeSAle.getSelectedIndex();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jTextField3 = new javax.swing.JTextField();
        jLabelModel = new javax.swing.JLabel();
        jLabelBrand = new javax.swing.JLabel();
        jLabelYear = new javax.swing.JLabel();
        jLabelCarId = new javax.swing.JLabel();
        jLabelColor = new javax.swing.JLabel();
        jLabelDescrption = new javax.swing.JLabel();
        jT_brand = new javax.swing.JTextField();
        jT_Model = new javax.swing.JTextField();
        jT_Year = new javax.swing.JTextField();
        jT_CarId = new javax.swing.JTextField();
        jT_Color = new javax.swing.JTextField();
        jT_Description = new javax.swing.JTextField();
        jB_return = new javax.swing.JButton();
        jB_register = new javax.swing.JButton();
        jLabelDays = new javax.swing.JLabel();
        jLabelMinOffer = new javax.swing.JLabel();
        jT_Days = new javax.swing.JTextField();
        jT_MinOffer = new javax.swing.JTextField();
        jC_TypeSAle = new javax.swing.JComboBox<String>();
        jLabelTypeSale = new javax.swing.JLabel();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabelModel.setText("Modelo");

        jLabelBrand.setText("Marca");

        jLabelYear.setText("Año");

        jLabelCarId.setText("Número de matrícula");

        jLabelColor.setText("Color");

        jLabelDescrption.setText("Descripción");

        jT_Color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_ColorActionPerformed(evt);
            }
        });

        jB_return.setText("Regresar");
        jB_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_returnActionPerformed(evt);
            }
        });

        jB_register.setText("Registrar");
        jB_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_registerActionPerformed(evt);
            }
        });

        jLabelDays.setText("Diás disponibles ");

        jLabelMinOffer.setText("Oferta mínima");

        jC_TypeSAle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Subasta Abierta", "Subasta Cerrada" }));

        jLabelTypeSale.setText("Tipo de subasta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jB_return)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jB_register))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(jLabelBrand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jT_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelYear)
                            .addComponent(jLabelCarId)
                            .addComponent(jLabelColor)
                            .addComponent(jLabelModel)
                            .addComponent(jLabelDescrption, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDays)
                            .addComponent(jLabelMinOffer)
                            .addComponent(jLabelTypeSale))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jC_TypeSAle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jT_Model, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(jT_CarId)
                            .addComponent(jT_Color)
                            .addComponent(jT_Description)
                            .addComponent(jT_MinOffer)
                            .addComponent(jT_Year)
                            .addComponent(jT_Days))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabelBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelModel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jT_brand, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jT_Model, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_Year, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabelCarId, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jT_CarId)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_Color, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescrption, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_Description, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDays)
                    .addComponent(jT_Days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMinOffer)
                    .addComponent(jT_MinOffer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jC_TypeSAle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTypeSale))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_return)
                    .addComponent(jB_register))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jT_ColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_ColorActionPerformed

    }//GEN-LAST:event_jT_ColorActionPerformed

    private void jB_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_registerActionPerformed

        try {
            this.initVariables();
            String message = controller.createSale(brand, model, year, carId, color, description, days, minOffer, typeSale);
            JOptionPane.showMessageDialog(null, "Resultado de Registrar\n" + message);
            
            this.dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_jB_registerActionPerformed

    private void jB_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_returnActionPerformed

    }//GEN-LAST:event_jB_returnActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RegisterUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RegisterUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RegisterUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RegisterUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        </editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegisterUserView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_register;
    private javax.swing.JButton jB_return;
    private javax.swing.JComboBox<String> jC_TypeSAle;
    private javax.swing.JLabel jLabelBrand;
    private javax.swing.JLabel jLabelCarId;
    private javax.swing.JLabel jLabelColor;
    private javax.swing.JLabel jLabelDays;
    private javax.swing.JLabel jLabelDescrption;
    private javax.swing.JLabel jLabelMinOffer;
    private javax.swing.JLabel jLabelModel;
    private javax.swing.JLabel jLabelTypeSale;
    private javax.swing.JLabel jLabelYear;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jT_CarId;
    private javax.swing.JTextField jT_Color;
    private javax.swing.JTextField jT_Days;
    private javax.swing.JTextField jT_Description;
    private javax.swing.JTextField jT_MinOffer;
    private javax.swing.JTextField jT_Model;
    private javax.swing.JTextField jT_Year;
    private javax.swing.JTextField jT_brand;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
