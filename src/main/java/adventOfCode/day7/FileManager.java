package adventOfCode.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {

    public Map<String, Bag> get(String path) throws FileNotFoundException {
        Map<String, Bag> bagList = getAllBagList(path);
        addChildrenToBagList(path, bagList);

        return bagList;
    }

    private Map<String, Bag> getAllBagList(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        Map<String,Bag> bagList = new HashMap<>();
        while (sc.hasNext()){
            String bagName =  getBagNameFromLine(sc.nextLine());
            bagList.put(bagName,new Bag(bagName));
        }
        return bagList;
    }

    private String getBagNameFromLine(String line){
        String bagName = line.split("contain")[0].trim();
        bagName =  bagName.replace("bags","bag");
        return bagName;
    }

    private void addChildrenToBagList(String path, Map<String, Bag> bagList) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String bagName = getBagNameFromLine(line);
            String childrenLine = getChildrenFromLine(line);
            Map<Bag, Integer> childrenMap = getChildren(bagList,childrenLine);

            if(!childrenMap.isEmpty()){
                bagList.get(bagName).setChildren(childrenMap);
            }
        }
    }

    private String getChildrenFromLine(String line) {
       return line.split("contain")[1].trim();
    }

    private Map<Bag, Integer> getChildren(Map<String, Bag> bagList, String childrenLine) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);

        Map<Bag,Integer> childrenMap = new HashMap<>();
        String[] children = childrenLine.split(",");
        for(int i = 0; i < children.length; i++){

            Matcher matcher = pattern.matcher(children[i]);
            if(matcher.find()){
                Integer occurrence = Integer.parseInt(matcher.group(0));
                children[i] = getChildName(children[i]);
                childrenMap.put(bagList.get(children[i]),occurrence);
            }
        }
        return childrenMap;
    }

    private String getChildName(String line){
        String childrenName = line.replace(".","");
        childrenName = childrenName.replaceAll("\\d","").trim();
        childrenName =  childrenName.replace("bags","bag");

        return childrenName;
    }

}
