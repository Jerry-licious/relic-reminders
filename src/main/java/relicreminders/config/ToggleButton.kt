package relicreminders.config

import basemod.ModLabeledToggleButton
import basemod.ModPanel
import com.megacrit.cardcrawl.core.Settings
import com.megacrit.cardcrawl.helpers.FontHelper
import relicreminders.RelicRemindersMod

class ToggleButton(labelText: String, x: Float, y: Float, val configKey: String, panel: ModPanel):
    ModLabeledToggleButton(labelText, x, y, Settings.CREAM_COLOR, FontHelper.charDescFont,
    RelicRemindersMod.config.getBool(configKey), panel, {}, { button ->
            RelicRemindersMod.config.setBool(configKey, button.enabled)
            RelicRemindersMod.config.save()
        })