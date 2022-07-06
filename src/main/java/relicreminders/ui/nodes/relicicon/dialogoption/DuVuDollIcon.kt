package relicreminders.ui.nodes.relicicon.dialogoption

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.DuVuDoll
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton
import relicreminders.ui.getPrivate

class DuVuDollIcon(button: LargeDialogOptionButton): DialogRelicIcon(DuVuDoll(), button) {
    init {
        loadLocalisation("relic_reminders:DuVuDoll")

        tips.add(PowerTip(texts[0], texts[1]))
    }

    override fun display(): Boolean {
        val cardToPreview = dialogOption.getPrivate<AbstractCard?>("cardToPreview")

        // Only triggers if there's no Omamori to block the curse.
        return super.display() && canHeal && cardToPreview != null && omamoriCounter <= 0 &&
                cardToPreview.type == AbstractCard.CardType.CURSE
    }
}

