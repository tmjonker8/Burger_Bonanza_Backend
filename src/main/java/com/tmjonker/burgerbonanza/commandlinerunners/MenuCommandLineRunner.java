package com.tmjonker.burgerbonanza.commandlinerunners;

import com.tmjonker.burgerbonanza.dtos.MenuItemDTO;
import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import com.tmjonker.burgerbonanza.services.MenuService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuCommandLineRunner implements CommandLineRunner {

    MenuService menuService;

    public MenuCommandLineRunner(MenuService menuService) {

        this.menuService = menuService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<MenuItemDTO> menuList = new ArrayList<>();

        MenuItemDTO menuItem1 = new MenuItemDTO("Appetizer", "Boneless Wings", "Boneless Wings with your choice of Ranch" +
                "or Bleu Cheese.", 8.99, "https://dinnerthendessert.com/wp-content/uploads/2018/08/Boneless-Buffalo-Wings-3.jpg");
        MenuItemDTO menuItem2 = new MenuItemDTO("Appetizer", "Fried Pickles", "Delicious fried pickles.  Served with ranch " +
                "or blue cheese.", 6.99, "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2012/5/4/0/FNM_060112-Almost-Famous-Fried-Pickles-Recipe_s4x3.jpg.rend.hgtvcom.616.462.suffix/1382541365213.jpeg");
        MenuItemDTO menuItem3 = new MenuItemDTO("Appetizer", "Mozzarella Sticks", "Fried mozzarella sticks served with a side " +
                "of marinara sauce.", 7.99, "https://lilluna.com/wp-content/uploads/2017/12/mozz-sticks-resize-6-500x500.jpg");
        MenuItemDTO menuItem4 = new MenuItemDTO("Appetizer", "Onion Ring Tower", "Delicious tower of Onion Rings",
                8.99, "https://www.webstaurantstore.com/images/products/large/230257/1063423.jpg");
        MenuItemDTO menuItem5 = new MenuItemDTO("Appetizer", "Pretzel Bites", "Pretzel bites served with a side of beer " +
                "cheese sauce", 6.99, "https://sugarspunrun.com/wp-content/uploads/2021/11/Homemade-soft-pretzel-bites-1-of-1.jpg");
        MenuItemDTO menuItem6 = new MenuItemDTO("Salad", "Cobb Salad", "Salad with eggs, ham, bacon bits, tomato." +
                "  Served with your choice of dressing.", 12.99, "https://reciperunner.com/wp-content/uploads/2020/09/Fall-Cobb-Salad-Photo-720x720.jpg");
        MenuItemDTO menuItem7 = new MenuItemDTO("Salad", "Grilled Chicken Salad", "Grilled chicken salad with bacon, " +
                "tomato, onions, and croutons.  Served with your choice of dressing.", 13.99, "https://www.thespruceeats.com/thmb/agWvZXfd9cQhJSP1kL1N8douR8M=/2000x1386/filters:fill(auto,1)/california-grilled-chicken-salad-recipe-334159-13-8ecd934fee5e42f8b5d38239b083460b.jpg");
        MenuItemDTO menuItem8 = new MenuItemDTO("Salad", "Southwest Salad", "Salad with spicy chicken," +
                " frito chips, bacon.  Served with your choice of dressing.", 13.99, "https://theoregondietitian.com/wp-content/uploads/2022/04/SpicySouthwestSalad-1200-x-1200.jpg");
        MenuItemDTO menuItem12 = new MenuItemDTO("Burger", "Exotic Cheeseburger", "A wild ass cheeseburger.  Served with a side of fries and a pickle."
                , 14.99, "https://www.burgervillage.com/wp-content/uploads/2022/06/organic-exotic.jpg");
        MenuItemDTO menuItem9 = new MenuItemDTO("Burger", "Cheeseburger", "A basic cheeseburger.  Served with a side of fries and a pickle."
                , 12.99, "https://www.simplyrecipes.com/thmb/v9oJerpFOWNuMwJmL9HrXFvgy4g=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Simply-Recipes-Smash-Burger-LEAD-06-ef2afe47d4014f76b1ed50e906c4b17d.jpg");
        MenuItemDTO menuItem10 = new MenuItemDTO("Dessert", "Cheesecake", "A slice of NY style cheesecake."
                , 7.99, "https://www.onceuponachef.com/images/2017/12/cheesecake.jpg");
        MenuItemDTO menuItem11 = new MenuItemDTO("Dessert", "Strawberry Shortcake", "A slice of strawberry shortcake."
                , 8.99, "https://freedsbakery.com/cdn/shop/products/ShortcakeSlice_1024x1024_14c38a3c-84e1-4453-b8ff-fda2864caf32.jpg?v=1718555645");


        menuList.add(menuItem1);
        menuList.add(menuItem2);
        menuList.add(menuItem3);
        menuList.add(menuItem4);
        menuList.add(menuItem5);
        menuList.add(menuItem6);
        menuList.add(menuItem7);
        menuList.add(menuItem8);
        menuList.add(menuItem9);
        menuList.add(menuItem10);
        menuList.add(menuItem11);
        menuList.add(menuItem12);

        menuList.forEach(item -> {
            if (!menuService.existsByName(item.getName()))
                menuService.addMenuItem(item);
        });
    }
}
