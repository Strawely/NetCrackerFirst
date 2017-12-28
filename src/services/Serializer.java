package services;


import model.SuperService;
import model.company.Companies;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    public static void store(Companies company) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Companies/" + company + ".bin"));
            out.writeObject(company);
            out.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void storeAll(SuperService superService, String fileName) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Companies/" + fileName + ".bin"));
            out.writeObject(superService);
            out.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static Companies load(String companyName) {
        try {
            ObjectInputStream in = new ObjectInputStream((new FileInputStream("Companies/" + companyName + ".bin")));
            Companies company = (Companies) in.readObject();
            in.close();
            return company;

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static SuperService loadAll(String fileName) {
        try {
            ObjectInputStream in = new ObjectInputStream((new FileInputStream("Companies/" + fileName + ".bin")));
            SuperService superService = (SuperService) in.readObject();
            in.close();
            return superService;

        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("qqq");
        return null;
    }
}
