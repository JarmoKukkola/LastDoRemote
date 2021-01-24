package com.lastdo.remote.example.notes

import com.lastdo.remote.example.AbstractIntentFragment
import com.lastdo.remote.note.MoveNotesToTrashIntent

open class MoveNotesToTrashFragment : AbstractIntentFragment() {
    override val lastDoIntent = MoveNotesToTrashIntent()
    override fun sendBroadcast() {
        getInputs().let {
            lastDoIntent.sendBroadcast(
                requireContext(),
                topic = it[0],
                cardName = it[1],
                tag = it[2],
                accessKey = it.last()
            )
        }
    }
}