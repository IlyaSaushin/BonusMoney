package com.earl.bonusmoney.data

import android.util.Log
import com.earl.bonusmoney.data.models.remote.BodyDto
import com.earl.bonusmoney.data.models.remote.CompanyRemote
import com.earl.bonusmoney.data.retrofit.Service
import com.earl.bonusmoney.domain.Repository

class BaseRepository(
    private val service: Service
) : Repository {

    override suspend fun getAllCards() : List<CompanyRemote> {
        return try {
            val apiKey = mapOf(Pair("TOKEN", "123"))
            val list = service.getAllCards(
                apiKey,
                BodyDto(0)
            )
            Log.d("tag", "getAllCards: success")
            Log.d("tag", "getAllCards: $list")
            list
        } catch (e: Exception) {
            Log.d("tag", "getAllCards: $e")
            e.printStackTrace()
            emptyList()
        }
    }
}

//[
//{
//    "company": {
//    "companyId": "67101c54-3c17-4a03-a76a-96e0d69ec37c"
//},
//    "customerMarkParameters": {
//    "loyaltyLevel": {
//    "number": 0,
//    "name": "пятый",
//    "requiredSum": 8547,
//    "markToCash": 99,
//    "cashToMark": 68
//},
//    "mark": 5080
//},
//    "mobileAppDashboard": {
//    "companyName": "Венская кофейня",
//    "logo": "http://bonusmoney.info/image/mail/bm.png",
//    "backgroundColor": "#389BD0",
//    "mainColor": "#E799E1",
//    "cardBackgroundColor": "#976F15",
//    "textColor": "#BA3AB9",
//    "highlightTextColor": "#A79C1C",
//    "accentColor": "#E8986C"
//}
//},
//{
//    "company": {
//    "companyId": "00064df7-e7f4-4ed3-bfb2-d0e5b251eeaa"
//},
//    "customerMarkParameters": {
//    "loyaltyLevel": {
//    "number": 9,
//    "name": "серебряный",
//    "requiredSum": 13396,
//    "markToCash": 67,
//    "cashToMark": 67
//},
//    "mark": 8214
//},
//    "mobileAppDashboard": {
//    "companyName": "Автоплюс",
//    "logo": "http://bonusmoney.info/image/mail/logo3.png",
//    "backgroundColor": "#88D516",
//    "mainColor": "#DEBE4D",
//    "cardBackgroundColor": "#361AC0",
//    "textColor": "#6D76F6",
//    "highlightTextColor": "#88A312",
//    "accentColor": "#CA4B87"
//}
//},
//{
//    "company": {
//    "companyId": "5cc3baad-577f-4d58-8dd0-a0462dd6a3c4"
//},
//    "customerMarkParameters": {
//    "loyaltyLevel": {
//    "number": 0,
//    "name": "пятый",
//    "requiredSum": 322,
//    "markToCash": 46,
//    "cashToMark": 16
//},
//    "mark": 5512
//},
//    "mobileAppDashboard": {
//    "companyName": "Пробуй еще!",
//    "logo": "http://bonusmoney.info/image/mail/logo1.png",
//    "backgroundColor": "#477E81",
//    "mainColor": "#45AAB8",
//    "cardBackgroundColor": "#F2ECCD",
//    "textColor": "#11EAAF",
//    "highlightTextColor": "#CE8829",
//    "accentColor": "#AC6CE5"
//}
//},
//{
//    "company": {
//    "companyId": "863fa78e-bbd3-409c-861c-173fb87ada54"
//},
//    "customerMarkParameters": {
//    "loyaltyLevel": {
//    "number": 1,
//    "name": "червертый",
//    "requiredSum": 717,
//    "markToCash": 74,
//    "cashToMark": 50
//},
//    "mark": 5909
//},
//    "mobileAppDashboard": {
//    "companyName": "Пиво у Палыча",
//    "logo": "http://bonusmoney.info/image/mail/logo2.png",
//    "backgroundColor": "#949494",
//    "mainColor": "#2688EB",
//    "cardBackgroundColor": "#FFFFFF",
//    "textColor": "#EFEFEF",
//    "highlightTextColor": "#1A1A1A",
//    "accentColor": "#FF3044"
//}
//},
//{
//    "company": {
//    "companyId": "4fc0e995-6f0e-4f55-99df-80951ddd6cc9"
//},
//    "customerMarkParameters": {
//    "loyaltyLevel": {
//    "number": 1,
//    "name": "третий",
//    "requiredSum": 7969,
//    "markToCash": 55,
//    "cashToMark": 84
//},
//    "mark": 4792
//},
//    "mobileAppDashboard": {
//    "companyName": "Венская кофейня",
//    "logo": "http://bonusmoney.info/image/mail/bm.png",
//    "backgroundColor": "#CFDD58",
//    "mainColor": "#076549",
//    "cardBackgroundColor": "#D2A629",
//    "textColor": "#17174B",
//    "highlightTextColor": "#B15068",
//    "accentColor": "#E71D70"
//}
//}
//]