package relicreminders.ui.nodes.relicicon.mapnode.shop

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.map.MapRoomNode
import com.megacrit.cardcrawl.relics.SmilingMask
import com.megacrit.cardcrawl.rooms.ShopRoom
import relicreminders.ui.nodes.relicicon.mapnode.MapNodeRelicIcon

class SmilingMaskIcon(node: MapRoomNode): MapNodeRelicIcon(SmilingMask(), node) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }

    override fun display() = super.display() && node.room is ShopRoom
}