package com.sabekur2017.digitalwallet.presentation.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sabekur2017.digitalwallet.R
import com.sabekur2017.digitalwallet.domain.models.Transaction
import com.sabekur2017.digitalwallet.presentation.components.TransactionHistoryItem
import com.sabekur2017.digitalwallet.presentation.theme.Sdp
import java.util.Locale

@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA))
    ) {
        HistoryHeader(
            searchQuery = uiState.searchQuery,
            onSearchQueryChange = { viewModel.onEvent(HistoryEvent.SearchTransactions(it)) }
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = Sdp.dp20, end = Sdp.dp20, top = Sdp.dp20, bottom = Sdp.dp110),
            verticalArrangement = Arrangement.spacedBy(Sdp.dp16)
        ) {
            items(uiState.transactions) { transaction ->
                TransactionHistoryItem(transaction)
            }
        }
    }
}

@Composable
fun HistoryHeader(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = Sdp.dp20)
            .padding(top = Sdp.dp52, bottom = Sdp.dp20)
    ) {
        Text(
            text = "Transaction History",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(Sdp.dp16))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(Sdp.dp36),
                shape = RoundedCornerShape(Sdp.dp8),
                color = Color.White
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = Sdp.dp12)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.LightGray,
                        modifier = Modifier.size(Sdp.dp18)
                    )
                    Spacer(modifier = Modifier.width(Sdp.dp8))
                    BasicTextField(
                        value = searchQuery,
                        onValueChange = onSearchQueryChange,
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        textStyle = MaterialTheme.typography.bodyMedium.copy(color = Color.DarkGray),
                        decorationBox = { innerTextField ->
                            if (searchQuery.isEmpty()) {
                                Text(
                                    text = "Search",
                                    color = Color.LightGray,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                            innerTextField()
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(Sdp.dp12))
            Icon(
                painter = painterResource(id = R.drawable.ic_filter_icon),
                contentDescription = "Filter",
                tint = Color.White,
                modifier = Modifier.size(Sdp.dp24)
            )
        }
    }
}
