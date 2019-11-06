package ui.components.validator;

import model.MathOperator;

public class OperatorValidator implements Validator {

    @Override
    public void validate(Object value) throws Exception {
        try {
            int f = 0;//nema ga
            String val = value.toString();
            for (MathOperator v : MathOperator.values()) {
                if (v.toString().equals(val)) {
                    f = 1;
                }
            }
            if (f == 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception("Value: " + value + " is not Operatior!");
        }
    }

}
