package to.lodestone.knowledgebook;

import org.bukkit.plugin.java.JavaPlugin;

public class KBHook {

    private final IKnowledgeBookAPI api;

    public KBHook(JavaPlugin plugin) {
        KBProvider provider = new KBProvider(plugin);
        this.api = provider.service();
    }

    public IKnowledgeBookAPI api() {
        return api;
    }

}
