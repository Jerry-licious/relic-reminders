package relicreminders

import basemod.BaseMod
import basemod.interfaces.EditStringsSubscriber
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer
import com.megacrit.cardcrawl.localization.UIStrings

@SpireInitializer
class RelicRemindersMod: EditStringsSubscriber {
    init {
        BaseMod.subscribe(this)
    }

    companion object {
        @JvmStatic
        fun initialize() {
            RelicRemindersMod()
        }
    }

    override fun receiveEditStrings() {
        BaseMod.loadCustomStringsFile(UIStrings::class.java, "relicreminders/localisation/ui_strings.json")
    }
}