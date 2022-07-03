package relicreminders.ui.nodes.relicicon.dialogoption

import com.megacrit.cardcrawl.core.Settings
import com.megacrit.cardcrawl.ui.buttons.LargeDialogOptionButton
import relicreminders.ui.Vector2
import relicreminders.ui.nodes.Direction
import relicreminders.ui.nodes.NodeContainer

class DialogRelicIconList(val dialogOption: LargeDialogOptionButton):
    NodeContainer(arrayListOf(), Vector2.ZERO, Direction.LEFT) {
    val icons: ArrayList<DialogRelicIcon> = arrayListOf()

    init {
        // Ordered from least significant to most significant (in reverse because the list expands to the left).
        icons.add(OmamoriRelicIcon(dialogOption))
        icons.add(DarkstonePeriaptIcon(dialogOption))
        icons.add(CeramicFishIcon(dialogOption))
    }

    override fun update() {
        val buttonHitbox = dialogOption.hb
        // Anchor the icons to the right of the button
        firstNodeCentre = Vector2(buttonHitbox.x + buttonHitbox.width + 30f * Settings.scale,
            buttonHitbox.cY)

        children.clear()
        children.addAll(icons.filter { it.display() })

        super.update()
    }
}