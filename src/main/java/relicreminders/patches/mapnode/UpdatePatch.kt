package relicreminders.patches.mapnode

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.map.MapRoomNode
import relicreminders.RelicRemindersMod

@SpirePatch(clz = MapRoomNode::class, method = "update")
object UpdatePatch {
    @JvmStatic
    @SpirePostfixPatch
    fun updateRelicIcons(mapRoomNode: MapRoomNode) {
        if (RelicRemindersMod.config.map) {
            mapRoomNode.relicIcons.update()
        }
    }
}