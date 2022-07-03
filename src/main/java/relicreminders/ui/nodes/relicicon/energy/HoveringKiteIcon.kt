package relicreminders.ui.nodes.relicicon.energy

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.HoveringKite
import relicreminders.ui.getPrivate
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class HoveringKiteIcon: AbstractRelicIcon(HoveringKite(), 80f) {
    var triggeredThisTurn = false

    init {
        loadLocalisation("relic_reminders:HoveringKite")
    }

    override fun update() {
        tips.clear()
        if (playerRelic.getPrivate("triggeredThisTurn")) {
            greyscale = true
            tips.add(PowerTip(texts[0], texts[2]))

            // If the relic has just been triggered.
            if (!triggeredThisTurn) {
                flash()
            }
        } else {
            greyscale = false
            tips.add(PowerTip(texts[0], texts[1]))
        }

        triggeredThisTurn = playerRelic.getPrivate("triggeredThisTurn")

        super.update()
    }
}