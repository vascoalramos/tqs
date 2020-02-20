//Junit

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StocksPortfolioTest {

    @Mock
    IStockMarket market;

    @InjectMocks
    StocksPortfolio portfolio;

    @BeforeEach
    public void setup() {
        portfolio.setName("Vasco's Portfolio");
    }

    @Test
    public void getTotalValue() {
        when(market.getPrice("AMAZON")).thenReturn(50.50);
        when(market.getPrice("EBAY")).thenReturn(10.0);

        // do test
        portfolio.addStock(new Stock("AMAZON", 2));
        portfolio.addStock(new Stock("EBAY", 2));

        double result = 2 * 50.50 + 2 * 10.0;

        // verify the use of mock with the expected outcome

        assertThat(portfolio.getTotalValue(), is(result));

        verify(market, times(2)).getPrice(anyString());
    }
}