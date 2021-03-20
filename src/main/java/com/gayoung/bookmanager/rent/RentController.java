package com.gayoung.bookmanager.rent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RentController {
    private static RentController instance;

    public static RentController getInstance() {
        if (instance == null) {
            instance = new RentController();
        }
        return instance;
    }

    private RentController() {

    }







}
