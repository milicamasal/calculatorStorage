
package ui.components;

import ui.components.validator.Validator;


public class PanelTextfieldComponent extends javax.swing.JPanel implements IGetValue {

    private Validator validator;

    public PanelTextfieldComponent() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lInput = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        lError = new javax.swing.JLabel();

        lInput.setText("jLabel1");

        lError.setForeground(new java.awt.Color(255, 0, 51));
        lError.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lInput, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtInput, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lInput)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lError))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lError;
    private javax.swing.JLabel lInput;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables

    public void prepareView(String labelText, String inputText, String errorText) {
        lInput.setText(labelText);
        txtInput.setText(inputText);
        lError.setText(errorText);
    }

    public javax.swing.JLabel getlError() {
        return lError;
    }

    public void setlError(javax.swing.JLabel lError) {
        this.lError = lError;
    }

    public javax.swing.JLabel getlInput() {
        return lInput;
    }

    public void setlInput(javax.swing.JLabel lInput) {
        this.lInput = lInput;
    }

    public javax.swing.JTextField getTxtInput() {
        return txtInput;
    }

    public void setTxtInput(javax.swing.JTextField txtInput) {
        this.txtInput = txtInput;
    }

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    @Override
    public Object getValue() throws Exception{
        lError.setText("");
        Object value = txtInput.getText().trim();
        if(validator == null) return value;

        try {
            validator.validate(value);
            return value;
        } catch (Exception ex) {
            lError.setText(ex.getMessage());
        }
        throw new Exception("Validation error");
    }
}
