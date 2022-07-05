package relicreminders.ui.nodes.relicicon.healthbar

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.LizardTail
import com.megacrit.cardcrawl.relics.MarkOfTheBloom
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class LizardTailIcon: AbstractRelicIcon(LizardTail(), 45f) {
    init {
        loadLocalisation("relic_reminders:LizardTail")
    }

    override fun display(): Boolean = super.display() && canHeal && !playerRelic.usedUp

    override fun render(sb: SpriteBatch) {
        super.render(sb)

        tips.clear()
        tips.add(PowerTip(texts[0], texts[1].replace("\$amount\$", (AbstractDungeon.player.maxHealth / 2f).toInt().toString())))

        // Render the amount of healing.
        renderCounter(sb, (AbstractDungeon.player.maxHealth / 2f).toInt())
    }
}