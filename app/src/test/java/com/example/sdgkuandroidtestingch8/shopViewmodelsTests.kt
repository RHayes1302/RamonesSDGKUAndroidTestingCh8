package com.example.sdgkuandroidtestingch8

import com.example.sdgkuandroidtestingch8.models.Product
import com.example.sdgkuandroidtestingch8.ui.theme.shopping.ProductRepository
import com.example.sdgkuandroidtestingch8.ui.theme.shopping.ShopViewModel
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions
import org.mockito.kotlin.whenever

class ShopViewModelTests {

    @Test
    fun products_comeFromTheRepository() {
        val repo = mock<ProductRepository>()
        val fakeProducts = listOf(Product("Running Shoes", 50.0), Product("Hat", 20.0))
        whenever(repo.getProducts()).thenReturn(fakeProducts)

        val viewModel = ShopViewModel(repo)

        assertEquals(fakeProducts, viewModel.products)
        verify(repo).getProducts()
    }

    @Test
    fun emptyRepository_returnsNoProducts() {
        val repo = mock<ProductRepository>()
        whenever(repo.getProducts()).thenReturn(emptyList())

        assertEquals(0, ShopViewModel(repo).products.size)
    }

    @Test
    fun addingToCart_updatesSubtotal_withoutCallingTheRepository() {
        val repo = mock<ProductRepository>()
        val viewModel = ShopViewModel(repo)

        viewModel.addToCart(Product("Running Shoes", 150.0))
        viewModel.addToCart(Product("Hat", 100.0)) // 250 -> 10% off

        assertEquals(225.0, viewModel.subtotalPrice(), 0.001)
        verifyNoInteractions(repo)
    }
}
