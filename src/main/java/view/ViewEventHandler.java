package view;


import java.beans.PropertyChangeEvent;

public class ViewEventHandler implements IViewEventHandler{
    private ViewListener listener;




    @Override // event handler
    public void rollButtonClicked() {
        if (listener != null) {
            listener.onRollButtonClicked();
        }
    }

    @Override //  event handler
    public void setViewListener(ViewListener listener) {
        this.listener = listener;
    }

}


