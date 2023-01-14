package com.earl.bonusmoney.data.models.remote

import com.earl.bonusmoney.data.mappers.*
import com.earl.bonusmoney.data.models.*

@kotlinx.serialization.Serializable
data class Company(
    val company: CompanyId,
    val customerMarkParameters: CustomerMarkParameters,
    val mobileAppDashboard: MobileAppDashboard
) {
    fun mapToData(mapper: CompanyRemoteToDataMapper<CompanyData>) =
        mapper.map(company, customerMarkParameters, mobileAppDashboard)
}

@kotlinx.serialization.Serializable
data class CompanyId(
    val companyId: String
) {
    fun mapToData(mapper: CompanyIdRemoteToDataMapper<CompanyIdData>) = mapper.map(companyId)
}

@kotlinx.serialization.Serializable
data class CustomerMarkParameters(
    val loyaltyLevel: LoyaltyLevel,
    val mark: Int
) {
    fun mapToData(mapper: CustomerMarkParametersRemoteToDataMapper<CustomerMarkParametersData>) =
        mapper.map(loyaltyLevel, mark)
}

@kotlinx.serialization.Serializable
data class LoyaltyLevel(
    val number: Int,
    val name: String,
    val requiredSum: Int,
    val markToCash: Int,
    val cashToMark: Int
) {
    fun mapToData(mapper: LoyaltyLevelRemoteToDataMapper<LoyaltyLevelData>) =
        mapper.map(number, name, requiredSum, markToCash, cashToMark)
}

@kotlinx.serialization.Serializable
data class MobileAppDashboard(
    val companyName: String,
    val logo: String,
    val backgroundColor: String,
    val mainColor: String,
    val cardBackgroundColor: String,
    val textColor: String,
    val highlightTextColor: String,
    val accentColor: String
) {
    fun mapToData(mapper: MobileAppDashboardRemoteToDataMapper<MobileAppDashboardData>) =
        mapper.map(companyName, logo, backgroundColor, mainColor, cardBackgroundColor, textColor, highlightTextColor, accentColor)
}