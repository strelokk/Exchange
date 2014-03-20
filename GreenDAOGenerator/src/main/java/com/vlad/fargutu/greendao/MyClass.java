package com.vlad.fargutu.greendao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class MyClass {

    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(3, "com.vlad.fargutu.exchange.dao");

        Entity course = schema.addEntity("Course");
        course.addIdProperty().notNull();
        course.addStringProperty("name").notNull();
        course.addStringProperty("code");
        course.addByteArrayProperty("icon");

        Entity courseValue = schema.addEntity("CourseValue");
        courseValue.addIdProperty().notNull();
        courseValue.addFloatProperty("purchase");
        courseValue.addFloatProperty("sale");
        courseValue.addDateProperty("updatedDate");
        courseValue.addLongProperty("courseId");
        courseValue.addLongProperty("bankId");

        Entity branch = schema.addEntity("Branch");
        branch.addIdProperty().notNull();
        branch.addStringProperty("name").notNull();
        branch.addLongProperty("latitude");
        branch.addLongProperty("longitude");
        branch.addStringProperty("address");
        Property bankId = branch.addLongProperty("bankId").getProperty();

        Entity bank = schema.addEntity("Bank");
        bank.addIdProperty().notNull();
        bank.addStringProperty("name").notNull();
        bank.addDateProperty("updatedDate");
        bank.addToMany(branch, bankId);

        new DaoGenerator().generateAll(schema, "D:/Development/Contests/Exchange/android-app/src/main/java/");
    }

}
