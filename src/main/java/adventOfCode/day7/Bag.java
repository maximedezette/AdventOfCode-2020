package adventOfCode.day7;

import java.util.Map;
import java.util.Objects;

import static adventOfCode.day7.Constants.shinyBagLibelle;

public class Bag {

    public Bag(String label) {
        this.label = label;
    }

    private Map<Bag, Integer> children;
    private String label;

    public Map<Bag, Integer> getChildren() {
        return children;
    }

    public void setChildren(Map<Bag, Integer> childrens) {
        this.children = childrens;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getAmountOfShinyGoldBag() {
        int amountOfShinyGoldBag = 0;
        if(children != null) {
            for (Map.Entry<Bag, Integer> entry : children.entrySet()) {
                Bag bag = entry.getKey();
                Integer occurence = entry.getValue();
                if (bag.getLabel().equals(shinyBagLibelle)) {
                    amountOfShinyGoldBag += occurence;
                } else {
                    amountOfShinyGoldBag += occurence * bag.getAmountOfShinyGoldBag();
                }
            }
        }
        return amountOfShinyGoldBag;
    }


    public int getAmountOfIndividualBag() {
      return getAllBagsIncludingHimself() - 1;
    }

    private int getAllBagsIncludingHimself(){
        int amountOfIndividualBag = 0;
        if(children != null) {
            for (Map.Entry<Bag, Integer> entry : children.entrySet()) {
                Bag bag = entry.getKey();
                Integer occurrence = entry.getValue();
                amountOfIndividualBag += occurrence * bag.getAllBagsIncludingHimself() ;
            }
            amountOfIndividualBag += 1;
        }else{
            amountOfIndividualBag = 1;
        }
        return amountOfIndividualBag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return Objects.equals(children, bag.children) &&
                Objects.equals(label, bag.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children, label);
    }

    @Override
    public String toString() {
        return "Bag{" +
                "childrens=" + children +
                ", libelle='" + label + '\'' +
                '}';
    }

}
