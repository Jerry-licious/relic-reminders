package relicreminders.patches.dialogoption

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton

@SpirePatch(clz = LargeDialogOptionButton::class, method = "update")
object UpdatePatch {
    @JvmStatic
    @SpirePostfixPatch
    fun updateRelicIcons(button: LargeDialogOptionButton) {
        button.relicIcons.update()
    }
}