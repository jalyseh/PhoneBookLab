import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, List<String>> contactsList;

    public PhoneBook(){

    }

    public PhoneBook(Map<String, List<String>> phoneNumbers) {
        this.contactsList = phoneNumbers;
    }

    public void add(String name, String phoneNumber) {

        if(contactsList.containsKey(name)){
            contactsList.get(name).add(phoneNumber);
        }else{
            contactsList.put(name, new ArrayList<String>());
            add(name,phoneNumber);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        contactsList.put(name, Arrays.asList(phoneNumbers));
    }
    public void remove(String name){
        contactsList.remove(name);
    }
    public boolean hasEntry(String name){
        return contactsList.containsKey(name);

    }
    public List<String> lookup(String name){
        return contactsList.get(name);
    }

    public String reverseLookup(String phoneNumber){

        ArrayList<String> names = new ArrayList<String>();
        names.addAll(contactsList.keySet());
        for(String name : names){
          for(String phoneNum : contactsList.get(name)){
              if(phoneNum.equals(phoneNumber)){
                  return name;
              }
          }
        }
        return null;
    }
    
    public List<String> getAllContactNames(){
        return new ArrayList<String>(contactsList.keySet());
    }

}

