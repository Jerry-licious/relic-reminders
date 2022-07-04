package relicreminders.patches.potionpopup

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.ui.panels.PotionPopUp
import relicreminders.ui.nodes.relicicon.potionpopup.discard.PotionDiscardRelicIconList
import relicreminders.ui.nodes.relicicon.potionpopup.use.PotionUseRelicIconList

@SpirePatch(clz = PotionPopUp::class, method = SpirePatch.CONSTRUCTOR)
object ConstructorPatch {
    @JvmStatic
    @SpirePostfixPatch
    fun initialisePopUpIcons(popUp: PotionPopUp) {
        popUp.useRelicIconList = PotionUseRelicIconList(popUp)
        popUp.discardRelicIconList = PotionDiscardRelicIconList(popUp)
    }
}