package relicreminders.ui.nodes.relicicon.dialogoption

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.relics.AbstractRelic
import com.megacrit.cardcrawl.relics.Omamori
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

open class DialogRelicIcon(relic: AbstractRelic, val dialogOption: LargeDialogOptionButton):
    AbstractRelicIcon(relic, 60f)