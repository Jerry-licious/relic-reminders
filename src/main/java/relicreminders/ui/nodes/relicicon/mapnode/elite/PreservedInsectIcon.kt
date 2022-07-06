package relicreminders.ui.nodes.relicicon.mapnode.elite

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.map.MapRoomNode
import com.megacrit.cardcrawl.relics.PreservedInsect
import com.megacrit.cardcrawl.rooms.MonsterRoomElite
import relicreminders.ui.nodes.relicicon.mapnode.MapNodeRelicIcon

class PreservedInsectIcon(node: MapRoomNode): MapNodeRelicIcon(PreservedInsect(), node) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }

    override fun display() = super.display() && node.room is MonsterRoomElite
}