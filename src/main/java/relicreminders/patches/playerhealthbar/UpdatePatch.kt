package relicreminders.patches.playerhealthbar

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch
import com.megacrit.cardcrawl.characters.AbstractPlayer
import relicreminders.RelicRemindersMod

@SpirePatch(clz = AbstractPlayer::class, method = "update")
object UpdatePatch {
    @JvmStatic
    @SpirePostfixPatch
    fun updateHealthBarIcons(player: AbstractPlayer) {
        if (RelicRemindersMod.config.hp) {
            player.healthBarRelicIcons.update()
        }
    }
}