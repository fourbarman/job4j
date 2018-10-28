package tracker.models;

/**
 * Item fo Tracker task.
 * Represents Items.
 * @author fourbarman (maks.java@yandex.ru).
 * @version 1.
 * @since 26.10.2018.
 */
public class Item {
	private String id;
	private String name;
	private String description;
	private long create;

    /**
     * Default constructor.
     */
	public Item() {
	}

    /**
     * Constructor for Item with parameters.
     * @param name Item name.
     * @param description Item description.
     * @param create Creation time.
     */
	public Item(String name, String description, long create) {
		this.name = name;
		this.description = description;
		this.create = create;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setCreate(long create) {
		this.create = create;
	}
	
	public long getCreate() {
		return this.create;
	}
}