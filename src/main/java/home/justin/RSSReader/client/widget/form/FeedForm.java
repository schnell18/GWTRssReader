package home.justin.RSSReader.client.widget.form;

import com.sencha.gxt.ui.client.Registry;
import com.sencha.gxt.ui.client.widget.Info;
import com.sencha.gxt.ui.client.widget.form.FormPanel;
import com.sencha.gxt.ui.client.widget.form.TextArea;
import com.sencha.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import home.justin.RSSReader.client.Constants;
import home.justin.RSSReader.shared.model.Feed;
import home.justin.RSSReader.shared.service.FeedServiceAsync;



public class FeedForm extends FormPanel {

    private TextField<String> tfTitle = new TextField<String>();
    private TextArea tfDescription = new TextArea();
    private TextField<String> tfLink = new TextField<String>();

    public FeedForm() {

        setHeaderVisible(false);

    }

    @Override
    protected void onRender(Element target, int index) {

        super.onRender(target, index);

        tfTitle.setFieldLabel("Title");
        tfTitle.setAllowBlank(false);
        tfTitle.getMessages().setBlankText("Title is mandatory");
        tfDescription.setFieldLabel("Description");
        tfDescription.getMessages().setBlankText("Description is mandatory");
        tfDescription.setAllowBlank(false);
        tfLink.setFieldLabel("Link");
        tfLink.setAllowBlank(false);
        tfLink.setRegex("^http\\://\\w+(\\.\\w+)+/\\S*$");
        tfLink.getMessages().setBlankText("Link is mandatory");
        tfLink.getMessages().setRegexText("URL is expected, eg: http://www.google.com");

        add(tfTitle);
        add(tfDescription);
        add(tfLink);

    }

    public void save(final Feed feed) {
        feed.setTitle(tfTitle.getValue());
        feed.setDescription(tfDescription.getValue());
        feed.setLink(tfLink.getValue());
        FeedServiceAsync service = Registry.get(Constants.FEED_SERVICE);
        service.saveFeed(feed, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                Info.display("RSS Reader", "Unable to save feed!");
            }

            @Override
            public void onSuccess(Void result) {
                Info.display("RSS Reader", "Feed " + feed.getTitle() + " saved!");
            }
        });
    }
}
