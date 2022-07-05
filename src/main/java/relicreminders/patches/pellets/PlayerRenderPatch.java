package relicreminders.patches.pellets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;

@SpirePatch(clz = AbstractPlayer.class, method = "render")
public class PlayerRenderPatch {
    @SpireInsertPatch(rloc = 4)
    public static void renderPelletsIndicator(AbstractPlayer player, SpriteBatch sb) {
        PelletsIndicatorPatch.indicatorField.get(player).render(sb);
    }
}
