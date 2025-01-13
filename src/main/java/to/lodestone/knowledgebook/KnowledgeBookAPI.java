package to.lodestone.knowledgebook;

public class KnowledgeBookAPI {

    private static IKnowledgeBookAPI api;

    public static void setApi(IKnowledgeBookAPI api) {
        KnowledgeBookAPI.api = api;
    }

    public static IKnowledgeBookAPI getApi() {
        return api;
    }
}
