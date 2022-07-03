package relicreminders.patches.dialogoption

import com.evacipated.cardcrawl.modthespire.lib.SpireField
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton
import relicreminders.ui.nodes.relicicon.dialogoption.DialogRelicIconList

@SpirePatch(clz = LargeDialogOptionButton::class, method = SpirePatch.CLASS)
object ButtonIconsField {
    @JvmField
    val relicIcons: SpireField<DialogRelicIconList> = SpireField { null }
}

var LargeDialogOptionButton.relicIcons: DialogRelicIconList
    get() = ButtonIconsField.relicIcons.get(this)
    set(value) = ButtonIconsField.relicIcons.set(this, value)