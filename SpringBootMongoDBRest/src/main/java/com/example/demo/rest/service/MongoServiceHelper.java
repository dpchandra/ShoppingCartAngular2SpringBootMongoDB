/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.rest.service;

import com.example.demo.rest.pojo.Product;
import org.springframework.stereotype.Service;
import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
@Service
public class MongoServiceHelper {

    public List<Product> getProducts() {
        List<Product> products = new ArrayList();
//        products.add(new Product(1, "Nexus S", "/assets/img/phones/nexus-s.0.jpg", "The Nexus S is a smartphone co-developed by Google and Samsung and manufactured by Samsung Electronics for release in 2010. It was the first smartphone to use the Android 2.3 Gingerbread operating system, and the first Android device to support Near Field Communication (NFC).", 99.99));
//        products.add(new Product(2, "Dell Venue", "/assets/img/phones/dell-venue.0.jpg", "The Dell Venue is a line of Android smartphones and tablets manufactured by Dell. The first Dell Venue was released for both T-Mobile and AT&T in the United States, and for KT in South Korea. It was the second Dell smartphone to be released in the US and features the Dell Stage UI also found on the Dell Streak line of tablets.", 109.00));
//        products.add(new Product(3, "Droid 2", "/assets/img/phones/droid-2-global-by-motorola.0.jpg",
//                "The Motorola Droid 2 is the fifth phone in Verizon's Droid line. It runs the Android operating system by Google, and can run Flash Player 10.1. It comes with 8 GB of internal memory and is shipped with an additional 8 GB SDHC card, upgradable to 32 GB. It has a 3.7 in display and a 5-megapixel camera.", 99.99));

        MongoClientURI uri = new MongoClientURI("mongodb://purna:purna@ds135364.mlab.com:35364/mytasklist_purna");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());

        /*
         * First we'll add a few songs. Nothing is required to create the
         * songs collection; it is created automatically when we insert.
         */
        MongoCollection<Document> document = db.getCollection("product");
        MongoCursor<Document> cursor = document.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println("In the " + doc.get("uid") + ", " + doc.get("name")+ "  " + doc.get("src") +", "+doc.get("info"));
                products.add(new Product(doc.get("uid").toString(), doc.get("name").toString(), doc.get("src").toString(), doc.get("info").toString(), Double.parseDouble(doc.get("price").toString())));
            }
        } finally {
            cursor.close();
        }

        // Only close the connection when your app is terminating
        client.close();
        return products;
    }
}
