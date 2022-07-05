package relicreminders.ui.nodes

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import relicreminders.ui.Vector2
import relicreminders.ui.shape.Rectangle

open class NodeContainer(val children: ArrayList<AbstractNode>,
                    // The position of the nodes are anchored by the designated centre position of the first node.
                         var firstNodeCentre: Vector2, val extendDirection: Direction,
                         val gap: Float = 0f):
    AbstractNode(Rectangle(Vector2.ZERO, Vector2.ZERO)) {
    override fun update() {
        updateChildrenPosition()

        // Update the hitbox after the bounding box has been adjusted.
        hitbox.update()

        // Update all the nodes after they get their new position.
        children.forEach { it.update() }

        super.update()
    }

    open fun updateChildrenPosition() {
        if (children.isNotEmpty()) {
            // Line all the nodes up:
            // Anchor the first node at the designated position.
            children.first().shape.moveCentreTo(firstNodeCentre)

            // Only position the children if there are more than one child.
            if (children.size > 1) {
                if (extendDirection.isVertical) {
                    var stackedCentreY = firstNodeCentre.y
                    for (i in 1 until children.size) {
                        stackedCentreY += (children[i - 1].shape.boundingBox.size.y +
                                children[i].shape.boundingBox.size.y + gap) / 2 * extendDirection.axisMultiplier
                        children[i].moveCentreTo(Vector2(firstNodeCentre.x, stackedCentreY))
                    }
                } else {
                    var stackedCentreX = firstNodeCentre.x
                    for (i in 1 until children.size) {
                        stackedCentreX += (children[i - 1].shape.boundingBox.size.x +
                                children[i].shape.boundingBox.size.x + gap) / 2 * extendDirection.axisMultiplier
                        children[i].moveCentreTo(Vector2(stackedCentreX, firstNodeCentre.y))
                    }
                }
            }

            refitHitbox()
        }
    }

    fun refitHitbox() {
        // Update the shape after all the nodes have been set.
        val newBoundingBoxPosition = Vector2(
            children.minOf { it.shape.boundingBox.position.x },
            children.minOf { it.shape.boundingBox.position.y }
        )
        val boundingBoxCorner = Vector2(
            children.maxOf { it.shape.boundingBox.position.x },
            children.maxOf { it.shape.boundingBox.position.y }
        )
        updateShape(Rectangle(boundingBoxCorner - newBoundingBoxPosition, newBoundingBoxPosition))
    }

    override fun moveCentreTo(newCentre: Vector2) {
        firstNodeCentre += newCentre - shape.boundingBox.centre
        updateChildrenPosition()
    }

    override fun render(sb: SpriteBatch) {
        super.render(sb)

        children.forEach { it.render(sb) }
    }
}