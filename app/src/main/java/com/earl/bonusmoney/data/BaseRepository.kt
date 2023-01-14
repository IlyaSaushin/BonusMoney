package com.earl.bonusmoney.data

import com.earl.bonusmoney.data.mappers.CompanyDataToDomainMapper
import com.earl.bonusmoney.data.mappers.CompanyRemoteToDataMapper
import com.earl.bonusmoney.data.models.CompanyData
import com.earl.bonusmoney.data.models.remote.BodyDto
import com.earl.bonusmoney.data.retrofit.Service
import com.earl.bonusmoney.domain.Repository
import com.earl.bonusmoney.domain.models.CardListDomain
import com.earl.bonusmoney.domain.models.CompanyDomain

class BaseRepository(
    private val service: Service,
    private val companyRemoteToDataMapper: CompanyRemoteToDataMapper<CompanyData>,
    private val companyDataToDomainMapper: CompanyDataToDomainMapper<CompanyDomain>
) : Repository {

    override suspend fun getAllCards(offset: Int, apikey: Map<String, String>) = try {
        val resultList = service.getAllCards(
            apikey,
            BodyDto(offset)
        )
        CardListDomain.Success(resultList.map { it.mapToData(companyRemoteToDataMapper) }.map { it.map(companyDataToDomainMapper) })
    } catch (e: Exception) {
        CardListDomain.Fail(e)
    }

    override suspend fun getAllCardsIdeal(offset: Int, apikey: Map<String, String>) = try {
        val resultList = service.getAllCardsIdeal(
            apikey,
            BodyDto(offset)
        )
        CardListDomain.Success(resultList.map { it.mapToData(companyRemoteToDataMapper) }.map { it.map(companyDataToDomainMapper) })
    } catch (e: Exception) {
        CardListDomain.Fail(e)
    }

    override suspend fun getAllCardsLong(offset: Int, apikey: Map<String, String>) = try {
        val resultList = service.getAllCardsLong(
            apikey,
            BodyDto(offset)
        )
        CardListDomain.Success(resultList.map { it.mapToData(companyRemoteToDataMapper) }.map { it.map(companyDataToDomainMapper) })
    } catch (e: Exception) {
        CardListDomain.Fail(e)
    }

    override suspend fun getAllCardsError(offset: Int, apikey: Map<String, String>) = try {
        val resultList = service.getAllCardsError(
            apikey,
            BodyDto(offset)
        )
        CardListDomain.Success(resultList.map { it.mapToData(companyRemoteToDataMapper) }.map { it.map(companyDataToDomainMapper) })
    } catch (e: Exception) {
        CardListDomain.Fail(e)
    }
}