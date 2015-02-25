package br.example.client.presenter;

import br.example.client.NameTokens;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.ChangeTabHandler;
import com.gwtplatform.mvp.client.RequestTabsHandler;
import com.gwtplatform.mvp.client.TabContainerPresenter;
import com.gwtplatform.mvp.client.TabView;
import com.gwtplatform.mvp.client.annotations.ChangeTab;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.RequestTabs;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

/**
 *
 * @author flachadriano
 */
public class HomePresenter extends TabContainerPresenter<HomePresenter.Display, HomePresenter.MyProxy> {

    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_SetTabContent = new Type<RevealContentHandler<?>>();
    @RequestTabs
    public static final Type<RequestTabsHandler> SLOT_RequestTabs = new Type<RequestTabsHandler>();
    @ChangeTab
    public static final Type<ChangeTabHandler> SLOT_ChangeTab = new Type<ChangeTabHandler>();

    @Inject
    public HomePresenter(EventBus eventBus, Display view, MyProxy proxy) {
        super(eventBus, view, proxy, SLOT_SetTabContent, SLOT_RequestTabs, SLOT_ChangeTab, RevealType.Root);
    }

    public interface Display extends TabView {
    }

    @ProxyStandard
    @NameToken(NameTokens.HOME)
    public interface MyProxy extends ProxyPlace<HomePresenter> {
    }

}
