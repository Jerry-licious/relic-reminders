package relicreminders.ui.nodes.relicicon.orbs

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.AbstractRelic
import com.megacrit.cardcrawl.relics.EmotionChip
import relicreminders.ui.getPrivateFromClass
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class EmotionChipIcon: AbstractRelicIcon(EmotionChip(), 60f) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }

    override fun update() {
        greyscale = !playerRelic.getPrivateFromClass<AbstractRelic, Boolean>("pulse", AbstractRelic::class.java)

        super.update()
    }
}