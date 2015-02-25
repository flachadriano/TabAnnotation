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
public class Tab2Presenter extends Presenter<Tab2Presenter.Display, Tab2Presenter.MyProxy> {

    @Inject
    public Tab2Presenter(EventBus eventBus, Display view, MyProxy proxy) {
        super(eventBus, view, proxy);
    }

    public interface Display extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.TAB2)
    @TabInfo(container = HomePresenter.class, label = "Tab 2", priority = 2)
    public interface MyProxy extends ProxyPlace<Tab2Presenter> {
    }

    @Override
    protected void revealInParent() {
        super.revealInParent();
    }
    
}
