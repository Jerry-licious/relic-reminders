package relicreminders.ui.nodes.relicicon.mapnode.rest

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.map.MapRoomNode
import com.megacrit.cardcrawl.relics.EternalFeather
import com.megacrit.cardcrawl.rooms.RestRoom
import relicreminders.ui.nodes.relicicon.mapnode.MapNodeRelicIcon

class EternalFeatherIcon(node: MapRoomNode): MapNodeRelicIcon(EternalFeather(), node) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }

    override fun display() = super.display() && canHeal && node.room is RestRoom
}