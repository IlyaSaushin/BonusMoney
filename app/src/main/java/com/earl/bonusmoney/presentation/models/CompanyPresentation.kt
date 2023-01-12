package com.earl.bonusmoney.presentation.models

interface CompanyPresentation {

    class Base(
        private val company: CompanyIdPresentation,
        private val customerMarkParameters: CustomerMarkParametersPresentation,
        private val mobileAppDashboard: MobileAppDashboardPresentation
    ) : CompanyPresentation {

    }
}