package relicreminders.ui.nodes.relicicon

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Interpolation
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.relics.AbstractRelic
import relicreminders.ui.Vector2
import relicreminders.ui.nodes.TextureRect
import relicreminders.ui.relicCrop
import relicreminders.ui.shape.Rectangle


abstract class AbstractRelicIcon(val relic: AbstractRelic): TextureRect(relic.img.relicCrop,
    // The position of the rectangle doesn't matter since it's going to be updated by its container anyways.
    Rectangle(Vector2(80f, 80f).scaled())) {
    var flashTimer: Float = 0f
    val flashColour = Color(1f, 1f, 1f, 0f)

    // Returns true if this icon should be displayed in the relic icon list.
    open fun display(): Boolean = AbstractDungeon.player.hasRelic(relic.relicId)

    fun renderFlash(sb: SpriteBatch) {
        val interpolation = Interpolation.exp10In.apply(0.0f, 4.0f, flashTimer / 2.0f)
        sb.setBlendFunction(770, 1)
        flashColour.a = flashTimer * 0.2f
        sb.color = flashColour

        renderScaled(sb, interpolation)
        renderScaled(sb, interpolation * 2/3)
        renderScaled(sb, interpolation / 3)

        sb.setBlendFunction(770, 771)
    }

    fun renderScaled(sb: SpriteBatch, scale: Float) {
        val boundingBox = shape.boundingBox
        val centre = boundingBox.centre
        val scaledSize = boundingBox.size * scale
        val corner = centre - scaledSize / 2f

        sb.draw(texture, corner.x, corner.y, scaledSize.x, scaledSize.y)
    }

    fun flash() {
        // Only flash if the icon is actually being updated and displayed.
        // This prevents sudden flashing when the icon enters the icon list.
        if (display()) {
            flashTimer = 2f
        }
    }

    override fun update() {
        // Tick down the flash timer.
        flashTimer -= Gdx.graphics.deltaTime

        super.update()
    }

    override fun render(sb: SpriteBatch) {
        super.render(sb)

        // Render the flash if it's ongoing.
        if (flashTimer > 0f) {
            renderFlash(sb)
        }
    }

    // Helper functions for obtaining the relic.
    val playerRelic: AbstractRelic
        get() = AbstractDungeon.player.getRelic(relic.relicId)
}