package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        User user1 = new User("Ivan", 2, new GregorianCalendar(1988, 5, 17));
        User user2 = new User("Ivan", 2, new GregorianCalendar(1988, 5, 17));
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
        /**
         * 5.1 Пары попали в разные бакеты.
         * 5.2 Проверка ключей на равенство их хеш-кодов не проводилась, т.к. ключи попали в разные бакеты.
         * 5.3 ПРоверка на equals() не проводилась, потому что ключи попали в разные бакеты.
         */
    }
}
