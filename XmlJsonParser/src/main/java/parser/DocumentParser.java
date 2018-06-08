package parser;

/**
 * Created by Denis on 08.06.2018.
 */
public interface DocumentParser<T, K> {
    T parseDocument(K doc);
}
