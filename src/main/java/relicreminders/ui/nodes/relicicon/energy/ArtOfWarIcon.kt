package relicreminders.ui.nodes.relicicon.energy

import basemod.BaseMod
import basemod.interfaces.OnPlayerTurnStartSubscriber
import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.ArtOfWar
import relicreminders.ui.getPrivate
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class ArtOfWarIcon: AbstractRelicIcon(ArtOfWar(), 80f), OnPlayerTurnStartSubscriber {
    init {
        loadLocalisation("relic_reminders:ArtOfWar")

        BaseMod.subscribe(this)
    }

    override fun update() {
        tips.clear()
        if (playerRelic.getPrivate("gainEnergyNext")) {
            greyscale = false
            tips.add(PowerTip(texts[0], texts[1]))
        } else {
            greyscale = true
            tips.add(PowerTip(texts[0], texts[2]))
        }

        super.update()
    }

    override fun receiveOnPlayerTurnStart() {
        // Flash if the relic is about to trigger.
        if (display() && playerRelic.getPrivate("gainEnergyNext") && !playerRelic.getPrivate<Boolean>("firstTurn")) {
            flash()
        }
    }
}