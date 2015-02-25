package br.example.client.view;

import br.example.client.presenter.Tab2Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 *
 * @author flachadriano
 */
public class Tab2View extends Composite implements Tab2Presenter.Display {

    private static final Tab2ViewUiBinder uiBinder = GWT.create(Tab2ViewUiBinder.class);

    interface Tab2ViewUiBinder extends UiBinder<Widget, Tab2View> {
    }

    @Inject
    public Tab2View() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void addToSlot(Object slot, IsWidget content) {
    }

    @Override
    public void removeFromSlot(Object slot, IsWidget content) {
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
    }

}
