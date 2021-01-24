package com.lastdo.remote.event

import com.lastdo.remote.AbstractIntent

abstract class AbstractEventIntent : AbstractIntent() {
    override val broadcastReceiverClass = "com.lastdo.broadcast.EventReceiver"
}