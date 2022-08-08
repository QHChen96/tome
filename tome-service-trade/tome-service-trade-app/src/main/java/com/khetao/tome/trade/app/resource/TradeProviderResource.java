package com.khetao.tome.trade.app.resource;

import com.khetao.tome.trade.domain.repo.BuyerRepo;
import com.khetao.tome.trade.dto.OrderDTO;
import com.khetao.tome.trade.dto.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenqinhao 2022/7/13
 * @email qhchen96@gmail.com
 */
@RequestMapping("/trade")
@RestController
@Slf4j
public class TradeProviderResource {

    @Autowired
    private BuyerRepo buyerRepo;

    @GetMapping("/order/{orderId}")
    public OrderResponse getOrder(@PathVariable("orderId") Long orderId) {
        OrderResponse response = new OrderResponse();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(orderId);
        String buyerName = buyerRepo.getBuyer(orderId).getBuyerName();
        orderDTO.setBuyerName(buyerName);
        response.setOrder(orderDTO);
        return response;
    }

}
