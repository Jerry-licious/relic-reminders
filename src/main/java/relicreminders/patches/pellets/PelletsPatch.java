package relicreminders.patches.pellets;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.OrangePellets;

@SpirePatch(clz = OrangePellets.class, method = "onUseCard")
public class PelletsPatch {
    @SpireInsertPatch(rloc = 9)
    public static void onPelletsProc() {
        PelletsIndicatorPatch.indicatorField.get(AbstractDungeon.player).activate();
    }
}
