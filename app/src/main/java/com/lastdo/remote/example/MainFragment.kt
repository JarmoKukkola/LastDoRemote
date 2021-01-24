package com.lastdo.remote.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layout = view.findViewById<LinearLayout>(R.id.layout)
        values.forEach { value ->
            Button(context).apply {
                text = context.getString(value.first)
                setOnClickListener {
                    findNavController().navigate(value.second)
                }
                layout.addView(this)
            }
        }
    }

    private val values = listOf(
        R.string.add_alarm to R.id.AddAlarmFragment,
        R.string.add_challenge_alarm to R.id.AddChallengeAlarmFragment,
        R.string.add_notification to R.id.AddNotificationFragment,
        R.string.add_persistent_notification to R.id.AddPersistentNotificationFragment,
        R.string.dismiss_events to R.id.DismissEventsFragment,
        R.string.enable_events to R.id.EnableEventsFragment,
        R.string.disable_events to R.id.DisableEventsFragment,
        R.string.move_events_to_trash to R.id.MoveEventsToTrashFragment,
        R.string.restore_events to R.id.RestoreEventsFragment,
        R.string.create_note to R.id.CreateNoteFragment,
        R.string.move_notes_to_trash to R.id.MoveNotesToTrashFragment,
        R.string.restore_notes to R.id.RestoreNotesFragment,
        R.string.create_card to R.id.CreateCardFragment,
        R.string.move_cards_to_trash to R.id.MoveCardsToTrashFragment,
        R.string.restore_cards to R.id.RestoreCardsFragment,
        R.string.create_timer to R.id.CreateTimerFragment,
        R.string.delete_timers to R.id.DeleteTimersFragment
    )
}