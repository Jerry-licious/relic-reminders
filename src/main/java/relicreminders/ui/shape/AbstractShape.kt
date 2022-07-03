package relicreminders.ui.shape

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import relicreminders.ui.Vector2

abstract class AbstractShape {
    abstract fun containsPoint(point: Vector2): Boolean

    abstract val boundingBox: Rectangle
    val centre: Vector2
        get() {
            val boundingBox = boundingBox
            return boundingBox.position + boundingBox.size / 2f
        }

    abstract fun moveBy(offset: Vector2)

    fun moveCentreTo(newCentre: Vector2) {
        moveBy(newCentre - centre)
    }

    abstract fun render(sb: SpriteBatch)
}