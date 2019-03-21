package com.automation;

public class ProductPage extends Common{

	public static void SearchProduct()
	{
		Common.click(Common.read("logo"), "xpath");
		Common.clear(Common.read("searchquery"), "id");
		Common.sendkeys(Common.read("searchquery"), "id", Common.read("searchvalue"));
		Common.wait(2);
		if(Common.isElementPresent(Common.read("instock"), "xpath"))
		{
			Common.mouseover(Common.read("instock"), "xpath");
			Common.wait(2);
			Common.click(Common.read("addtocart"), "xpath");
			Common.click(Common.read("ProceedToCheckout"), "xpath");
		}
		
		
		
	}
}
