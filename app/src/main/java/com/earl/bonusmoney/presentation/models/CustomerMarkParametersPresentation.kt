package com.earl.bonusmoney.presentation.models

data class CustomerMarkParametersPresentation(
    private val loyaltyLevel: LoyaltyLevelPresentation,
    private val mark: Int
)