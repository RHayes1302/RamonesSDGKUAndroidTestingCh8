package com.example.sdgkuandroidtestingch8.models

object ProductValidator {

    private const val MIN_PRICE = 0.0

    fun isValid(product: Product): Boolean =
        hasName(product) && hasValidPrice(product)

    private fun hasName(product: Product): Boolean = product.name.isNotBlank()

    private fun hasValidPrice(product: Product): Boolean = product.price >= MIN_PRICE
}