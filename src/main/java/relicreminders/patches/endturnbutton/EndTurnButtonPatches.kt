package relicreminders.patches.endturnbutton

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.evacipated.cardcrawl.modthespire.lib.*
import com.megacrit.cardcrawl.actions.GameActionManager
import com.megacrit.cardcrawl.core.Settings
import com.megacrit.cardcrawl.dungeons.AbstractDungeon
import com.megacrit.cardcrawl.helpers.Hitbox
import com.megacrit.cardcrawl.relics.GremlinHorn
import com.megacrit.cardcrawl.relics.UnceasingTop
import com.megacrit.cardcrawl.ui.buttons.EndTurnButton
import com.megacrit.cardcrawl.vfx.RelicAboveCreatureEffect
import relicreminders.ui.getPrivate

object EndTurnButtonPatches {
    var timeSinceWaitingOnUser = 0f
    // The amount of time the player must wait to end their turn after their action queue is empty.
    val waitingOnUserThreshold = 0.5f

    val relicTimerResetValue = 2f
    // Timer for relics that block the player from ending their turn.
    var unceasingTopTimer = 0f
    var gremlinHornTimer = 0f

    val allowEndTurn: Boolean
        get() = timeSinceWaitingOnUser > waitingOnUserThreshold && unceasingTopTimer < 0f && gremlinHornTimer < 0f

    @SpirePatch(clz = EndTurnButton::class, method = "disable", paramtypez = [Boolean::class])
    object BlockEndTurnPatch {
        @JvmStatic
        @SpirePrefixPatch
        fun blockEndTurn(endTurnButton: EndTurnButton): SpireReturn<Void> {
            val stackTrace = Thread.currentThread().stackTrace
            // A normal end turn button press would have the following stacktrace:
            // Thread -> Patch -> Button -> Button
            // But something else that calls the button would have something like this:
            // Thread -> Patch -> Button -> Some Other Class
            if (stackTrace.size > 3 && // Avoid unnecessary crashes.
                // Only consider blocking the end turn button if it's the player pressing the button.
                stackTrace[3].className == "com.megacrit.cardcrawl.ui.buttons.EndTurnButton") {
                // Block the end turn if the player hasn't waited long enough.
                if (!allowEndTurn) {
                    val buttonHitbox = endTurnButton.getPrivate<Hitbox>("hb")
                    if (unceasingTopTimer > 0f) {
                        AbstractDungeon.effectList.add(RelicAboveCreatureEffect(buttonHitbox.cX,
                            buttonHitbox.cY + buttonHitbox.height, UnceasingTop()))
                    }
                    if (gremlinHornTimer > 0f) {
                        AbstractDungeon.effectList.add(RelicAboveCreatureEffect(buttonHitbox.cX,
                            buttonHitbox.cY + buttonHitbox.height, GremlinHorn()))
                    }

                    return SpireReturn.Return()
                }
            }

            return SpireReturn.Continue()
        }
    }

    @SpirePatch(clz = EndTurnButton::class, method = "update")
    object UpdatePatch {
        @JvmStatic
        @SpirePostfixPatch
        fun updateTimers(endTurnButton: EndTurnButton) {
            if (AbstractDungeon.actionManager.phase == GameActionManager.Phase.WAITING_ON_USER) {
                timeSinceWaitingOnUser += Gdx.graphics.deltaTime
            } else {
                timeSinceWaitingOnUser = 0f
            }

            unceasingTopTimer -= Gdx.graphics.deltaTime
            gremlinHornTimer -= Gdx.graphics.deltaTime
        }
    }

    @SpirePatch(clz = EndTurnButton::class, method = "render")
    object RenderPatch {
        @JvmStatic
        @SpireInsertPatch(rloc = 52)
        fun changeColour(endTurnButton: EndTurnButton, sb: SpriteBatch) {
            if (!allowEndTurn) {
                sb.color = Settings.RED_TEXT_COLOR
            }
        }
    }

    @SpirePatch(clz = UnceasingTop::class, method = "onRefreshHand")
    object UnceasingTopPatch {
        @JvmStatic
        @SpireInsertPatch(rloc = 5)
        fun resetUnceasingTopTimer() {
            unceasingTopTimer = relicTimerResetValue
        }
    }

    @SpirePatch(clz = GremlinHorn::class, method = "onMonsterDeath")
    object GremlinHornPatch {
        @JvmStatic
        @SpireInsertPatch(rloc = 1)
        fun resetGremlinHornTimer() {
            gremlinHornTimer = relicTimerResetValue
        }
    }
}