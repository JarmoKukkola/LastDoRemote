package com.lastdo.remote.note

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
 * UndeleteNotesIntent().sendBroadcast(context,topic,cardName, tag)
 * UndeleteNotesIntent().sendBroadcast(context,topic,cardName) // all tags or without tags
 * UndeleteNotesIntent().sendBroadcast(context,topic) // all tags and cards
 * UndeleteNotesIntent().sendBroadcast(context) // all notes
 * UndeleteNotesIntent().sendBroadcast(context, tag = "work") // all tags that contains "work" string
 * UndeleteNotesIntent().sendBroadcast(context, cardName = "Shop") // all notes in "Shop" cards
 */

class RestoreNotesToTrashIntent : MoveNotesToTrashIntent() {
    override val action = "RESTORE_NOTES"
}