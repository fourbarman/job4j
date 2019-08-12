package tracker;

import java.lang.*;
import java.util.Arrays;
/**
 * Tracker.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 12.08.2019
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     * @return item .
     */
    public Item add(Item item) {
        if(item != null) {
            item.setId(this.generateId());
            item.setTime(System.currentTimeMillis());
            this.items[this.position++] = item;
        }
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * Генерирует ID при помощи текущего времени в миллисекундах плюс случайное число от 0 до 10,
     * что дает низкую вероятность коллизии в ID.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf((int)System.currentTimeMillis() + (int)(Math.random()*10));
    }

    /**
     * Метод реализущий замену заявки по ID
     * @param id идентификатор заявки
     * @param item новая заявка
     */
    public boolean replace(String id, Item item){
        boolean success = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i]!=null && this.items[i].getId().equals(id)) {
                item.setTime(System.currentTimeMillis());
                item.setId(id);
                this.items[i] = item;
                success = true;
            }
        }
        return success;
    }

    /**
     * Метод реализущий удаление заявки
     * @param id идентификатор удаляемой заявки
     */
    public boolean delete(String id){
        boolean success = false;
        for (int i = 0; i < this.position; i++){
            if (items[i].getId().equals(id)){
                items[i] = null;
                System.arraycopy(this.items, i + 1, this.items, i, this.position - i - 1);
                this.position--;
                success = true;
            }
        }
        return success;
    }

    /**
     * Метод реализаущий вывод всех заявок
     * @return result[] массив всех заявок
     */
    public Item[] findAll(){
        return Arrays.copyOf(this.items, position);
    }

    /**
     * Метод реализаущий поиск по ключу
     * @param key ключ для поиска
     */
    public Item[] findByName(String key){
        Item result[] = new Item[this.items.length];
        int found = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i]!=null && key!=null && this.items[i].getName().contains(key)) {
                result[found] = items[i];
                found++;
            }
        }
        return Arrays.copyOf(result, found);
    }

    /**
     * Метод реализаущий поиск по ID
     * @param id идентификатор
     */
    public Item findById(String id){
        Item item = null;
        for (int i = 0; i < items.length; i++){
            if (items[i]!=null && items[i].getId().equals(id)) {
                item = items[i];
            }
        }
        return item;
    }
}
