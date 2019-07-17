package org.panta.misskeysleepy.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Note(
    val id: String,
    //@JsonProperty("createdAt") @JsonFormat(pattern = REMOTE_DATE_FORMAT) val createdAt: Date,
    val text: String?,
    val cw: String?,
    val userId: String?,

    val replyId: String?,

    @SerializedName("renoteId")
    val reNoteId: String?,

    val viaMobile: Boolean?,
    val visibility: String?,

    @SerializedName("visibilityUserIds")
    val visibilityUserIds: List<String?>?,

    val url: String?,
    @SerializedName("renoteCount") val reNoteCount: Int,
    @SerializedName("reactions") val reactionCounts: Map<String, Int>?,
    //@JsonProperty("emojis") val emojis: List<EmojiProperty>?,
    @SerializedName("repliesCount") val replyCount: Int,
    @SerializedName("user") val user: User?,
    @SerializedName("files") val files: List<FileProperty>?,
    //@JsonProperty("fileIds") val mediaIds: List<String?>?,    //v10, v11の互換性が取れない
    @SerializedName("renote") val reNote: Note?,
    val reply: Note?,
    @SerializedName("myReaction") val myReaction: String?
): Serializable