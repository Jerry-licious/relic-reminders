package relicreminders.ui.nodes.relicicon

import basemod.BaseMod
import basemod.interfaces.OnPlayerTurnStartSubscriber
import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.HappyFlower

class HappyFlowerIcon: AbstractRelicIcon(HappyFlower()), OnPlayerTurnStartSubscriber {
    init {
        loadLocalisation("relic_reminders:HappyFlower")

        BaseMod.subscribe(this)
    }

    override fun update() {
        tips.clear()

        greyscale = playerRelic.counter != 0
        tips.add(PowerTip(texts[0], texts[playerRelic.counter + 1]))

        super.update()
    }

    override fun receiveOnPlayerTurnStart() {
        // Flash if the relic is about to trigger.
        if (display() && playerRelic.counter == 0) {
            flash()
        }
    }
}