package sg.ctx.cp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yu.miao
 */
public class MarketDepth {
    private String symbol;
    private Date ts;
    private List<MarketDepthItem> bids = new ArrayList<>();
    private List<MarketDepthItem> asks = new ArrayList<>();

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public List<MarketDepthItem> getBids() {
        return bids;
    }

    public void setBids(List<MarketDepthItem> bids) {
        this.bids = bids;
    }

    public List<MarketDepthItem> getAsks() {
        return asks;
    }

    public void setAsks(List<MarketDepthItem> asks) {
        this.asks = asks;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
