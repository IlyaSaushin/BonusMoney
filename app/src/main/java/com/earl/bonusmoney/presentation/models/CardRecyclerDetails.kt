package com.earl.bonusmoney.presentation.models

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.earl.bonusmoney.presentation.base.Same

data class CardRecyclerDetails(
    private val id: String,
    private val name: String,
    private val image: String,
    private val cashbackPercent: Int,
    private val loyaltyLevel: String,
    private val mainColor: String,
    private val cardBackgroundColor: String,
    private val textColor: String,
    private val highlightColor: String,
    private val accentColor: String,
    private val backgroundColor: String
) : Same<CardRecyclerDetails> {

    override fun isSame(value: CardRecyclerDetails) = value == this

    fun provideId() = id

    fun provideRecyclerDetails(
        companyName: TextView,
        logo: ImageView,
        percent: TextView,
        level: TextView,
        scoreCount: TextView,
        scoreText: TextView,
        iconEye: ImageView,
        btn: AppCompatButton,
        trashBtn: ImageView,
        layout: ConstraintLayout
    ) {
        companyName.text = name
        Glide.with(logo.context).load(image).into(logo)
        percent.text = cashbackPercent.toString()
        level.text = loyaltyLevel

        companyName.setTextColor(Color.parseColor(cardBackgroundColor))
        scoreCount.setTextColor(Color.parseColor(cardBackgroundColor))
        scoreText.setTextColor(Color.parseColor(highlightColor))
        iconEye.setColorFilter(Color.parseColor(textColor))
        btn.setTextColor(Color.parseColor(textColor))
        btn.setBackgroundColor(Color.parseColor(accentColor))
        trashBtn.setColorFilter(Color.parseColor(mainColor))
        layout.setBackgroundColor(Color.parseColor(backgroundColor))
    }
}
