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
            val boxWidth = 320f * Settings.scale
            var xPosition = InputHelper.mX.toFloat() + 48f * Settings.scale

            // If the tip will overflow the screen
            if (xPosition + boxWidth > Settings.WIDTH) {
                // Shift it left to prevent that.
                xPosition -= boxWidth + 60f * Settings.scale
            }

            // Render to the right by a bit so the tip doesn't get covered by the cursor.
            TipHelper.queuePowerTips(xPosition, InputHelper.mY.toFloat(), tips)
        }
    }

    // Changes the shape of the node.
    open fun updateShape(newShape: AbstractShape) {
        shape = newShape
        hitbox = UHitbox(newShape)
    }
}