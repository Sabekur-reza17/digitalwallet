package com.sabekur2017.digitalwallet.presentation.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sabekur2017.digitalwallet.R
import com.sabekur2017.digitalwallet.domain.models.SettingsCategory
import com.sabekur2017.digitalwallet.domain.models.UserProfile
import com.sabekur2017.digitalwallet.presentation.components.SettingsItemRow
import com.sabekur2017.digitalwallet.presentation.theme.Sdp

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF8F9FA)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = Sdp.dp16)
        ) {
            item {
                ProfileHeader(uiState.userProfile)
            }

            items(uiState.settingsCategories) { category ->
                SettingsSection(category)
            }

            item {
                LogoutButton(onLogout = { viewModel.onEvent(ProfileEvent.Logout) })
            }
        }
    }
}

@Composable
fun ProfileHeader(profile: UserProfile?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Sdp.dp180)
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = Sdp.dp16),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(Sdp.dp72),
                shape = CircleShape,
                color = Color.White.copy(alpha = 0.1f)
            ) {
                profile?.avatarRes?.let {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                    )
                }
            }
            Spacer(modifier = Modifier.width(Sdp.dp16))
            Column {
                Text(
                    text = profile?.name ?: "",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = profile?.email ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.9f)
                )
                Text(
                    text = profile?.phone ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.9f)
                )
                Spacer(modifier = Modifier.height(Sdp.dp8))
                if (profile?.isVerified == true) {
                    Surface(
                        color = Color.White,
                        shape = RoundedCornerShape(Sdp.dp16)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = Sdp.dp10, vertical = Sdp.dp2)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_verified_account),
                                contentDescription = null,
                                tint = Color(0xFF4CAF50),
                                modifier = Modifier.size(Sdp.dp12)
                            )
                            Spacer(modifier = Modifier.width(Sdp.dp4))
                            Text(
                                text = "Verified account",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(0xFF4CAF50),
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SettingsSection(category: SettingsCategory) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Sdp.dp24)
    ) {
        Text(
            text = category.title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = Sdp.dp24)
        )
        Spacer(modifier = Modifier.height(Sdp.dp8))
        category.items.forEach { item ->
            SettingsItemRow(item)
        }
    }
}

@Composable
fun LogoutButton(onLogout: () -> Unit) {
    Surface(
        onClick = onLogout,
        modifier = Modifier
            .padding(Sdp.dp24)
            .width(Sdp.dp110)
            .height(Sdp.dp48),
        shape = RoundedCornerShape(Sdp.dp8),
        border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant),
        color = Color.White
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_logout),
                contentDescription = null,
                modifier = Modifier.size(Sdp.dp24),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(Sdp.dp4))
            Text(
                text = "Logout",
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                fontSize = Sdp.sp14
            )
        }
    }
}
