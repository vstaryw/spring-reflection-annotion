package com.vstaryw.code.component

import com.vstaryw.code.annotation.OrderType
import com.vstaryw.code.handler.OrderHandler
import org.reflections.Reflections
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class OrderHandlerContext(
    private val springUtil: SpringUtil
) {

    private val package_path = "com.vstaryw.code.handler.impl"

    private val handlerMap = mutableMapOf<String, OrderHandler>()

    @PostConstruct
    fun init(){
        val reflections = Reflections(package_path)
        val typesAnnotatedWith = reflections.getTypesAnnotatedWith(OrderType::class.java)
        for (it in typesAnnotatedWith) {
            val annotation = it.getAnnotation(OrderType::class.java)
            handlerMap[annotation.value] = springUtil.getBean(it) as OrderHandler
        }
    }

    fun getInstance(type: String): OrderHandler? {
        return  handlerMap.getOrDefault(type, null)
    }
}