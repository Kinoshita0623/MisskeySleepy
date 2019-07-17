package org.panta.misskeysleepy.viewdata

import java.io.File

data class ReactionViewData(
    val id: String,
    val file: File,
    val reactionName: String,
    val reactionUrl: String
)