package relicreminders.ui.nodes.relicicon.dialogoption

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.events.beyond.Falling
import com.megacrit.cardcrawl.relics.AbstractRelic
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton
import relicreminders.ui.getPrivateFromClass
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

abstract class DialogRelicIcon(relic: AbstractRelic, val dialogOption: LargeDialogOptionButton):
    AbstractRelicIcon(relic, 60f) {
    override fun display() = super.display() && AbstractDungeon.getCurrRoom().event !is Falling
}

val LargeDialogOptionButton.previewCard: AbstractCard?
    get() = getPrivateFromClass("cardToPreview", LargeDialogOptionButton::class.java)