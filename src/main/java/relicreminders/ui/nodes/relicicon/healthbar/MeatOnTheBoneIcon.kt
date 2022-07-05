package relicreminders.ui.nodes.relicicon.healthbar

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.MarkOfTheBloom
import com.megacrit.cardcrawl.relics.MeatOnTheBone
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class MeatOnTheBoneIcon: AbstractRelicIcon(MeatOnTheBone(), 45f) {
    init {
        loadLocalisation("relic_reminders:MeatOnTheBone")
    }

    override fun display(): Boolean = super.display() && canHeal

    val threshold: Int
        get() = (AbstractDungeon.player.maxHealth / 2f).toInt()

    override fun update() {
        val bloodied = AbstractDungeon.player.currentHealth <= threshold

        greyscale = !bloodied

        tips.clear()
        if (bloodied) {
            tips.add(PowerTip(texts[0], texts[1]))
        } else {
            tips.add(PowerTip(texts[0], texts[2].replace("\$amount\$", threshold.toString())))
        }

        super.update()
    }

    override fun render(sb: SpriteBatch) {
        super.render(sb)

        renderCounter(sb, threshold)
    }
}