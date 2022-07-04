package relicreminders.ui.nodes.relicicon.potionlist

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import relicreminders.ui.Vector2
import relicreminders.ui.nodes.relicicon.AbstractRelicIconList

class PotionRelicIconList: AbstractRelicIconList() {
    init {
        icons.add(WhiteBeastStatueIcon())
    }

    override fun update() {
        val lastPotionHitbox = AbstractDungeon.player.potions.last().hb
        // Anchor to the right to the rightmost potion slot.
        firstNodeCentre = Vector2(lastPotionHitbox.cX + lastPotionHitbox.width, lastPotionHitbox.cY)

        super.update()
    }
}