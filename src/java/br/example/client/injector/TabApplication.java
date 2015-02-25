package br.example.client.injector;

import br.example.client.presenter.HomePresenter;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;

/**
 *
 * @author flachadriano
 */
public class TabApplication {

    private final HomePresenter homePresenter;
    
    @Inject
    public TabApplication(HomePresenter homePresenter) {
        this.homePresenter = homePresenter;
    }
    
    public void load() {
        RootPanel.get().add(homePresenter);
    }
    
}
