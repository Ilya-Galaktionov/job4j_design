package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int changed = 0;
        int deleted = 0;
        Map<Integer, String> map = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        for (User user : previous) {
            if (!map.containsKey(user.getId())) {
                deleted++;
                map.put(user.getId(), user.getName());
            } else if (!map.get(user.getId()).equals(user.getName())) {
                changed++;
            }
        }
        return new Info(map.size() - previous.size(), changed, deleted);
    }
}
