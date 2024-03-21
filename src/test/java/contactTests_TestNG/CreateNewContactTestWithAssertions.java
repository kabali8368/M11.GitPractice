package contactTests_TestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.BaseClass_CrossBrowser;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

public class CreateNewContactTestWithAssertions extends BaseClass{
	
	@Test(groups = {"RegressionSuite","SmokeSuite"})
	public void createNewContactWithMandatoryFields() throws EncryptedDocumentException, IOException
	{
		/*Read Test data - Excel File*/
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
		
		//step 3 : Navigate to contacts link
		HomePage hp = new HomePage(driver);
		hp.conactsLink();
		
		//step 4 : Click on create contacts look Up image
		ContactsPage cp = new ContactsPage(driver);
		cp.createContactLookUpImg();
		
		//step 5 : Create contact with mandatory information and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		// step 6 : validate for the contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.captureContactHeader();
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		
		
	}


}
