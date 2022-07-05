package relicreminders.ui.nodes.relicicon.mapnode.treasure

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.map.MapRoomNode
import com.megacrit.cardcrawl.relics.Matryoshka
import com.megacrit.cardcrawl.rooms.TreasureRoom
import relicreminders.ui.nodes.relicicon.mapnode.MapNodeRelicIcon

class MatryoshkaIcon(node: MapRoomNode): MapNodeRelicIcon(Matryoshka(), node) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }

    override fun display() = super.display() && node.room is TreasureRoom && !playerRelic.usedUp
}