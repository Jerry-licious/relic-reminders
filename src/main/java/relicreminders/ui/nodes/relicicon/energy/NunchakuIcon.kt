package relicreminders.ui.nodes.relicicon.energy

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.Nunchaku
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class NunchakuIcon: AbstractRelicIcon(Nunchaku(), 80f) {
    init {
        loadLocalisation("relic_reminders:Nunchaku")
    }

    override fun update() {
        tips.clear()

        greyscale = playerRelic.counter != 9

        val remainingAttacks = 10 - playerRelic.counter
        if (remainingAttacks == 1) {
            tips.add(PowerTip(texts[0], texts[1]))
        } else {
            tips.add(PowerTip(texts[0], texts[2].replace("\$amount\$", remainingAttacks.toString())))
        }

        super.update()
    }
}