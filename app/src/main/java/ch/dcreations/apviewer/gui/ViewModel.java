package ch.dcreations.apviewer.gui;

import ch.rcreations.stepdecoder.Step3DModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ViewModel {

    public final ObservableList<String> list = FXCollections.observableArrayList();
    List<Step3DModel> step3DModels = new ArrayList<>();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(step3DModels);
    private  String textfield = new String();


    public void addStepModel(Step3DModel step3DModel) {
        List<Step3DModel> step3DModelsOld = new ArrayList<>();
        for (Step3DModel step3DModel1 : step3DModels){
            step3DModelsOld.add(step3DModel1);
        }
        step3DModels.add(step3DModel);
        update(step3DModelsOld);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);

    }

    public void update(List<Step3DModel>  step3DModelOld){
        this.pcs.firePropertyChange("3DData",step3DModelOld,step3DModels);
    }

    public void setList(List<String> lists){
        list.clear();
        list.add(0,"Properties");
        for (String line : lists){
            list.add(line);
        }
    }

    public void clearStepModel() {
        step3DModels.clear();
        list.clear();
        update(step3DModels);
    }

    public String getText() {
    return textfield;
    }

    public void setTextfield(String textfield) {
        this.textfield = textfield;
    }
}
