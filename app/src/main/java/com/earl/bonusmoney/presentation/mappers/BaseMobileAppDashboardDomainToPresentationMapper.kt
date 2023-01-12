package com.earl.bonusmoney.presentation.mappers

import com.earl.bonusmoney.domain.mappers.MobileAppDashboardDomainToPresentationMapper
import com.earl.bonusmoney.presentation.models.MobileAppDashboardPresentation
import javax.inject.Inject

class BaseMobileAppDashboardDomainToPresentationMapper @Inject constructor() : MobileAppDashboardDomainToPresentationMapper<MobileAppDashboardPresentation> {

    override fun map(
        companyName: String,
        logo: String,
        backgroundColor: String,
        mainColor: String,
        cardBackgroundColor: String,
        textColor: String,
        highlightTextColor: String,
        accentColor: String
    ) = MobileAppDashboardPresentation.Base(
        companyName, logo, backgroundColor, mainColor, cardBackgroundColor, textColor, highlightTextColor, accentColor
    )
}