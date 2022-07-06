package relicreminders.config

import basemod.ModPanel
import com.megacrit.cardcrawl.core.CardCrawlGame

val toggleButtonX = 350f
val toggleButtonY = 700f
val toggleButtonSpacing = 75f

class ConfigMenu: ModPanel() {
    val texts = CardCrawlGame.languagePack.getUIString("relic_reminders:config").TEXT
    val keys = arrayOf("energy", "event", "hp", "potion", "endturn", "pellets", "map", "orbs")

    init {
        for (i in keys.indices) {
            addUIElement(ToggleButton(texts[i], toggleButtonX, toggleButtonY - i * toggleButtonSpacing, keys[i], this))
        }
    }
}