package com.khetao.tome.trade.facade;

import com.khetao.tome.trade.dto.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author chenqinhao 2022/7/13
 * @email qhchen96@gmail.com
 */
@FeignClient("trade-provider")
public interface TradeClientFacade {

    /**
     * 获取订单信息
     * @param orderId
     * @return
     */
    @Path("/trade/order/{orderId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    OrderResponse getOrder(@PathParam("orderId") Long orderId);


}
