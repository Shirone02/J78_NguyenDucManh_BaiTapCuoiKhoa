package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

public class DataProcessing {

	public static void addBook(ArrayList<Book> books) {
		//, String code, String title, String author, String category, String year
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập mã sách: ");
		String code = sc.nextLine();
		
		for(Book book : books) {
			if(book.getCode().equals(code)) {
				System.out.println("Mã đã tồn tại");
				return;
			}
		}
		
		System.out.println("Mời nhập tựa sách: ");
		String title = sc.nextLine();
		System.out.println("Mời nhập tên tác giả: ");
		String author = sc.nextLine();
		System.out.println("Mời nhập thể loại: ");
		String category = sc.nextLine();
		System.out.println("Mời nhập năm xuất bản: ");
		String year = sc.nextLine();
		
		
		Book book = new Book(code, title, author, category, year);
		books.add(book);
		
		System.out.println("Thêm thành công !!!");
	}

	public static void deleteBook(ArrayList<Book> books, int chon) {
		Scanner sc = new Scanner(System.in);
		int size = books.size();
		switch (chon) {
		case 1:
			System.out.println("Mời nhập mã sách: ");
			String code = sc.nextLine();
			books.removeIf(book -> book.getCode().equals(code));
			
			break;
		case 2:
			System.out.println("Mời nhập tựa sách: ");
			String title = sc.nextLine();
			books.removeIf(book -> book.getTitle().equals(title));
	
			break;
		case 3:
			System.out.println("Mời nhập tên tác giả: ");
			String author = sc.nextLine();
			books.removeIf(book -> book.getAuthor().equals(author));
			
			break;
		case 4:
			System.out.println("Mời nhập thể loại: ");
			String category = sc.nextLine();
			books.removeIf(book -> book.getCategory().equals(category));
			
			break;
		case 5:
			System.out.println("Mời nhập năm xuất bản: ");
			String year = sc.nextLine();
			books.removeIf(book -> book.getYear().equals(year));
		
			break;
		case 0:
			break;
		default:
			System.out.println("Nhập sai !!! - Mời nhập lại: ");
		}
		if(books.size() < size) {
			System.out.println("Xoá thành công !!!");
		} else {
			System.out.println("Xoá thất bại !!!");
		}
	}

	public static void updateBook(ArrayList<Book> books) {
		Scanner sc = new Scanner(System.in);	
		Book bookToUpdate = searchByCode(books);
		
		if (bookToUpdate != null) {
			System.out.println("Mời nhập tựa sách mới: ");
			String title = sc.nextLine();
			System.out.println("Mời nhập tên tác giả mới: ");
			String author = sc.nextLine();
			System.out.println("Mời nhập thể loại mới: ");
			String category = sc.nextLine();
			System.out.println("Mời nhập năm xuất bản mới: ");
			String year = sc.nextLine();
			
			for (Book book : books) {
				if (book.getCode().equals(bookToUpdate.code)) {
					book.title = title;
					book.author = author;
					book.category = category;
					book.year = year;
					break;
				}
			}
			System.out.println("Cập nhật thành công !!!");
			DataProcessing.printBook(books);
		}else {
			System.out.println("Không tìm thấy mã sách để cập nhật");;
		}
	}

	public static void sortByCode(ArrayList<Book> books) {
		books.sort((o1, o2) -> {
			int code1 = Integer.parseInt(o1.getCode());
			int code2 = Integer.parseInt(o2.getCode());
			return Integer.compare(code1, code2);
		});
	}

	public static void sortByTitle(ArrayList<Book> books) {
		books.sort(Comparator.comparing(Book::getTitle));
//		books.sort((o1,o2) -> {
//			String title1 = o1.getTitle();
//			String title2 = o2.getTitle();
//			return title1.compareTo(title2);
//		});
	}

	public static void sortByAuthor(ArrayList<Book> books) {
		books.sort(Comparator.comparing(Book::getAuthor));
	}

	public static void sortByCategory(ArrayList<Book> books) {
		books.sort(Comparator.comparing(Book::getCategory));
	}

	public static void sortByYear(ArrayList<Book> books) {
		books.sort((o1, o2) -> {
			int year1 = Integer.parseInt(o1.getYear());
			int year2 = Integer.parseInt(o2.getYear());
			return Integer.compare(year2, year1);
		});
	}

	public static Book searchByCode(ArrayList<Book> books){
		 //String code
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập mã sách: ");
		String code = sc.nextLine();
		
		for (Book book : books ) {
			if(book.getCode().equals(code)) {
				return book;
			}
		}
		return null;
		
	}
	public static ArrayList<Book> searchByTitle(ArrayList<Book> books){
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập tựa sách: ");
		String keyword = sc.nextLine();
		
		ArrayList<Book> list = new ArrayList<>();
		for (Book book : books) {
			String title = book.getTitle().toLowerCase();
			keyword = keyword.toLowerCase();
			if(title.contains(keyword)) {	
				list.add(book);
			}
		}
		return list;
			
	}
	
	public static ArrayList<Book> searchByAuthor(ArrayList<Book> books){
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập tên tác giả: ");
		String keyword = sc.nextLine();
		
		ArrayList<Book> list = new ArrayList<>();
		for (Book book : books) {
			String author = book.getTitle().toLowerCase();
			keyword = keyword.toLowerCase();
			if(author.contains(keyword)) {
				list.add(book);
			}
		}
		return list;
	}
	
	public static void printBook(ArrayList<Book> Data) {
		System.out.format("%6s | %25s | %20s | %15s | %5s |","MÃ SÁCH ", "TỰA SÁCH ", "TÊN TÁC GIẢ ", "THỂ LOẠI ", "NĂM " );
		System.out.println();
		for (Book t : Data) {
			t.printBookInfo();
		}	
	}
}
