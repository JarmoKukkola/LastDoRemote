package com.lastdo.remote.note

import android.content.Context

/**
 * Usage example:
 *
 * val cardName = "Card Name"
 * // if subBoardName is not used insert to root board in the current workspace. If used, it finds first
 * nate that has the exact subBoardName and converts it to subboard (unless it is already converted).
 * val subBoardName= "SubBoard note name"
 * val accessKey = "" // optional. Only required if set in LastDo settings.
 * CreateCardIntent().sendBroadcast(context,cardName,subBoardName,accessKey)
 */

class CreateCardIntent : AbstractNoteIntent() {
    override val action = "CREATE_CARD"
    override val inputs: List<Pair<Class<*>, String>> = listOf(
        Pair(String::class.java, "SUB_BOARD_NAME"),
        Pair(String::class.java, "CARD_NAME")
    )

    /**
     * Sends a broadcast to LastDo and LastDo pro apps to create a card.
     *
     * @param context application context.
     * @param cardName the topic of the newly created card
     * @param subBoardName if "0" root board, otherwise find a child board with the specified name
     * @param accessKey only required if set in LastDo settings
     */

    fun sendBroadcast(
        context: Context,
        cardName: String,
        subBoardName: String = "0",
        accessKey: String = ""
    ) {
        sendBroadcast(context, listOf(subBoardName, cardName, accessKey))
    }
}