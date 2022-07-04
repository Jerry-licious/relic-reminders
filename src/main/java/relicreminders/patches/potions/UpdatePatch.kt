package relicreminders.patches.potions

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.ui.panels.TopPanel

@SpirePatch(clz = TopPanel::class, method = "updatePotions")
object UpdatePatch {
    @JvmStatic
    @SpirePostfixPatch
    fun updateRelicIcons(topPanel: TopPanel) {
        topPanel.relicIcons.update()
    }
}