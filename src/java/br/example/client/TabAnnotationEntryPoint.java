package br.example.client;

import br.example.client.injector.TabGinjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

/**
 * Main entry point.
 *
 * @author flachadriano
 */
public class TabAnnotationEntryPoint implements EntryPoint {

    private static final TabGinjector tabGinjector = GWT.create(TabGinjector.class);
    
    /**
     * Creates a new instance of TabAnnotationEntryPoint
     */
    public TabAnnotationEntryPoint() {
    }

    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry-point
     */
    @Override
    public void onModuleLoad() {
        tabGinjector.getPlaceManager().revealDefaultPlace();
    }
}
