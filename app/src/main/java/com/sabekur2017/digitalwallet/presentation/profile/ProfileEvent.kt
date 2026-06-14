package com.sabekur2017.digitalwallet.presentation.profile

sealed class ProfileEvent {
    object LoadProfile : ProfileEvent()
    object Logout : ProfileEvent()
}
