package tracker;

import org.junit.Test;
import org.junit.After;
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
 * @since 07.08.2019
 */
public class TrackerTest {
//    @Before
//    public void setVar(){
//        Item item1 = new Item("firstItem", "firstDescription", System.currentTimeMillis());
//        Item item2 = new Item("secondItem", "secondDescription", System.currentTimeMillis());
//        Item item3 = new Item("thirdItem", "thirdDescription", System.currentTimeMillis());
//        Item item4 = new Item("fourthItem", "fourthDescription", System.currentTimeMillis());
//        Item item5 = new Item("fifthItem", "fifthDescription", System.currentTimeMillis());
//
//    }
    /**
     * Test FindAll.
     */
    @Test
    public void FindAllWhenStorageIsEmpty(){
        Tracker tracker = new Tracker();
        assertThat("arr size should be equal to 0", tracker.findAll(), emptyArray());
    }
    @Test
    public void WhenAddOneItemThenStorageContainsOneItem(){
        Tracker tracker = new Tracker();
        Item item = new Item("firstItem", "firstDescription", System.currentTimeMillis());
        tracker.add(item);
        assertThat(tracker.findAll().length, is(1));
    }
    @Test
    public void WhenAddFiveItemThenStorageContainsFiveItems(){
        Tracker tracker = new Tracker();
        Item item1 = new Item("firstItem", "firstDescription", System.currentTimeMillis());
        Item item2 = new Item("secondItem", "secondDescription", System.currentTimeMillis());
        Item item3 = new Item("thirdItem", "thirdDescription", System.currentTimeMillis());
        Item item4 = new Item("fourthItem", "fourthDescription", System.currentTimeMillis());
        Item item5 = new Item("fifthItem", "fifthDescription", System.currentTimeMillis());
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
        Tracker tracker = new Tracker();
        tracker.add(null);
        assertThat("arr size should be equal to 0", tracker.findAll(), emptyArray());
    }
    @Test
    public void WhenAddNewItemTheStorageContainsTheSameItem(){
        Tracker tracker = new Tracker();
        Item item = new Item("firstItem", "firstDescription", System.currentTimeMillis());
        tracker.add(item);
        assertThat(tracker.findAll()[0].hashCode(), is(item.hashCode()));
    }
    @Test
    public void WhenAddThreeNewItemsTheStorageContainsSameItems(){
        Item item1 = new Item("firstItem", "firstDescription", System.currentTimeMillis());
        Item item2 = new Item("secondItem", "secondDescription", System.currentTimeMillis());
        Item item3 = new Item("thirdItem", "thirdDescription", System.currentTimeMillis());
        Tracker tracker = new Tracker();
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
    public void WhenFindById(){
        Item item1 = new Item("firstItem", "firstDescription", System.currentTimeMillis());
        Item item2 = new Item("secondItem", "secondDescription", System.currentTimeMillis());
        Item item3 = new Item("thirdItem", "thirdDescription", System.currentTimeMillis());
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById(item2.getId()), is(item2));
    }
    @Test
    public void WhenNotFoundById(){
        Item item1 = new Item("firstItem", "firstDescription", System.currentTimeMillis());
        Item item2 = new Item("secondItem", "secondDescription", System.currentTimeMillis());
        Item item3 = new Item("thirdItem", "thirdDescription", System.currentTimeMillis());
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        //assertThat(tracker.findById(item2.getId()), isNull());
        assertNull(tracker.findById(null));
    }
//    @Test
//    public void WhenAddNewItemOldItemIsDeleted(){
//        Item item1 = new Item("firstItem", "firstDescription", System.currentTimeMillis());
//        Item item2 = new Item("secondItem", "secondDescription", System.currentTimeMillis());
//        Item item3 = new Item("thirdItem", "thirdDescription", System.currentTimeMillis());
//        Tracker tracker = new Tracker();
//        Item expected[] = {item2, item3};
//        tracker.add(item1);
//        tracker.add(item2);
//        tracker.add(item3);
//        tracker.replace(, item2);
//    }
}
