package luaManager;

import org.luaj.vm2.*;
import org.luaj.vm2.lib.jse.*;

public class LuaGame {

    public static void Load(String game) {
        String gamePath = "PaperEngineGames/games/" + game;
        Globals globals = JsePlatform.standardGlobals();
        LuaValue chunk = globals.loadfile("config.lua");
        //Load game/{game}/config.lua
        String[] assets = {}; //Load assets to array from config.lua
        for(int i = 0; 0 < assets.length; i++) {
            //Load assets/{assets[i]}/config.lua and load in the textures and audio
        }
    }
}
