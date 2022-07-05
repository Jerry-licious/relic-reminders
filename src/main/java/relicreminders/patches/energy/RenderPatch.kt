package relicreminders.patches.energy

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.ui.panels.EnergyPanel
import relicreminders.RelicRemindersMod

@SpirePatch(clz = EnergyPanel::class, method = "render")
object RenderPatch {
    @JvmStatic
    @SpirePostfixPatch
    fun renderPanelIcons(panel: EnergyPanel, sb: SpriteBatch) {
        if (RelicRemindersMod.config.energy) {
            panel.relicIcons.render(sb)
        }
    }
}