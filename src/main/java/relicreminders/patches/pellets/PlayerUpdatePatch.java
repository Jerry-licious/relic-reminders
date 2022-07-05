package relicreminders.patches.pellets;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import relicreminders.RelicRemindersMod;

@SpirePatch(clz = AbstractPlayer.class, method = "update")
public class PlayerUpdatePatch {
    @SpireInsertPatch(rloc = 4)
    public static void updateIndicator(AbstractPlayer player) {
        if (RelicRemindersMod.Companion.getConfig().getPellets()) {
            PelletsIndicatorPatch.indicatorField.get(player).update();
        }
    }
}
