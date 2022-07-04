package relicreminders.patches.potions

import com.evacipated.cardcrawl.modthespire.lib.SpireField
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.ui.panels.TopPanel
import relicreminders.ui.nodes.relicicon.potionlist.PotionRelicIconList

@SpirePatch(clz = TopPanel::class, method = SpirePatch.CLASS)
object TopPanelIconField {
    @JvmField
    val relicIconList: SpireField<PotionRelicIconList> = SpireField { PotionRelicIconList() }
}

var TopPanel.relicIcons: PotionRelicIconList
    get() = TopPanelIconField.relicIconList.get(this)
    set(value) = TopPanelIconField.relicIconList.set(this, value)