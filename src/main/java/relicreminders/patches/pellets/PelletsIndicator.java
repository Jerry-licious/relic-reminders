package relicreminders.patches.pellets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.Hitbox;
import com.megacrit.cardcrawl.relics.OrangePellets;

public class PelletsIndicator {
    public static float SIZE = 384f;

    private AbstractPlayer player;

    private boolean hasPellets = false;
    private boolean attackPlayed = false;
    private boolean skillPlayed = false;
    private boolean powerPlayed = false;

    private Hitbox hitbox;
    private float drawX;
    private float drawY;

    private Color pelletsBaseColour = Color.WHITE.cpy();
    private Color greyedOutColour = new Color(1f, 1f, 1f, 0.5f);
    private Color enabledColour = new Color(1f, 1f, 1f, 0.8f);

    private boolean activated = false;
    private float activatedTimer = 0f;

    public PelletsIndicator() {
        hitbox = new Hitbox(SIZE * Settings.scale, SIZE * Settings.scale);
    }

    public void update() {
        player = AbstractDungeon.player;

        hasPellets = player.hasRelic(OrangePellets.ID);

        if (hasPellets) {
            // When activated, starts counting down on the timer and keep everything at the brightest until the timer
            // runs out.
            if (activated) {
                attackPlayed = true;
                skillPlayed = true;
                powerPlayed = true;
                pelletsBaseColour.a = 1f;

                activatedTimer -= Gdx.graphics.getDeltaTime();
                if (activatedTimer <= 0) {
                    activated = false;
                }
            } else {
                attackPlayed = (boolean) ReflectionHacks.getPrivateStatic(OrangePellets.class, "ATTACK");
                skillPlayed = (boolean) ReflectionHacks.getPrivateStatic(OrangePellets.class, "SKILL");
                powerPlayed = (boolean) ReflectionHacks.getPrivateStatic(OrangePellets.class, "POWER");

                // Make the pellets icon more visible with more parts activated.
                pelletsBaseColour.a = 0.25f;
                if (attackPlayed) pelletsBaseColour.a += 0.25f;
                if (skillPlayed) pelletsBaseColour.a += 0.25f;
                if (powerPlayed) pelletsBaseColour.a += 0.25f;
            }
        }

        hitbox.move(player.hb.cX, player.hb.cY + player.hb_h + SIZE * Settings.scale / 2f);
        hitbox.update();

        drawX = hitbox.x;
        drawY = hitbox.y;
    }

    private void renderTexture(SpriteBatch sb, Texture texture) {
        sb.draw(texture, drawX, drawY, SIZE * Settings.scale, SIZE * Settings.scale);
    }

    public void render(SpriteBatch sb) {
        hitbox.render(sb);

        if (hasPellets) {
            System.out.println("Trying to render.");

            Gdx.gl.glEnable(Gdx.gl20.GL_BLEND);

            sb.setColor(pelletsBaseColour);
            renderTexture(sb, TextureLoader.pelletsBase);

            if (attackPlayed) {
                sb.setColor(enabledColour);
                renderTexture(sb, TextureLoader.attackPlayed);
            } else {
                sb.setColor(greyedOutColour);
                renderTexture(sb, TextureLoader.attackNotPlayed);
            }

            if (skillPlayed) {
                sb.setColor(enabledColour);
                renderTexture(sb, TextureLoader.skillPlayed);
            } else {
                sb.setColor(greyedOutColour);
                renderTexture(sb, TextureLoader.skillNotPlayed);
            }

            if (powerPlayed) {
                sb.setColor(enabledColour);
                renderTexture(sb, TextureLoader.powerPlayed);
            } else {
                sb.setColor(greyedOutColour);
                renderTexture(sb, TextureLoader.powerNotPlayed);
            }
        }
    }

    // When activated, all things become enabled for a while.
    public void activate() {
        activated = true;
        activatedTimer = 1.5f;
    }
}
