package com.delivery.model

import android.media.Image
import androidx.annotation.DrawableRes
import com.delivery.R
import java.math.BigDecimal

class Product(

    val name: String,
    val price: BigDecimal,
    @DrawableRes val image: Int

)

