package relicreminders.patches.player

import com.evacipated.cardcrawl.modthespire.lib.SpireField
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.characters.AbstractPlayer
import relicreminders.ui.nodes.relicicon.healthbar.HealthBarRelicIcons
import relicreminders.ui.nodes.relicicon.orbs.OrbRelicIcons

@SpirePatch(clz = AbstractPlayer::class, method = SpirePatch.CLASS)
object PlayerIconFields {
    @JvmField
    val healthBarRelicIcons: SpireField<HealthBarRelicIcons> = SpireField { HealthBarRelicIcons() }
    @JvmField
    val orbRelicIcons: SpireField<OrbRelicIcons> = SpireField { OrbRelicIcons() }
}

var AbstractPlayer.healthBarRelicIcons: HealthBarRelicIcons
    get() = PlayerIconFields.healthBarRelicIcons.get(this)
    set(value) = PlayerIconFields.healthBarRelicIcons.set(this, value)

var AbstractPlayer.orbRelicIcons: OrbRelicIcons
    get() = PlayerIconFields.orbRelicIcons.get(this)
    set(value) = PlayerIconFields.orbRelicIcons.set(this, value)