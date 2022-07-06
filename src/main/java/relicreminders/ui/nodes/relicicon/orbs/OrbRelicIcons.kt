package relicreminders.ui.nodes.relicicon.orbs

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import relicreminders.ui.Vector2
import relicreminders.ui.nodes.relicicon.AbstractRelicIconList

class OrbRelicIcons: AbstractRelicIconList() {
    init {
        icons.add(GoldPlatedCablesIcon())
        icons.add(EmotionChipIcon())
    }

    override fun update() {
        // Only update and render if the player has orbs.
        if (AbstractDungeon.player.orbs.isNotEmpty()) {
            // Anchor to the player's next orb.
            val firstOrb = AbstractDungeon.player.orbs[0]
            val firstOrbHitbox = firstOrb.hb
            firstNodeCentre = Vector2(firstOrb.cX + firstOrbHitbox.width * 0.75f, firstOrb.cY)

            super.update()
        }
    }

    override fun render(sb: SpriteBatch) {
        if (AbstractDungeon.player.orbs.isNotEmpty()) {
            super.render(sb)
        }
    }
}