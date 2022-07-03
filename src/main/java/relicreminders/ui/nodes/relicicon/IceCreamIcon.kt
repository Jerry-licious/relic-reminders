package relicreminders.ui.nodes.relicicon

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.IceCream

class IceCreamIcon: AbstractRelicIcon(IceCream()) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }
}