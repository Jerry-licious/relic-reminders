package relicreminders.ui.nodes.relicicon.mapnode.shop

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.map.MapRoomNode
import com.megacrit.cardcrawl.relics.Courier
import com.megacrit.cardcrawl.rooms.ShopRoom
import relicreminders.ui.nodes.relicicon.mapnode.MapNodeRelicIcon

class CourierIcon(node: MapRoomNode): MapNodeRelicIcon(Courier(), node) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }

    override fun display() = super.display() && node.room is ShopRoom
}