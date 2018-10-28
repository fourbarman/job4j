package tracker.models;

public class Task extends Item {
	public Task(String name, String desc) {
		this.setName(name);
		this.setDescription(desc);
	}
}