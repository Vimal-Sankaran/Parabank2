package org.parabank.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.parabank.utilities.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EntityHelper {

    public static ConfigReader config = new ConfigReader();
    /*
     * READ JSON
     */
    public static List<ParabankData> readJson() {

        ObjectMapper obj = new ObjectMapper();

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
    public static void writeJson(List<ParabankData> dataList) {

        ObjectMapper obj = new ObjectMapper();

        try {

            obj.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(config.getProperty("jsonPath")), dataList);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * GET DATA BY ID
     */
    private final List<ParabankData> parabankDataList = readJson();

    public ParabankData getDataById(String id) {

        return parabankDataList.stream()
                .filter(data -> data.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /*
     * ADD ACCOUNT
     */
    public void addAccountById(String id, Account account) {

        List<ParabankData> dataList = readJson();

        dataList.stream()
                .filter(data -> data.getId().equals(id))
                .findFirst()
                .ifPresent(data -> {

                    data.getAccounts().add(account);

                });

        writeJson(dataList);
    }

    /*
     * GET ACCOUNT BY TYPE
     */
    public Account getAccountByType(String id, String accountType) {

        ParabankData data = getDataById(id);

        return data.getAccounts()
                .stream()
                .filter(a -> a.getAccountType().equals(accountType))
                .findFirst()
                .orElse(null);
    }
}
