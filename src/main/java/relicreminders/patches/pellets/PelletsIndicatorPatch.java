package relicreminders.patches.pellets;

import com.evacipated.cardcrawl.modthespire.lib.SpireField;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;

@SpirePatch(clz = AbstractPlayer.class, method = SpirePatch.CLASS)
public class PelletsIndicatorPatch {
    public static SpireField<PelletsIndicator> indicatorField = new SpireField<>(PelletsIndicator::new);
}
