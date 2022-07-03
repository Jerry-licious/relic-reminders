package relicreminders.ui

import com.badlogic.gdx.graphics.g2d.SpriteBatch

interface UIElement {
    fun update()
    fun render(sb: SpriteBatch)
}