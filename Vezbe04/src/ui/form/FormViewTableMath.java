package ui.form;

import controller.Controller;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import model.MathOperator;
import ui.components.IViewData;
import ui.components.table.model.MathTableModel;

public class FormViewTableMath extends javax.swing.JDialog implements IViewData {

    public FormViewTableMath(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        JDialog opened = this;
        fillForm();
        Controller.getInstance().register(this);
        opened.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Controller.getInstance().deleteForm(opened);
            }

        });
        jtblMath.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!Controller.getInstance().getMaths().isEmpty() && jtblMath.getSelectedRow() > 0) {
                    Controller.getInstance().selectAll(jtblMath.getSelectedRow());
                }

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtblMath = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View-table");

        jtblMath.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblMath);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRemove)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnRemove)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int row = jtblMath.getSelectedRow();
        if (!Controller.getInstance().getMaths().isEmpty()) {
            
            controller.Controller.getInstance().selectAll(0);

            if (row >= 0) {
                Controller.getInstance().deleteMath(Controller.getInstance().getMaths().get(row));
                Controller.getInstance().refreshAll();
            } else {
                JOptionPane.showMessageDialog(this, "You haven't selected an item that you want to remove!");
            }

    }//GEN-LAST:event_btnRemoveActionPerformed
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblMath;
    // End of variables declaration//GEN-END:variables

    private void fillForm() {
        List<model.Math> maths = Controller.getInstance().getMaths();
        TableModel tm = new MathTableModel(maths);
        jtblMath.setModel(tm);

        List<model.Math> math = Controller.getInstance().getMaths();
        JComboBox comboMath = new JComboBox(new DefaultComboBoxModel(math.toArray()));

        TableColumn tc = jtblMath.getColumnModel().getColumn(2);
        tc.setCellEditor(new DefaultCellEditor(comboMath));

    }

    @Override
    public void refreshData() {
        fillForm();
    }

    @Override
    public void selectRow(int selection) {
        jtblMath.setRowSelectionInterval(selection, selection);
    }

}
