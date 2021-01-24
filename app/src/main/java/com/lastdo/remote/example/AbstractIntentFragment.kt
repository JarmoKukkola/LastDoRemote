package com.lastdo.remote.example

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.lastdo.remote.AbstractIntent

abstract class AbstractIntentFragment : Fragment() {

    abstract val lastDoIntent: AbstractIntent

    private lateinit var editTexts: List<EditText>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_intent, container, false).apply {
        findViewById<LinearLayout>(R.id.layout).let { layout ->
            editTexts = lastDoIntent.inputs.map {
                EditText(requireContext()).apply {
                    hint = it.second
                    layout.addView(this)
                    when (it.first) {
                        Int::class.java, Long::class.java ->
                            inputType = InputType.TYPE_CLASS_NUMBER
                    }
                }
            }.toMutableList().apply {
                add(EditText(requireContext()).apply {
                    hint = requireContext().getString(R.string.access_key)
                    layout.addView(this)
                })
            }.toList()
        }
    }

    protected fun getInputs() = editTexts.map {
        it.text.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_send_intent)
            .setOnClickListener {
                sendBroadcast()
            }
    }

    abstract fun sendBroadcast()
}