package br.example.client.injector;

import br.example.client.presenter.HomePresenter;
import br.example.client.presenter.Tab1Presenter;
import br.example.client.presenter.Tab2Presenter;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

/**
 *
 * @author flachadriano
 */
@GinModules({TabModule.class})
public interface TabGinjector extends Ginjector {

    PlaceManager getPlaceManager();

    EventBus getEventBus();

    Provider<HomePresenter> getHomePresenter();
    
    Provider<Tab1Presenter> getTab1Presenter();
    
    Provider<Tab2Presenter> getTab2Presenter();
    
}
