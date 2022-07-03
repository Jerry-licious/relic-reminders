package relicreminders.ui

import com.megacrit.cardcrawl.core.Settings

class Vector2(val x: Float, val y: Float) {
    operator fun plus(other: Vector2) = Vector2(x + other.x, y + other.y)
    operator fun minus(other: Vector2) = Vector2(x - other.x, y - other.y)
    operator fun times(scale: Float) = Vector2(x * scale, y * scale)
    operator fun div(scale: Float) = times(1 / scale)

    // Scales the current vector by Settings.scale
    fun scaled() = this.times(Settings.scale)

    companion object {
        @JvmField
        val ZERO = Vector2(0f, 0f)
    }
}