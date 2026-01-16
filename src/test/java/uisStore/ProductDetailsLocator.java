package uisStore;

import org.openqa.selenium.By;

public class ProductDetailsLocator {
	public By specification = By.xpath("(//h2[normalize-space()='Description & Specifications'])[1]");
    public By price=By.xpath("(//div[@class='f-price__sale']//span[@class='f-price-item f-price-item--sale'])[9]");
	public By plusButton=By.xpath("//button[@name='plus']");
	public By addToCartBtn=By.xpath("//button[@id='ProductSubmitButton-template--18553631703193__main']");
	public By yourCartPopup=By.xpath("//span[text()='Your cart']");
	public By orderNote=By.xpath("//button[.//span[normalize-space()='Order note']");
	public  By OrderNoteText=By.xpath("//textarea[@placeholder='Order special instructions']");
	public By Applybtn=By.xpath("(//button//span[text()='Apply'])[1]");
	public By checkOut=By.xpath("//button[@id='checkout2']");
}