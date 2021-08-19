package resources;

import POJO.reqBook;

public class Data {

	public reqBook addBookWith(String name, String isbn, String aisle, String author)
	{
		reqBook ab = new reqBook();
		ab.setName(name);
		ab.setIsbn(isbn);
		ab.setAisle(aisle);
		ab.setAuthor(author);
		return ab;
		
	}
}
