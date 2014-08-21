package home.justin.RSSReader.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import home.justin.RSSReader.shared.model.Feed;
import home.justin.RSSReader.shared.service.FeedService;

import java.util.UUID;

public class FeedServiceImpl extends RemoteServiceServlet implements FeedService {

    @Override
    public Feed createNewFeed() {
        return new Feed(UUID.randomUUID().toString());
    }

    @Override
    public void saveFeed(Feed feed) {
        String ret = new StringBuilder()
            .append("<rss version=\"2.0\">\n")
            .append("<channel>\n")
            .append("<title>")
            .append(feed.getTitle())
            .append("</title>\n")
            .append("<description>")
            .append(feed.getDescription())
            .append("</description>\n")
            .append("<link>")
            .append(feed.getLink())
            .append("</link>\n")
            .append("</channel>\n")
            .append("</rss>")
            .toString();
        System.out.println(ret);
    }
}
