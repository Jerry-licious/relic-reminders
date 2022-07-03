package relicreminders.patches.energy

import com.evacipated.cardcrawl.modthespire.lib.SpireField
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.ui.panels.EnergyPanel
import relicreminders.ui.nodes.relicicon.energy.EnergyRelicIconList

@SpirePatch(clz = EnergyPanel::class, method = SpirePatch.CLASS)
object PanelIconsField {
    @JvmField
    val relicIcons: SpireField<EnergyRelicIconList> = SpireField { EnergyRelicIconList() }
}

var EnergyPanel.relicIcons: EnergyRelicIconList
    get() = PanelIconsField.relicIcons.get(this)
    set(value) = PanelIconsField.relicIcons.set(this, value)