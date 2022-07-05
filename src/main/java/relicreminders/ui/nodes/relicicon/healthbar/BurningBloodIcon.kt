package relicreminders.ui.nodes.relicicon.healthbar

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.BurningBlood
import com.megacrit.cardcrawl.relics.MarkOfTheBloom
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class BurningBloodIcon: AbstractRelicIcon(BurningBlood(), 45f) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }

    override fun display(): Boolean = super.display() && canHeal

    override fun render(sb: SpriteBatch) {
        super.render(sb)
    }
}