package relicreminders.ui.nodes.relicicon.potionlist

import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.helpers.PowerTip
import com.megacrit.cardcrawl.relics.Sozu
import com.megacrit.cardcrawl.relics.WhiteBeast
import com.megacrit.cardcrawl.rooms.AbstractRoom
import relicreminders.ui.nodes.relicicon.AbstractRelicIcon

class WhiteBeastStatueIcon: AbstractRelicIcon(WhiteBeast(), 50f) {
    init {
        tips.add(PowerTip(relic.name, relic.description))
    }

    override fun display(): Boolean = super.display() && !AbstractDungeon.player.hasRelic(Sozu.ID) &&
            // Only show up in combat.
            AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT
}