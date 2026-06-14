package com.sabekur2017.digitalwallet.data.sources

import com.sabekur2017.digitalwallet.R
import com.sabekur2017.digitalwallet.data.models.*

class WalletDatasourceImpl : WalletDatasource {
    override suspend fun getWalletInfo(): UserWalletInfoDto {
        return UserWalletInfoDto(
            userName = "ARIEF WAHAN",
            balance = 385.00,
            coinReward = 5.400
        )
    }

    override suspend fun getServices(): List<ServiceItemDto> {
        return listOf(
            ServiceItemDto("1", "Electricity", R.drawable.ic_elecricity),
            ServiceItemDto("2", "Water Bill", R.drawable.ic_waterbill),
            ServiceItemDto("3", "Phone Credit", R.drawable.ic_phone_credit),
            ServiceItemDto("4", "Internet", R.drawable.ic_internet),
            ServiceItemDto("5", "E-Money", R.drawable.ic_e_money),
            ServiceItemDto("6", "G-Voucher", R.drawable.ic_voucher),
            ServiceItemDto("7", "Netflix", R.drawable.ic_neflix_icon),
            ServiceItemDto("8", "More", R.drawable.ic_more_icon)
        )
    }

    override suspend fun getPromotions(): List<PromotionDto> {
        return listOf(
            PromotionDto("1", "BIG SALE", R.drawable.today_promotion_banner),
            PromotionDto("2", "BIG SALE 2", R.drawable.today_promotion_banner),
            PromotionDto("3", "BIG SALE 3", R.drawable.today_promotion_banner)
        )
    }

    override suspend fun getNearbyMerchants(): List<MerchantDto> {
        return listOf(
            MerchantDto("1", "KFC", "Fast Food", "1.2 km", 4.8, R.drawable.kfc_icon),
            MerchantDto("2", "Burger King", "Fast Food", "1.2 km", 4.8, R.drawable.burger_king_icon),
            MerchantDto("3", "Pizza Hut", "Fast Food", "1.2 km", 4.8, R.drawable.pizza_hut_icon)
        )
    }

    override suspend fun getTransactions(): List<TransactionDto> {
        return listOf(
            TransactionDto("1", "Junaedi", "QR Payment", "5 Jul 2023", 75.000, false, "Success", R.drawable.qr_code_icon),
            TransactionDto("2", "Junaedi", "Bank Transfer", "5 Jul 2023", 115.000, false, "Success", R.drawable.__icon__send_2_),
            TransactionDto("3", "Junaedi", "Top Up", "5 Jul 2023", 345.000, true, "Success", R.drawable.ic_icon_topup),
            TransactionDto("4", "Junaedi", "Sent to Friend", "5 Jul 2023", 115.000, false, "Success", R.drawable.__icon__wallet_),
            TransactionDto("5", "Junaedi", "Bank Transfer", "5 Jul 2023", 115.000, false, "Success", R.drawable.__icon__send_2_),
            TransactionDto("2", "Junaedi", "Bank Transfer", "5 Jul 2023", 115.000, false, "Success", R.drawable.__icon__send_2_),
            TransactionDto("3", "Junaedi", "Top Up", "5 Jul 2023", 345.000, true, "Success", R.drawable.ic_icon_topup),
            TransactionDto("4", "Junaedi", "Sent to Friend", "5 Jul 2023", 115.000, false, "Success", R.drawable.__icon__wallet_),
            TransactionDto("5", "Junaedi", "Bank Transfer", "5 Jul 2023", 115.000, false, "Success", R.drawable.__icon__send_2_)
        )
    }

    override suspend fun getUserProfile(): UserProfileDto {
        return UserProfileDto(
            name = "ARIEF WAHDAN ALFHAT",
            email = "Wahdanalfhat@gmail.com",
            phone = "081221447884",
            isVerified = true,
            avatarRes = R.drawable.ic_profile_icon
        )
    }

    override suspend fun getSettingsCategories(): List<SettingsCategoryDto> {
        return listOf(
            SettingsCategoryDto(
                title = "Account & Security",
                items = listOf(
                    SettingsItemDto("1", "Account Settings", R.drawable.ic_account_setting),
                    SettingsItemDto("2", "Referral", R.drawable.ic_referels),
                    SettingsItemDto("3", "Coin & Reward", R.drawable.ic_coin_reward),
                    SettingsItemDto("4", "My Voucher", R.drawable.ic_my_voucher)
                )
            ),
            SettingsCategoryDto(
                title = "General",
                items = listOf(
                    SettingsItemDto("5", "Terms & Conditions", R.drawable.ic_terms),
                    SettingsItemDto("6", "Privacy Policy", R.drawable.ic_privacy_policy),
                    SettingsItemDto("7", "Customer Services", R.drawable.ic_custom_service)
                )
            )
        )
    }
}
