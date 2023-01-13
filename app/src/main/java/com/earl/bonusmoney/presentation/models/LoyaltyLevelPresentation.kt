package com.earl.bonusmoney.presentation.models

interface LoyaltyLevelPresentation {

    fun provideDetailsForCardRecycler() : LoyaltyLevelDetailsForRecyclerDetails

    class Base(
        private val number: Int,
        private val name: String,
        private val requiredSum: Int,
        private val markToCash: Int,
        private val cashToMark: Int
    ) : LoyaltyLevelPresentation {
        override fun provideDetailsForCardRecycler() =
            LoyaltyLevelDetailsForRecyclerDetails(number, name)
    }
}