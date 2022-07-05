package relicreminders.patches.dialogoption

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton
import relicreminders.RelicRemindersMod

@SpirePatch(clz = LargeDialogOptionButton::class, method = "update")
object UpdatePatch {
    @JvmStatic
    @SpirePostfixPatch
    fun updateRelicIcons(button: LargeDialogOptionButton) {
        if (RelicRemindersMod.config.event) {
            button.relicIcons.update()
        }
    }
}