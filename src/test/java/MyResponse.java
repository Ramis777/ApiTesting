import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

public class MyResponse extends Steps {

    public static HttpResponse Response(String setPath) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme(PropReader.getProperty(PropReader.CONFIGURATION,"setScheme"));
        uriBuilder.setHost(PropReader.getProperty(PropReader.CONFIGURATION,"setHost"));
        uriBuilder.setPath(setPath);

        HttpGet get = new HttpGet(uriBuilder.build());
        get.setHeader("Accept", "application/json");
        return client.execute(get);
    }
}