package home.justin.RSSReader.shared.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import home.justin.RSSReader.shared.model.Feed;

@RemoteServiceRelativePath("service")
public interface FeedService extends RemoteService {
    Feed createNewFeed();
    void saveFeed(Feed feed);
}
