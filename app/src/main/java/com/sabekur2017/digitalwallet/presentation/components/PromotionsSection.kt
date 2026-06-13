package com.sabekur2017.digitalwallet.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.sabekur2017.digitalwallet.domain.models.Promotion
import com.sabekur2017.digitalwallet.presentation.theme.Sdp

@Composable
fun PromotionsSection(promotions: List<Promotion>) {
    Column(modifier = Modifier.padding(vertical = Sdp.dp16)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Sdp.dp20),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Today's Promotions",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "view all",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = Sdp.sp14,
                modifier = Modifier.clickable { }
            )
        }
        Spacer(modifier = Modifier.height(Sdp.dp12))
        LazyRow(
            contentPadding = PaddingValues(horizontal = Sdp.dp20),
            horizontalArrangement = Arrangement.spacedBy(Sdp.dp16)
        ) {
            items(promotions) { promotion ->
                Image(
                    painter = painterResource(id = promotion.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .width(Sdp.dp300)
                        .height(Sdp.dp130)
                        .clip(RoundedCornerShape(Sdp.dp12)),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}
