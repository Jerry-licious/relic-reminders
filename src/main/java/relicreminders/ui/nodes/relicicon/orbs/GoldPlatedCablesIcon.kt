package relicreminders.ui.nodes.relicicon.orbs

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.GoldPlatedCables
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class GoldPlatedCablesIcon: AbstractRelicIcon(GoldPlatedCables(), 60f) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }
}