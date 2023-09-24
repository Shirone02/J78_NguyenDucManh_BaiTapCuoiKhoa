package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		DataIO.root = "E:\\Hoc\\AppAndroid\\btvn_java";
		ArrayList<Book> listBook = DataIO.loadFile("book_data.txt");

		Scanner sc = new Scanner(System.in);
		int chon = -1;

		do {
			try {
				printMainMenu();
				System.out.print("Mời nhập lựa chọn: ");
				chon = sc.nextInt();
				switch (chon) {
				case 1:	
					int chonDisplay;
					do {
						printDisplayMenu();
						System.out.println("Mời nhập lựa chọn: ");
						chonDisplay = sc.nextInt();
						switch (chonDisplay) {
						case 1:
							DataProcessing.sortByCode(listBook);
							DataProcessing.printBook(listBook);
							break;
						case 2:
							DataProcessing.sortByTitle(listBook);
							DataProcessing.printBook(listBook);
							break;
						case 3:
							DataProcessing.sortByAuthor(listBook);
							DataProcessing.printBook(listBook);
							break;
						case 4:
							DataProcessing.sortByCategory(listBook);
							DataProcessing.printBook(listBook);
							break;
						case 5:
							DataProcessing.sortByYear(listBook);
							DataProcessing.printBook(listBook);
							break;
						case 0:
							break;
						default :
							System.out.println("Nhập sai !!! - Mời nhập lại: ");
						}
					} while (chonDisplay != 0);
					DataIO.saveFile("book_data.txt", listBook);
					break;
				case 2:
					int chonSearch;
					do {
						printSearchMenu();
						System.out.print("Mời nhập lựa chọn: ");
						ArrayList<Book> books = new ArrayList<>();
						Book book = new Book();
						chonSearch = sc.nextInt();
						switch (chonSearch) {
						case 1:
							book = DataProcessing.searchByCode(listBook);
							if (book != null) {
								System.out.println(book);
							} else {
								System.out.println("Không tìm thấy sách");
							}
							break;
						case 2:
							books = DataProcessing.searchByTitle(listBook);
							if (books != null) {
								DataProcessing.printBook(books);
							} else {
								System.out.println("Không tìm thấy sách");
							}
							break;
						case 3:
							books = DataProcessing.searchByAuthor(listBook);
							if (books != null) {
								DataProcessing.printBook(books);
							} else {
								System.out.println("Không tìm thấy sách");
							}
						case 0:
							break;
						default:
							System.out.println("Nhập sai !!! - Mời nhập lại: ");
						}
					} while (chonSearch != 0);
					DataIO.saveFile("book_data.txt", listBook);
					break;
				case 3:
					DataProcessing.addBook(listBook);
					DataProcessing.printBook(listBook);
					DataIO.saveFile("book_data.txt", listBook);
					break;
				case 4:
					DataProcessing.updateBook(listBook);
					DataIO.saveFile("book_data.txt", listBook);
					break;
				case 5:
					int chonDelete;
					do {
						printDeleteMenu();
						System.out.print("Mời nhập lựa chọn: ");
						chonDelete = sc.nextInt();
						DataProcessing.deleteBook(listBook, chonDelete);
					} while (chonDelete != 0);
					DataProcessing.printBook(listBook);
					DataIO.saveFile("book_data.txt", listBook);
					break;
				case 0:
					System.out.println("Đã thoát chương trình !!!");
					break;
				default:
					System.out.println("Nhập sai !!! - Mời nhập lại: ");
				}
			} catch (Exception e) {
				System.out.println("Lỗi: " + e.getMessage());
				sc = new Scanner(System.in);
			}
		} while (chon != 0);

	}

	public static void printMainMenu() {
		System.out.println("-----MENU-------");
		System.out.println("1. Hiển thị danh sách");
		System.out.println("2. Tìm kiếm");
		System.out.println("3. Thêm sách");
		System.out.println("4. Sửa thông tin sách");
		System.out.println("5. Xoá sách");
		System.out.println("0. Thoát");
	}

	public static void printSearchMenu() {
		System.out.println("---- SEARCH ----");
		System.out.println("1. Tìm theo mã sách");
		System.out.println("2. Tìm theo tựa sách");
		System.out.println("3. Tìm theo tên tác giả");
		System.out.println("0. Quay lại");
	}

	public static void printDeleteMenu() {
		System.out.println("---- DELETE ----");
		System.out.println("1. Xoá theo mã sách");
		System.out.println("2. Xoá theo tựa sách");
		System.out.println("3. Xoá theo tên tác giả");
		System.out.println("4. Xoá theo thể loại");
		System.out.println("5. Xoá theo năm xuất bản");
		System.out.println("0. Quay lại");
	}

	public static void printDisplayMenu() {
		System.out.println("---- DISPLAY ----");
		System.out.println("1. Hiển thị theo mã sách");
		System.out.println("2. Hiển thị theo tựa sách");
		System.out.println("3. Hiển thị theo tên tác giả");
		System.out.println("4. Hiển thị theo thể loại");
		System.out.println("5. Hiển thị theo năm xuất bản");
		System.out.println("0. Quay lại");
	}
}
