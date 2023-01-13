package com.earl.bonusmoney.presentation.models

sealed class CardListPresentation {

    abstract fun map(render: CardListRender)

    data class Success(private val list: List<CompanyPresentation>) : CardListPresentation() {
        override fun map(render: CardListRender) {
            render.updateCardList(list)
        }
    }

    data class Fail(private val exception: Exception) : CardListPresentation() {
        override fun map(render: CardListRender) {
            render.provideException(exception)
        }
    }
}
