package sg.ctx.cp.bequant;

import java.util.Date;
import java.util.List;

/**
 * @author yu.miao
 */
public class OrderBook {
    private List<OrderBookItem> ask;
    private List<OrderBookItem> bid;
    private Date timestamp;

    public List<OrderBookItem> getAsk() {
        return ask;
    }

    public void setAsk(List<OrderBookItem> ask) {
        this.ask = ask;
    }

    public List<OrderBookItem> getBid() {
        return bid;
    }

    public void setBid(List<OrderBookItem> bid) {
        this.bid = bid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
