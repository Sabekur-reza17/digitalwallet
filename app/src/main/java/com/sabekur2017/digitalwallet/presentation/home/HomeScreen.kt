package com.sabekur2017.digitalwallet.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sabekur2017.digitalwallet.presentation.components.*
import com.sabekur2017.digitalwallet.presentation.theme.Sdp

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF8F9FA)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = Sdp.dp32)
        ) {
            item {
                HomeHeader(uiState.walletInfo?.userName ?: "ARIEF WAHAN")
            }

            item {
                BalanceCard(uiState.walletInfo)
            }

            item {
                ServiceGrid(uiState.services)
            }

            item {
                PromotionsSection(uiState.promotions)
            }

            item {
                MerchantSection(uiState.merchants)
            }
        }
    }
}
