package com.rk.components

import androidx.compose.runtime.Composable

data class DialogProvider(val content: @Composable () -> Unit)

object DialogRegistry {

    private val providers = mutableListOf<DialogProvider>()

    fun register(provider: DialogProvider) {
        providers += provider
    }

    fun unregister(provider: DialogProvider) {
        providers -= provider
    }

    @Composable
    fun getDialogs(): List<@Composable () -> Unit> {
        return providers.map { { it.content() } }
    }
}
