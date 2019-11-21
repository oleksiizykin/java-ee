package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum Role {
    ADMIN("admin"),
    USER("user"),
    SUPERUSER("superuser"),
    VISITOR("visitor");

    public static void getUserRoles() {
        for (Role role : values()) {
            System.out.println(role);
        }
    }

    private String type;

    Role(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public static Role getUserRoleByType(String role) {
        for (Role userRole : values()) {
            if (userRole.type.equals(role)) {
                return userRole;
            }
        }
        return VISITOR;
    }

    public void access() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = Role.class.getClassLoader().getResourceAsStream("user_prop.properties");
        properties.load(resourceAsStream);
        switch (this) {
            case ADMIN:
                System.out.println(ADMIN + " : " + properties.getProperty("admin"));
                break;
            case USER:
                System.out.println(USER + " : " + properties.getProperty("user"));
                break;
            case SUPERUSER:
                System.out.println(SUPERUSER + " : " + properties.getProperty("superuser"));
                break;
        }
    }
}
