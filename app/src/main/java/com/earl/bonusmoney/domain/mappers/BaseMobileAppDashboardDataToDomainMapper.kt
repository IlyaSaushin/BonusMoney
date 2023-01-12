package com.earl.bonusmoney.domain.mappers

import com.earl.bonusmoney.data.mappers.MobileAppDashboardDataToDomainMapper
import com.earl.bonusmoney.domain.models.MobileAppDashboardDomain
import javax.inject.Inject

class BaseMobileAppDashboardDataToDomainMapper @Inject constructor(): MobileAppDashboardDataToDomainMapper<MobileAppDashboardDomain> {

    override fun map(
        companyName: String,
        logo: String,
        backgroundColor: String,
        mainColor: String,
        cardBackgroundColor: String,
        textColor: String,
        highlightTextColor: String,
        accentColor: String
    ) = MobileAppDashboardDomain.Base(
        companyName, logo, backgroundColor, mainColor, cardBackgroundColor, textColor, highlightTextColor, accentColor
    )
}