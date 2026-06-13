package com.sabekur2017.digitalwallet.data.sources

import com.sabekur2017.digitalwallet.R
import com.sabekur2017.digitalwallet.data.models.*

class WalletDatasourceImpl : WalletDatasource {
    override suspend fun getWalletInfo(): UserWalletInfoDto {
        return UserWalletInfoDto(
            userName = "ARIEF WAHDAN",
            balance = 385.00,
            coinReward = 5.400
        )
    }

    override suspend fun getServices(): List<ServiceItemDto> {
        return listOf(
            ServiceItemDto("1", "Electricity", R.drawable.ic_home_selected),
            ServiceItemDto("2", "Water Bill", R.drawable.ic_home_selected),
            ServiceItemDto("3", "Phone Credit", R.drawable.ic_home_selected),
            ServiceItemDto("4", "Internet", R.drawable.ic_home_selected),
            ServiceItemDto("5", "E-Money", R.drawable.ic_home_selected),
            ServiceItemDto("6", "G-Voucher", R.drawable.ic_home_selected),
            ServiceItemDto("7", "Netflix", R.drawable.ic_home_selected),
            ServiceItemDto("8", "More", R.drawable.ic_home_selected)
        )
    }

    override suspend fun getPromotions(): List<PromotionDto> {
        return listOf(
            PromotionDto("1", "BIG SALE", R.drawable.ic_launcher_foreground)
        )
    }

    override suspend fun getNearbyMerchants(): List<MerchantDto> {
        return listOf(
            MerchantDto("1", "KFC", "Fast Food", "1.2 km", 4.8, R.drawable.ic_marcent_icon),
            MerchantDto("2", "Burger King", "Fast Food", "1.2 km", 4.8, R.drawable.ic_marcent_icon),
            MerchantDto("3", "Pizza Hut", "Fast Food", "1.2 km", 4.8, R.drawable.ic_marcent_icon)
        )
    }

    override suspend fun getTransactions(): List<TransactionDto> {
        return listOf(
            TransactionDto("1", "Junaedi", "QR Payment", "5 Jul 2023", 75.000, false, "Success", R.drawable.ic_history_selected),
            TransactionDto("2", "Junaedi", "Bank Transfer", "5 Jul 2023", 115.000, false, "Success", R.drawable.ic_history_selected),
            TransactionDto("3", "Junaedi", "Top Up", "5 Jul 2023", 345.000, true, "Success", R.drawable.ic_history_selected),
            TransactionDto("4", "Junaedi", "Sent to Friend", "5 Jul 2023", 115.000, false, "Success", R.drawable.ic_history_selected)
        )
    }

    override suspend fun getUserProfile(): UserProfileDto {
        return UserProfileDto(
            name = "ARIEF WAHDAN ALFHAT",
            email = "Wahdanalfhat@gmail.com",
            phone = "081221447884",
            isVerified = true,
            avatarRes = R.drawable.ic_profile_selected
        )
    }

    override suspend fun getSettingsCategories(): List<SettingsCategoryDto> {
        return listOf(
            SettingsCategoryDto(
                title = "Account & Security",
                items = listOf(
                    SettingsItemDto("1", "Account Settings", R.drawable.ic_profile_selected),
                    SettingsItemDto("2", "Referral", R.drawable.ic_profile_selected),
                    SettingsItemDto("3", "Coin & Reward", R.drawable.ic_profile_selected),
                    SettingsItemDto("4", "My Voucher", R.drawable.ic_profile_selected)
                )
            ),
            SettingsCategoryDto(
                title = "General",
                items = listOf(
                    SettingsItemDto("5", "Terms & Conditions", R.drawable.ic_profile_selected),
                    SettingsItemDto("6", "Privacy Policy", R.drawable.ic_profile_selected),
                    SettingsItemDto("7", "Customer Services", R.drawable.ic_profile_selected)
                )
            )
        )
    }
}
