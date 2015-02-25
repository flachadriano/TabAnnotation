package br.example.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.TabPanel;
import java.util.ArrayList;
import java.util.List;

public class ExampleTabPanel extends Composite implements TabPanel {

    private static Binder uiBinder = GWT.create(Binder.class);
    
    Tab currentActiveTab;

    @UiField
    FlowPanel tabContentContainer;

    @UiField
    FlowPanel tabPanel;

    private final List<ExampleTab> tabList = new ArrayList<ExampleTab>();

    /**
     */
    public interface Binder extends UiBinder<Widget, ExampleTabPanel> {
    }

    @Inject
    public ExampleTabPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    /**
     * Returns a new tab of the type specific for this tab panel.
     *
     * @param tabData Some data on the tab to create.
     * @return The new tab.
     */
    protected ExampleTab createNewTab(TabData tabData) {
        return new ExampleTab(tabData);
    }

    @Override
    public Tab addTab(TabData tabData, String historyToken) {
        ExampleTab newTab = createNewTab(tabData);
        int beforeIndex;
        for (beforeIndex = 0; beforeIndex < tabList.size(); ++beforeIndex) {
            if (newTab.getPriority() < tabList.get(beforeIndex).getPriority()) {
                break;
            }
        }
        tabPanel.insert(newTab.asWidget(), beforeIndex);
        tabList.add(beforeIndex, newTab);
        newTab.setTargetHistoryToken(historyToken);
        setTabVisibility(newTab);
        return newTab;
    }

    @Override
    public void removeTab(Tab tab) {
        tabPanel.getElement().removeChild(tab.asWidget().getElement());
        tabList.remove(tab);
    }

    @Override
    public void removeTabs() {
        for (Tab tab : tabList) {
            tabPanel.getElement().removeChild(tab.asWidget().getElement());
        }
        tabList.clear();
    }

    @Override
    public void setActiveTab(Tab tab) {
        if (currentActiveTab != null) {
            currentActiveTab.deactivate();
        }
        if (tab != null) {
            tab.activate();
        }
        currentActiveTab = tab;
    }

    @Override
    public void changeTab(Tab tab, TabData tabData, String historyToken) {
        tab.setText(tabData.getLabel());
        tab.setTargetHistoryToken(historyToken);
    }

    /**
     * Sets the content displayed in the main panel.
     *
     * @param panelContent The {@link Widget} to set in the main panel, or
     * {@code null} to clear the panel.
     */
    public void setPanelContent(IsWidget panelContent) {
        tabContentContainer.clear();
        if (panelContent != null) {
            tabContentContainer.add(panelContent);
        }
    }

    /**
     * Ensures that all tabs are visible or hidden as they should.
     */
    public void refreshTabs() {
        for (ExampleTab tab : tabList) {
            setTabVisibility(tab);
        }
    }

    /**
     * Ensures the specified tab is visible or hidden as it should.
     *
     * @param tab The {@link WBaseTab} to check.
     */
    private void setTabVisibility(ExampleTab tab) {
        boolean visible = (tab == currentActiveTab) || tab.canUserAccess();
        tab.setVisible(visible);
    }

}
