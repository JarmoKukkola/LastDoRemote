package com.lastdo.remote.event

import com.lastdo.remote.AbstractIntent

abstract class AbstractTimerIntent : AbstractIntent() {
    override val broadcastReceiverClass = "com.lastdo.broadcast.TimerReceiver"
}