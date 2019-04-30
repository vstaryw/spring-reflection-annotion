package com.vstaryw.code.handler

import com.vstaryw.code.entity.OrderInfo

interface OrderHandler {

    fun handler(orderInfo: OrderInfo)
}