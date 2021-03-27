package com.ibm.shop;

import com.ibm.bank.BalanceException;

public class ShoppingCart {
	
	private double cartTotal;
	private  Product[] items;
	private int idx;
	
	
	String [][] coupns = {{"HOLI200", "200"},{"WKND100","100"},{"APRIL150","150"}};
	
	public ShoppingCart() {
		items = new Product[5];
	}

	public void addProduct(Product p) throws OutOfStockException {
		
		if (idx < items.length) {
			
			if (p.getStock()>=1) {
				p.setStock(p.getStock() - 1)  ;
				items[idx++] = p;
				cartTotal += p.getPrice();
			}
			else if (p.getStock()==0) {
				//throw new OutOfStockException("Product out of stock");
				System.out.println("Product out of stock");
			}
			
		} 
		else {
			System.out.println("Your cart is full");
		}
		
	}
	
	public void checkout(Payment pmt, String code) throws PaymentDeniedException{
		if (idx == 0)
			System.out.println("your cart is empty");
		else{
				System.out.println("Products in your cart : ");
				for (int i=0; i<idx; i++) {
					System.out.println(items[i].getName() +" : "+ items[i].getPrice());
				} 
				System.out.println("Your cart total is " + cartTotal);
				
				System.out.println();
				System.out.println("------ Proceeding to Payment -------");
				System.out.println("Your Account Number is : " + pmt.getAcntNo());
				
				
				if (cartTotal >= 300 && pmt.getBalance() > cartTotal) {
					
					
					for (int i=0; i<coupns.length; i++) {
						for (int j=0; j<coupns[i].length; j++) 
						{
							if (code == coupns[i][0]) {
								cartTotal = cartTotal - Integer.parseInt(coupns[i][1]);
								System.out.println("Your cart total after applying " + code + " is " + cartTotal);
								break;
							}
							else if (code == coupns[i][0]) {
								cartTotal = cartTotal - Integer.parseInt(coupns[i][1]);
								System.out.println("Your cart total after applying " + code + " is " + cartTotal);
								break;
							}
							else if (code == coupns[i][0]) {
								cartTotal = cartTotal - Integer.parseInt(coupns[i][1]);
								System.out.println("Your cart total after applying " + code + " is " + cartTotal);
								break;
							}
					
						} 
					}
					
				}
				
				else if (pmt.getBalance() < cartTotal) {
					System.out.println("Insufficient balance in your accountc " + pmt.getBalance());
				}
				else {
					System.out.println("Your final cart total is " + cartTotal);
				}
				
			}
	}
		
}
