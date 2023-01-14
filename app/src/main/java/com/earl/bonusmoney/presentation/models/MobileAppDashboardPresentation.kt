package com.earl.bonusmoney.presentation.models

interface MobileAppDashboardPresentation {

    fun provideDetailsForCardRecycler() : MobileAppDashboardDetailsForCardRecycler

    class Base(
        private val companyName: String,
        private val logo: String,
        private val backgroundColor: String,
        private val mainColor: String,
        private val cardBackgroundColor: String,
        private val textColor: String,
        private val highlightTextColor: String,
        private val accentColor: String
    ) : MobileAppDashboardPresentation {

        override fun provideDetailsForCardRecycler() =
            MobileAppDashboardDetailsForCardRecycler(
                companyName,
                logo,
                mainColor,
                cardBackgroundColor,
                textColor,
                highlightTextColor,
                accentColor,
                backgroundColor
            )
    }
}