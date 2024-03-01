package zyculous.hypixelutils.mixin.client;



import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class OptionsMenu extends Screen{
    private final Screen parent;
    private final GameOptions settings;
    public OptionsMenu(Screen parent, GameOptions settings) {
        super(Text.of("HypixelUtils Options"));
        this.parent = parent;
        this.settings = settings;
    }

    protected void init(){
        this.addDrawableChild(ButtonWidget.builder(Text.of("Press this"), (button) -> {
            client.player.sendMessage(Text.of("You pressed the button"), false);
        }).dimensions(this.width /2, 10, 50, 200).build());
    }

}
