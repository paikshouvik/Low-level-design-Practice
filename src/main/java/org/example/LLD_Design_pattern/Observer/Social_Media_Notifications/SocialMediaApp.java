package org.example.LLD_Design_pattern.Observer.Social_Media_Notifications;

public class SocialMediaApp {
    public static void main(String[] args) {
        // 1. Create creators
        User techInfluencer = new User("TechGuru_2026");

        // 2. Create followers with different preferences
        UserObserver alice = new UserObserver("Alice", new PushNotification());
        UserObserver bob = new UserObserver("Bob", new EmailNotification());
        UserObserver charlie = new UserObserver("Charlie", new PushNotification());

        // 3. Establish relationships
        techInfluencer.follow(alice);
        techInfluencer.follow(bob);
        techInfluencer.follow(charlie);

        // 4. Trigger activity
        techInfluencer.postUpdate("The new AI chips are finally here!");

        // 5. Unfollow scenario
        techInfluencer.unfollow(bob);
        techInfluencer.postUpdate("Don't forget to like and subscribe!");
        
    }
}