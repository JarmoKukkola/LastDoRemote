package com.lastdo.remote.example.events.modify

import com.lastdo.remote.event.modify.MoveEventsToTrashIntent

class MoveEventsToTrashFragment : DisableEventsFragment() {
    override val lastDoIntent = MoveEventsToTrashIntent()
}