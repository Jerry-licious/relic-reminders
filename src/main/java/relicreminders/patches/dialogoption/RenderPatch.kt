package relicreminders.patches.dialogoption

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton
import relicreminders.RelicRemindersMod

@SpirePatch(clz = LargeDialogOptionButton::class, method = "render")
object RenderPatch {
    @JvmStatic
    @SpirePostfixPatch
    fun renderRelicIcons(button: LargeDialogOptionButton, sb: SpriteBatch) {
        if (RelicRemindersMod.config.event) {
            button.relicIcons.render(sb)
        }
    }
}