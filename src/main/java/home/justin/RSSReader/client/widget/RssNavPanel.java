package home.justin.RSSReader.client.widget;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;

public class RssNavPanel extends ContentPanel {
    public RssNavPanel() {
        setHeadingText("Navigation");

        // add link feed button
        ToolTipConfig linkBtnTip = new ToolTipConfig();
        linkBtnTip.setTitle("Link to existing RSS feed");
        linkBtnTip.setText("Allows you to enter the URL of an existing RSS feed you would like to link to");
        final ToggleButton linkBtn = new ToggleButton("Link Feed");
        linkBtn.setIconStyle("link-feed");
        linkBtn.setToolTip(linkBtnTip);
        setButtonAlign(Style.HorizontalAlignment.RIGHT);

        final LinkFeedPopup linkFeedPopup = new LinkFeedPopup();
        linkFeedPopup.setConstrainViewport(true);
        linkBtn.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                if (linkBtn.isPressed()) {
                    // display the popup to the top of link button
                    linkFeedPopup.show(linkBtn.getElement(), "b-t?", new int[]{4, 4, 4, 4});
                }
                else {
                    linkFeedPopup.hide();
                }
            }
        });

        addButton(linkBtn);

    }
}
