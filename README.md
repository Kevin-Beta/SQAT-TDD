# SQAT-TDD

An assignment of SQAT class in Greeting Kata

# Project

The source code files for the java functions and tests are stored in [./SQAT/src/GreetingKata.java ](https://github.com/Kevin-Beta/SQAT-TDD/blob/main/SQAT/src/Greetingkata.java) and [./SQAT/test/TestGreetingKata.java](https://github.com/Kevin-Beta/SQAT-TDD/blob/main/SQAT/test/TestGreetingkata.java) , respectively

To run the test, please open the "SQAT" folder as IntelliJ IDEA project.

# Detail

###  greet(String name):String

The parameter of this method has only one String type variable, which solves requirements one to three

```java
    /*
        Requirement 1-3
    */
    public String greet(String name) {
        if (name != null) {
            //Requirement 1 & Requirement 3
            return name.equals(name.toUpperCase()) ? "HELLO " + name + "!" : "Hello, " + name + ".";
        } else {
            //Requirement 2
            return "Hello, my friend.";
        }
    }
```

### greet(String[] name) :String

The parameter of this method is a String type array, which solves requirements 4 to 8.

##### The core idea of the method

The method divides names into three categories: normal, shouted and special. Normal and shouted are described the same as the requirements. Special name refers to the name containing quote. The method first divides the name by category by using stack. The rules are as follows:
1. Normal or shouted name (Requirement 4-6), directly into the stack
2. Special name (requirement 8), the whole is put on the stack
3. If comma (Requirement 7) is included, comma is used as the dividing line for segmentation, then repeat steps 1-2. 
Special attention should be paid to the step 3 that comma contained in a pair of quotes cannot be used as the dividing line for segmentation, otherwise Requirement 8 is violated.

```java
    /*
        Requirement 4-8
    */

    /*
     * Return true if the name is Shouted
     * */
    private Boolean isShouted(String name)

    /*
     * Combine non-Shouted names into statements
     * */
    private String normalMeet(String[] name,int len)

    /*
     * Combine Shouted names into statements
     * */
    private String shoutedMeet(String[] name,int len)

    /*
    * greet() Method，Processing Multiple Groups of Names
    * */
    public String greet(String[] name)
```

Please read the comments in the code for more details.