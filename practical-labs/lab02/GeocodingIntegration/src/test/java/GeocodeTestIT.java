import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeocodeTestIT {

    private AddressResolver addressResolver = new AddressResolver(new TqsHttpBasicClient());

    @Test
    public void testFindAddressForLocation() throws URISyntaxException, IOException {
        Address returnedAddress = addressResolver.findAddressForLocation(40.6318, -8.658);
        Address expectedAddress = new Address("Parque Estacionamento da Reitoria - Univerisdade de Aveiro", "Glória e Vera Cruz", "Centro", "3810-193", null);

        assertThat(returnedAddress.toString(), is(expectedAddress.toString()));
    }

    @Test
    void testValidCoordinates() throws URISyntaxException, IOException {
        String responseJson = "{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\\u00A9 2020 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\\u00A9 2020 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":100.0,\"lng\":100.0}},\"locations\":[]}]}";
        assertThrows(IndexOutOfBoundsException.class, () -> addressResolver.findAddressForLocation(100, 100));
    }

}