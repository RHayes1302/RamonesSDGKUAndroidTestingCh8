package com.example.sdgkuandroidtestingch8

import com.example.sdgkuandroidtestingch8.models.Product
import com.example.sdgkuandroidtestingch8.models.ProductValidator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ProductValidatorTests {

    @Test
    fun productWithNameAndPrice_isValid() {
        assertTrue(ProductValidator.isValid(Product("Running Shoes", 49.99)))
    }

    @Test
    fun productWithEmptyName_isInvalid() {
        assertFalse(ProductValidator.isValid(Product("", 10.0)))
    }

    @Test
    fun productWithNegativePrice_isInvalid() {
        assertFalse(ProductValidator.isValid(Product("Hat", -5.0)))
    }

    @Test
    fun productWithZeroPrice_isValid() {
        assertTrue(ProductValidator.isValid(Product("Free Sticker", 0.0)))
    }

    @Test
    fun productWithBlankName_isInvalid() {
        assertFalse(ProductValidator.isValid(Product("   ", 10.0)))
    }
}
