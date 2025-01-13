package to.lodestone.knowledgebook;

import org.mongojack.JacksonMongoCollection;
import to.lodestone.bookshelfapi.api.internal.Service;

public interface IKnowledgeBookAPI {

    <V> JacksonMongoCollection<V> getOrCreateCollection(Class<V> entityType);

}