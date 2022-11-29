//package com.example.orderservice.controller;
//
//import com.example.orderservice.dto.OrderDto;
//import com.example.orderservice.service.OrderService;
//import com.example.orderservice.vo.RequestOrder;
//import com.example.orderservice.vo.ResponseOrder;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.convention.MatchingStrategies;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/sm-mtd-service")
//public class OrderController {
//    Environment env;
//
//    @Autowired
//    public OrderController( Environment env) {
//        this.env = env;
//    }
//    @GetMapping("/health_check")
//    public String status() {
//
//        return  String.format("It's Working in Order Service on PORT %s",
//                env.getProperty("local.server.port"));
//    }
//    @PostMapping("/{userId}/orders")
//    public ResponseEntity<ResponseOrder> createOrder(@PathVariable("userId") String userId,
//                                      @RequestBody RequestOrder orderDetails ) {
//        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        OrderDto orderDto = mapper.map(orderDetails, OrderDto.class);
//        orderDto.setUserId(userId);
//        OrderDto CreatedOrder = orderService.createOrder(orderDto);
//
//        ResponseOrder responseOrder = mapper.map(CreatedOrder, ResponseOrder.class);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(responseOrder);
//    }
//
//   @GetMapping("/{userId}/orders")
//    public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable("userId") String userId) {
//        Iterable<OrderEntity> orderList = orderService.getOrderByUserId(userId);
//
//        List<ResponseOrder> result = new ArrayList<>();
//        orderList.forEach(v -> {
//            result.add(new ModelMapper().map(v, ResponseOrder.class));
//        });
//        return ResponseEntity.status(HttpStatus.CREATED).body(result);
//   }
//
//
//}
