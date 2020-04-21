package sg.ctx.cp.bequant;

import java.math.BigDecimal;

/**
 * @author yu.miao
 */
public class OrderBookItem {
    private BigDecimal price;
    private BigDecimal size;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }
}
