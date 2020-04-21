package sg.ctx.cp.service;

import sg.ctx.cp.domain.MarketDepth;

import java.io.IOException;

/**
 * @author yu.miao
 */
public interface MarketService {
    MarketDepth getDepth(String symbol) throws IOException;
}
