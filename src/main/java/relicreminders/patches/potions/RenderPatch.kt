package relicreminders.patches.potions

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.ui.panels.TopPanel
import relicreminders.RelicRemindersMod

@SpirePatch(clz = TopPanel::class, method = "renderPotions")
object RenderPatch {
    @JvmStatic
    @SpirePostfixPatch
    fun renderRelicIcons(topPanel: TopPanel, sb: SpriteBatch) {
        if (RelicRemindersMod.config.potion) {
            topPanel.relicIcons.render(sb)
        }
    }
}