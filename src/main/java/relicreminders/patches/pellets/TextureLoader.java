package relicreminders.patches.pellets;

import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.helpers.ImageMaster;

@SpirePatch(clz = ImageMaster.class, method = "initialize")
public class TextureLoader {
    public static Texture pelletsBase;

    public static Texture attackPlayed;
    public static Texture attackNotPlayed;

    public static Texture skillPlayed;
    public static Texture skillNotPlayed;

    public static Texture powerPlayed;
    public static Texture powerNotPlayed;

    @SpirePostfixPatch
    public static void loadImages() {
        pelletsBase = new Texture("pellets-indicator/pellets_base.png");

        attackPlayed = new Texture("pellets-indicator/attack_played.png");
        attackNotPlayed = new Texture("pellets-indicator/attack_not_played.png");

        skillPlayed = new Texture("pellets-indicator/skill_played.png");
        skillNotPlayed = new Texture("pellets-indicator/skill_not_played.png");

        powerPlayed = new Texture("pellets-indicator/power_played.png");
        powerNotPlayed = new Texture("pellets-indicator/power_not_played.png");
    }
}
