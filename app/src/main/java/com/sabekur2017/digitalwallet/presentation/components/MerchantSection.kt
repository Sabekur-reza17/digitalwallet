package com.sabekur2017.digitalwallet.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.sabekur2017.digitalwallet.domain.models.Merchant
import com.sabekur2017.digitalwallet.presentation.theme.Sdp

@Composable
fun MerchantSection(merchants: List<Merchant>) {
    Column(modifier = Modifier.padding(vertical = Sdp.dp16)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Sdp.dp20),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Nearby Merchant",
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
            items(merchants) { merchant ->
                MerchantCard(merchant)
            }
        }
    }
}

@Composable
fun MerchantCard(merchant: Merchant) {
    Card(
        modifier = Modifier.width(Sdp.dp110),
        shape = RoundedCornerShape(Sdp.dp12),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(Sdp.dp1, MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.1f))
    ) {
        Column(modifier = Modifier.padding(Sdp.dp12)) {
            Image(
                painter = painterResource(id = merchant.logoRes),
                contentDescription = null,
                modifier = Modifier
                    .size(Sdp.dp48)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(Sdp.dp8))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = merchant.distance,
                    fontSize = Sdp.sp10,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFFFFB400),
                    modifier = Modifier.size(Sdp.dp10)
                )
                Text(
                    text = merchant.rating.toString(),
                    fontSize = Sdp.sp10,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = "MERCHANT",
                fontSize = Sdp.sp12,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = merchant.name,
                fontSize = Sdp.sp12,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = merchant.category,
                fontSize = Sdp.sp10,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
