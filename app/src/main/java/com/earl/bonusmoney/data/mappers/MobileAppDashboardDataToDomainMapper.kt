package com.earl.bonusmoney.data.mappers

interface MobileAppDashboardDataToDomainMapper<T> {

    fun map(
        companyName: String,
        logo: String,
        backgroundColor: String,
        mainColor: String,
        cardBackgroundColor: String,
        textColor: String,
        highlightTextColor: String,
        accentColor: String
    ) : T
}