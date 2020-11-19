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
            //Requirement 1&Requirement 3
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
     * 判断名字是否为Shouted
     * */
    private Boolean isShouted(String name){
        Boolean flag=false;
        if(name.equals(name.toUpperCase())){
            flag=true;
        }else{
            flag=false;
        }
        return flag;
    }

    /*
     * 对于normal name的打招呼语句
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
     * 对于shouted name的打招呼语句
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

    private int classify(String name){
        int result=0;
        if(name.contains(",")){
            if(name.contains("\"")){
                if(name.charAt(name.length()-1)=='\"'){
                    result=3;   //包含quote,且quote包括了整个名字
                }else{
                    result=4;   //包含quote，但quote之外还有commas
                }
            }else{
                result=2;   //包含commas不包含quote
            }
        }else{
            result=1;   //normal和shouted
        }
        return result;
    }

    public String greet(String[] name) {
        ArrayList<String> arrName=new ArrayList<>();

        for(int i=0;i<name.length;i++) {
            switch (classify(name[i])){
                case 1:{}
            }
        }

        //处理带有comas的name
        for(int i=0;i<name.length;i++){
            String[] str=name[i].split(",");
            for(int j=0;j<str.length;j++){
                str[j]=str[j].replace(" ","");
                arrName.add(str[j]);
            }
        }

        name=arrName.toArray(new String[arrName.size()]);
        int len=name.length;
        int normal_cnt=0,shouted_cnt=0;
        Boolean[] IsShouted=new Boolean[len];
        String[] normalName=new String[len];
        String[] shoutedName=new String[len];

        //计算normal和shouted个数,并将两者分组
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

        String result=normalMeet(normalName,normal_cnt)+shoutedMeet(shoutedName,shouted_cnt);
        return result;
    }
}
