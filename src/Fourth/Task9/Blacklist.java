package Fourth.Task9;

import java.util.ArrayList;
import java.util.List;

public class Blacklist {
    private List<String> blacklistedEmails;

    public Blacklist() {
        this.blacklistedEmails = new ArrayList<>();
    }

    void addEmail(String email) {
        blacklistedEmails.add(email);
    }

    void removeEmail(String email) {
        blacklistedEmails.remove(email);
    }

    public boolean isBlacklisted(String email) {
        return blacklistedEmails.contains(email);
    }
}
