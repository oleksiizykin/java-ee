package com;

import com.service.UserService;
import com.service.UserServiceInterface;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class JMXUserTest {
    public static void main(String[] args) throws NotCompliantMBeanException, MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        StandardMBean userService =
                new StandardMBean(new UserService(), UserServiceInterface.class);
        ObjectName userServiceObjectName =
                new ObjectName("user_service:name=user-service");
        server.registerMBean(userService, userServiceObjectName);
        Thread.sleep(Long.MAX_VALUE);
    }
}
