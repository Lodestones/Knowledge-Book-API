package to.lodestone.knowledgebook;

import org.bukkit.plugin.java.JavaPlugin;
import to.lodestone.bookshelfapi.api.internal.ServiceProvider;

public class KBProvider extends ServiceProvider<IKnowledgeBookAPI> {

    public KBProvider(JavaPlugin plugin) {
        super(plugin, IKnowledgeBookAPI.class, "KnowledgeBookAPI");
    }

}
