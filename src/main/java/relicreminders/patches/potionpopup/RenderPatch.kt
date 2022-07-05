package relicreminders.patches.potionpopup

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.ui.panels.PotionPopUp
import relicreminders.RelicRemindersMod

@SpirePatch(clz = PotionPopUp::class, method = "render")
object RenderPatch {
    @JvmStatic
    @SpireInsertPatch(rloc = 107)
    fun renderIcons(popUp: PotionPopUp, sb: SpriteBatch) {
        if (RelicRemindersMod.config.potion) {
            popUp.useRelicIconList.render(sb)
            popUp.discardRelicIconList.render(sb)
        }
    }
}