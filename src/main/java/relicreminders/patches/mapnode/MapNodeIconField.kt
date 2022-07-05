package relicreminders.patches.mapnode

import com.evacipated.cardcrawl.modthespire.lib.SpireField
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.map.MapRoomNode
import relicreminders.ui.nodes.relicicon.mapnode.MapNodeRelicIcons

@SpirePatch(clz = MapRoomNode::class, method = SpirePatch.CLASS)
object MapNodeIconField {
    @JvmField
    val relicIcons: SpireField<MapNodeRelicIcons> = SpireField { null }
}

var MapRoomNode.relicIcons: MapNodeRelicIcons
    get() = MapNodeIconField.relicIcons.get(this)
    set(value) = MapNodeIconField.relicIcons.set(this, value)