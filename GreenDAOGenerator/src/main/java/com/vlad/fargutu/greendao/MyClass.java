package com.vlad.fargutu.greendao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyClass {

    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(3, "com.vlad.fargutu.exchange.dao");
        Entity upload = schema.addEntity("Upload");
        upload.addIdProperty();
        upload.addStringProperty("text");
        new DaoGenerator().generateAll(schema, "D:/Development/Contests/Exchange/android-app/src/main/java/");
    }

}
