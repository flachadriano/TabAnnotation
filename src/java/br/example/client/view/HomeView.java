package br.example.client.view;

import br.example.client.presenter.HomePresenter;
import br.example.client.ui.ExampleTabPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 *
 * @author flachadriano
 */
public class HomeView extends ViewImpl implements HomePresenter.Display {

    private static final SheetViewUiBinder uiBinder = GWT.create(SheetViewUiBinder.class);

    @UiField
    ExampleTabPanel tabPanel;

    interface SheetViewUiBinder extends UiBinder<Widget, HomeView> {
    }

    @Inject
    public HomeView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public Tab addTab(TabData tabData, String historyToken) {
        return tabPanel.addTab(tabData, historyToken);
    }

    @Override
    public void removeTab(Tab tab) {
        tabPanel.removeTab(tab);
    }

    @Override
    public void removeTabs() {
        tabPanel.removeTabs();
    }

    @Override
    public void setActiveTab(Tab tab) {
        tabPanel.setActiveTab(tab);
    }

    @Override
    public void changeTab(Tab tab, TabData tabData, String historyToken) {
        tabPanel.changeTab(tab, tabData, historyToken);
    }

}
