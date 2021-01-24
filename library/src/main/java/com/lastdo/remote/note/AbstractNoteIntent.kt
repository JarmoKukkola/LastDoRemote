package com.lastdo.remote.note

import com.lastdo.remote.AbstractIntent

abstract class AbstractNoteIntent : AbstractIntent() {
    override val broadcastReceiverClass = "com.lastdo.broadcast.NoteReceiver"
}