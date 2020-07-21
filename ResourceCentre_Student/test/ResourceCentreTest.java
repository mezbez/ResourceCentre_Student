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
		// This is a godforsaken test!!!!!!
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

<<<<<<< HEAD
		// test if the expected output string same as the list of chromebooks retrieved
		// from the SourceCentre
		allChromebook = ResourceCentre.retrieveAllChromebook(chromebookList);

		testOutput = String.format("%-10s %-30s %-10s\n", "CB0011", "My Google Chromebook 1st", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s\n", "CB0012", "SAMSUNG Chromebook 4+", "Win 10");

=======
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
			
>>>>>>> branch 'master' of https://github.com/mezbez/ResourceCentre_Student.git
		assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
<<<<<<< HEAD
		// testtest
		// testing testing
		// I am testing
=======
>>>>>>> branch 'master' of https://github.com/mezbez/ResourceCentre_Student.git
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

		// Test if the list is populated so that an item can be loaned
		assertNotNull("Test if list is valid Chromebook arraylist to add to", chromebookList);
		ResourceCentre.addChromebook(chromebookList, cb1);

		// Test if an item in the list can be loaned
		Boolean ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
		assertTrue("Test if an available item is ok to loan?", ok);

		ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0011", "8-8-2020");
		assertFalse("Test is tthe sam eitem is NOT ok to loan again?", ok);

		// Test if the ArrayList is updated to reflect the loan
		ResourceCentre.addChromebook(chromebookList, cb2);
		ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0012", "8-8-2020");
		assertFalse("Test that un-available item is NOT ok to loan?", ok);

		ok = ResourceCentre.doLoanChromebook(chromebookList, "CB0013", "8-8-2020");
		assertFalse("Test that non-esiting item is NOT ok to loan?", ok);

	}

	@Test
	public void doReturnCamcorderTest() {
		// fail("Not yet implemented");
		// write your code here

		// Test if the list is populated with both LOANED and not loaned items so that
		// an item can be returned
		assertNotNull("Test if list is available", camcorderList);

		// Test if any LOANED item in the list can be returned
		assertEquals("Test if the first item isn't available", false, camcorderList.get(0).getIsAvailable());
		camcorderList.get(0).setIsAvailable(true);

		// Test if the ArrayList is updated to reflect the return
		assertEquals("Test if in the ArrayList the first item has been returned", true,
				camcorderList.get(0).getIsAvailable());

	}

	@Test
	public void doReturnChromebookTest() {
		// fail("Not yet implemented");
		// write your code here

		// Test if the list is populated with both LOANED and not loaned items so that
		// an item can be returned
		assertNotNull("Test if list is available", chromebookList);

		// Test if any LOANED item in the list can be returned
		assertEquals("Test if the first item isn't available", false, chromebookList.get(0).getIsAvailable());
		chromebookList.get(0).setIsAvailable(true);
<<<<<<< HEAD

		// Test if the ArrayList is updated to reflect the return
		assertEquals("Test if in the ArrayList the first item has been returned", true,
				chromebookList.get(0).getIsAvailable());

=======
						
		//Test if the ArrayList is updated to reflect the return
		assertEquals("Test if in the ArrayList the first item has been returned", true, chromebookList.get(0).getIsAvailable());
		//Placeholder message
		
>>>>>>> branch 'master' of https://github.com/mezbez/ResourceCentre_Student.git
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
