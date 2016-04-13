package den.abramov.store;

import den.abramov.model.User;
import den.abramov.service.DBConnect;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserCache {

    private DBConnect db = new DBConnect();

    private static UserCache userCache = new UserCache();


    private UserCache() {
    }

    public static UserCache getInstance() {
        return userCache;
    }

    public Collection<User> value() {
        return db.readAll();
    }

    public void add(User user) {
        db.addUser(user);
    }

    public void delete(int id) {
        User user = db.getUserId(id);
        db.delete(user);
    }

    public User get(int id) {
        return db.getUserId(id);
    }

    public Collection<User> search(String name)
    {
        Collection<User> us = db.readAll();
        Collection<User> rezult = new CopyOnWriteArrayList<>();
        for (User u : us) {
            if(u.getName().toLowerCase().contains(name.toLowerCase()))
            {
                rezult.add(u);
            }
        }
        return rezult;
    }

    public User getName(String name)
    {
        return db.getByName(name);
    }

    public User getNumber(String number)
    {
        Collection<User> us = db.readAll();
        for (User u : us) {
            if(u.getNumber().equalsIgnoreCase(number))
                return u;

        }
        return null;
    }

    public Collection<User> watchOne(User user)
    {
        Collection<User> rezult = new CopyOnWriteArrayList<>();
        rezult.add(user);
        return rezult;
    }
}
