package com.exchange.greendao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class MyClass {

    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(3, "com.exchange.dao");

        Entity course = schema.addEntity("Course");
        course.addIdProperty().autoincrement();
        course.addStringProperty("name").notNull();
        course.addStringProperty("code");
        course.addByteArrayProperty("icon");

        Entity courseValue = schema.addEntity("CourseValue");
        courseValue.addIdProperty().autoincrement();
        courseValue.addFloatProperty("purchase");
        courseValue.addFloatProperty("sale");
        courseValue.addDateProperty("updatedDate");
        courseValue.addStringProperty("courseCode");
        courseValue.addStringProperty("bankName");

        Entity branch = schema.addEntity("Branch");
        branch.addIdProperty().autoincrement();
        branch.addStringProperty("name").notNull();
        branch.addDoubleProperty("latitude");
        branch.addDoubleProperty("longitude");
        branch.addStringProperty("address");
        Property bankId = branch.addLongProperty("bankId").notNull().getProperty();

        Entity bank = schema.addEntity("Bank");
        bank.addIdProperty().autoincrement();
        bank.addStringProperty("name").notNull();
        bank.addDateProperty("updatedDate");
        bank.addToMany(branch, bankId);

        new DaoGenerator().generateAll(schema, "D:/Development/Contests/Exchange/android-app/src/");
    }

}
