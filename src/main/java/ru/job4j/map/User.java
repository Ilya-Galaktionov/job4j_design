package ru.job4j.map;

import java.util.*;

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
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        User user1 = new User("Ivan", 2, new GregorianCalendar(1988, 5, 17));
        User user2 = new User("Ivan", 2, new GregorianCalendar(1988, 5, 17));
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
        /**
         * 6.1 Пары попали в одинаковые бакеты.
         * 6.2 Проверка ключей на равенство их хеш-кодов проводилась, т.к. пары попали в один бакеты.
         * 6.3 Проверка на equals() проводилась, но т.к. метод Equals() не переопредел, то для ключей вернул false.
         */
    }
}
