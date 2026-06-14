package com.sabekur2017.digitalwallet.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.sabekur2017.digitalwallet.presentation.theme.Sdp

@Composable
fun HomeHeader(userName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(Sdp.dp180)
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = Sdp.dp20)
            .padding(top = Sdp.dp52),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = userName,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = Sdp.dp4)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                contentPadding = PaddingValues(horizontal = Sdp.dp12),
                modifier = Modifier.height(Sdp.dp32),
                shape = RoundedCornerShape(Sdp.dp16)
            ) {
                Text(
                    text = "Get Reward",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = Sdp.sp12,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(Sdp.dp12))
            Surface(
                modifier = Modifier.size(Sdp.dp32),
                shape = CircleShape,
                color = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(Sdp.dp8)
                )
            }
        }
    }
}
