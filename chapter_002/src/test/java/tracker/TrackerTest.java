package tracker;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.emptyArray;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 12.08.2019
 */
public class TrackerTest {
    Tracker tracker;
    Item item1, item2, item3, item4, item5, newItem;
    @Before
    public void setVar() {
        tracker = new Tracker();
        item1 = new Item("firstItem", "firstDescription");
        item2 = new Item("secondItem", "secondDescription");
        item3 = new Item("thirdItem", "thirdDescription");
        item4 = new Item("fourthItem", "fourthDescription");
        item5 = new Item("fifthItem", "fifthDescription");
        newItem = new Item("newItem", "newDescription");
    }
    /**
     * Test FindAll.
     */
    @Test
    public void FindAllWhenStorageIsEmpty(){
        assertThat(tracker.findAll(), emptyArray());
    }
    @Test
    public void WhenAddOneItemThenStorageContainsOneItem(){
        tracker.add(item1);
        assertThat(tracker.findAll().length, is(1));
    }
    @Test
    public void WhenAddFiveItemThenStorageContainsFiveItems(){
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        assertThat(tracker.findAll().length, is(5));
    }
    /**
     * Test add.
     */
    @Test
    public void WhenAddNewNullItemTheStorageIsEmpty(){
        tracker.add(null);
        assertThat("arr size should be equal to 0", tracker.findAll(), emptyArray());
    }
    @Test
    public void WhenAddNewItemTheStorageContainsTheSameItem(){
        Item item = new Item("firstItem", "firstDescription");
        tracker.add(item);
        assertThat(tracker.findAll()[0].hashCode(), is(item.hashCode()));
    }
    @Test
    public void WhenAddThreeNewItemsTheStorageContainsSameItems(){
        Item expected[] = {item1, item2, item3};
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findAll(), is(expected));
    }
    /**
     * Test findById.
     */
    @Test
    public void WhenFoundById(){
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById(item2.getId()), is(item2));
    }
    @Test
    public void WhenNotFoundByNullId(){
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertNull(tracker.findById(null));
    }
    @Test
    public void WhenNotFoundByWrongId(){
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertNull(tracker.findById("testId"));
    }
    /**
     * Test findByName.
     */
    @Test
    public void WhenFoundByNameThenReturnOneItem() {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName(item2.getName()).length, is(1));
    }
    @Test
    public void WhenFoundBySameNameThenReturnSameItems() {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        assertThat(tracker.findByName("Item").length, is(5));
    }
    @Test
    public void WhenFoundByNameReturnTheSameItem(){
        Item expected[] = {item2};
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName(item2.getName()), is(expected));
    }
    @Test
    public void WhenNotFoundByWrongNameReturnsEmptyArray(){
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName("testName"), emptyArray());
    }
    /**
     * Test delete.
     */
    @Test
    public void WhenDeleteItemThenSuccess(){
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.delete(item2.getId()),is(true));
    }
    @Test
    public void WhenDeleteItemThenStorageDoesNotContainIt(){
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        assertThat(tracker.findAll().length,is(2));
    }
    @Test
    public void WhenDeleteItemThenMoveNextItemOnDeletedPlace(){
        Item expected[] = {item1, item3, item4, item5};
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        tracker.delete(item2.getId());
        assertThat(tracker.findAll(),is(expected));
    }
    @Test
    public void WhenDeleteItemWithWrongIdThenReturnFalse() {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.delete("wrong id"),is(false));
    }
    @Test
    public void WhenDeleteItemWithWrongIdThenStorageNotChanged() {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item expected[] = tracker.findAll();
        tracker.delete("wrong id");
        assertThat(tracker.findAll(), is(expected));
    }
    /**
     * Test replace.
     */
    @Test
    public void WhenReplaceItemThenStorageHasSameNumberOfItems() {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.replace(item2.getId(), newItem);
        assertThat(tracker.findAll().length, is(3));
    }
    @Test
    public void WhenReplaceItemThenSuccess(){
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.replace(item2.getId(), newItem),is(true));
    }
    @Test
    public void WhenReplaceItemThenNewItemOnTheReplacedPosition(){
        newItem.setId(item2.getId());
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.replace(item2.getId(), newItem);
        assertThat(tracker.findById(item2.getId()).getName(), is("newItem"));
    }
}
