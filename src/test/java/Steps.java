import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Steps {
//
//    public HttpResponse myResponse(String setPath) throws URISyntaxException, IOException {
//        HttpClient client = HttpClientBuilder.create().build();
//        URIBuilder uriBuilder = new URIBuilder();
//        uriBuilder.setScheme(PropReader.getProperty("setScheme"));
//        uriBuilder.setHost(PropReader.getProperty("setHost"));
//        uriBuilder.setPath(PropReader.getProperty(setPath));
//
//        HttpGet get = new HttpGet(uriBuilder.build());
//        get.setHeader("Accept","application/json");
//        return client.execute(get);
//    }
    @Test
    public void positiveTest() throws IOException, URISyntaxException {
        HttpResponse response = MyResponse.Response(PropReader.getProperty(PropReader.CONFIGURATION,"filmsPath"));
        Assert.assertEquals(200,response.getStatusLine().getStatusCode());
    }
    @Test
    public void negativePeopleTest() throws IOException, URISyntaxException {
        HttpResponse response = MyResponse.Response(PropReader.getProperty(PropReader.CONFIGURATION, "filmsPath", "trt"));
        Assert.assertEquals(404,response.getStatusLine().getStatusCode());
    }
}
