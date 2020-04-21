package sg.ctx.cp.domain;

import java.math.BigDecimal;

/**
 * @author yu.miao
 */
public class MarketDepthItem {
    private BigDecimal price;
    private BigDecimal quantity;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
