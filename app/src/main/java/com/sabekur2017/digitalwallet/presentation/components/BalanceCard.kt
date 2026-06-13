package com.sabekur2017.digitalwallet.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.sabekur2017.digitalwallet.R
import com.sabekur2017.digitalwallet.domain.models.UserWalletInfo
import com.sabekur2017.digitalwallet.presentation.theme.Sdp

@Composable
fun BalanceCard(walletInfo: UserWalletInfo?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Sdp.dp20)
            .offset(y = (-Sdp.dp40)),
        shape = RoundedCornerShape(Sdp.dp16),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = Sdp.dp4)
    ) {
        Row(
            modifier = Modifier
                .padding(Sdp.dp16)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Balance",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "৳${walletInfo?.balance ?: "385.00"}",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Coin Reward ${walletInfo?.coinReward ?: "5.400"}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(Sdp.dp12)) {
                BalanceActionItem(icon = R.drawable.ic_top_up_icon, label = "Top Up")
                BalanceActionItem(icon = R.drawable.ic_send_icon, label = "Send")
            }
        }
    }
}

@Composable
fun BalanceActionItem(icon: Int, label: String) {
    Surface(
        modifier = Modifier.size(width = Sdp.dp48, height = Sdp.dp56),
        shape = RoundedCornerShape(Sdp.dp8),
        border = BorderStroke(
            Sdp.dp1,
            MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.1f)
        ),
        color = Color.White
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(Sdp.dp24),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(Sdp.dp4))
            Text(
                text = label,
                fontSize = Sdp.sp12,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
