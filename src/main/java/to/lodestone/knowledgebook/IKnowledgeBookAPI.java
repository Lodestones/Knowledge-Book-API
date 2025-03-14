package to.lodestone.knowledgebook;

import org.mongojack.JacksonMongoCollection;

public interface IKnowledgeBookAPI {

    <V> JacksonMongoCollection<V> getOrCreateCollection(Class<V> entityType);

}