package testdataobject;


public class Pet {
	
	public int id;
	public String name;
	public Category category;
	public String[] photoUrls;
	public Tag[] tags;
	public String status;
	
	public Pet() { }
	
	public Pet(int id, String name, Category category, String[] photoUrls, Tag[] tags, String status) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}
}
