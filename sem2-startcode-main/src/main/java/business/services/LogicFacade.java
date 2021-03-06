package business.services;

import business.entities.Bottom;
import business.entities.Topping;
import business.exceptions.UserException;
import business.persistence.BottomMapper;
import business.persistence.Database;
import business.persistence.ToppingMapper;


import java.util.List;

public class LogicFacade {

    BottomMapper bottomMapper;
    ToppingMapper toppingMapper;

    public LogicFacade(Database database)
    {
        bottomMapper = new BottomMapper(database);
        toppingMapper = new ToppingMapper(database);
    }

    public List<Bottom> getAllBottoms() throws UserException {
        return bottomMapper.getAllBottoms();
    }

    public List<Topping> getAllToppings() throws UserException {
        return toppingMapper.getAllToppings();
    }

    public Bottom getBottomFromId(int id) throws UserException {
        return bottomMapper.getAllBottoms().get(id-1);
    }

    public Topping getToppingFromId(int id) throws UserException {
        return toppingMapper.getAllToppings().get(id-1);
    }
}
