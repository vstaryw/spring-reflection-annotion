package com.vstaryw.code.component

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
class SpringUtil: ApplicationContextAware {

    private lateinit var applicationContext: ApplicationContext

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        this.applicationContext = applicationContext
    }

    fun getApplicationContext(): ApplicationContext = applicationContext

    fun getBean(name: String): Any {
        return applicationContext.getBean(name)
    }

    fun <T> getBean(clazz: Class<T>): T {
        return applicationContext.getBean(clazz)
    }
}
