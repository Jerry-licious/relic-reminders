package relicreminders.patches.playerhealthbar

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.characters.AbstractPlayer

@SpirePatch(clz = AbstractPlayer::class, method = "render")
object RenderPatch {
    @JvmStatic
    @SpireInsertPatch(rloc = 5)
    fun renderHealthBarIcons(player: AbstractPlayer, sb: SpriteBatch) {
        player.healthBarRelicIcons.render(sb)
    }
}