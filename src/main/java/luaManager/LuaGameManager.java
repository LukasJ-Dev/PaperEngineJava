package luaManager;

import engine.IApplication;

public class LuaGameManager implements IApplication {

    public String game = "flappybird";
    @Override
    public void init()  {
        LuaGame.Load(game);
    }

    @Override
    public void render() {

    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void input() {

    }
}
