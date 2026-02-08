package org.example.LLD_Design_pattern.Observer.Social_Media_Notifications;

import java.util.ArrayList;
import java.util.List;

class User implements UserSubject {
    private String username;
    private List<UserObserver> followers = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() { return username; }

    @Override
    public void follow(UserObserver observer) {
        followers.add(observer);
    }

    @Override
    public void unfollow(UserObserver observer) {
        followers.remove(observer);
    }

    @Override
    public void notifyFollowers(String activity) {
        String message = username + " just " + activity;
        for (UserObserver follower : followers) {
            follower.update(message);
        }
    }

    public void postUpdate(String content) {
        System.out.println("\n--- " + username + " posted: " + content + " ---");
        notifyFollowers("posted a new update: " + content);
    }
}

