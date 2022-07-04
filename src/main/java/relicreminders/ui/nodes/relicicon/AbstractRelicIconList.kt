package relicreminders.ui.nodes.relicicon

import relicreminders.ui.Vector2
import relicreminders.ui.nodes.Direction
import relicreminders.ui.nodes.NodeContainer

abstract class AbstractRelicIconList(val icons: ArrayList<AbstractRelicIcon> = arrayListOf(),
                                     direction: Direction = Direction.RIGHT, gap: Float = 0f):
    NodeContainer(arrayListOf(), Vector2.ZERO, direction, gap) {
    override fun update() {
        children.clear()
        children.addAll(icons.filter { it.display() })

        super.update()
    }
}