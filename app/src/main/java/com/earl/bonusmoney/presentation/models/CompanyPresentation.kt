package com.earl.bonusmoney.presentation.models

interface CompanyPresentation {

    fun provideDetailsForCardRecycler() : CardRecyclerDetails

    class Base(
        private val company: CompanyIdPresentation,
        private val customerMarkParameters: CustomerMarkParametersPresentation,
        private val mobileAppDashboard: MobileAppDashboardPresentation
    ) : CompanyPresentation {
        override fun provideDetailsForCardRecycler(): CardRecyclerDetails {
            val customerMarkParametersDetails = customerMarkParameters.provideDetailsForCardRecycler()
            val mobileAppDashboardDetails = mobileAppDashboard.provideDetailsForCardRecycler()
            return CardRecyclerDetails(
                company.id,
                mobileAppDashboardDetails.name,
                mobileAppDashboardDetails.image,
                customerMarkParametersDetails.cashbackPercent,
                customerMarkParametersDetails.loyaltyLevel,
                mobileAppDashboardDetails.main,
                mobileAppDashboardDetails.cardBackground,
                mobileAppDashboardDetails.text,
                mobileAppDashboardDetails.highlight,
                mobileAppDashboardDetails.accent,
                mobileAppDashboardDetails.backgroundColor
            )
        }
    }
}