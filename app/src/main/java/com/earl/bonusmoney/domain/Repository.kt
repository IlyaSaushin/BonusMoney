package com.earl.bonusmoney.domain

import com.earl.bonusmoney.data.models.remote.CompanyRemote

interface Repository {

    suspend fun getAllCards() : List<CompanyRemote>
}