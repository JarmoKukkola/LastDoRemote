package com.lastdo.remote.note

import android.content.Context

/**
 * Usage example:
 *
 * val cardName = "Exact Card Name"
 * // val cardName = "card name start*"
 * // val cardName = "*card name end"
 * // val cardName = "*text that card name contains*"
 * val accessKey = "" // optional. Only required if set in LastDo settings.
 * MoveCardsToTrashIntent().sendBroadcast(context, cardName, subBoardName, accessKey)
 */

open class MoveCardsToTrashIntent : AbstractNoteIntent() {
    override val action = "MOVE_CARDS_TO_TRASH"
    override val inputs: List<Pair<Class<*>, String>> = listOf(
        Pair(String::class.java, "CARD_NAME")
    )

    /**
     * Sends a broadcast to LastDo and LastDo pro apps to move cards.
     *
     * @param context application context.
     * @param cardName the card name, where the note is to be deleted. Wild cards are allowed,
     *          such as, "*ard" is a match with card "First Card".
     * @param accessKey only required if set in LastDo settings
     */

    fun sendBroadcast(
        context: Context,
        cardName: String,
        accessKey: String = ""
    ) {
        sendBroadcast(context, listOf(cardName, accessKey))
    }
}