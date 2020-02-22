import java.io.IOException;

/**
 * @author Vasco Ramos
 * @date 22/02/20
 * @time 09:35
 */

public interface ITqsHttpClient {
    String get(String url) throws IOException;
}
