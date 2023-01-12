package com.earl.bonusmoney.domain.models

import com.earl.bonusmoney.domain.mappers.MobileAppDashboardDomainToPresentationMapper

interface MobileAppDashboardDomain {

    fun <T> mapToPresentation(mapper: MobileAppDashboardDomainToPresentationMapper<T>) : T

    class Base(
        private val companyName: String,
        private val logo: String,
        private val backgroundColor: String,
        private val mainColor: String,
        private val cardBackgroundColor: String,
        private val textColor: String,
        private val highlightTextColor: String,
        private val accentColor: String
    ) : MobileAppDashboardDomain {
        override fun <T> mapToPresentation(mapper: MobileAppDashboardDomainToPresentationMapper<T>) =
            mapper.map(companyName, logo, backgroundColor, mainColor, cardBackgroundColor, textColor, highlightTextColor, accentColor)
    }
}