package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import model.Math;
import ui.components.IViewData;

public class Controller {

    private final List<model.Math> maths;
    private final List<JDialog> views;
    private static Controller controller;

    private Controller() {
        maths = new ArrayList<>();
        views = new ArrayList<>();
    }

    public void add(model.Math math) {
        maths.add(math);
        for (JDialog view : views) {
            ((IViewData) view).refreshData();
        }
    }

    public void deleteMath(model.Math math) {
        maths.remove(math);
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public List<Math> getMaths() {
        return maths;
    }

    public void register(JDialog view) {
        views.add(view);
    }

    public void deleteForm(JDialog view) {
        views.remove(view);
    }

    public void refreshAll() {
        for (JDialog view : views) {
            ((IViewData) view).refreshData();
        }
    }

    public void selectAll(int selection) {

        for (JDialog view : views) {
            ((IViewData) view).selectRow(selection);
        }

    }

}
