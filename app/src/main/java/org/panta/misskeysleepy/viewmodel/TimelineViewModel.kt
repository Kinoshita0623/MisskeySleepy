package org.panta.misskeysleepy.viewmodel

import android.databinding.ObservableArrayList
import android.util.Log
import okhttp3.OkHttpClient
import org.panta.misskeysleepy.entities.Note
import org.panta.misskeysleepy.entities.out.TimelineRequest
import org.panta.misskeysleepy.network.MisskeyApi
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TimelineViewModel {

    val noteList = ObservableArrayList<Note>()

    init{
        getTimeline()
    }

    private fun getTimeline(){
        val okHttpClient = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://misskey.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val api  =retrofit.create(MisskeyApi::class.java)

        api.getLocalTimeline(TimelineRequest()).enqueue(
            object : retrofit2.Callback<List<Note>?>{
                override fun onResponse(call: Call<List<Note>?>, response: Response<List<Note>?>) {
                    val body = response.body()
                    Log.d("", "response: $body")
                    if(body != null){
                        noteList.clear()
                        noteList.addAll(body)
                    }
                }

                override fun onFailure(call: Call<List<Note>?>, t: Throwable) {
                    Log.e("", "error", t)
                }
            }
        )
    }
}