package relicreminders.patches.mapnode

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.map.MapRoomNode

@SpirePatch(clz = MapRoomNode::class, method = "update")
object UpdatePatch {
    @JvmStatic
    @SpirePostfixPatch
    fun updateRelicIcons(mapRoomNode: MapRoomNode) {
        mapRoomNode.relicIcons.update()
    }
}