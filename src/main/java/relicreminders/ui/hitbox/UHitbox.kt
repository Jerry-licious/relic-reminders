package relicreminders.ui.hitbox

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.megacrit.cardcrawl.core.Settings
import com.megacrit.cardcrawl.helpers.input.InputHelper
import relicreminders.ui.UIElement
import relicreminders.ui.mousePosition
import relicreminders.ui.shape.AbstractShape

class UHitbox(val shape: AbstractShape): UIElement {
    var hovered = false
    var leftMouseDown = false
    var rightMouseDown = false

    val listeners: ArrayList<UHitboxListener> = arrayListOf()

    fun addListener(listener: UHitboxListener) {
        listeners.add(listener)
    }

    override fun update() {
        // Mark hovered if the mouse is in the hitbox.
        if (shape.containsPoint(mousePosition)) {
            // Update the listeners if the hover has just begun.
            if (!hovered) {
                listeners.forEach(UHitboxListener::onMouseEnter)
            }
            hovered = true

            if (InputHelper.justClickedLeft) {
                listeners.forEach { it.onMouseDown(MouseButton.LEFT) }
                leftMouseDown = true
            }
            if (InputHelper.justClickedRight) {
                listeners.forEach { it.onMouseDown(MouseButton.RIGHT) }
                rightMouseDown = true
            }
        } else {
            // Update the listeners if the hover is finishing.
            if (hovered) {
                listeners.forEach(UHitboxListener::onMouseLeave)
            }
            hovered = false
        }

        // Mouse up events will be updated regardless of if the cursor is in the hitbox or not,
        // because the user can click in the button and drag the mouse elsewhere and finish the click.
        if (InputHelper.justReleasedClickLeft && leftMouseDown) {
            listeners.forEach { it.onClick(MouseButton.LEFT) }
            leftMouseDown = false
        }
        if (InputHelper.justReleasedClickRight && rightMouseDown) {
            listeners.forEach { it.onClick(MouseButton.RIGHT) }
            rightMouseDown = false
        }
    }

    override fun render(sb: SpriteBatch) {
        if (Settings.isDebug) {
            shape.render(sb)
        }
    }
}