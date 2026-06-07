package org.parabank.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.parabank.utilities.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EntityHelper {

    public static ConfigReader config =
            new ConfigReader();

    /*
     * READ JSON
     */
    public static List<ParabankData> readJson() {

        ObjectMapper obj =
                new ObjectMapper();

        List<ParabankData> dataList;

        try {

            dataList = obj.readValue(
                    new File(config.getProperty("jsonPath")),
                    new TypeReference<List<ParabankData>>() {}
            );

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        return dataList;
    }

    /*
     * WRITE JSON
     */
    public static void writeJson(
            List<ParabankData> dataList
    ) {

        ObjectMapper obj =
                new ObjectMapper();

        try {

            obj.writerWithDefaultPrettyPrinter()
                    .writeValue(
                            new File(
                                    config.getProperty("jsonPath")
                            ),
                            dataList
                    );

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    /*
     * GET DATA BY ID
     */
    public ParabankData getDataById(
            String id
    ) {

        return readJson()
                .stream()
                .filter(data ->
                        data.getId()
                                .equalsIgnoreCase(id)
                )
                .findFirst()
                .orElse(null);
    }

    /*
     * ADD ACCOUNT
     */
    public void addAccountById(
            String id,
            Account account
    ) {

        List<ParabankData> allData =
                readJson();

        for (ParabankData data : allData) {

            if (data.getId()
                    .equalsIgnoreCase(id)) {

                if (data.getAccounts() == null) {

                    data.setAccounts(
                            new ArrayList<>()
                    );
                }

                data.getAccounts()
                        .add(account);

                break;
            }
        }

        writeJson(allData);
    }

    /*
     * UPDATE CUSTOMER DETAILS
     */
    public void updateCustomerDetails(
            String id,
            Customer updatedCustomer
    ) {

        List<ParabankData> allData =
                readJson();

        for (ParabankData data : allData) {

            if (data.getId()
                    .equalsIgnoreCase(id)) {

                data.setCustomer(
                        updatedCustomer
                );

                break;
            }
        }

        writeJson(allData);
    }

    /*
     * GET ACCOUNT BY TYPE
     */
    public Account getAccountByType(
            String id,
            String accountType
    ) {

        ParabankData data =
                getDataById(id);

        if (data == null ||
                data.getAccounts() == null) {

            return null;
        }

        return data.getAccounts()
                .stream()
                .filter(account ->
                        account.getAccountType()
                                .equalsIgnoreCase(accountType)
                )
                .findFirst()
                .orElse(null);
    }

    /*
     * GET ACCOUNT BY FIELD
     */
    public Account getAccountByField(
            String id,
            String fieldName,
            String expectedValue
    ) {

        ParabankData data =
                getDataById(id);

        if (data == null ||
                data.getAccounts() == null) {

            return null;
        }

        for (Account account :
                data.getAccounts()) {

            try {

                Field field =
                        Account.class
                                .getDeclaredField(fieldName);

                field.setAccessible(true);

                Object value =
                        field.get(account);

                if (value != null &&
                        value.toString()
                                .equalsIgnoreCase(expectedValue)) {

                    return account;
                }

            } catch (Exception e) {

                throw new RuntimeException(e);
            }
        }

        return null;
    }

    /*
     * GET ACCOUNT BY TYPE AND INDEX
     */
    public Account getAccountByTypeAndIndex(
            String id,
            String accountType,
            int index
    ) {

        ParabankData data =
                getDataById(id);

        if (data == null ||
                data.getAccounts() == null) {

            return null;
        }

        List<Account> accounts =
                data.getAccounts()
                        .stream()
                        .filter(account ->
                                account.getAccountType()
                                        .equalsIgnoreCase(accountType)
                        )
                        .collect(Collectors.toList());

        if (accounts.size() > index) {

            return accounts.get(index);
        }

        return null;
    }

    /*
     * GET ALL ACCOUNTS BY TYPE
     */
    public List<Account> getAccountsByType(
            String id,
            String accountType
    ) {

        ParabankData data =
                getDataById(id);

        if (data == null ||
                data.getAccounts() == null) {

            return new ArrayList<>();
        }

        return data.getAccounts()
                .stream()
                .filter(account ->
                        account.getAccountType()
                                .equalsIgnoreCase(accountType)
                )
                .collect(Collectors.toList());
    }

    /*
     * UPDATE ACCOUNT DETAILS
     */
    public void updateAccountByNumber(
            String customerId,
            String accountNumber,
            String balance,
            String availableBalance
    ) {

        List<ParabankData> allData =
                readJson();

        for (ParabankData data : allData) {

            if (data.getId()
                    .equalsIgnoreCase(customerId)) {

                for (Account account :
                        data.getAccounts()) {

                    if (account.getAccountNumber()
                            .equalsIgnoreCase(accountNumber)) {

                        account.setBalance(balance);

                        account.setAvailableBalance(
                                availableBalance
                        );

                        break;
                    }
                }
            }
        }

        writeJson(allData);
    }
}