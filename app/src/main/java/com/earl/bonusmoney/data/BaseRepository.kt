package com.earl.bonusmoney.data

import android.util.Log
import com.earl.bonusmoney.data.mappers.CompanyDataToDomainMapper
import com.earl.bonusmoney.data.mappers.CompanyRemoteToDataMapper
import com.earl.bonusmoney.data.models.CompanyData
import com.earl.bonusmoney.data.models.remote.BodyDto
import com.earl.bonusmoney.data.retrofit.Service
import com.earl.bonusmoney.domain.Repository
import com.earl.bonusmoney.domain.models.CardListDomain
import com.earl.bonusmoney.domain.models.CompanyDomain
import retrofit2.HttpException

class BaseRepository(
    private val service: Service,
    private val companyRemoteToDataMapper: CompanyRemoteToDataMapper<CompanyData>,
    private val companyDataToDomainMapper: CompanyDataToDomainMapper<CompanyDomain>
) : Repository {

    override suspend fun getAllCards(offset: Int) = try {
        val requestApiKey = mapOf(Pair("TOKEN", "123"))
        val resultList = service.getAllCards(
            requestApiKey,
            BodyDto(offset)
        )
        Log.d("tag", "getAllCards repository: $resultList")
        CardListDomain.Success(resultList.map { it.mapToData(companyRemoteToDataMapper) }.map { it.map(companyDataToDomainMapper) })
    } catch (e: Exception) {
        Log.d("tag", "getAllCards: repository $e")
        CardListDomain.Fail(e)
    }

    override suspend fun getAllCardsIdeal(offset: Int) = try {
        val requestApiKey = mapOf(Pair("TOKEN", "123"))
        val resultList = service.getAllCardsIdeal(
            requestApiKey,
            BodyDto(offset)
        )
        Log.d("tag", "getAllCards repository: $resultList")
        CardListDomain.Success(resultList.map { it.mapToData(companyRemoteToDataMapper) }.map { it.map(companyDataToDomainMapper) })
    } catch (e: Exception) {
        Log.d("tag", "getAllCards: repository $e")
        CardListDomain.Fail(e)
    }

    override suspend fun getAllCardsLong(offset: Int) = try {
        val requestApiKey = mapOf(Pair("TOKEN", "123"))
        val resultList = service.getAllCardsLong(
            requestApiKey,
            BodyDto(offset)
        )
        Log.d("tag", "getAllCards repository: $resultList")
        CardListDomain.Success(resultList.map { it.mapToData(companyRemoteToDataMapper) }.map { it.map(companyDataToDomainMapper) })
    } catch (e: Exception) {
        Log.d("tag", "getAllCards: repository $e")
        CardListDomain.Fail(e)
    }

    override suspend fun getAllCardsError(offset: Int) = try {
        val requestApiKey = mapOf(Pair("TOKEN", "123"))
        val resultList = service.getAllCardsError(
            requestApiKey,
            BodyDto(offset)
        )
        Log.d("tag", "getAllCards repository: $resultList")
        CardListDomain.Success(resultList.map { it.mapToData(companyRemoteToDataMapper) }.map { it.map(companyDataToDomainMapper) })
    } catch (e: Exception) {

        Log.d("tag", "getAllCards: repository ${e.message}")
        CardListDomain.Fail(e)
    }
}