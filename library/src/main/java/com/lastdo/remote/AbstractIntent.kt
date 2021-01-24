package com.lastdo.remote

import android.content.Context
import android.content.Intent

/**
 * Helper class to send broadcasts to LastDo.
 *
 * @property inputs defines the type and label of values expected for sendBroadcast function.
 */
abstract class AbstractIntent() {
    protected abstract val broadcastReceiverClass: String
    protected abstract val action: String
    abstract val inputs: List<Pair<Class<*>, String>>
    protected open val fixedExtras: List<Triple<Class<*>, String, String>> = emptyList()
    private val intents: List<Intent> = listOf(Intent(), Intent())

    /**
     * Sends a broadcast to LastDo and LastDo pro apps.
     * It is recommended to not use this method directly because you might get an
     * IllegalArgumentException, if wrong input is send.
     *
     * @param context application context.
     * @param values list of values that match the inputs.
     * @return true if LastDo or LastDo Pro is installed to the device and broadcast was sent.
     */
    @Throws(IllegalArgumentException::class)
    protected fun sendBroadcast(
        context: Context,
        values: List<String>
    ): Boolean {
        if (inputs.size + 1 != values.size) {
            throw java.lang.IllegalArgumentException()
        }
        intents.forEachIndexed { i, intent ->
            intent.action = action
            inputs.forEachIndexed { i: Int, input: Pair<Class<*>, String> ->
                intent.putExtra(
                    Triple(
                        input.first,
                        input.second,
                        values[i]
                    )
                )
            }
            fixedExtras.forEach {
                intent.putExtra(it)
            }
            intent.putExtra("ACCESS_KEY", values.last())
            intent.setClassName(
                "com.lastdo." + if (i == 0) "pro" else "app",
                broadcastReceiverClass
            )
        }

        return intents.any {
            it.resolveActivity(context.packageManager)?.apply {
                context.sendBroadcast(it)
            } != null
        }
    }

    private fun Intent.putExtra(values: Triple<Class<*>, String, String>) {
        val classType = values.first
        val label = values.second
        val value = values.third
        when (classType) {
            Int::class.java -> {
                value.toIntOrNull()?.let {
                    putExtra(label, it)
                }
            }
            String::class.java -> {
                if (value.isNotBlank()) putExtra(label, value)
            }
            Long::class.java -> {
                value.toLongOrNull()?.let {
                    putExtra(label, it)
                }
            }
        }
    }
}
