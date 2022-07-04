package relicreminders.ui.nodes.relicicon.energy

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import relicreminders.ui.Vector2
import relicreminders.ui.hitbox
import relicreminders.ui.nodes.Direction
import relicreminders.ui.nodes.relicicon.AbstractRelicIconList

class EnergyRelicIconList(): AbstractRelicIconList(direction = Direction.UP) {
    init {
        // Ice Cream has the simplest effect and is always active, put it closest to the energy bar.
        icons.add(IceCreamIcon())

        // Happy Flower triggers periodically by itself instead of being manually activated.
        // Put it closer to the energy icon and near Ice Cream as both relics are passive.
        icons.add(HappyFlowerIcon())

        // Hovering kite, Nunchaku and Sundial are all triggered effects and should be put together.
        // They are placed in order of trigger frequency, with the most frequent triggers being closest to the energy
        // icon.
        icons.add(HoveringKiteIcon())
        icons.add(NunchakuIcon())
        icons.add(SundialIcon())

        // Art of War is an "anti-trigger" relic.
        // Place it near Pocketwatch because the greyscale of both relics indicate what they do *next turn* and
        // because both of them are "anti-trigger" relics.
        icons.add(ArtOfWarIcon())

        // Pocketwatch is the only relic here that doesn't relate to energy, put it to be the furthest from the
        // energy icon.
        icons.add(PocketwatchIcon())
    }

    override fun update() {
        val energyPanelHitbox = AbstractDungeon.overlayMenu.energyPanel.hitbox
        // Anchor the icons above the energy panel.
        firstNodeCentre = Vector2(energyPanelHitbox.cX, energyPanelHitbox.cY + energyPanelHitbox.height)

        super.update()
    }
}