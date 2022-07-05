package relicreminders.patches.energy

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.ui.panels.EnergyPanel
import relicreminders.RelicRemindersMod

@SpirePatch(clz = EnergyPanel::class, method = "update")
object UpdatePatch {
    @JvmStatic
    @SpirePostfixPatch
    fun updateRelicIcons(panel: EnergyPanel) {
        if (RelicRemindersMod.config.energy) {
            panel.relicIcons.update()
        }
    }
}