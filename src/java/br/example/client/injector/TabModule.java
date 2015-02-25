package br.example.client.injector;

import br.example.client.presenter.HomePresenter;
import br.example.client.presenter.Tab1Presenter;
import br.example.client.presenter.Tab2Presenter;
import br.example.client.view.HomeView;
import br.example.client.view.Tab1View;
import br.example.client.view.Tab2View;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;

/**
 *
 * @author flachadriano
 */
public class TabModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new DefaultModule.Builder()
                .placeManager(TabPlaceManager.class)
                .tokenFormatter(RouteTokenFormatter.class).build());
        
        bindPresenter(HomePresenter.class, HomePresenter.Display.class, HomeView.class, HomePresenter.MyProxy.class);
        bindPresenter(Tab1Presenter.class, Tab1Presenter.Display.class, Tab1View.class, Tab1Presenter.MyProxy.class);
        bindPresenter(Tab2Presenter.class, Tab2Presenter.Display.class, Tab2View.class, Tab2Presenter.MyProxy.class);
    }

}
