package relicreminders.ui.hitbox

open class UHitboxListener {
    open fun onMouseEnter() {}
    open fun onMouseLeave() {}

    open fun onMouseDown(mouseButton: MouseButton) {}
    open fun onClick(mouseButton: MouseButton) {}
}