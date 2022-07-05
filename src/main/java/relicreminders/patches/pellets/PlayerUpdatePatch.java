package relicreminders.patches.pellets;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;

@SpirePatch(clz = AbstractPlayer.class, method = "update")
public class PlayerUpdatePatch {
    @SpireInsertPatch(rloc = 4)
    public static void updateIndicator(AbstractPlayer player) {
        PelletsIndicatorPatch.indicatorField.get(player).update();
    }
}
