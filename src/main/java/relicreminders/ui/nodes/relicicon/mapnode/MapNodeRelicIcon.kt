package relicreminders.ui.nodes.relicicon.mapnode

import com.megacrit.cardcrawl.map.MapRoomNode
import com.megacrit.cardcrawl.relics.AbstractRelic
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

abstract class MapNodeRelicIcon(relic: AbstractRelic, val node: MapRoomNode):
    AbstractRelicIcon(relic, 40f) {
    init {
        opacity = 0.7f
    }

    override fun display() = super.display() && !node.taken
}