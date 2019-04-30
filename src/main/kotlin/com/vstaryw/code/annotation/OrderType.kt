package com.vstaryw.code.annotation

@MustBeDocumented
@Target(AnnotationTarget.FIELD, AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class OrderType(
    val value: String
)