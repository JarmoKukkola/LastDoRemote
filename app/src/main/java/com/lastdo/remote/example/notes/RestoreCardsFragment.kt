package com.lastdo.remote.example.notes

import com.lastdo.remote.note.RestoreCardsIntent

class RestoreCardsFragment : MoveCardsToTrashFragment() {
    override val lastDoIntent = RestoreCardsIntent()
}