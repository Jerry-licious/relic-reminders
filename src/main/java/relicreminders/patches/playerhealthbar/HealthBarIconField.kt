package relicreminders.patches.playerhealthbar

import com.evacipated.cardcrawl.modthespire.lib.SpireField
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.characters.AbstractPlayer
import relicreminders.ui.nodes.relicicon.healthbar.HealthBarRelicIconList

@SpirePatch(clz = AbstractPlayer::class, method = SpirePatch.CLASS)
object HealthBarIconField {
    @JvmField
    val healthBarRelicIcons: SpireField<HealthBarRelicIconList> = SpireField { HealthBarRelicIconList() }
}

var AbstractPlayer.healthBarRelicIcons: HealthBarRelicIconList
    get() = HealthBarIconField.healthBarRelicIcons.get(this)
    set(value) = HealthBarIconField.healthBarRelicIcons.set(this, value)