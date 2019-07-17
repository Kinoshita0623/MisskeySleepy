package org.panta.misskeysleepy.viewdata

data class NoteViewDatum(
    val primaryId: String,
    val noteStatus: String?,

    val userPrimaryId: String,
    val userName: String,
    val userId: String,
    val noteText:String?,


    val subNotePrimaryId: String,
    val subNoteUserPrimaryId: String,
    val subNoteUserName: String,
    val subNoteUserId: String,
    val subNoteText: String?,

    val replyCount: Int,
    val reNoteCount: Int,

    //ReactionViewDataはリアクションの種類、Boolean値はユーザーがリアクション済みか
    val reactionCount: List<Pair<ReactionViewData, Boolean>>

)