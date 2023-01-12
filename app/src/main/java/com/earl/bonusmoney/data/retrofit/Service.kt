package com.earl.bonusmoney.data.retrofit

import com.earl.bonusmoney.data.models.remote.BodyDto
import com.earl.bonusmoney.data.models.remote.CompanyRemote
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface Service {

    @POST("/mobileapp/getAllCompanies")
    suspend fun getAllCards(
        @HeaderMap header: Map<String, String>,
        @Body body: BodyDto,
    ) : List<CompanyRemote>
}