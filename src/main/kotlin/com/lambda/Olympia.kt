package com.lambda

import com.lambda.client.plugin.api.Plugin
import com.lambda.huds.GoonSquadHud

internal object Olympia : Plugin() {

    override fun onLoad() {
        // Load any modules, commands, or HUD elements here
        hudElements.add(GoonSquadHud)
    }

    override fun onUnload() {
        // Here you can unregister threads etc...
    }
}