package home.justin.RSSReader.client.widget.list;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Element;
import home.justin.RSSReader.client.Constants;


public class FeedList extends LayoutContainer {

    public FeedList () {
        setLayout(new FitLayout());
    }

    @Override
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);

        ListView<BeanModel> feedList = new ListView<BeanModel>();
        ListStore<BeanModel> store = Registry.get(Constants.FEED_STORE);
        feedList.setStore(store);
        add(feedList);

    }
}
