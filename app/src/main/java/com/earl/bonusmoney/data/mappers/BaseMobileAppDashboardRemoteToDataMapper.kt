package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.MobileAppDashboardData
import javax.inject.Inject

class BaseMobileAppDashboardRemoteToDataMapper @Inject constructor() : MobileAppDashboardRemoteToDataMapper<MobileAppDashboardData> {

    override fun map(
        companyName: String,
        logo: String,
        backgroundColor: String,
        mainColor: String,
        cardBackgroundColor: String,
        textColor: String,
        highlightTextColor: String,
        accentColor: String
    ) = MobileAppDashboardData.Base(
        companyName, logo, backgroundColor, mainColor, cardBackgroundColor, textColor, highlightTextColor, accentColor
    )
}