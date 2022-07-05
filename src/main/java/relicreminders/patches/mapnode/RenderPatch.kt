package relicreminders.patches.mapnode

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.map.MapRoomNode
import relicreminders.RelicRemindersMod

@SpirePatch(clz = MapRoomNode::class, method = "render")
object RenderPatch {
    @JvmStatic
    @SpirePostfixPatch
    fun renderIcons(mapRoomNode: MapRoomNode, sb: SpriteBatch) {
        if (RelicRemindersMod.config.map) {
            mapRoomNode.relicIcons.render(sb)
        }
    }
}