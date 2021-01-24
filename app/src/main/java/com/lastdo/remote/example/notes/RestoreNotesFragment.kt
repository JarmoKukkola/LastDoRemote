package com.lastdo.remote.example.notes

import com.lastdo.remote.note.RestoreNotesToTrashIntent

class RestoreNotesFragment : MoveNotesToTrashFragment() {
    override val lastDoIntent = RestoreNotesToTrashIntent()
}