package com.example.sdgkuandroidtestingch8

import com.example.sdgkuandroidtestingch8.models.Product
import com.example.sdgkuandroidtestingch8.ui.theme.ShoppingCart
import org.junit.Assert.assertEquals
import org.junit.Test

class CartLogicTests {

    @Test
    fun calculateTotal_addsAllItemPrices() {
        val cart = ShoppingCart()
        cart.addItem(Product("Shoes", 10.0))
        cart.addItem(Product("Hat", 20.0))
        assertEquals(30.0, cart.totalPrice(), 0.001)
    }

    @Test
    fun removingAnItem_lowersTheTotal() {
        val cart = ShoppingCart()
        val hat = Product("Hat", 20.0)
        cart.addItem(Product("Shoes", 50.0))
        cart.addItem(hat)
        cart.removeItem(hat)
        assertEquals(50.0, cart.totalPrice(), 0.001)
    }

    @Test
    fun totalOfExactly500_getsTenPercentNotTwenty() {
        val cart = ShoppingCart()
        cart.addItem(Product("Bike", 500.0))
        assertEquals(450.0, cart.totalPrice(), 0.001)
    }
}

