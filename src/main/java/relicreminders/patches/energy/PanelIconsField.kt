package relicreminders.patches.energy

import com.evacipated.cardcrawl.modthespire.lib.SpireField
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.ui.panels.EnergyPanel
import relicreminders.ui.nodes.relicicon.energy.EnergyRelicIcons

@SpirePatch(clz = EnergyPanel::class, method = SpirePatch.CLASS)
object PanelIconsField {
    @JvmField
    val relicIcons: SpireField<EnergyRelicIcons> = SpireField { EnergyRelicIcons() }
}

var EnergyPanel.relicIcons: EnergyRelicIcons
    get() = PanelIconsField.relicIcons.get(this)
    set(value) = PanelIconsField.relicIcons.set(this, value)