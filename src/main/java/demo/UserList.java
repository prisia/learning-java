package demo;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import demo.model.User;
import demo.services.UserService;

@Route("")
public class UserList extends VerticalLayout {
    public UserList(UserService service){
        var grid = new Grid<User>(User.class);

        grid.setItems(service.getUsers());

        add(grid);
    }
}
