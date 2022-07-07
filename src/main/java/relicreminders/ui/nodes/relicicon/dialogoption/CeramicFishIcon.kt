package relicreminders.ui.nodes.relicicon.dialogoption

import com.megacrit.cardcrawl.cards.AbstractCard
import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.CeramicFish
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton
import relicreminders.ui.getPrivate
import relicreminders.ui.getPrivateFromClass

class CeramicFishIcon(button: LargeDialogOptionButton): DialogRelicIcon(CeramicFish(), button) {
    init {
        loadLocalisation("relic_reminders:CeramicFish")

        tips.add(PowerTip(texts[0], texts[1]))
    }

    override fun display(): Boolean {
        val cardToPreview = dialogOption.previewCard

        return super.display() && cardToPreview != null && canGainGold &&
                // Triggers if the card isn't a curse
                (cardToPreview.type != AbstractCard.CardType.CURSE ||
                    // and if there isn't enough Omamori charges to block the curse.
                    (omamoriCounter <= 0 && cardToPreview.type == AbstractCard.CardType.CURSE))
    }
}

