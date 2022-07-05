package relicreminders.ui

import com.megacrit.cardcrawl.core.Settings
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class Vector2(val x: Float, val y: Float) {
    operator fun plus(other: Vector2) = Vector2(x + other.x, y + other.y)
    operator fun minus(other: Vector2) = Vector2(x - other.x, y - other.y)
    operator fun times(scale: Float) = Vector2(x * scale, y * scale)
    operator fun div(scale: Float) = times(1 / scale)

    // Scales the current vector by Settings.scale
    fun scaled() = this.times(Settings.scale)

    val angle: Float
        get() = atan2(y.toDouble(), x.toDouble()).toFloat()

    val length: Float
        get() = sqrt(x * x + y * y)

    fun rotated(angle: Float): Vector2 {
        val summedAngle = angle + this.angle
        return Vector2(cos(summedAngle), sin(summedAngle)) * length
    }

    companion object {
        @JvmField
        val ZERO = Vector2(0f, 0f)
    }
}