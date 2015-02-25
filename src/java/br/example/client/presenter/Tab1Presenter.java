package br.example.client.presenter;

import br.example.client.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

/**
 *
 * @author flachadriano
 */
public class Tab1Presenter extends Presenter<Tab1Presenter.Display, Tab1Presenter.MyProxy> {

    @Inject
    public Tab1Presenter(EventBus eventBus, Display view, MyProxy proxy) {
        super(eventBus, view, proxy);
    }

    public interface Display extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.TAB1)
    @TabInfo(container = HomePresenter.class, label = "Tab 1", priority = 1)
    public interface MyProxy extends ProxyPlace<Tab1Presenter> {
    }

    @Override
    protected void revealInParent() {
        super.revealInParent();
    }
    
}
