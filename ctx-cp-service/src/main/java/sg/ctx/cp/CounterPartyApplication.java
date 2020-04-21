package sg.ctx.cp;

import com.alibaba.fastjson.parser.ParserConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import sg.ctx.cp.service.MarketService;
import sg.ctx.cp.strategy.BequantDepthStrategy;


/**
 * @author yu.miao
 */
@EnableAsync //开启异步
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableScheduling
@MapperScan("sg.ctx.cp.repository")
@ComponentScan("sg.ctx")
public class CounterPartyApplication implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(CounterPartyApplication.class);

    @Autowired
    private MarketService marketService;

    public static void main(String[] args) {
        SpringApplication.run(CounterPartyApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var depth = this.marketService.getDepth("BTC/USD");

        // fast json 添加 autotype 白名单
        ParserConfig.getGlobalInstance().addAccept("sg.ctx.cp.domain.");
    }
}
