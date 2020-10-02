import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PhoneBookTest {

    @Test
    public void addTest(){

        ArrayList<String> phoneNums = new ArrayList<String>();
        phoneNums.add("302-123-4567");

        PhoneBook phoneBook = new PhoneBook(new HashMap<String, List<String>>());
        phoneBook.add("Ace","302-123-4567");

        Assert.assertEquals(phoneNums, phoneBook.lookup("Ace"));
    }
    @Test
    public void addAll(){

        //Expected
        ArrayList<String> phoneNums = new ArrayList<String>();
        phoneNums.add("302-345-6789");
        phoneNums.add("302-123-4567");

        //Actual
        PhoneBook phoneBook = new PhoneBook(new HashMap<String, List<String>>());
        phoneBook.addAll("Ace","302-345-6789","302-123-4567");

        Assert.assertEquals(phoneNums, phoneBook.lookup("Ace"));

    }

    @Test
    public void hasEntry(){

        PhoneBook phoneBook = new PhoneBook(new HashMap<String, List<String>>());
        phoneBook.add("Ace","302-234-5678");

        boolean expected = true;
        boolean actual = phoneBook.hasEntry("Ace");


        Assert.assertEquals(true, actual);

    }
    @Test
    public void lookupTest(){

        ArrayList<String> phoneNums = new ArrayList<String>();
        phoneNums.add("302-123-4567");
        phoneNums.add("302-234-5678");
        phoneNums.add("302-345-6789");

        Map<String, List<String>> phoneBookMap = new HashMap();
        phoneBookMap.put("Ace", phoneNums);

        PhoneBook phoneBook = new PhoneBook(phoneBookMap);
        List<String> expected = phoneNums;
        List<String> actual = phoneBook.lookup("Ace");

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void reverseLookUp(){

        ArrayList<String> phoneNums = new ArrayList<String>();
        phoneNums.add("302-123-4567");

        Map<String, List<String>> phoneBookMap = new HashMap();
        phoneBookMap.put("Ace", phoneNums);

        PhoneBook phoneBook = new PhoneBook(phoneBookMap);

        String expected = "Ace";
        String actual = phoneBook.reverseLookup("302-123-4567");

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void removeTest(){

        ArrayList<String> phoneNums = new ArrayList<String>();
        phoneNums.add("302-123-4567");
        phoneNums.add("302-234-5678");
        phoneNums.add("302-345-6789");

        Map<String, List<String>> phoneBookMap = new HashMap();
        phoneBookMap.put("Ace", phoneNums);

        PhoneBook phoneBook = new PhoneBook(phoneBookMap);
        phoneBook.remove("Ace");

        Assert.assertEquals(null, phoneBook.lookup("Ace"));
    }
    @Test
    public void getAllContactsTest(){

        ArrayList<String> phoneNums = new ArrayList<String>();
        phoneNums.add("302-123-4567");
        phoneNums.add("302-234-5678");
        phoneNums.add("302-345-6789");

        Map<String, List<String>> phoneBookMap = new HashMap();
        phoneBookMap.put("Ace", phoneNums);

        PhoneBook phoneBook = new PhoneBook(phoneBookMap);
        phoneBook.add("Ace","302-123-4567");
        phoneBook.add("Susan","302-234-5678");
        phoneBook.add("Roy", "302-345-6789");

        List<String> expected = new ArrayList<String>();
        expected.add("Ace");
        expected.add("Roy");
        expected.add("Susan");

        Collections.sort(expected);
        List<String> actual = phoneBook.getAllContactNames();
        Collections.sort(actual);

        Assert.assertEquals(expected, actual);

    }
}
