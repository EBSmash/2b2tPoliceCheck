package com.lambda.huds

import com.lambda.ExamplePlugin
import com.lambda.client.event.SafeClientEvent
import com.lambda.client.plugin.api.PluginLabelHud
import com.lambda.client.util.color.ColorHolder
import com.lambda.util.FriendManager

internal object ExampleLabelHud : PluginLabelHud(
    name = "Gooon Squad",
    category = Category.MISC,
    description = "Olympus on top!",
    pluginMain = ExamplePlugin
) {

    override fun SafeClientEvent.updateText() {
        displayText.add("Olympus Goon Squad:")
        displayText.currentLine++
        for(player in mc.world.playerEntities) {
            if(FriendManager.isFriendly(player.name)) {
                    displayText.add(FriendManager.getName(player.name), ColorHolder(0,255, 0))
                    displayText.currentLine++
            }
            else {
                displayText.add(player.name, ColorHolder(255, 0, 0))
                displayText.currentLine++
            }
        }

    }
}