package com.lastdo.remote.note

/**
 * Usage example:
 *
 * val cardName = "Exact Card Name"
 * // val cardName = "card name start*"
 * // val cardName = "*card name end"
 * // val cardName = "*text that card name contains*"
 * UndeleteCardsIntent().sendBroadcast(context, cardName, subBoardName)
 */

class RestoreCardsIntent : MoveCardsToTrashIntent() {
    override val action = "RESTORE_CARDS"
}