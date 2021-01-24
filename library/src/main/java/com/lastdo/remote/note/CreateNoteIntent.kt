package com.lastdo.remote.note

import android.content.Context

/**
 * Usage example:
 *
 * val topic = "Note topic"
 * val text = "Content of the note"
 * val cardName = "exact card name" // cardName is to find a card or create a new card
 * val accessKey = "" // optional. Only required if set in LastDo settings.
 * CreateNoteIntent().sendBroadcast(context,topic,text, cardName,accessKey)
 */

class CreateNoteIntent : AbstractNoteIntent() {
    override val action = "CREATE_NOTE"
    override val inputs: List<Pair<Class<*>, String>> = listOf(
        Pair(String::class.java, "NAME"),
        Pair(String::class.java, "TEXT"),
        Pair(String::class.java, "CARD_NAME")
    )

    /**
     * Sends a broadcast to LastDo and LastDo pro apps to create a note.
     *
     * @param context application context.
     * @param topic text written in the note.
     * @param text additional text to be written to note. If both set, topic is written in bold.
     * @param cardName the card name, where the note is to be inserted. If no matching card is found,
     *        we create a new card. Wild cards are allowed, such as, "*ard" is a match with card
     *        "First Card".
     * @param accessKey only required if set in LastDo settings
     */

    fun sendBroadcast(
        context: Context,
        topic: String,
        text: String = "",
        cardName: String = "",
        accessKey: String = ""
    ) {
        sendBroadcast(context, listOf(topic, text, cardName, accessKey))
    }
}