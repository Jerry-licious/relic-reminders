package relicreminders.patches.potionpopup

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.ui.panels.PotionPopUp

@SpirePatch(clz = PotionPopUp::class, method = "update")
object UpdatePatch {
    @JvmStatic
    @SpireInsertPatch(rloc = 5)
    fun updateIcons(popUp: PotionPopUp) {
        popUp.useRelicIconList.update()
        popUp.discardRelicIconList.update()
    }
}