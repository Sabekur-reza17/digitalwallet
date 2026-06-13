package com.sabekur2017.digitalwallet.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.sabekur2017.digitalwallet.domain.models.ServiceItem
import com.sabekur2017.digitalwallet.presentation.theme.Sdp

@Composable
fun ServiceGrid(services: List<ServiceItem>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Sdp.dp20)
            .padding(bottom = Sdp.dp16)
    ) {
        val rows = services.chunked(4)
        rows.forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Sdp.dp8)
            ) {
                rowItems.forEach { item ->
                    Box(modifier = Modifier.weight(1f)) {
                        ServiceItemView(item)
                    }
                }
                if (rowItems.size < 4) {
                    repeat(4 - rowItems.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
            Spacer(modifier = Modifier.height(Sdp.dp16))
        }
    }
}

@Composable
fun ServiceItemView(item: ServiceItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.size(Sdp.dp36),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = item.iconRes),
                contentDescription = item.title,
                modifier = Modifier.size(Sdp.dp24),
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.height(Sdp.dp4))
        Text(
            text = item.title,
            fontSize = Sdp.sp12,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            maxLines = 2,
            minLines = 2,
            overflow = TextOverflow.Ellipsis,
            lineHeight = Sdp.sp12
        )
    }
}
