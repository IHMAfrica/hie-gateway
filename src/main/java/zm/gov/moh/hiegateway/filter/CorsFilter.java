package zm.gov.moh.hiegateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CorsFilter implements GlobalFilter, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(CorsFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String origin = headers.getOrigin();
        String method = headers.getFirst(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD);

        if (origin != null) {
            logger.info("CORS Request - Origin: {}, Method: {}, Path: {}",
                    origin, method, exchange.getRequest().getPath());
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}