package ru.job4j.map;

import java.util.*;
import java.util.random.RandomGenerator;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return RandomGenerator.getDefault().hashCode();
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        User user1 = new User("Ivan", 2, new GregorianCalendar(1988, 5, 17));
        User user2 = new User("Ivan", 2, new GregorianCalendar(1988, 5, 17));
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
        /**
         * 6.1 Пары попали в разные бакеты, потому что у ключей разные хеш-коды.
         * 6.2 Проверка ключей на равенство их хеш-кодов не проводилась, т.к. пары попали в разные бакеты.
         * 6.3 Проверка на equals() не проводилась.
         */
    }
}
