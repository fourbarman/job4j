package tracker;

import java.util.Random;
/**
 * TrackerSingleStatic.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 03.11.2019
 */
public class TrackerSingleStatic extends BaseTracker {
    private TrackerSingleStatic() {
    }

    public static TrackerSingleStatic getInstance() {
        return Holder.INSTANCE;
    }
    private static final class Holder {
        private static final TrackerSingleStatic INSTANCE = new TrackerSingleStatic();
    }
    /**
     * Item's storage.
     */
    private final Item[] items = new Item[100];

    /**
     * Cell pointer for a new Item.
     */
    private int position = 0;
    /**
     * Random.
     */

    private static final Random RN = new Random();

    /**
     * Generate ID.
     * Set creation time.
     * Adds Item to storage.
     *
     * @param item New Item.
     * @return Item.
     */
    @Override
    public Item add(Item item) {
        return super.add(item);
    }

    /**
     * Generate ID.
     *
     * @return ID.
     */
    String generateId() {
        return super.generateId();
    }

    /**
     * Replace Item by ID.
     *
     * @param id   ID.
     * @param item New Item.
     */
    public boolean replace(String id, Item item) {
        return super.replace(id, item);
    }

    /**
     * Delete Item by ID.
     *
     * @param id ID
     * @return if success
     */
    public boolean delete(String id) {
        return super.delete(id);
    }

    /**
     * Shows all Items.
     *
     * @return result[] All Items.
     */
    public Item[] findAll() {
        return super.findAll();
    }

    /**
     * Find Items by key.
     *
     * @param key Searching key.
     */
    public Item[] findByName(String key) {
        return super.findByName(key);
    }

    /**
     * Find Item by ID.
     *
     * @param id ID.
     */
    public Item findById(String id) {
        return super.findById(id);
    }
}