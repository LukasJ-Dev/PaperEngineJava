package luaManager;

import engine.KeyCode;
import engine.PaperEngine;
import engine.manager.ResourceManager;
import engine.renderer.Camera;
import engine.renderer.SpriteRenderer;
import engine.renderer.Texture;
import org.luaj.vm2.*;
import org.luaj.vm2.lib.jse.*;

public class LuaGame {

    static Globals mainGlobals;
    static LuaValue mainChunk;

    public static void Load(String game, SpriteRenderer spriteRenderer, Camera camera) {
        String gamePath = "PaperEngineGames/games/" + game;

        Globals globals = JsePlatform.standardGlobals();
        LuaValue configChunk = globals.loadfile(gamePath + "/config.lua");
        //Load game/{game}/config.lua
        configChunk.call();

        LuaTable configTable = globals.get("config").checktable();

        PaperEngine.window.setTitle(configTable.get("title").toString());

        LuaTable assets = globals.get("assets").checktable();
        //Load assets to array from config.lua
        for(int i = 1; i < assets.length()+1; i++) {
            LuaValue assetChunk = globals.loadfile( "PaperEngineGames/assets/" + assets.get(i) + "/assets.lua");
            assetChunk.call();
            LuaTable textures = globals.get("textures").checktable();
            //Load assets/{assets[i]}/config.lua and load in the textures and audio
            for(int c = 1; c < textures.length()+1; c++) {
                String name = textures.get(c).checktable().get(1).toString();
                String texturePathName = textures.get(c).checktable().get(2).toString();
                ResourceManager.get().setTexture(name, new Texture("PaperEngineGames/assets/"+game+"/"+texturePathName));
            }
        }

        mainGlobals = JsePlatform.standardGlobals();

        LuaPaperEngine.get().setSpriteRenderer(spriteRenderer);
        LuaCamera.get().setCamera(camera);

        LuaValue luaPaper = CoerceJavaToLua.coerce(LuaPaperEngine.get());
        LuaValue luaInput = CoerceJavaToLua.coerce(PaperEngine.input);
        LuaValue luaKeyCode = CoerceJavaToLua.coerce(new KeyCode());
        LuaValue luaCamera = CoerceJavaToLua.coerce(LuaCamera.get());

        mainGlobals.set("paper", luaPaper);
        mainGlobals.set("input", luaInput);
        mainGlobals.set("keycode", luaKeyCode);
        mainGlobals.set("camera", luaCamera);

        mainChunk = mainGlobals.loadfile(gamePath + "/main.lua");

        mainChunk.call();

    }

    public static void init() {
        mainGlobals.get("init").call();
    }

    public static void render() {
        mainGlobals.get("render").call();
    }

    public static void update(double delta) {
        mainGlobals.get("update").call(LuaValue.valueOf(delta));
    }




}
