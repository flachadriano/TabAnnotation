package br.example.client.view;

import br.example.client.presenter.Tab1Presenter;
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
public class Tab1View extends Composite implements Tab1Presenter.Display {

    private static final Tab1ViewUiBinder uiBinder = GWT.create(Tab1ViewUiBinder.class);

    interface Tab1ViewUiBinder extends UiBinder<Widget, Tab1View> {
    }

    @Inject
    public Tab1View() {
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
