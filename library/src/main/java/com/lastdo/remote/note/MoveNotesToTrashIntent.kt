package com.lastdo.remote.note

import android.content.Context

/**
 * Usage example:
 *
 * val topic = "exact topic text"
 * // val topic = "topic that starts with*"
 * // val topic = "*topic that ends with"
 * // val topic = "*topic that contains*"
 * val cardName = "exact card topic"
 * // val cardName = "card topic that starts with*"
 * // val cardName = "*card topic that ends with"
 * // val cardName = "*card topic that contains*"
 * val tag = "partial tag name" //if tag is empty, ignore.
 * DeleteNotesIntent().sendBroadcast(context,topic,cardName, tag)
 * DeleteNotesIntent().sendBroadcast(context,topic,cardName) // all tags or without tags
 * DeleteNotesIntent().sendBroadcast(context,topic) // all tags and cards
 * DeleteNotesIntent().sendBroadcast(context) // all notes
 * DeleteNotesIntent().sendBroadcast(context, tag = "work") // all tags that contains "work" string
 * DeleteNotesIntent().sendBroadcast(context, cardName = "Shop") // all notes in "Shop" cards
 */

open class MoveNotesToTrashIntent : AbstractNoteIntent() {
    override val action = "MOVE_NOTES_TO_TRASH"
    override val inputs: List<Pair<Class<*>, String>> = listOf(
        Pair(String::class.java, "NAME"),
        Pair(String::class.java, "CARD_NAME"),
        Pair(String::class.java, "TAG")
    )

    /**
     * Sends a broadcast to LastDo and LastDo pro apps to move notes.
     *
     * @param context application context.
     * @param cardName the card name, where the note is to be deleted. Wild cards are allowed,
     *          such as, "*ard" is a match with card "First Card".
     * @param tag filters notes by tags. Wild cards are allowed,
     *          such as, "*or*" is a match with note with tag "Work".
     * @param accessKey only required if set in LastDo settings
     */

    fun sendBroadcast(
        context: Context,
        topic: String = "",
        cardName: String = "",
        tag: String = "",
        accessKey: String = ""
    ) {
        sendBroadcast(context, listOf(topic, cardName, tag, accessKey))
    }
}