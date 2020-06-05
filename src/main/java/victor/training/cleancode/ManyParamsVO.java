package victor.training.cleancode;

public class ManyParamsVO {
   public static void main(String[] args) {
      new ManyParamsVO().placeOrder(new PersonName("John", "Doe"), "St. Albergue", "Paris", 99);
   }

   public void placeOrder(PersonName personName, String city, String streetName, Integer streetNumber) {

      System.out.println("Some Logic");
   }
}
//class ClientName { // prea specifi. nu reutilizabil
// Person poate contine
// Name e gresit - si un SRL are nume
// PersonName
class PersonName {
   private final String firstName;
   private final String lastName;

   public PersonName(String firstName, String lastName) {
      if (firstName == null || lastName == null) throw new IllegalArgumentException();
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }
}

//class OrderDetails { // prea specific. nu poate fi refolosit
//class Client // prea vag. in client poti sa pui orice, si tu si colegu/a
//class Address {
//   String city;
//   String streetName;
//   Integer streetNumber;
//}


class AnotherClass {
   public void otherMethod(PersonName personName, int x) {
      System.out.println("Another distant Logic");
   }
}

// Holy entity. SACRED GROUNDS OF PERSISTENT OBJECTS.
// toata lumea lucreaza cu astea.
class Person {
   private Long id;
   private PersonName name;
   private String phone;

   public Person(String firstName, String lastName) {
      name = new PersonName(firstName, lastName);
      // TODO think: is this sufficient enforcing ?
   }

   // TODO hard-core: implement setter
//   public void setLastName(String lastName) {
//      this.lastName = lastName;
//   }


   public PersonName getName() {
      return name;
   }

}

class PersonService {
   public void f(Person person) {
      String fullNameStr = getFullName(person.getName());
      System.out.println(fullNameStr);
   }

   private String getFullName(PersonName name) {
      return name.getFirstName() + " " + name.getLastName().toUpperCase();
   }

   public void p(String city, String streetName, Integer streetNumber) {
      System.out.println("Living in " + city + " on St. " + streetName + " " + streetNumber);
   }
}