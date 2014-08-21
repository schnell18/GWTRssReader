package home.justin.RSSReader.client.widget;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.Popup;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;

public class LinkFeedPopup extends Popup {

    public LinkFeedPopup() {

        setSize(300, 50);
        setBorders(true);
        setShadow(true);
        setAutoHide(false);

    }

    @Override
    protected void onRender(Element target, int index) {
        super.onRender(target, index);

        final TextField<String> tfUrl = new TextField<String>();
        tfUrl.setAllowBlank(false);
        tfUrl.setRegex("^http\\://\\w+(\\.\\w+)+/\\S*$");
        tfUrl.getMessages().setBlankText("URL is required");
        tfUrl.getMessages().setRegexText("URL is expected, eg: http://www.google.com");
        final Text lblExplain = new Text("Enter a feed URL");
        final Button btnAdd = new Button("Add");
        tfUrl.addKeyListener(new KeyListener() {
            @Override
            public void componentKeyUp(ComponentEvent event) {
                if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
                    addUrl(tfUrl.getValue());
                }
            }
        });

        btnAdd.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                addUrl(tfUrl.getValue());
            }
        });

        setLayout(new BorderLayout());

        BorderLayoutData north = new BorderLayoutData(Style.LayoutRegion.NORTH, 20);
        north.setMargins(new Margins(2));
        add(lblExplain, north);
        BorderLayoutData center = new BorderLayoutData(Style.LayoutRegion.CENTER);
        center.setMargins(new Margins(4));
        add(tfUrl, center);
        BorderLayoutData east = new BorderLayoutData(Style.LayoutRegion.EAST, 50);
        east.setMargins(new Margins(4));
        add(btnAdd, east);

    }

    private void addUrl(String value) {
        Window.alert("You entered: " + value);
    }
}
