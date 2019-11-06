package ui.components.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Math;
import model.MathOperator;

public class MathTableModel extends AbstractTableModel {

    private final List<Math> maths;
    private final String[] columns = new String[]{"A", "B", "Result", "Operation"};
    private final Class[] columnsType = new Class[]{Integer.class, Integer.class, Double.class, MathOperator.class};

    public MathTableModel(List<Math> maths) {
        this.maths = maths;
    }

    @Override
    public int getRowCount() {
        if (maths == null) {
            return 0;
        }
        return maths.size();
    }

    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        model.Math math = maths.get(row);
        switch (column) {
            case 0:
                return math.getA();
            case 1:
                return math.getB();
            case 2:
                return math.getResult();
            case 3:
                return math.getMathOperator();
            default:
                return "n/a";
        }
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return columnsType[column];
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        Math math = maths.get(row);
        switch (column) {

            case 1:
                math.setA((Integer) value);
                break;
            case 2:
                math.setB((Integer) value);
                break;
            case 3:
                math.setResult((Integer) value);
                break;
            case 4:
                math.setMathOperator((MathOperator) value);
                break;
        }
    }

}
