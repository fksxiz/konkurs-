package com.example.project4

import android.util.Log
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class ApiRepository {
    // json to request body with media type...
    private val dataToRequestBody: (String) -> RequestBody =
        { it.toRequestBody("application/json; charset=utf-8".toMediaType()) }

    private val client = OkHttpClient()

    fun sendCode(data: String, callback: (Boolean) -> Unit) {

        val url = HttpUrl.Builder()
            .scheme("https")
            .host("medic.madskill.ru")
            .addPathSegments("api/sendCode")
            .build()

        val request = Request.Builder().post(dataToRequestBody("")).addHeader("email", "malyshkin_04@bk.ru")
            .addHeader("accept", "application/json").url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Server", "qwe${e.message}")
                callback(false)
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    Log.e("Server", response.message)
                    callback(false)
                    return
                }
                callback(true)

            }

        })
    }

    fun AuthProfile(data: String, callback: (Boolean) -> String) {

        val url = HttpUrl.Builder()
            .scheme("https")
            .host("medic.madskill.ru")
            .addPathSegments("api/signin")
            .build()

        val request = Request.Builder().post(dataToRequestBody(""))
            .addHeader("accept","application/json")
            .addHeader("email","malyshkin_04@bk.ru")
            .addHeader("code","7883")
            .url(url).build()

        client.newCall(request).enqueue(object:Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Server","${e.message}")
                callback(false)
            }

            override fun onResponse(call: Call, response: Response) {
                if(!response.isSuccessful){
                    Log.e("Server",response.message)
                    callback(false)
                    return
                }
                callback(true)
            }

        })
    }

    fun CreateProfile(data: String, callback: () -> Unit) {
//        val request = Request.Builder().post(
//            dataToRequestBody(data)
//        ).url(
//
//        ).build()
    }
}