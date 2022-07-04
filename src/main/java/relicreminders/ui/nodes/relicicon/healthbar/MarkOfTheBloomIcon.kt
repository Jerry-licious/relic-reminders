package relicreminders.ui.nodes.relicicon.healthbar

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.MarkOfTheBloom
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class MarkOfTheBloomIcon: AbstractRelicIcon(MarkOfTheBloom(), 45f) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }
}