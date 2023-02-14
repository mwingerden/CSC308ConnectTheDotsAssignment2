/**
 * The Observer interface to have the observer be updated.
 *
 * @author Matthew Wingerden
 * @version 1.0
 * @since 2023-2-13
 *
 */
public interface Observer {
    void update(boolean cluster, boolean connect);
}
