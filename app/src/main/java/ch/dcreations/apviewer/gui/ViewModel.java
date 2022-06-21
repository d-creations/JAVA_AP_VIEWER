package ch.dcreations.apviewer.gui;

import ch.dcreations.apviewer.Step3DModel.Step3DModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ViewModel {

    List<Step3DModel> step3DModels = new ArrayList<>();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(step3DModels);


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
}
