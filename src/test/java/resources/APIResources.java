package resources;

public enum APIResources {

	add("/Library/Addbook.php"),
	delete("/Library/DeleteBook.php"),
	get("/Library/GetBook.php");
	private String resource;
	APIResources(String resource) {
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}
