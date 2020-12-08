package adventOfCode.day7;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BagTest {

    public static final String DARK_ORANGE_BAG = "dark orange bag";
    public static final String SHINY_GOLD_BAG = "shiny gold bag";
    public static final String MUTED_YELLOW_BAG = "muted yellow bag";
    public static final String FADED_BLUE_BAG = "faded blue bag";

    @Test
    void shouldIndicateTheAmountOfShinnyBagItCanHoldDirectly(){

        Bag mutedYellowBags = new Bag(MUTED_YELLOW_BAG);
        Map<Bag, Integer> children = new HashMap<>();
        children.put(new Bag(SHINY_GOLD_BAG),1);
        children.put(new Bag(FADED_BLUE_BAG),2);
        mutedYellowBags.setChildren(children);

        assertThat(mutedYellowBags.getAmountOfShinyGoldBag()).isEqualTo(1);
    }

    @Test
    void shouldIndicateTheAmountOfShinnyBagItCanHoldIndirectly(){

        Bag darkOrangeBag = new Bag(DARK_ORANGE_BAG);
        Map<Bag,Integer> darkOrangeChildrens = new HashMap<>();

        Bag shinnyGoldBag = new Bag(SHINY_GOLD_BAG);

        Bag mutedYellowBags = new Bag(MUTED_YELLOW_BAG);
        Map<Bag, Integer> childrens = new HashMap<>();
        childrens.put(shinnyGoldBag,1);
        childrens.put(new Bag(FADED_BLUE_BAG),2);
        mutedYellowBags.setChildren(childrens);

        darkOrangeChildrens.put(mutedYellowBags,4);
        darkOrangeChildrens.put(shinnyGoldBag,3);
        darkOrangeBag.setChildren(darkOrangeChildrens);

        assertThat(darkOrangeBag.getAmountOfShinyGoldBag()).isEqualTo(7);
    }

    @Test
    void shouldIndicateTheAmountOfShinnyBagItCanHoldIndirectlyWithDepthThree(){

        Bag someBag = new Bag("someBag");
        Map<Bag,Integer> someBagChildrens = new HashMap<>();

        Bag darkOrangeBag = new Bag(DARK_ORANGE_BAG);
        Map<Bag,Integer> darkOrangeChildrens = new HashMap<>();

        Bag shinnyGoldBag = new Bag(SHINY_GOLD_BAG);

        Bag mutedYellowBags = new Bag(MUTED_YELLOW_BAG);
        Map<Bag, Integer> childrens = new HashMap<>();
        childrens.put(shinnyGoldBag,1);
        childrens.put(new Bag(FADED_BLUE_BAG),2);
        mutedYellowBags.setChildren(childrens);

        darkOrangeChildrens.put(mutedYellowBags,4);
        darkOrangeChildrens.put(shinnyGoldBag,3);
        darkOrangeBag.setChildren(darkOrangeChildrens);

        someBagChildrens.put(darkOrangeBag,2);
        someBagChildrens.put(mutedYellowBags,1);
        someBag.setChildren(someBagChildrens);

        assertThat(someBag.getAmountOfShinyGoldBag()).isEqualTo(15);
    }

    @Test
    void shouldIndicateTheAmountOfIndividualBagItCanHold(){

        Bag darkOrangeBag = new Bag(DARK_ORANGE_BAG);
        Map<Bag,Integer> darkOrangeChildren = new HashMap<>();

        Bag shinyGoldBag = new Bag(SHINY_GOLD_BAG);

        Bag mutedYellowBag = new Bag(MUTED_YELLOW_BAG);
        Map<Bag, Integer> children = new HashMap<>();
        children.put(shinyGoldBag,1);
        children.put(new Bag(FADED_BLUE_BAG),2);
        mutedYellowBag.setChildren(children);

        darkOrangeChildren.put(mutedYellowBag,4);
        darkOrangeChildren.put(shinyGoldBag,3);
        darkOrangeBag.setChildren(darkOrangeChildren);

        assertThat(darkOrangeBag.getAmountOfIndividualBag()).isEqualTo(19);
    }

}
