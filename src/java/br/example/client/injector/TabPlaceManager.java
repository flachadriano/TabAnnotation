package br.example.client.injector;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.shared.proxy.TokenFormatter;

/**
 *
 * @author flachadriano
 */
public class TabPlaceManager extends PlaceManagerImpl {

    private final TabApplication tabApplication;

    @Inject
    public TabPlaceManager(EventBus eventBus, TokenFormatter tokenFormatter, TabApplication tabApplication) {
        super(eventBus, tokenFormatter);
        this.tabApplication = tabApplication;
    }

    @Override
    public void revealDefaultPlace() {
        this.tabApplication.load();
    }

}
