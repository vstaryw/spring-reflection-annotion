package com.vstaryw.code.component

import com.vstaryw.code.annotation.OrderType
import com.vstaryw.code.handler.OrderHandler
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.stereotype.Component

@Component
class OrderListenerProcessor: BeanPostProcessor  {

    private val handlerMap = mutableMapOf<String, OrderHandler>()

    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
        val findAnnotation = AnnotationUtils.findAnnotation(bean.javaClass, OrderType::class.java)
         findAnnotation?.apply {
            handlerMap[this.value] = bean as OrderHandler
        }
        return bean
    }

    fun getInstance(type: String): OrderHandler? {
        return handlerMap.getOrDefault(type, null)
    }
}