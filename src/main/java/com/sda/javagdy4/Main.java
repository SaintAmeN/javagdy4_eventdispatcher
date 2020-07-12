package com.sda.javagdy4;

import com.sda.javagdy4.departments.*;
import com.sda.javagdy4.dispatcher.Dispatcher;
import com.sda.javagdy4.event.NewEmployeeEvent;
import com.sda.javagdy4.event.NewProductLine;
import com.sda.javagdy4.event.ProductRelease;
import com.sda.javagdy4.event.ProductTerminated;
import com.sda.javagdy4.model.Employee;
import com.sda.javagdy4.model.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        new FinancialDepartment();
        new HRDepartment();
        new MediaDepartment();
        new ProductionDepartment();
        new ITDepartment();

        Scanner scanner = new Scanner(System.in);
        String komenda;

        do {
            komenda = scanner.nextLine();

            if (komenda.startsWith("hire")) {
                String[] slowa = komenda.split(" ");
//hire Marian Nowak 20 IT
                Dispatcher.getInstance()
                        .fireEvent(
                                new NewEmployeeEvent(
                                        new Employee(
                                                slowa[1],
                                                slowa[2],
                                                Integer.parseInt(slowa[3]),
                                                Department.valueOf(slowa[4]))));
            } else if (komenda.startsWith("newproduct")) {
                String[] slowa = komenda.split(" ");
//newproduct 1 Maslo 3.3 Maslo-Maslane-Ekstra 2020-10-10
                Dispatcher.getInstance()
                        .fireEvent(
                                new NewProductLine(
                                        new Product(
                                                Long.parseLong(slowa[1]),
                                                slowa[2],
                                                Double.parseDouble(slowa[3]),
                                                slowa[4],
                                                LocalDate.parse(slowa[5], DATE_TIME_FORMATTER))));
            } else if (komenda.startsWith("productrelease")) {
                String[] slowa = komenda.split(" ");

                Dispatcher.getInstance()
                        .fireEvent(
                                new ProductRelease(Long.parseLong(slowa[1])));
            }else if (komenda.startsWith("productterminated")) {
                String[] slowa = komenda.split(" ");

                Dispatcher.getInstance()
                        .fireEvent(
                                new ProductTerminated(Long.parseLong(slowa[1])));
            }
        } while (!komenda.equalsIgnoreCase("quit"));


    }
}
