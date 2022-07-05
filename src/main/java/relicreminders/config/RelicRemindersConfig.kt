package relicreminders.config

import com.evacipated.cardcrawl.modthespire.lib.SpireConfig
import java.util.*


class RelicRemindersConfig: SpireConfig("relic_reminders", "config", defaults) {
    companion object {
        val defaults = Properties()
        init {
            defaults.setProperty("energy", "true")
            defaults.setProperty("event", "true")
            defaults.setProperty("hp", "true")
            defaults.setProperty("potion", "true")
            defaults.setProperty("endturn", "true")
            defaults.setProperty("pellets", "true")
            defaults.setProperty("map", "true")
        }
    }

    val energy: Boolean
        get() = getBool("energy")
    val event: Boolean
        get() = getBool("event")
    val hp: Boolean
        get() = getBool("hp")
    val potion: Boolean
        get() = getBool("potion")
    val blockEndTurn: Boolean
        get() = getBool("endturn")
    val pellets: Boolean
        get() = getBool("pellets")
    val map: Boolean
        get() = getBool("map")
}