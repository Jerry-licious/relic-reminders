package relicreminders.ui.nodes

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.megacrit.cardcrawl.helpers.ShaderHelper
import relicreminders.ui.shape.Rectangle

open class TextureRect(var texture: TextureRegion, shape: Rectangle): AbstractNode(shape) {
    var greyscale: Boolean = false
    var renderColour: Color = Color.WHITE.cpy()
    var opacity: Float = 1f

    override fun render(sb: SpriteBatch) {
        if (greyscale) ShaderHelper.setShader(sb, ShaderHelper.Shader.GRAYSCALE)
        val boundingBox = shape.boundingBox

        renderColour.a = opacity
        sb.color = renderColour
        sb.draw(texture, boundingBox.position.x, boundingBox.position.y,
            boundingBox.size.x, boundingBox.size.y)

        if (greyscale) ShaderHelper.setShader(sb, ShaderHelper.Shader.DEFAULT)

        super.render(sb)
    }
}