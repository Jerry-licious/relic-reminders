package relicreminders.ui.nodes

enum class Direction {
    UP, DOWN, LEFT, RIGHT;

    // Returns true if the axis of the direction is vertical, false if it's horizontal.
    val isVertical: Boolean
        get() = when (this) {
            UP, DOWN -> true
            LEFT, RIGHT -> false
        }

    // The sign that each direction points to on its corresponding axis.
    val axisMultiplier: Float
        get() = when (this) {
            // Going up on libgdx corresponds to an increase in y-value.
            // Right corresponds to an increase in x-value.
            UP, RIGHT -> 1f
            DOWN, LEFT -> -1f
        }
}