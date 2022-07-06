package relicreminders.ui.nodes.relicicon.healthbar

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.MagicFlower
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class MagicFlowerIcon: AbstractRelicIcon(MagicFlower(), 45f) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }

    override fun display() = super.display() && canHeal
}