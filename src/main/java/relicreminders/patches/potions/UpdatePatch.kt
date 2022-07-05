package relicreminders.patches.potions

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.ui.panels.TopPanel
import relicreminders.RelicRemindersMod

@SpirePatch(clz = TopPanel::class, method = "updatePotions")
object UpdatePatch {
    @JvmStatic
    @SpirePostfixPatch
    fun updateRelicIcons(topPanel: TopPanel) {
        if (RelicRemindersMod.config.potion) {
            topPanel.relicIcons.update()
        }
    }
}