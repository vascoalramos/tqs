import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author Vasco Ramos
 * @date 22/02/20
 * @time 09:38
 */

public class TqsHttpBasicClient implements ITqsHttpClient {

    @Override
    public String get(String url) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        String stringResponse = null;
        try {
            HttpEntity entity = response.getEntity();
            stringResponse = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringResponse;
    }
}
