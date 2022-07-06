package relicreminders

import basemod.BaseMod
import basemod.interfaces.EditStringsSubscriber
import basemod.interfaces.PostInitializeSubscriber
import com.badlogic.gdx.graphics.Texture
import com.evacipated.cardcrawl.modthespire.Loader
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer
import com.megacrit.cardcrawl.core.CardCrawlGame
import com.megacrit.cardcrawl.localization.UIStrings
import relicreminders.config.ConfigMenu
import relicreminders.config.RelicRemindersConfig

@SpireInitializer
class RelicRemindersMod: EditStringsSubscriber, PostInitializeSubscriber {
    lateinit var texts: Array<String>

    init {
        BaseMod.subscribe(this)
    }

    companion object {
        @JvmStatic
        fun initialize() {
            RelicRemindersMod()
        }

        val config = RelicRemindersConfig()
    }

    override fun receiveEditStrings() {
        BaseMod.loadCustomStringsFile(UIStrings::class.java, "relicreminders/localisation/ui_strings.json")
    }

    override fun receivePostInitialize() {
        // Initialise the strings after the strings are loaded.
        texts = CardCrawlGame.languagePack.getUIString("relic_reminders:mod").TEXT
        BaseMod.registerModBadge(Texture("relicreminders/badge.png"), texts[0], texts[1], texts[2], ConfigMenu())

        // STSLib offers the temporary HP feature. Have the relic icons shifted right if the mod is enabled to make
        // sure it's not covered
        if (Loader.isModLoaded("stslib")) {
            config.shiftHPIconsRight = true
        }
    }
}