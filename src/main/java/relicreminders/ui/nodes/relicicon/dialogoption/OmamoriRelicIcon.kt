package relicreminders.ui.nodes.relicicon.dialogoption

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.Omamori
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton
import relicreminders.ui.getPrivate

class OmamoriRelicIcon(button: LargeDialogOptionButton): DialogRelicIcon(Omamori(), button) {
    init {
        loadLocalisation("relic_reminders:Omamori")
    }

    override fun display(): Boolean {
        val cardToPreview = dialogOption.getPrivate<AbstractCard?>("cardToPreview")

        return super.display() && omamoriCounter > 0 &&
                cardToPreview != null && cardToPreview.type == AbstractCard.CardType.CURSE
    }

    override fun update() {
        greyscale = omamoriCounter <= 0

        tips.clear()
        tips.add(PowerTip(texts[0], texts[omamoriCounter + 1]))

        super.update()
    }
}

