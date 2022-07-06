package relicreminders.ui.nodes.relicicon.mapnode.event

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.map.MapRoomNode
import com.megacrit.cardcrawl.relics.SsserpentHead
import com.megacrit.cardcrawl.rooms.EventRoom
import relicreminders.ui.nodes.relicicon.mapnode.MapNodeRelicIcon

class SerpentHeadIcon(node: MapRoomNode): MapNodeRelicIcon(SsserpentHead(), node) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }

    override fun display() = super.display() && node.room is EventRoom
}