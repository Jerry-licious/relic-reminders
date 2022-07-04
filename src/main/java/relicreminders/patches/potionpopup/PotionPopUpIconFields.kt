package relicreminders.patches.potionpopup

import com.evacipated.cardcrawl.modthespire.lib.SpireField
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.ui.panels.PotionPopUp
import relicreminders.ui.nodes.relicicon.potionpopup.discard.PotionDiscardRelicIconList
import relicreminders.ui.nodes.relicicon.potionpopup.use.PotionUseRelicIconList

@SpirePatch(clz = PotionPopUp::class, method = SpirePatch.CLASS)
object PotionPopUpIconFields {
    @JvmField
    val useRelicIconList: SpireField<PotionUseRelicIconList> = SpireField { null }
    @JvmField
    val discardRelicIconList: SpireField<PotionDiscardRelicIconList> = SpireField { null }
}

var PotionPopUp.useRelicIconList: PotionUseRelicIconList
    get() = PotionPopUpIconFields.useRelicIconList.get(this)
    set(value) = PotionPopUpIconFields.useRelicIconList.set(this, value)

var PotionPopUp.discardRelicIconList: PotionDiscardRelicIconList
    get() = PotionPopUpIconFields.discardRelicIconList.get(this)
    set(value) = PotionPopUpIconFields.discardRelicIconList.set(this, value)