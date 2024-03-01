package zyculous.hypixelutils;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import zyculous.hypixelutils.mixin.client.OptionsMenu;

@Environment(EnvType.CLIENT)
public class HypixelUtilsClient implements ClientModInitializer {
	public static final String MODID = "hypixelutils";
    public static final KeyBinding GUI_KEY = new KeyBinding("key." + MODID + ".opengui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "key.categories." + MODID);


	public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        KeyBindingHelper.registerKeyBinding(GUI_KEY);

        ClientTickEvents.START_CLIENT_TICK.register((client) -> {
            if (GUI_KEY.wasPressed() && client.world != null && client.currentScreen == null) {
                client.setScreen(new OptionsMenu(client.currentScreen, client.options));
            }
        });

    }
}