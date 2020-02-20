import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasco Ramos
 * @date 20/02/20
 * @time 14:20
 */

public class StocksPortfolio {

    private String name;
    private IStockMarket iStockMarket;
    private List<Stock> stocks = new ArrayList<>();

    public IStockMarket getMarketService() {
        return this.iStockMarket;
    }

    public void setMarketService(IStockMarket market) {
        this.iStockMarket = market;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalValue() {
        double value = 0.0;
        for(Stock stock: this.stocks) {
            value += iStockMarket.getPrice(stock.getName()) * stock.getQuantity();
        }
        return value;

    }

    public void addStock(Stock stock) {
        this.stocks.add(stock);
    }
}
