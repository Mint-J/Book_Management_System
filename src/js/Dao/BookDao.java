package js.Dao;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

import js.Bean.Book;
import js.Exception.BookNotFoundException;
import js.Utils.XmlUtils;

public class BookDao {

	public void add(Book book) {

		try {

			Document document = XmlUtils.getDocument();

			Element book_tag = document.createElement("book");
			book_tag.setAttribute("ID", book.getId());

			Element name = document.createElement("name");
			Element price = document.createElement("price");
			Element author = document.createElement("author");
			Element date = document.createElement("date");

			name.setTextContent(book.getName());
			price.setTextContent(book.getPrice() + "");
			author.setTextContent(book.getAuthor());
			date.setTextContent(book.getDate() + "");

			book_tag.appendChild(name);
			book_tag.appendChild(price);
			book_tag.appendChild(author);
			book_tag.appendChild(date);

			document.getElementsByTagName("BOOK").item(0).appendChild(book_tag);

			XmlUtils.writeToDocument(document);

			System.out.println("---Addition Successful!---");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public Book find(String id) {

		try {

			Document document = XmlUtils.getDocument();

			NodeList list = document.getElementsByTagName("book");
			for (int i = 0; i < list.getLength(); i++) {
				Element book_tag = (Element) list.item(i);
				if (book_tag.getAttribute("ID").equalsIgnoreCase(id)) {
					Book b = new Book();
					b.setId(id);
					b.setAuthor(book_tag.getElementsByTagName("author").item(0).getTextContent());
					b.setDate(Double.parseDouble(book_tag.getElementsByTagName("date").item(0).getTextContent()));
					b.setName(book_tag.getElementsByTagName("name").item(0).getTextContent());
					b.setPrice(Double.parseDouble(book_tag.getElementsByTagName("price").item(0).getTextContent()));
					return b;
				}
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public String delete(String name) throws BookNotFoundException {

		try {
			Document document = XmlUtils.getDocument();
			NodeList list = document.getElementsByTagName("name");
			for (int i = 0; i < list.getLength()-1; i++) {
				if (list.item(i).getTextContent().equals(name)) {
					list.item(i).getParentNode().getParentNode().removeChild(list.item(i).getParentNode());
					XmlUtils.writeToDocument(document);
					return "Delete Successfully!";
				}
			}
			throw new BookNotFoundException("Delete Failed!");
		} catch (BookNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
