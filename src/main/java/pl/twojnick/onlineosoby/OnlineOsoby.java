package pl.twojnick.onlineosoby;

import org.bukkit.plugin.java.JavaPlugin;

public final class OnlineOsoby extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        new OnlineExpansion(this).register();
        getLogger().info("Placeholder %online_osoby% zarejestrowany.");
    }
}
