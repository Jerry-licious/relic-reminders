package relicreminders.patches.dialogoption

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.relics.AbstractRelic
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton
import relicreminders.ui.nodes.relicicon.dialogoption.DialogRelicIcons

@SpirePatch(clz = LargeDialogOptionButton::class, method = SpirePatch.CONSTRUCTOR,
    paramtypez = [Int::class, String::class, Boolean::class, AbstractCard::class, AbstractRelic::class])
object ConstructorPatch {
    @JvmStatic
    @SpirePostfixPatch
    fun initialiseRelicIcons(button: LargeDialogOptionButton) {
        button.relicIcons = DialogRelicIcons(button)
    }
}