package org.example.LLD_Design_pattern.Observer.Social_Media_Notifications;

// The Subject Interface
interface UserSubject {
    void follow(UserObserver observer);

    void unfollow(UserObserver observer);

    void notifyFollowers(String activity);
}
