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
        int index = -1;
        for (int i = 0; i <= this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                index = i;
            }
        }
        if (index != -1) {
            this.items[index] = item;
        }
    }

    /**
     * Deletes the Item.
     *
     * @param id Id of deleting Item.
     */
    public void delete(String id) {
        int index = -1;
        for (int i = 0; i <= this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                index = i;
            }
        }
        if (index != -1) {
            this.items[index] = null;
            System.arraycopy(this.items, index + 1, this.items, index, this.items.length - index - 1);
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
     * @return Item.
     */
    public Item[] findByName(String key) {
        int found = 0;
        for (int i = 0; i != this.position; i++) {
            if (items[i] != null && key != null && items[i].getName().contains(key)) {
                found++;
            }
        }
        Item[] result = new Item[found];
        for (int i = 0; i != found; i++) {
            if (items[i] != null && key != null && items[i].getName().contains(key)) {
                result[i] = items[i];
            }
        }
        return result;
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