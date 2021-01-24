package com.lastdo.remote.example.notes

import com.lastdo.remote.example.AbstractIntentFragment
import com.lastdo.remote.note.MoveCardsToTrashIntent

open class MoveCardsToTrashFragment : AbstractIntentFragment() {
    override val lastDoIntent = MoveCardsToTrashIntent()
    override fun sendBroadcast() {
        getInputs().let {
            lastDoIntent.sendBroadcast(
                requireContext(),
                cardName = it[0],
                accessKey = it[1]
            )
        }
    }
}