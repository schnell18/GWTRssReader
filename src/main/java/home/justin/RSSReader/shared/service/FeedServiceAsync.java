package home.justin.RSSReader.shared.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import home.justin.RSSReader.shared.model.Feed;

public interface FeedServiceAsync {
    void createNewFeed(AsyncCallback<Feed> callback);
    void saveFeed(Feed feed, AsyncCallback<Void> callback);
}