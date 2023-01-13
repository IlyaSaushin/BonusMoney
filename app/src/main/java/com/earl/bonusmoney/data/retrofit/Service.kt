package com.earl.bonusmoney.data.retrofit

import com.earl.bonusmoney.data.models.remote.BodyDto
import com.earl.bonusmoney.data.models.remote.Company
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface Service {

    @POST("/mobileapp/getAllCompanies")
    suspend fun getAllCards(
        @HeaderMap header: Map<String, String>,
        @Body body: BodyDto,
    ) : List<Company>

    @POST("/mobileapp/getAllCompaniesIdeal")
    suspend fun getAllCardsIdeal(
        @HeaderMap header: Map<String, String>,
        @Body body: BodyDto,
    ) : List<Company>

    @POST("/mobileapp/getAllCompaniesLong")
    suspend fun getAllCardsLong(
        @HeaderMap header: Map<String, String>,
        @Body body: BodyDto,
    ) : List<Company>

    @POST("/mobileapp/getAllCompaniesError")
    suspend fun getAllCardsError(
        @HeaderMap header: Map<String, String>,
        @Body body: BodyDto,
    ) : List<Company>
}