package sg.ctx.cp.strategy;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sg.ctx.cp.bequant.OrderBook;
import sg.ctx.cp.domain.MarketDepth;
import sg.ctx.cp.domain.MarketDepthItem;
import sg.ctx.cp.utils.RestClient;

import java.io.IOException;

/**
 * @author yu.miao
 */
@Service(DepthStrategy.DEFAULT_DEPTH_STRATEGY)
public class DefaultDepthStrategy implements DepthStrategy {
    @Value("${bequant.orderbook.url}")
    private String url;

    @Override
    public MarketDepth getDepth(String symbol) throws IOException {
        // 重置 BTC/USD => BTC/USD
        symbol = symbol.replace("/","");

        var client = new RestClient();
        String content = null;
        content = client.get(this.url + "/" + symbol + "?limit=20");

        var orderBook = JSONObject.parseObject(content, OrderBook.class);


        var marketDepth = new MarketDepth();
        var askList = marketDepth.getAsks();

        var ask = orderBook.getAsk();
        for(var item: ask)
        {
            var e = new MarketDepthItem();
            e.setPrice(item.getPrice());
            e.setQuantity(item.getSize());
            askList.add(e);
        }

        var bidList = marketDepth.getBids();
        var bid = orderBook.getBid();
        for(var item: bid)
        {
            var e = new MarketDepthItem();
            e.setPrice(item.getPrice());
            e.setQuantity(item.getSize());
            bidList.add(e);
        }

        marketDepth.setSymbol(symbol);
        marketDepth.setTs(orderBook.getTimestamp());
        return marketDepth;
    }
}
