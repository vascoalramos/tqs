import org.apache.http.client.utils.URIBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Formatter;
import java.util.Locale;

/**
 * @author Vasco Ramos
 * @date 22/02/20
 * @time 09:30
 */

public class AddressResolver {
    private ITqsHttpClient httpClient;

    public AddressResolver(ITqsHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Address findAddressForLocation(double latitude, double longitude) throws URISyntaxException, IOException, ParseException {

        URIBuilder uriBuilder = new URIBuilder("http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location", (new Formatter()).format(Locale.US, "%.4f,%.3f", latitude, longitude).toString());
        uriBuilder.addParameter("includeRoadMetadata", "true");

        String url = uriBuilder.build().toString();

        String response = this.httpClient.get(url);

        // get parts from response till reaching the address
        JSONObject obj = (JSONObject) new JSONParser().parse(response);
        obj = (JSONObject) ((JSONArray) obj.get("results")).get(0);
        JSONObject address = (JSONObject) ((JSONArray) obj.get("locations")).get(0);

        String street = (String) address.get("street");
        String city = (String) address.get("adminArea5");
        String state = (String) address.get("adminArea3");
        String zip = (String) address.get("postalCode");
        return new Address(street, city, state, zip, null);
    }
}
