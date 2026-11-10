package pl.twojnick.onlineosoby;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OnlineExpansion extends PlaceholderExpansion {

    private final OnlineOsoby plugin;

    public OnlineExpansion(OnlineOsoby plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "online";
    }

    @Override
    public @NotNull String getAuthor() {
        return "TwojNick";
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getPluginMeta().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer offlinePlayer, @NotNull String params) {
        if (!params.equalsIgnoreCase("osoby")) return null;

        Player player = offlinePlayer != null ? offlinePlayer.getPlayer() : null;
        if (player == null) {
            return String.valueOf(Bukkit.getOnlinePlayers().size());
        }

        String world = player.getWorld().getName();
        ConfigurationSection section = plugin.getConfig().getConfigurationSection("tryby");

        if (section != null) {
            for (String mode : section.getKeys(false)) {
                List<String> worlds = section.getStringList(mode);
                if (worlds.contains(world)) {
                    int count = 0;
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (worlds.contains(p.getWorld().getName())) count++;
                    }
                    return String.valueOf(count);
                }
            }
        }

        return String.valueOf(player.getWorld().getPlayerCount());
    }
}
