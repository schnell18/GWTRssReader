package home.justin.RSSReader.client.widget;

import com.sencha.gxt.ui.client.Registry;
import com.sencha.gxt.ui.client.Style;
import com.sencha.gxt.ui.client.event.ButtonEvent;
import com.sencha.gxt.ui.client.event.SelectionListener;
import com.sencha.gxt.ui.client.widget.ContentPanel;
import com.sencha.gxt.ui.client.widget.Info;
import com.sencha.gxt.ui.client.widget.button.Button;
import com.sencha.gxt.ui.client.widget.button.ToggleButton;
import com.sencha.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.user.client.rpc.AsyncCallback;
import home.justin.RSSReader.client.Constants;
import home.justin.RSSReader.client.widget.window.FeedWindow;
import home.justin.RSSReader.shared.model.Feed;
import home.justin.RSSReader.shared.service.FeedServiceAsync;

public class RssNavPanel extends ContentPanel {

    public RssNavPanel() {

        // add link feed button
        ToolTipConfig tipBtnLink = new ToolTipConfig();
        tipBtnLink.setTitle("Link to existing RSS feed");
        tipBtnLink.setText("Allows you to enter the URL of an existing RSS feed you would like to link to");
        final ToggleButton btnLink = new ToggleButton("Link Feed");
        btnLink.setIconStyle("link-feed");
        btnLink.setToolTip(tipBtnLink);

        final LinkFeedPopup linkFeedPopup = new LinkFeedPopup();
        linkFeedPopup.setConstrainViewport(true);
        btnLink.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                if (btnLink.isPressed()) {
                    // display the popup to the top of link button
                    linkFeedPopup.show(btnLink.getElement(), "b-t?", new int[]{4, 4, 4, 4});
                }
                else {
                    linkFeedPopup.hide();
                }
            }
        });

        // add create feed button
        ToolTipConfig tipBtnCreate = new ToolTipConfig();
        tipBtnCreate.setTitle("Create RSS feed");
        tipBtnCreate.setText("Allows you to create an RSS feed");
        final Button btnCreate = new Button("Create Feed");
        btnCreate.setIconStyle("create-feed");
        btnCreate.setToolTip(tipBtnCreate);
        btnCreate.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                createFeed();
            }
        });

        setHeadingText("Navigation");
        setButtonAlign(Style.HorizontalAlignment.LEFT);
        addButton(btnCreate);
        addButton(btnLink);

    }

    private void createFeed() {
        FeedServiceAsync service = Registry.get(Constants.FEED_SERVICE);
        service.createNewFeed(new AsyncCallback<Feed>() {
            @Override
            public void onFailure(Throwable caught) {
                Info.display("RSS Reader", "Unable to create feed!");
            }

            @Override
            public void onSuccess(Feed feed) {
                FeedWindow feedWindow = new FeedWindow(feed);
                feedWindow.show();
            }
        });
    }
}
