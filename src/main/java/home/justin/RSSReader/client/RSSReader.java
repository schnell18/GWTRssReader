package home.justin.RSSReader.client;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


public class RSSReader implements EntryPoint {
    @Override
    public void onModuleLoad() {
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
        BorderLayoutData west = new BorderLayoutData(Style.LayoutRegion.WEST, 200, 150, 300);
        west.setCollapsible(true);
        west.setSplit(true);
        ContentPanel navigator = new ContentPanel();
        viewport.add(navigator, west);

        // create center section
        BorderLayoutData center = new BorderLayoutData(Style.LayoutRegion.CENTER);
        center.setCollapsible(false);
        ContentPanel main = new ContentPanel();
        viewport.add(main, center);

        viewport.setLayout(borderLayout);
        RootPanel.get().add(viewport);

    }
}
