package ans.no3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Menu {

    public List<Item> getDummyMenuList(){

        Category starter = new Category(1L, "Starter");
        Category bbq = new Category(2L, "BBQ");
        Category fastFood = new Category(2L, "Fast_Food");
        Category drinks = new Category(2L, "Drinks");
        Category miscellaneous = new Category(2L, "Miscellaneous");

        return Arrays.asList(
                new Item(1L, "Fries", 100.0, starter),
                new Item(2L, "Salad", 60.5, starter),
                new Item(3L, "Finger Fish", 150.0, starter),
                new Item(4L, "Tikka", 350.0, bbq),
                new Item(5L, "Kabab", 380.0, bbq),
                new Item(6L, "Zinger Burger", 360.0, fastFood),
                new Item(7L, "Broast", 380.0, fastFood),
                new Item(8L, "Club Sandwich", 360.0, fastFood),
                new Item(9L, "Pepsi", 60.0, drinks),
                new Item(10L, "7-UP", 60.0, drinks),
                new Item(11L, "Dew", 60.0, drinks),
                new Item(12L, "Tea", 80.0, drinks),
                new Item(13L, "Coffee", 120.0, drinks),
                new Item(14L, "Raita", 30.0, miscellaneous),
                new Item(14L, "Chapati", 20.0, miscellaneous),
                new Item(14L, "Naan", 25.0, miscellaneous)
        );
    }

    public List<Item> getSortedMenuList(List<Item> items ,SortingOrder sortingOrder){
        Comparator<Item> category = Comparator.comparing(item -> item.getCategory().getName());
        switch (sortingOrder){
            case NAME:
                items.sort(Comparator.comparing(Item::getName));
                break;
            case AMOUNT:
                items.sort(Comparator.comparing(Item::getAmount));
                break;
            case CATEGORY_NAME:
                items.sort(category.thenComparing(Item::getName));
                break;
            case CATEGORY_AMOUNT:
                items.sort(category.thenComparing(Item::getAmount));
                break;
            default:
                items.sort(category);
        }
        return items;
    }

    public static void main(String[] args) {

        Menu menu = new Menu();

        System.out.println(menu.getSortedMenuList(menu.getDummyMenuList(), SortingOrder.DEFAULT));
        System.out.println(menu.getSortedMenuList(menu.getDummyMenuList(), SortingOrder.NAME));
        System.out.println(menu.getSortedMenuList(menu.getDummyMenuList(), SortingOrder.AMOUNT));
        System.out.println(menu.getSortedMenuList(menu.getDummyMenuList(), SortingOrder.CATEGORY_NAME));
        System.out.println(menu.getSortedMenuList(menu.getDummyMenuList(), SortingOrder.CATEGORY_AMOUNT));


    }

}
