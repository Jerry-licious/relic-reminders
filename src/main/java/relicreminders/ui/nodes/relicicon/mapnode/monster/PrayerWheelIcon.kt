package relicreminders.ui.nodes.relicicon.mapnode.monster

import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.map.MapRoomNode
import com.megacrit.cardcrawl.relics.PrayerWheel
import com.megacrit.cardcrawl.rooms.MonsterRoom
import relicreminders.ui.nodes.relicicon.mapnode.MapNodeRelicIcon

class PrayerWheelIcon(node: MapRoomNode): MapNodeRelicIcon(PrayerWheel(), node) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }

    // Check for class specifically here because elite and boss rooms extend monster room.
    override fun display() = super.display() && node.room.javaClass == MonsterRoom::class.java
}