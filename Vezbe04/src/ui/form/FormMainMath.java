package ui.form;

import javax.swing.JDialog;

public class FormMainMath extends javax.swing.JFrame {

    public FormMainMath() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuMath = new javax.swing.JMenu();
        menuMathItemSave = new javax.swing.JMenuItem();
        menuMathItemViewTable = new javax.swing.JMenuItem();
        menuMathItemCmb = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuMath.setText("Math");

        menuMathItemSave.setText("Save");
        menuMathItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMathItemSaveActionPerformed(evt);
            }
        });
        menuMath.add(menuMathItemSave);

        menuMathItemViewTable.setText("View-table");
        menuMathItemViewTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMathItemViewTableActionPerformed(evt);
            }
        });
        menuMath.add(menuMathItemViewTable);

        menuMathItemCmb.setText("View-combobox");
        menuMathItemCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMathItemCmbActionPerformed(evt);
            }
        });
        menuMath.add(menuMathItemCmb);

        jMenuBar1.add(menuMath);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuMathItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMathItemSaveActionPerformed
        // TODO add your handling code here:
        JDialog form = new FormAddMath(this, false);
        form.setVisible(true);
    }//GEN-LAST:event_menuMathItemSaveActionPerformed

    private void menuMathItemViewTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMathItemViewTableActionPerformed
        // TODO add your handling code here:
        JDialog form = new FormViewTableMath(this, false);
        form.setVisible(true);
    }//GEN-LAST:event_menuMathItemViewTableActionPerformed

    private void menuMathItemCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMathItemCmbActionPerformed
        // TODO add your handling code here:
        JDialog form = new FormViewComboboxMath(this, false);
        form.setVisible(true);
    }//GEN-LAST:event_menuMathItemCmbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuMath;
    private javax.swing.JMenuItem menuMathItemCmb;
    private javax.swing.JMenuItem menuMathItemSave;
    private javax.swing.JMenuItem menuMathItemViewTable;
    // End of variables declaration//GEN-END:variables
}
