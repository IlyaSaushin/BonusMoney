package com.earl.bonusmoney.domain.mappers

interface MobileAppDashboardDomainToPresentationMapper<T> {

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