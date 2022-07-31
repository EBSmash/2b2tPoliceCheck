package com.lambda.huds

import com.lambda.Olympia
import com.lambda.client.event.SafeClientEvent
import com.lambda.client.plugin.api.PluginLabelHud
import com.lambda.client.util.color.ColorHolder
import com.lambda.util.OlympiaUtil

internal object GoonSquadHud : PluginLabelHud(
    name = "Gooon Squad",
    category = Category.MISC,
    description = "Olympia on top!",
    pluginMain = Olympia
) {
    private var reload by setting("Reload", false)

    override fun SafeClientEvent.updateText() {
        if(reload){
            OlympiaUtil.reload()
            reload = false;
        }

        displayText.add("Olympia Goon Squad:")
        displayText.currentLine++
        for(player in mc.world.playerEntities) {
            if(OlympiaUtil.isFriendly(player.name)) {
                    displayText.add(OlympiaUtil.getName(player.name), ColorHolder(0,255, 0))
                    displayText.currentLine++
            }
            else {
                displayText.add(player.name, ColorHolder(255, 0, 0))
                displayText.currentLine++
            }
        }

    }
}