package relicreminders.ui.nodes.relicicon

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.Sundial

class SundialIcon: AbstractRelicIcon(Sundial()) {
    init {
        loadLocalisation("relic_reminders:Sundial")
    }

    override fun update() {
        tips.clear()

        greyscale = playerRelic.counter != 2
        tips.add(PowerTip(texts[0], texts[playerRelic.counter + 1]))

        super.update()
    }
}