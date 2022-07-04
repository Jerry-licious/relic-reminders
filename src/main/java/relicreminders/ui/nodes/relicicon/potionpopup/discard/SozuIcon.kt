package relicreminders.ui.nodes.relicicon.potionpopup.discard

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.Sozu
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class SozuIcon: AbstractRelicIcon(Sozu(), 60f) {
    init {
        loadLocalisation("relic_reminders:Sozu")

        tips.add(PowerTip(texts[0], texts[1]))
    }
}