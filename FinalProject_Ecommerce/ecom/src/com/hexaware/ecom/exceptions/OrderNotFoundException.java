package com.hexaware.ecom.exceptions;

/**
 * Author: Kariyappa D C, Eshwar Reddy V
 * Date: October 14, 2024
 * Description: This class defines a custom exception that is thrown when a order 
 * is not found in the e-commerce system. It extends the RuntimeException and provides 
 * an appropriate message when triggered.
 */

public class OrderNotFoundException extends RuntimeException {
	public OrderNotFoundException(String message) {
        super(message);
    }
}
