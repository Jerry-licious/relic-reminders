package relicreminders.ui.nodes.relicicon.potionpopup.use

import com.megacrit.cardcrawl.helpers.Hitbox
import com.megacrit.cardcrawl.ui.panels.PotionPopUp
import relicreminders.ui.Vector2
import relicreminders.ui.getPrivate
import relicreminders.ui.nodes.relicicon.AbstractRelicIconList

class PotionUseRelicIconList(val popUp: PotionPopUp): AbstractRelicIconList() {
    init {
        icons.add(ToyOrnithopterIcon())
    }

    override fun update() {
        // Anchor the icons to the right of the use button's hitbox.
        val useHitbox = popUp.getPrivate<Hitbox>("hbTop")
        firstNodeCentre = Vector2(useHitbox.x + useHitbox.width, useHitbox.cY)

        super.update()
    }
}