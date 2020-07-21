import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;

	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;

	public ResourceCentreTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList = new ArrayList<Camcorder>();
		chromebookList = new ArrayList<Chromebook>();
	}

	@Test
	public void addCamcorderTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));

		// Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}

	@Test
	public void addChromebookTest() {
		// fail("Not yet implemented");
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addChromebook(chromebookList, cb1);
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, chromebookList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));

		// Add another item. test The size of the list is 2?
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
	}

	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);

		// test if the list of camcorders retrieved from the SourceCentre is empty
		String allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());

		// test if the expected output string same as the list of camcorders retrieved
		// from the SourceCentre
		allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0012", "Sony DSC-RX100M7", "Yes", "", 20);

		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);

	}

	@Test
	public void retrieveAllChromebookTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);

		// test if the list of chromebooks retrieved from the SourceCentre is empty
		String allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);
		String testOutput = "";
		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());


		// test if the expected output string same as the list of chromebooks retrieved
		// from the SourceCentre
		allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);

		testOutput = String.format("%-10s %-30s %-10s\n", "CB0011", "My Google Chromebook 1st", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s\n", "CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
			
		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
	}

	@Test
	public void doLoanCamcorderTest() {
		// Test if item list is not null
		assertNotNull("Check if there is an arraylist to loan from", camcorderList);

		// Test if the item list has items to loan
		ResourceCentre.addCamcorder(camcorderList, cc1);
		assertEquals("Test if there is an item in the list", 1, camcorderList.size());

		// Test if asset tag input of item needs to be loaned is present in item list
		ResourceCentre.addCamcorder(camcorderList, cc1);
		String testInput = "CC0011";
		String camcorderTag = camcorderList.get(0).getAssetTag();

		assertEquals("Test if input matches camcorder tag", testInput, camcorderTag);

		// Test if availability of the item loaned is changed and due date entered
		ResourceCentre.addCamcorder(camcorderList, cc1);
		camcorderList.get(0).setIsAvailable(false);
		camcorderList.get(0).setDueDate("21/7");
		String allCamcorder = ResourceCentre.retrieveAllCamcorder(camcorderList);

		String testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0011", "Nikon HDSLR", "No", "21/7", 40);

		assertEquals("Availability and due date changed Accordingly", testOutput, allCamcorder);
	}

	@Test
	public void doLoanChromebookTest() {
		// fail("Not yet implemented");
		// write your code here
		
		//Test if the list is populated so that an item can be loaned
		assertNotNull("Test if list is available", chromebookList);
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
		
		//Error Condition
		Boolean isReturned = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
		assertTrue("Is available Chromebook CB0011 loaned (true)?", isReturned);
				
		//Normal Condition
		cb2.setIsAvailable(false);
		isReturned = ResourceCentre.doLoanChromebook(chromebookList, "CB0012", "8-8-2020");
		assertFalse("Is loaned Chromebook CB0012 loaned (false)?", isReturned);
				
		//Error
		isReturned = ResourceCentre.doLoanChromebook(chromebookList, "CB0013", "8-8-2020");
		assertFalse("Is non-existent Chromebook CB0013 loaned (false)?", isReturned);
	}

	@Test
	public void doReturnCamcorderTest() {
		//Let's load the list!!
		assertNotNull("Is the list of camcorders available?", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		
		//Error Condition
		Boolean isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
		assertFalse("Is available camcorder CC0011 is returned (false)?", isReturned);
		
		//Normal Condition
		cc2.setIsAvailable(false);
		isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0012");
		assertTrue("Is borrowed camcorder CC0012 returned (true)?", isReturned);
		
		//Error
		isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0013");
		assertTrue("Is camcorder CC0013 returned (false)?", isReturned);
	}

	@Test
	public void doReturnChromebookTest() {
		//fail("Not yet implemented");
		//Let's load the list!!
		assertNotNull("Is the list of Chromebooks available?", chromebookList);
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
				
		//Error Condition
		Boolean isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
		assertFalse("Is available Chromebook CB0011 returned (false)?", isReturned);
				
		//Normal Condition
		cb2.setIsAvailable(false);
		isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0012");
		assertTrue("Is borrowed Chromebook CB0012 returned (true)?", isReturned);
				
		//Error
		isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0013");
		assertTrue("Is non-existent Chromebook CB0013 returned (false)?", isReturned);
	}

	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
