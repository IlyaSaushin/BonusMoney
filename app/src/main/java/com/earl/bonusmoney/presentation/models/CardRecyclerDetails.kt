package com.earl.bonusmoney.presentation.models

import android.widget.ImageView
import android.widget.TextView
import com.earl.bonusmoney.presentation.Same

//interface CardRecyclerDetails : Same<CardRecyclerDetails> {
//
//    override fun isSame(value: CardRecyclerDetails) = value == this
//
//    fun <T> map() : T
//
//    object Loading : CardRecyclerDetails
//
//    class Fail(private val messageError: String) : CardRecyclerDetails
//
//    class Base(
//        private val name: String,
//        private val image: String,
//        private val cashbackPercent: Int,
//        private val loyaltyLevel: String,
//        private val main: String,
//        private val cardBackground: String,
//        private val text: String,
//        private val highlight: String,
//        private val accent: String
//    ) : CardRecyclerDetails {
//
//    }
//}


data class CardRecyclerDetails(
    val name: String,
    val image: String,
    val cashbackPercent: Int,
    val loyaltyLevel: String,
    val main: String,
    val cardBackground: String,
    val text: String,
    val highlight: String,
    val accent: String
) : Same<CardRecyclerDetails> {

    override fun isSame(value: CardRecyclerDetails) = value == this

    fun provideRecyclerDetails(
        companyName: TextView,
        logo: ImageView,
        percent: TextView,
        level: TextView,
        mainColor: TextView,
        cardBackgroundColor: TextView,
        textColor: TextView,
        highLightColor: TextView,
        accentColor: TextView
    ) {

    }
}
