package relicreminders.patches.player

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.characters.AbstractPlayer
import relicreminders.RelicRemindersMod

@SpirePatch(clz = AbstractPlayer::class, method = "render")
object RenderPatch {
    @JvmStatic
    @SpireInsertPatch(rloc = 5)
    fun renderHealthBarIcons(player: AbstractPlayer, sb: SpriteBatch) {
        if (RelicRemindersMod.config.hp) {
            player.healthBarRelicIcons.render(sb)
        }
        if (RelicRemindersMod.config.orbs) {
            player.orbRelicIcons.render(sb)
        }
    }
}