package js.Test;

import org.junit.jupiter.api.Test;

import js.Bean.Book;
import js.Dao.BookDao;
import js.Exception.BookNotFoundException;

public class TestBookDao {
	@Test
	public void AddTest() {
		Book book = new Book();
		book.setAuthor("Jason");
		book.setDate(2018);
		book.setId("6");
		book.setName("Mybatis");
		book.setPrice(129.9);
		BookDao dao = new BookDao();
		dao.add(book);
	}
	@Test
	public void FindTest(){
		BookDao dao = new BookDao();
		dao.find("8");
	}
	@Test
	public void DeleteTest() throws BookNotFoundException {
		BookDao dao = new BookDao();
		dao.delete("Mybatis");
	}
}
