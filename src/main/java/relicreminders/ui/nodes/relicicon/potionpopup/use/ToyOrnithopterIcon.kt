package relicreminders.ui.nodes.relicicon.potionpopup.use

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.MarkOfTheBloom
import com.megacrit.cardcrawl.relics.ToyOrnithopter
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class ToyOrnithopterIcon: AbstractRelicIcon(ToyOrnithopter(), 60f) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }

    override fun display(): Boolean = super.display() && !AbstractDungeon.player.hasRelic(MarkOfTheBloom.ID)
}