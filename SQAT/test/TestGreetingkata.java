import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGreetingkata {
    @Test
    public void TestGreetingKata_requirement1(){
        // set up
        String name = "Bob";
        Greetingkata greetingkata = new Greetingkata();

        // exercise
        String returnedString  = greetingkata.greet(name);

        // perform check
        assertEquals("Hello, Bob.", returnedString);
    }

    @Test
    public void testGreetingkata_requirement2(){
        //Set up
        Greetingkata greetingkata = new Greetingkata();
        //exercise
        String returnedString = greetingkata.greet((String) null);
        //perform check
        assertEquals("Hello, my friend.",returnedString);
    }

    @Test
    public void testGreetingkata_requirement3(){
        //Set up
        String name = "JERRY";
        Greetingkata greetingkata = new Greetingkata();
        //exercise
        String returnedString = greetingkata.greet(name);
        //perform check
        assertEquals("HELLO JERRY!",returnedString);
    }

    @Test
    public void testGreetingkata_requirement4(){
        //Set up
        String[] name = new String[]{"Jill","Jane"};
        Greetingkata greetingkata = new Greetingkata();
        //exercise
        String returnedString = greetingkata.greet(name);
        //perform check
        assertEquals("Hello, Jill and Jane.",returnedString);
    }

    @Test
    public void testGreetingkata_requirement5(){
        //Set up
        String name[] = new String[]{"Amy", "Brian", "Charlotte"};
        Greetingkata greetingkata = new Greetingkata();
        //exercise
        String returnedString = greetingkata.greet(name);
        //perform check
        assertEquals("Hello, Amy, Brian, and Charlotte.",returnedString);
    }

    @Test
    public void testGreetingkata_requirement6(){
        //Set up
        String name[] = new String[]{"Amy", "BRIAN", "Charlotte"};
        Greetingkata greetingkata = new Greetingkata();
        //exercise
        String returnedString = greetingkata.greet(name);
        //perform check
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!",returnedString);
    }

    @Test
    public void testGreetingkata_requirement7(){
        //Set up
        String name[] = new String[]{"Bob", "Charlie, Dianne"};
        Greetingkata greetingkata = new Greetingkata();
        //exercise
        String returnedString = greetingkata.greet(name);
        //perform check
        assertEquals("Hello, Bob, Charlie, and Dianne.",returnedString);
    }

    @Test
    public void testGreetingkata_requirement8(){
        //Set up
        String name[] = new String[]{"Bob", "\"Charlie, Dianne\""};
        Greetingkata greetingkata = new Greetingkata();
        //exercise
        String returnedString = greetingkata.greet(name);
        //perform check
        assertEquals("Hello, Bob and Charlie, Dianne.",returnedString);
    }
}
