package com.lastdo.remote.example.notes

import com.lastdo.remote.example.AbstractIntentFragment
import com.lastdo.remote.note.CreateNoteIntent

class CreateNoteFragment : AbstractIntentFragment() {
    override val lastDoIntent = CreateNoteIntent()
    override fun sendBroadcast() {
        getInputs().let {
            lastDoIntent.sendBroadcast(
                requireContext(),
                topic = it[0],
                text = it[1],
                cardName = it[2],
                accessKey = it.last()
            )
        }
    }
}