package ui.form;

import controller.Controller;
import javax.swing.JOptionPane;
import model.MathOperator;
import ui.components.validator.NumberValidator;
import ui.components.validator.OperatorValidator;

public class FormAddMath extends javax.swing.JDialog {

    public FormAddMath(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        prepareView();
        prepareValidator();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputA = new ui.components.PanelTextfieldComponent();
        inputB = new ui.components.PanelTextfieldComponent();
        inputOperator = new ui.components.PanelTextfieldComponent();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("add");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inputA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(inputB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(inputOperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSave)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(inputA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputOperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try {
            Object inputa = inputA.getValue();
            int a = Integer.parseInt(inputa.toString());
            Object inputb = inputB.getValue();
            int b = Integer.parseInt(inputb.toString());
            Object operator = inputOperator.getValue();
            MathOperator mathOperator = MathOperator.valueOf(operator.toString());
            double result = calculate(a, b, mathOperator);
            model.Math math = new model.Math(a, b, result, mathOperator);
            Controller.getInstance().add(math);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private ui.components.PanelTextfieldComponent inputA;
    private ui.components.PanelTextfieldComponent inputB;
    private ui.components.PanelTextfieldComponent inputOperator;
    // End of variables declaration//GEN-END:variables

    private void prepareView() {
        inputA.prepareView("A:", "", "Please enter A");
        inputB.prepareView("B:", "", "Please enter B");
        inputOperator.prepareView("Operator:", "", "Please enter Operator");

    }

    private void prepareValidator() {
        inputA.setValidator(new NumberValidator());
        inputB.setValidator(new NumberValidator());
        inputOperator.setValidator(new OperatorValidator());
    }

    private double calculate(int a, int b, MathOperator mathOperator) {
        if (mathOperator.equals(MathOperator.ADD)) {
            return a + b;
        }
        if (mathOperator.equals(MathOperator.SUBSTRACT)) {
            return a - b;
        }
        if (mathOperator.equals(MathOperator.MULTIPLY)) {
            return a * b;
        }
        if (mathOperator.equals(MathOperator.DIVIDE)) {
            if (b == 0) {
                JOptionPane.showMessageDialog(this, "You can't divide by 0!");
                return 0.0;
            } else {
                return a / b;
            }
        }

        return 0.0;
    }

}
