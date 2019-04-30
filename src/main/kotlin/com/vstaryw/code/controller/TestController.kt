package com.vstaryw.code.controller

import com.vstaryw.code.component.OrderHandlerContext
import com.vstaryw.code.component.OrderListenerProcessor
import com.vstaryw.code.entity.OrderInfo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("test")
class TestController(
    private val orderHandlerContext: OrderHandlerContext,
    private val orderListenerProcessor: OrderListenerProcessor
) {
    @GetMapping("/order/context")
    fun handlerByContext(orderInfo: OrderInfo){
        val instance = orderHandlerContext.getInstance(orderInfo.type.toString())
        instance?.handler(orderInfo)
    }

    @GetMapping("/order/processor")
    fun handlerByProcessor(orderInfo: OrderInfo){
        val instance = orderListenerProcessor.getInstance(orderInfo.type.toString())
        instance?.handler(orderInfo)
    }
}