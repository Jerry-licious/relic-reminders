package relicreminders.ui.nodes.relicicon.potionpopup.discard

import com.megacrit.cardcrawl.helpers.Hitbox
import com.megacrit.cardcrawl.ui.panels.PotionPopUp
import relicreminders.ui.Vector2
import relicreminders.ui.getPrivate
import relicreminders.ui.nodes.relicicon.AbstractRelicIconList

class PotionDiscardRelicIconList(val popUp: PotionPopUp): AbstractRelicIconList() {
    init {
        icons.add(SozuIcon())
    }

    override fun update() {
        // Anchor the icons to the right of the discard button's hitbox.
        val discardHitbox = popUp.getPrivate<Hitbox>("hbBot")
        firstNodeCentre = Vector2(discardHitbox.x + discardHitbox.width, discardHitbox.cY)

        super.update()
    }
}