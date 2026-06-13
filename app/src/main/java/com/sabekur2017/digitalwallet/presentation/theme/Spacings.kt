package com.blessbit.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

abstract class Spacings(
    open val extraSmall: Dp,
    open val small: Dp,
    open val medium: Dp,
    open val large: Dp,
    open val extraLarge: Dp,
    open val extra2Large: Dp,
)

data class PhoneSpacings(
    override val extraSmall: Dp = 4.dp,
    override val small: Dp = 8.dp,
    override val medium: Dp = 16.dp,
    override val large: Dp = 24.dp,
    override val extraLarge: Dp = 32.dp,
    override val extra2Large: Dp = 42.dp,
) : Spacings(
    extraSmall = extraSmall,
    small = small,
    medium = medium,
    large = large,
    extraLarge = extraLarge,
    extra2Large = extra2Large,
)

data class TabSpacings(
    override val extraSmall: Dp = 8.dp,
    override val small: Dp = 16.dp,
    override val medium: Dp = 24.dp,
    override val large: Dp = 32.dp,
    override val extraLarge: Dp = 42.dp,
    override val extra2Large: Dp = 64.dp,
) : Spacings(
    extraSmall = extraSmall,
    small = small,
    medium = medium,
    large = large,
    extraLarge = extraLarge,
    extra2Large = extra2Large,
)

data class TvSpacings(
    override val extraSmall: Dp = 16.dp,
    override val small: Dp = 24.dp,
    override val medium: Dp = 32.dp,
    override val large: Dp = 42.dp,
    override val extraLarge: Dp = 64.dp,
    override val extra2Large: Dp = 74.dp,
) : Spacings(
    extraSmall = extraSmall,
    small = small,
    medium = medium,
    large = large,
    extraLarge = extraLarge,
    extra2Large = extra2Large,
)

val LocalSpacings = compositionLocalOf<Spacings> {
    PhoneSpacings()
}

val MaterialTheme.spacings: Spacings
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacings.current