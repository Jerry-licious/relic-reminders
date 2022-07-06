package relicreminders.ui.nodes.relicicon.mapnode

import com.megacrit.cardcrawl.map.MapRoomNode
import relicreminders.ui.Vector2
import relicreminders.ui.nodes.relicicon.AbstractRelicIconList
import relicreminders.ui.nodes.relicicon.mapnode.elite.PreservedInsectIcon
import relicreminders.ui.nodes.relicicon.mapnode.elite.SlingOfCourageIcon
import relicreminders.ui.nodes.relicicon.mapnode.event.SerpentHeadIcon
import relicreminders.ui.nodes.relicicon.mapnode.monster.PrayerWheelIcon
import relicreminders.ui.nodes.relicicon.mapnode.rest.EternalFeatherIcon
import relicreminders.ui.nodes.relicicon.mapnode.shop.CourierIcon
import relicreminders.ui.nodes.relicicon.mapnode.shop.MealTicketIcon
import relicreminders.ui.nodes.relicicon.mapnode.shop.MembershipCardIcon
import relicreminders.ui.nodes.relicicon.mapnode.shop.SmilingMaskIcon
import relicreminders.ui.nodes.relicicon.mapnode.treasure.HungryFaceIcon
import relicreminders.ui.nodes.relicicon.mapnode.treasure.MatryoshkaIcon

val angleStartOffset = Math.PI.toFloat() / 6

class MapNodeRelicIcons(val node: MapRoomNode): AbstractRelicIconList() {
    init {
        icons.add(PreservedInsectIcon(node))
        icons.add(SlingOfCourageIcon(node))

        icons.add(SerpentHeadIcon(node))

        icons.add(PrayerWheelIcon(node))

        icons.add(EternalFeatherIcon(node))

        icons.add(MealTicketIcon(node))
        icons.add(CourierIcon(node))
        icons.add(MembershipCardIcon(node))
        icons.add(SmilingMaskIcon(node))

        icons.add(HungryFaceIcon(node))
        icons.add(MatryoshkaIcon(node))
    }

    override fun update() {
        val nodeHitbox = node.hb
        firstNodeCentre = Vector2(nodeHitbox.cX + nodeHitbox.width / 2, nodeHitbox.cY)

        super.update()
    }

    // Instead of ordering the relics in a list, distribute them in a ring around the node.
    override fun updateChildrenPosition() {
        if (children.isNotEmpty()) {
            // The angle between each relic.
            val distributionAngle = Math.PI.toFloat() * 2 / children.size
            // Distance of each relic's centre from the node's centre
            val radius = node.hb.width * 0.6f
            val mapNodeCentre = Vector2(node.hb.cX, node.hb.cY)
            for (i in 0 until children.size) {
                children[i].moveCentreTo(mapNodeCentre + Vector2(1f, 0f)
                    .rotated(i * distributionAngle + angleStartOffset) * radius)
            }

            refitHitbox()
        }
    }
}