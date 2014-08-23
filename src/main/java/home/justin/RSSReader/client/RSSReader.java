package home.justin.RSSReader.client;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Theme;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import home.justin.RSSReader.client.widget.RssMainPanel;
import home.justin.RSSReader.client.widget.RssNavPanel;
import home.justin.RSSReader.shared.service.FeedService;


public class RSSReader implements EntryPoint {
    @Override
    public void onModuleLoad() {

        GXT.setDefaultTheme(Theme.GRAY, true);
        Viewport viewport = new Viewport();
        // necessary if the loading div id is not 'loading'
        // viewport.setLoadingPanelId("loading");
        BorderLayout borderLayout = new BorderLayout();

        // create header section
        BorderLayoutData north = new BorderLayoutData(Style.LayoutRegion.NORTH, 20);
        north.setCollapsible(false);
        north.setSplit(false);
        Html header = new Html();
        header.setHtml("<h1>Just Reader</h1>");
        viewport.add(header, north);

        // create navigation section
        BorderLayoutData west = new BorderLayoutData(Style.LayoutRegion.WEST, 250, 150, 320);
        west.setMargins(new Margins(2, 0, 2, 2));
        west.setCollapsible(true);
        west.setSplit(true);
        RssNavPanel navigator = new RssNavPanel();
        viewport.add(navigator, west);

        // create center section
        BorderLayoutData center = new BorderLayoutData(Style.LayoutRegion.CENTER);
        center.setMargins(new Margins(2, 2, 2, 5));
        center.setCollapsible(false);
        RssMainPanel main = new RssMainPanel();
        viewport.add(main, center);

        viewport.setLayout(borderLayout);
        RootPanel.get().add(viewport);

        registerServices();
        registerStores();
    }

    private void registerServices() {
        Registry.register(Constants.FEED_SERVICE, GWT.create(FeedService.class));
    }

    private void registerStores() {
        Registry.register(Constants.FEED_STORE, new ListStore<BeanModel>());
    }
}
