package com.sabekur2017.digitalwallet.data.mapper

import com.sabekur2017.digitalwallet.data.models.SettingsCategoryDto
import com.sabekur2017.digitalwallet.data.models.SettingsItemDto
import com.sabekur2017.digitalwallet.domain.models.SettingsCategory
import com.sabekur2017.digitalwallet.domain.models.SettingsItem

fun SettingsCategoryDto.toSettingsCategory(): SettingsCategory {
    return SettingsCategory(
        title = title.orEmpty(),
        items = items?.map { it.toSettingsItem() }.orEmpty()
    )
}

fun SettingsItemDto.toSettingsItem(): SettingsItem {
    return SettingsItem(
        id = id.orEmpty(),
        title = title.orEmpty(),
        iconRes = iconRes ?: 0
    )
}
