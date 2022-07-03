package relicreminders.ui.nodes

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.core.Settings
import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.helpers.TipHelper
import com.megacrit.cardcrawl.helpers.input.InputHelper
import relicreminders.ui.UIElement
import relicreminders.ui.Vector2
import relicreminders.ui.hitbox.UHitbox
import relicreminders.ui.shape.AbstractShape

abstract class AbstractNode(var shape: AbstractShape): UIElement {
    var hitbox = UHitbox(shape)
    // Render a list of tips when hovered.
    val tips: ArrayList<PowerTip> = arrayListOf()

    var texts: Array<String> = arrayOf()

    fun loadLocalisation(id: String) {
        texts = CardCrawlGame.languagePack.getUIString(id).TEXT
    }

    open fun moveCentreTo(newCentre: Vector2) {
        shape.moveCentreTo(newCentre)
    }

    override fun update() {
        hitbox.update()
    }

    override fun render(sb: SpriteBatch) {
        hitbox.render(sb)

        // Render the tips if the node is being hovered.
        if (hitbox.hovered && tips.isNotEmpty()) {
            // Render to the right by a bit so the tip doesn't get covered by the cursor.
            TipHelper.queuePowerTips(InputHelper.mX.toFloat() + 48f * Settings.scale, InputHelper.mY.toFloat(), tips)
            TipHelper.render(sb)
        }
    }

    // Changes the shape of the node.
    open fun updateShape(newShape: AbstractShape) {
        shape = newShape
        hitbox = UHitbox(newShape)
    }
}