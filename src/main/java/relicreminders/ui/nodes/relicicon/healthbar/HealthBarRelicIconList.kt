package relicreminders.ui.nodes.relicicon.healthbar

import com.megacrit.cardcrawl.core.AbstractCreature
import com.megacrit.cardcrawl.core.Settings
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import relicreminders.ui.Vector2
import relicreminders.ui.getPrivateFromClass
import relicreminders.ui.nodes.Direction
import relicreminders.ui.nodes.NodeContainer
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class HealthBarRelicIconList(val icons: ArrayList<AbstractRelicIcon> = arrayListOf()):
    NodeContainer(arrayListOf(), Vector2.ZERO, Direction.RIGHT, gap = 15f * Settings.scale) {
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
        firstNodeCentre = Vector2(healthBarHitbox.x + healthBarHitbox.width, healthBarHitbox.y + 60f * Settings.scale)

        children.clear()
        children.addAll(icons.filter { it.display() })

        super.update()
    }
}