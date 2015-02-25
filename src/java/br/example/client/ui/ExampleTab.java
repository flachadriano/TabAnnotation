package br.example.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;

public class ExampleTab extends Composite implements Tab {

    interface Binder extends UiBinder<Widget, ExampleTab> {
    }

    /**
     * {@link WBaseTab}'s CssResource.
     */
    protected interface Style extends CssResource {

        String active();

        String inactive();
    }

    // TODO Once we use assisted injection in {@link SimpleTabPabel}, then inject the binder.
    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    Hyperlink hyperlink;

    @UiField
    Style style;

    private final float priority;

    ExampleTab(TabData tabData) {
        super();
        this.priority = tabData.getPriority();
        initWidget(binder.createAndBindUi(this));
        setText(tabData.getLabel());
    }

    @Override
    public void activate() {
        removeStyleName(style.inactive());
        addStyleName(style.active());
    }

    @Override
    public Widget asWidget() {
        return this;
    }

    @Override
    public void deactivate() {
        removeStyleName(style.active());
        addStyleName(style.inactive());
    }

    @Override
    public float getPriority() {
        return priority;
    }

    @Override
    public String getText() {
        return hyperlink.getText();
    }

    @Override
    public void setTargetHistoryToken(String historyToken) {
        hyperlink.setTargetHistoryToken(historyToken);
    }

    @Override
    public void setText(String text) {
        hyperlink.setText(text);
    }

    /**
     * Checks whether or not the current user has the right to access this tab.
     * By default, all tabs can be accessed.
     *
     * @return {@code true} if the user can access this tab, {@code false}
     * otherwise.
     */
    public boolean canUserAccess() {
        return true;
    }

}
