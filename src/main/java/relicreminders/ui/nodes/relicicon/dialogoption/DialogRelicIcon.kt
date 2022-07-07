package relicreminders.ui.nodes.relicicon.dialogoption

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.relics.AbstractRelic
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton
import relicreminders.ui.getPrivateFromClass
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

abstract class DialogRelicIcon(relic: AbstractRelic, val dialogOption: LargeDialogOptionButton):
    AbstractRelicIcon(relic, 60f)

val LargeDialogOptionButton.previewCard: AbstractCard?
    get() = getPrivateFromClass("cardToPreview", LargeDialogOptionButton::class.java)