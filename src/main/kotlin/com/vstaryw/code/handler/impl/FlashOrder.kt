package com.vstaryw.code.handler.impl

import com.vstaryw.code.annotation.OrderType
import com.vstaryw.code.entity.OrderInfo
import com.vstaryw.code.handler.OrderHandler
import org.springframework.stereotype.Service

@OrderType("1")
@Service
class FlashOrder: OrderHandler {
    override fun handler(orderInfo: OrderInfo) {
        println("handler flash order success: $orderInfo")
    }
}