package relicreminders.ui.shape

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.megacrit.cardcrawl.helpers.ImageMaster
import relicreminders.ui.Vector2
import relicreminders.ui.between

class Rectangle(var size: Vector2, var position: Vector2 = Vector2.ZERO): AbstractShape() {
    override fun containsPoint(point: Vector2): Boolean {
        val corner = position + size

        return point.x.between(position.x, corner.x) && point.y.between(position.y, corner.y)
    }

    override val boundingBox: Rectangle
                // Make a new instance so it doesn't follow any changes from the current rectangle.
                // It's fine to pass the position by reference since the fields aren't mutable.
        get() = Rectangle(size, position)

    override fun moveBy(offset: Vector2) {
        position += offset
    }

    override fun render(sb: SpriteBatch) {
        sb.draw(ImageMaster.DEBUG_HITBOX_IMG, position.x, position.y, size.x, size.y)
    }
}