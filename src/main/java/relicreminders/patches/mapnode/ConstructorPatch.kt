package relicreminders.patches.mapnode

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.map.MapRoomNode
import relicreminders.ui.nodes.relicicon.mapnode.MapNodeRelicIcons

@SpirePatch(clz = MapRoomNode::class, method = SpirePatch.CONSTRUCTOR)
object ConstructorPatch {
    @JvmStatic
    @SpirePostfixPatch
    fun initialiseIcons(mapRoomNode: MapRoomNode) {
        mapRoomNode.relicIcons = MapNodeRelicIcons(mapRoomNode)
    }
}