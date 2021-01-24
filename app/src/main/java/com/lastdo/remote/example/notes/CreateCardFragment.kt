package com.lastdo.remote.example.notes

import com.lastdo.remote.example.AbstractIntentFragment
import com.lastdo.remote.note.CreateCardIntent

class CreateCardFragment : AbstractIntentFragment() {
    override val lastDoIntent = CreateCardIntent()
    override fun sendBroadcast() {
        getInputs().let {
            lastDoIntent.sendBroadcast(
                requireContext(),
                subBoardName = it[0],
                cardName = it[1],
                accessKey = it.last()
            )
        }
    }
}