package sg.ctx.cp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sg.ctx.cp.strategy.BequantDepthStrategy;
import sg.ctx.cp.domain.MarketDepth;
import sg.ctx.cp.service.MarketService;
import sg.ctx.cp.strategy.DefaultDepthStrategy;
import sg.ctx.cp.strategy.DepthStrategy;

import java.io.IOException;

/**
 * @author yumiao
 */
@Service
public class MarketServiceImpl implements MarketService {

    @Value("${cp.depth.strategy}")
    private String depthStrategy;

    @Autowired
    @Qualifier(DepthStrategy.BEQUANT_DEPTH_STRATEGY)
    private BequantDepthStrategy bequantDepthStrategy;

    @Autowired
    @Qualifier(DepthStrategy.DEFAULT_DEPTH_STRATEGY)
    private DefaultDepthStrategy defaultDepthStrategy;

    @Override
    public MarketDepth getDepth(String symbol) throws IOException {
        MarketDepth depth = null;
        switch (this.depthStrategy)
        {
            case DepthStrategy.BEQUANT_DEPTH_STRATEGY:
                depth = this.bequantDepthStrategy.getDepth(symbol);
                break;
            case DepthStrategy.DEFAULT_DEPTH_STRATEGY:
                depth = this.defaultDepthStrategy.getDepth(symbol);
                break;
        }
        return depth;
    }
}
