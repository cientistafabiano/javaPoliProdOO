package app;

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

public class Applications {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//list of product
		List<Product> list = new ArrayList<>();
		
		System.out.print("Entre com o número de produtos: ");
		int n = sc.nextInt();
		for (int i=0;i<n;i++) {
			System.out.println("Dados do produto #" + (i+1));
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String name = sc.nextLine();
			System.out.print("Preço: ");
			double price = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Taxa personalizada: ");
				double customsFee = sc.nextDouble();
				ImportedProduct imp = new ImportedProduct(name, price, customsFee);
				list.add(imp);
			} else if (ch == 'u') {
				System.out.print("Data de fabricação (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				sc.nextLine(); 
				UsedProduct usedP = new UsedProduct(name, price, manufactureDate);
				list.add(usedP);		
			} else {
				Product prod = new Product(name, price);
				list.add(prod);
			}			
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();		
	}
}