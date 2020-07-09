package Utility;

import org.openqa.selenium.By;

public class Locators
{
	private By email;
	private By password;
	private By button;
	private By registerEmail;
	private By registerButton;
	private By mouse_hovering;
	private By signIn;
	private By chiffon_product;
	private By blouse;
	private By search_box;
	private By search_button;
	private By add_cart_button;
	private By continue_shopping_button;
	private By proceed_checkout_button;
	private By summary_checkout_button;
	private By shipping_proceed_button;
	private By agree_checkbox;
	private By payment_selector;
	private By confirm_order_button;
	private By gender_radio;
	private By first_name;
	private By last_name;
	private By pass_word;
	private By days;
	private By months;
	private By years;
	private By signup_checkbox;
	private By uniform_checkbox;
	private By address;
	private By city;
	private By state;
	private By postal_code;
	private By phone_number;
	private By alias;
	private By submit_button;
	private By newsletter_email;
	private By newsletter_submit;
	
	
	public By sign_In()
	{
		signIn = By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account'][@title='Log in to your customer account']");
		return signIn;
	}
	
	public By email_loc()
	{
		email = By.id("email");
		return email;
	}
	
	public By password_loc()
	{
		password = By.id("passwd");
		return password;
	}
	
	public By button_loc()
	{
		button = By.id("SubmitLogin");
		return button;
	}
	
	public By email_reg_loc()
	{
		registerEmail = By.xpath("//input[@id='email_create']");
		return registerEmail;
	}
	
	public By btn_reg_loc()
	{
		registerButton = By.xpath("//button[@id='SubmitCreate']");
		return registerButton;
	}
	
	public By mouse_hover()
	{
		mouse_hovering = By.xpath("//a[contains(@title,'Blouses')][text()='Blouses']");
		return mouse_hovering;
	}
	
	// locators for product purchase page
	
	public By chiffon_purchase()
	{
		chiffon_product = By.xpath("//img[@title='Printed Chiffon Dress']");
		return chiffon_product;
	}
	
	public By blouse_purchase()
	{
		blouse = By.xpath("//img[@title='Blouse']");
		return blouse;
	}
	
	public By search_locator()
	{
		search_box = By.xpath("//input[@id='search_query_top']");
		return search_box;
	}
	
	public By search_button_locator()
	{
		search_button = By.xpath("//button[@name='submit_search']");
		return search_button;
	}
	
	public By add_cart_locator()
	{
		add_cart_button = By.xpath("//span[text()='Add to cart']");
		return add_cart_button;
	}
	
	public By continue_shopping_locator()
	{
		continue_shopping_button = By.xpath("//span[@title='Continue shopping']");
		return continue_shopping_button;
	}
	
	public By proceed_checkout_locator()
	{
		proceed_checkout_button = By.xpath("//a[@title='Proceed to checkout']");
		return proceed_checkout_button;
	}
	
	public By summary_checkout_locator()
	{
		summary_checkout_button = By.xpath("//span[text()='Proceed to checkout']");
		return summary_checkout_button;
	}
	
	public By shipping_proceed_locator()
	{
		shipping_proceed_button = By.xpath("//button[@name='processCarrier']");
		return shipping_proceed_button;
	}
		
	public By agree_checkbox_locator()
	{
		agree_checkbox = By.xpath("//input[@id='cgv']");
		return agree_checkbox;
	}
	
	public By payment_selector_locator()
	{
		payment_selector = By.xpath("//a[@title='Pay by bank wire']");
		return payment_selector;
	}
	
	public By confirm_order_locator()
	{
		confirm_order_button = By.xpath("//span[text()='I confirm my order']");
		return confirm_order_button;
	}
	
	// end of productpurchase page
	
	public By gender_locator()
	{
		gender_radio = By.xpath("//input[@id='id_gender1']");
		return gender_radio;
	}
	
	public By firstname_locator()
	{
		first_name = By.xpath("//input[@id='customer_firstname']");
		return first_name;
	}
	
	public By lastname_locator()
	{
		last_name = By.xpath("//input[@id='customer_lastname']");
		return last_name;
	}
	
	public By day_locator()
	{
		days = By.id("days");
		return days;
	}
	
	public By month_locator()
	{
		months = By.id("months");
		return months;
	}
	
	public By year_locator()
	{
		years = By.id("years");
		return years;
	}
	
	public By signup_locator()
	{
		signup_checkbox = By.id("newsletter");
		return signup_checkbox;
	}
	
	public By uniform_locator()
	{
		uniform_checkbox = By.id("uniform-optin");
		return uniform_checkbox;
	}
	
	public By address_locator()
	{
		address = By.xpath("//input[@id='address1']");
		return address;
	}
	
	public By city_locator()
	{
		city = By.xpath("//input[@id='city']");
		return city;
	}
	
	public By state_locator()
	{
		state = By.id("id_state");
		return state;
	}
	
	public By postalCode_locator()
	{
		postal_code = By.xpath("//input[@id='postcode']");
		return postal_code;
	}
	
	public By phonenumber_locator()
	{
		phone_number = By.xpath("//input[@id='phone_mobile']");
		return phone_number;
	}
	
	public By alias_locator()
	{
		alias = By.xpath("//input[@id='alias']");
		return alias;
	}
	
	public By submitButton_locator()
	{
		submit_button = By.id("submitAccount");
		return submit_button;
	}
	
	//newsletter locators
	
	public By newsletter_email_locator()
	{
		newsletter_email = By.id("newsletter-input");
		return newsletter_email;
	}
	
	public By newsletter_submit_locator()
	{
		newsletter_submit = By.name("submitNewsletter");
		return newsletter_submit;
	}
}
