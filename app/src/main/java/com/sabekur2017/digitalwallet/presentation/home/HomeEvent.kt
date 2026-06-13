package com.sabekur2017.digitalwallet.presentation.home

sealed interface HomeEvent {
    data object Refresh : HomeEvent
}
