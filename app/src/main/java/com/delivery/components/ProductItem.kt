package com.delivery.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delivery.R
import com.delivery.activity.ui.theme.Purple40
import com.delivery.activity.ui.theme.Purple80
import com.delivery.extensions.toBrazilianCurrency
import com.delivery.model.Product
import java.math.BigDecimal

@Composable
fun ProductItem(product: Product) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple40,
                                Purple80
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    Modifier
                        .offset(y = imageSize / 2)
                        .size(imageSize)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))

            Column(Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight((700)),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    Modifier.padding(top = 4.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ProductItem(
        Product(
            name = LoremIpsum(50).values.first(),
            price = BigDecimal("15.99"),
            image = R.drawable.placeholder
        )
    )

}