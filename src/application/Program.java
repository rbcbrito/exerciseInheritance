package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char commonUsedImported = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Price: ");
			Double priceProduct = sc.nextDouble();
			if(commonUsedImported == 'i') {
				System.out.print("Customs fee: ");
				Double CunstomFeeProduct = sc.nextDouble();
				list.add(new ImportedProduct(nameProduct, priceProduct, CunstomFeeProduct));
			}
			else if(commonUsedImported == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(nameProduct, priceProduct, manufactureDate));
			}
			else {
				list.add(new Product(nameProduct, priceProduct));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		
		//foreach com lambda
		list.forEach(c -> System.out.println(c.priceTag()));
		
		sc.close();
		
	}

}
