package com.lastdo.remote.example.events.add

import com.lastdo.remote.event.add.AddChallengeAlarmIntent

class AddChallengeAlarmFragment : AddAlarmFragment() {
    override val lastDoIntent = AddChallengeAlarmIntent()
}