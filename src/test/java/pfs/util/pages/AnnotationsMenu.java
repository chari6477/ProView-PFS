package pfs.util.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pfs.util.helpers.BaseObject;
import pfs.util.helpers.PropertyReader;

public class AnnotationsMenu extends BaseObject{
	PropertyReader properties = new PropertyReader();

	/**
	 * This method constructs the Object of <b>AnnotationsMenu</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public AnnotationsMenu(WebDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>AnnotationsMenu_Btn_ID</b>.
	 */
	public WebElement annotationsMenu(){
		return findWebElementFromPropertyName("AnnotationsMenu_Btn_ID");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>AnnotationsMenu_DeleteAnnotationBtn_XPATH</b>.
	 */
	public WebElement deleteAnnotationBtn(){
		return findWebElementFromPropertyName("AnnotationsMenu_DeleteAnnotationBtn_XPATH");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>AnnotationsMenu_AnnotationEntry_CSS</b>.
	 */
	public WebElement annotationEntry(){
		return findWebElementFromPropertyName("AnnotationsMenu_AnnotationEntry_CSS");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @param color Should be one among the following - <b>all</b>, <b>green</b>, <b>yellow</b>, <b>blue</b>, <b>purple</b>, <b>pink</b>, <b>orange</b>, <b>black</b>. 
	 * @return WebElement for the property named <b>AnnotationsMenu_ColorFilterOptions_XPATH</b>.
	 */
	public WebElement colorFilterOptions(String color){
		return findWebElementFromPropertyName("AnnotationsMenu_ColorFilterOptions_XPATH", color);
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @param category Should be one among the following - <b>All</b>, <b>Bookmarks</b>, <b>Highlights</b> and <b>Notes</b>.
	 * @return WebElement for the property named <b>AnnotationsMenu_ButtonBarOptions_ID</b>.
	 */
	public WebElement buttonBarOptions(String category){
		return findWebElementFromPropertyName("AnnotationsMenu_ButtonBarOptions_ID", category);
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>AnnotationsMenu_ColorFilterBtn_ID</b>.
	 */
	public WebElement colorFilterBtn(){
		return findWebElementFromPropertyName("AnnotationsMenu_ColorFilterBtn_ID");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>AnnotationsMenu_ColorFilterBtn_ID</b>.
	 */
	public WebElement showDisplacedAnnotationsBtn(){
		return findWebElementFromPropertyName("AnnotationsMenu_ShowDisplacedAnnotationsBtn_ID");
	}

	/**
	 * This method deletes an annotation by clicking on <b>Delete</b> button which will be displayed when we hover on particular annotation.
	 * @throws InterruptedException
	 */
	public void deleteAnnotation() throws InterruptedException
	{
		moveToWebElement(annotationEntry());
		//moveToWebElement(deleteAnnotationBtn());
		clickWebElement(deleteAnnotationBtn());
	}

	public void deleteAnnotations() throws InterruptedException
	{
		moveToWebElement(driver.findElement(By.xpath("//div[@id='annotations'][2]")));
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("//img[contains(@src,'delete_button')]")).click();
	}

	/**
	 * Filters the annotations within the Annotations menu by a give color.
	 * @param color Should be one among the following - <b>all</b>, <b>green</b>, <b>yellow</b>, <b>blue</b>, <b>purple</b>, <b>pink</b>, <b>orange</b>, <b>black</b>.
	 * @throws InterruptedException
	 */
	public void filterByColor(String color) throws InterruptedException
	{
		clickWebElement(colorFilterOptions(color));
	}

	/**
	 * Filters the Annotations menu to only show based on category.
	 * @param category Should be one among the following - <b>All</b>, <b>Bookmarks</b>, <b>Highlights</b> and <b>Notes</b>.
	 * @throws InterruptedException
	 */
	public void filterByCategory(String category) throws InterruptedException
	{
		clickWebElement(buttonBarOptions(category));
	}

	/**
	 * Navigates to the annotation via the annotations menu.
	 * 
	 * @throws InterruptedException
	 */
	public void navigateToAnnotation() throws InterruptedException
	{
		clickWebElement(annotationEntry());
	}

	/**
	 * Opens <b>Annotations Menu</b> by clicking on it.
	 * @throws InterruptedException
	 */
	public void openAnnotationsMenu() throws InterruptedException
	{
		clickWebElement(annotationsMenu());
	}

	/**
	 * Opens <b>Color Filter</b> by clicking on it.
	 * @throws InterruptedException
	 */
	public void openColorFilter() throws InterruptedException
	{
		clickWebElementByActionsClass(colorFilterBtn());
	}

	/**
	 * Opens </b>Displaced Annotations</b> by clicking on it.
	 */
	public void openDisplacedAnnotations()
	{
		clickWebElement(showDisplacedAnnotationsBtn());
	}

	/**
	 * Verifies if <b>Annotation</b> is deleted from <b>Annotations Menu</b>.
	 * @throws InterruptedException
	 */
	public void verifyAnnotationIsDeleted() throws InterruptedException
	{
		threadWait(2);
		Assert.assertFalse(verifyWebElementIsDisplayed("AnnotationsMenu_AnnotationEntry_CSS"));
	}

	/**
	 * Verifies that the <b>Annotation</b> is displayed in the <b>Annotations menu</b>.
	 */
	public void verifyAnnotationIsDisplayed()
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("AnnotationsMenu_AnnotationEntry_CSS"));
	}
}
