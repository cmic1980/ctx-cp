package sg.ctx.cp.strategy;

import sg.ctx.cp.domain.MarketDepth;

import java.io.IOException;

/**
 * @author yu.miao
 */
public interface DepthStrategy {
    static final String BEQUANT_DEPTH_STRATEGY = "bequant";
    static final String DEFAULT_DEPTH_STRATEGY = "default";

    MarketDepth getDepth(String symbol) throws IOException;
}
