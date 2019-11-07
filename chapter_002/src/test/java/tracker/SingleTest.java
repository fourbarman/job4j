package tracker;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import javax.sound.midi.Track;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.emptyArray;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author fourbarman (mailto:maks.java@yandex.ru)
 * @version 1
 * @since 03.11.2019
 */

public class SingleTest {
    /**
     * Test When Tracker is not Singleton.
     */
    @Test
    public void whenTrackerNotSingle() {
        Tracker tracker = new TrackerNotSingle();
        Tracker tracker2 = new TrackerNotSingle();
        assertNotEquals(tracker, tracker2);
    }

    /**
     * Test When Tracker Enum Singleton.
     */
    @Test
    public void whenTrackerSingleEnum() {
        Tracker tracker = TrackerSingleEnum.INSTANCE;
        Tracker tracker2 = TrackerSingleEnum.INSTANCE;
        assertEquals(tracker, tracker2);
    }

    /**
     * Test When Tracker Lazy loading Singleton.
     */
    @Test
    public void whenTrackerSingleLazy() {
        Tracker tracker = TrackerSingleLazy.getInstance();
        Tracker tracker2 = TrackerSingleLazy.getInstance();
        assertEquals(tracker, tracker2);
    }

    /**
     * Test When Tracker Eager loading Singleton.
     */
    @Test
    public void whenTrackerSingleEager() {
        Tracker tracker = TrackerSingleEager.getInstance();
        Tracker tracker2 = TrackerSingleEager.getInstance();
        assertEquals(tracker, tracker2);
    }

    /**
     * Test When Tracker Lazy loading Singleton static final class.
     */
    @Test
    public void whenTrackerSingleLazyStaticFinalClass() {
        Tracker tracker = TrackerSingleStatic.getInstance();
        Tracker tracker2 = TrackerSingleStatic.getInstance();
        assertEquals(tracker, tracker2);
    }
}
