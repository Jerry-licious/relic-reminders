package relicreminders.ui

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.megacrit.cardcrawl.helpers.Hitbox
import com.megacrit.cardcrawl.helpers.input.InputHelper
import com.megacrit.cardcrawl.ui.panels.EnergyPanel
import java.lang.reflect.Field

val mousePosition
    get() = Vector2(InputHelper.mX.toFloat(), InputHelper.mY.toFloat())

// Inclusive comparison.
fun Float.between(a: Float, b: Float): Boolean = this in a..b || this in b..a

val Texture.fullRegion
    get() = TextureRegion(this)

// Crops the centre 64 by 64 region of an 128 by 128 relic image.
val Texture.relicCrop
    get() = TextureRegion(this, 32, 32, 64, 64)

val EnergyPanel.hitbox: Hitbox
    get() {
        val hitboxField: Field = javaClass.getDeclaredField("tipHitbox")
        hitboxField.isAccessible = true
        return hitboxField.get(this) as Hitbox
    }

fun<T> Any.getPrivate(fieldName: String): T {
    val field = javaClass.getDeclaredField(fieldName)
    field.isAccessible = true
    return field.get(this) as T
}

fun<T, U> Any.getPrivateFromClass(fieldName: String, clazz: Class<T>): U {
    val field = clazz.getDeclaredField(fieldName)
    field.isAccessible = true
    return field.get(this) as U
}