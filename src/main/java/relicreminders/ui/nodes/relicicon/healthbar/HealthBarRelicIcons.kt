package relicreminders.ui.nodes.relicicon.healthbar

import com.megacrit.cardcrawl.core.AbstractCreature
import com.megacrit.cardcrawl.core.Settings
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import relicreminders.ui.Vector2
import relicreminders.ui.getPrivateFromClass
import relicreminders.ui.nodes.Direction
import relicreminders.ui.nodes.NodeContainer
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon
import relicreminders.ui.nodes.relicicon.AbstractRelicIconList

class HealthBarRelicIcons: AbstractRelicIconList(gap = 15f * Settings.scale) {
    init {
        // In decreasing order of trigger frequency.
        icons.add(MarkOfTheBloomIcon())
        icons.add(BurningBloodIcon())
        icons.add(MeatOnTheBoneIcon())
        icons.add(LizardTailIcon())
    }

    override fun update() {
        val healthBarHitbox = AbstractDungeon.player.healthHb
        // Anchor the icons to the right of the player's health hitbox.
        firstNodeCentre = Vector2(healthBarHitbox.x + healthBarHitbox.width, healthBarHitbox.y + 55f * Settings.scale)

        super.update()
    }
}