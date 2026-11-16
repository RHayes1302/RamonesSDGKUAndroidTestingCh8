package com.example.sdgkuandroidtestingch8

import com.example.sdgkuandroidtestingch8.models.Product
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class ProductModelTests {

    @Test
    fun product_storesNameAndPrice() {
        val product = Product("Running Shoes", 49.99)
        assertEquals("Running Shoes", product.name)
        assertEquals(49.99, product.price, 0.001)
    }

    @Test
    fun productsWithSameValues_areEqual() {
        assertEquals(Product("Hat", 20.0), Product("Hat", 20.0))
        assertNotEquals(Product("Hat", 20.0), Product("Hat", 25.0))
    }

    @Test
    fun copy_changesOnlyTheGivenField() {
        val original = Product("Hat", 20.0)
        val discounted = original.copy(price = 15.0)
        assertEquals("Hat", discounted.name)
        assertEquals(15.0, discounted.price, 0.001)
        assertEquals(20.0, original.price, 0.001)
    }

    @Test
    fun product_convertsToReadableText() {
        assertEquals("Product(name=Hat, price=20.0)", Product("Hat", 20.0).toString())
    }
}

