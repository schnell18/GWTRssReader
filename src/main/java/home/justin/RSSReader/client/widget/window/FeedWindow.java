package home.justin.RSSReader.client.widget.window;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;
import home.justin.RSSReader.client.widget.form.FeedForm;
import home.justin.RSSReader.shared.model.Feed;

public class FeedWindow extends Window {

    private FeedForm feedForm = new FeedForm();

    public FeedWindow(final Feed feed) {

        setHeading("Feed");
        setWidth(400);
        setHeight(250);
        setResizable(false);
        setLayout(new FitLayout());

        Button btnSave = new Button("Save");
        btnSave.setIconStyle("save-feed");
        btnSave.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                if (feedForm.isValid()) {
                    feedForm.save(feed);
                }
            }
        });
        addButton(btnSave);
    }

    @Override
    protected void onRender(Element parent, int pos) {
        super.onRender(parent, pos);

        add(feedForm);
    }
}
