package view;


import controller.ViewListener;

public class ViewEventHandler implements IViewEventHandler{
    private ViewListener listener;




    @Override // event handler
    public void rollButtonClicked() {
        if (listener != null) {
            listener.onRollButtonClicked();
        }
    }

    @Override
    public void holdButtonClicked(int index){
        if (listener != null) {
            listener.onHoldButtonClicked(index);
        }
    }

    @Override //  event handler
    public void setViewListener(ViewListener listener) {
        this.listener = listener;
    }

}


