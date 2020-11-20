//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.ArrayList;

public class Greetingkata {
    public Greetingkata() {
    }
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

    /*
        Requirement 4-8
    */

    /*
     * Return true if the name is Shouted
     * */
    private Boolean isShouted(String name){
        Boolean flag=false;
        if(name.equals(name.toUpperCase()) && !name.contains("\"")){
            flag=true;
        }else{
            flag=false;
        }
        return flag;
    }

    /*
     * Combine non-Shouted names into statements
     * */
    private String normalMeet(String[] name,int len){
        String result="Hello, ";
        if(len == 0){
            result="";
        }else if(len == 1){
            result+=name[0]+".";
        }else if(len ==2 ){
            result+=name[0]+" and "+name[1]+".";
        }else{
            for(int i=0;i<len-1;i++){
                result+=name[i]+", ";
            }
            result+="and "+name[len-1]+".";
        }
        return result;
    }

    /*
     * Combine Shouted names into statements
     * */
    private String shoutedMeet(String[] name,int len){
        String result=" AND HELLO ";
        if(len == 0){
            result="";
        }else if(len == 1){
            result+=name[0]+"!";
        }else if(len ==2 ){
            result+=name[0]+" AND "+name[1]+".";
        }else{
            result="AND HELLO, ";
            for(int i=0;i<len-1;i++){
                result+=name[i]+", ";
            }
            result+="AND "+name[len-1]+"!";
        }
        return result;
    }

    /*
    * greet() Method，Processing Multiple Groups of Names
    * */
    public String greet(String[] name) {
        ArrayList<String> arrName=new ArrayList<>();
        //Requirement7, processing name with comas
        for(int i=0;i<name.length;i++){
            //Requirement8,if quete is contained, just push it into stack
            if(name[i].contains("\"")){
                String s=name[i].replace("\"","");
                arrName.add(s);
            }else {
                //split by commas and push each part into stack
                String[] str = name[i].split(",");
                for (int j = 0; j < str.length; j++) {
                    str[j] = str[j].replace(" ", "");
                    arrName.add(str[j]);
                }
            }
        }

        name=arrName.toArray(new String[arrName.size()]);
        int len=name.length;
        int normal_cnt=0,shouted_cnt=0;
        Boolean[] IsShouted=new Boolean[len];
        String[] normalName=new String[len];
        String[] shoutedName=new String[len];

        //Calculates the number of normal and shouted, and deliver them into two groups
        for(int i=0;i<len;i++) {
            IsShouted[i] = isShouted(name[i]);
            if (IsShouted[i]) {
                shoutedName[shouted_cnt]=name[i];
                shouted_cnt++;
            } else {
                normalName[normal_cnt]=name[i];
                normal_cnt++;
            }
        }

        //combine the final sentence by making each type of sentence
        String result=normalMeet(normalName,normal_cnt)+shoutedMeet(shoutedName,shouted_cnt);
        return result;
    }
}
