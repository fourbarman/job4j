package tracker.start;

import tracker.models.*;

import java.util.*;

/**
 * Tracker.
 * Stores items.
 *
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 26.10.2018.
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Adds new Item to storage.
     *
     * @param item Item to add.
     * @return Item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Replaces old Item with new.
     *
     * @param id   Id of new Item.
     * @param item new Item to replace.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < this.position; i++) {
            if (item != null && this.items[i].getId().equals(id)) {
                this.items[i] = item;
                item.setId(id);
                break;
            }
        }
    }

    /**
     * Deletes the Item.
     *
     * @param id Id of deleting Item.
     */
    public void delete(String id) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = null;
                System.arraycopy(this.items, i + 1, this.items, i, this.position - i - 1);
                this.position--;
                break;
            }
        }
    }

    /**
     * Gets all items.
     *
     * @return array of items.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, position);
    }

    /**
     * Searches item by id.
     *
     * @param id Id of item for searching.
     * @return Item.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Searches item by keyword.
     *
     * @param key Keyword for searching
     * @return Items array.
     */
    public Item[] findByName(String key) {
        int found = 0;
        Item[] result = new Item[this.items.length];
        for (int i = 0; i < this.position; i++) {
            if (items[i] != null && key != null && items[i].getName().contains(key)) {
                result[found] = this.items[i];
                found++;
            }
        }
        return Arrays.copyOf(result, found);
    }

    /**
     * Random generate id for item.
     * Generates with current time in millis and random int.
     *
     * @return Id.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}