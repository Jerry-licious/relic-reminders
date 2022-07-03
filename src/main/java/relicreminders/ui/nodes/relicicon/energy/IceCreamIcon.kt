package relicreminders.ui.nodes.relicicon.energy

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.IceCream
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class IceCreamIcon: AbstractRelicIcon(IceCream(), 80f) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }
}