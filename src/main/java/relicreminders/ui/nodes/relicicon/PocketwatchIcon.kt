package relicreminders.ui.nodes.relicicon

import basemod.BaseMod
import basemod.interfaces.OnPlayerTurnStartSubscriber
import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.Pocketwatch
import relicreminders.ui.getPrivate

class PocketwatchIcon: AbstractRelicIcon(Pocketwatch()), OnPlayerTurnStartSubscriber {
    init {
        loadLocalisation("relic_reminders:Pocketwatch")

        BaseMod.subscribe(this)
    }

    override fun update() {
        tips.clear()

        if (playerRelic.counter <= 3) {
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
        if (display() && playerRelic.counter <= 3 && !playerRelic.getPrivate<Boolean>("firstTurn")) {
            flash()
        }
    }
}