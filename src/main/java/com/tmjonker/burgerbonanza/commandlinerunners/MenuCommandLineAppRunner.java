package com.tmjonker.burgerbonanza.commandlinerunners;

import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import com.tmjonker.burgerbonanza.services.MenuService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuCommandLineAppRunner implements CommandLineRunner {

    MenuService menuService;

    public MenuCommandLineAppRunner(MenuService menuService) {

        this.menuService = menuService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<MenuItem> menuList = new ArrayList<>();

        MenuItem menuItem1 = new MenuItem(10, "Appetizer", "Boneless Wings", "Boneless Wings with your choice of Ranch" +
                "or Bleu Cheese.", 8.99, "https://dinnerthendessert.com/wp-content/uploads/2018/08/Boneless-Buffalo-Wings-3.jpg");
        MenuItem menuItem2 = new MenuItem(11, "Appetizer", "Fried Pickles", "Delicious fried pickles.  Served with ranch " +
                "or blue cheese.", 6.99, "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2012/5/4/0/FNM_060112-Almost-Famous-Fried-Pickles-Recipe_s4x3.jpg.rend.hgtvcom.616.462.suffix/1382541365213.jpeg");
        MenuItem menuItem3 = new MenuItem(12, "Appetizer", "Mozzarella Sticks", "Fried mozzarella sticks served with a side " +
                "of marinara sauce.", 7.99, "https://lilluna.com/wp-content/uploads/2017/12/mozz-sticks-resize-6-500x500.jpg");
        MenuItem menuItem4 = new MenuItem(13, "Appetizer", "Onion Ring Tower", "Delicious tower of Onion Rings",
                8.99, "https://www.webstaurantstore.com/images/products/large/230257/1063423.jpg");
        MenuItem menuItem5 = new MenuItem(14, "Appetizer", "Pretzel Bites", "Pretzel bites served with a side of beer " +
                "cheese sauce", 6.99, "https://sugarspunrun.com/wp-content/uploads/2021/11/Homemade-soft-pretzel-bites-1-of-1.jpg");
        MenuItem menuItem6 = new MenuItem(20, "Salad", "Cobb Salad", "Salad with eggs, ham, bacon bits, tomato." +
                "  Served with your choice of dressing.", 12.99, "https://reciperunner.com/wp-content/uploads/2020/09/Fall-Cobb-Salad-Photo-720x720.jpg");
        MenuItem menuItem7 = new MenuItem(21, "Salad", "Grilled Chicken Salad", "Grilled chicken salad with bacon, " +
                "tomato, onions, and croutons.  Served with your choice of dressing.", 13.99, "https://www.thespruceeats.com/thmb/agWvZXfd9cQhJSP1kL1N8douR8M=/2000x1386/filters:fill(auto,1)/california-grilled-chicken-salad-recipe-334159-13-8ecd934fee5e42f8b5d38239b083460b.jpg");
        MenuItem menuItem8 = new MenuItem(22, "Salad", "Southwest Salad", "Salad with spicy chicken," +
                " frito chips, bacon.  Served with your choice of dressing.", 13.99, "https://theoregondietitian.com/wp-content/uploads/2022/04/SpicySouthwestSalad-1200-x-1200.jpg");

        menuList.add(menuItem1);
        menuList.add(menuItem2);
        menuList.add(menuItem3);
        menuList.add(menuItem4);
        menuList.add(menuItem5);
        menuList.add(menuItem6);
        menuList.add(menuItem7);
        menuList.add(menuItem8);

        menuList.forEach(item -> {
            if (!menuService.existsById(item.getId()))
                menuService.addMenuItem(item);
        });
    }
}
