package relicreminders.ui.nodes.relicicon

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import relicreminders.ui.Vector2
import relicreminders.ui.hitbox
import relicreminders.ui.nodes.Direction
import relicreminders.ui.nodes.NodeContainer

class RelicIconList(val icons: ArrayList<AbstractRelicIcon> = arrayListOf()):
    NodeContainer(arrayListOf(), Vector2.ZERO, Direction.UP) {
    init {
        icons.add(HoveringKiteIcon())
    }

    override fun update() {
        val energyPanelHitbox = AbstractDungeon.overlayMenu.energyPanel.hitbox
        // Anchor the icons above the energy panel.
        firstNodeCentre = Vector2(energyPanelHitbox.cX, energyPanelHitbox.cY + energyPanelHitbox.height)

        children.clear()
        children.addAll(icons.filter { it.display() })

        super.update()
    }
}