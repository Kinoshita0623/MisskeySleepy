package org.panta.misskeysleepy.network

import org.panta.misskeysleepy.entities.Note
import org.panta.misskeysleepy.entities.out.TimelineRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MisskeyApi {

    @POST("notes/local-timeline")
    fun getLocalTimeline(@Body timelineRequest: TimelineRequest): Call<List<Note>?>
}