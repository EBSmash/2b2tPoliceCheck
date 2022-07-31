package com.lambda.modules

import com.lambda.Olympia
import com.lambda.client.module.Category
import com.lambda.client.plugin.api.PluginModule

object PortalBreaker : PluginModule(
    name = "Portal Breaker",
    category = Category.MISC,
    description = "",
    pluginMain = Olympia
) {
    private val breakType by setting("Prefer", EnumBreakType.Water)

    init{

    }
}

enum class EnumBreakType{
    Water,
    Mine
}