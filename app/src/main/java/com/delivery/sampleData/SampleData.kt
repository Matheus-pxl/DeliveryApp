package com.delivery.sampleData

import com.delivery.R
import com.delivery.model.Product
import java.math.BigDecimal

val sampleProducts = listOf(
    Product(
        name = "burger",
        price = BigDecimal("15.99"),
        image = R.drawable.burger
    ),
    Product(
        name = "fries",
        price = BigDecimal("5.99"),
        image = R.drawable.fries
    ),
    Product(
        name = "pizza",
        price = BigDecimal("25.99"),
        image = R.drawable.pizza
    )

)