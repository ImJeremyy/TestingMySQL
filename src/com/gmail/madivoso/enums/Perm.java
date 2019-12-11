package com.gmail.madivoso.enums;


import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public enum Perm {

    TEST_COMMAND("testingmysql.test"),
    TESTING_MY_SQL_RELOAD("testingmysql.reoad")
    ;

    private Permission permission;

    Perm(String node) {
        this.permission = new Permission(node);
        permission.setDefault(PermissionDefault.OP);
    }

    public Permission getPermission() {
        return permission;
    }

}
