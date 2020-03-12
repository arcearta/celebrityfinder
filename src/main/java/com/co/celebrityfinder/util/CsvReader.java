package com.co.celebrityfinder.util;

import com.co.celebrityfinder.service.dto.PeopleDto;
import com.co.celebrityfinder.service.dto.PersonDto;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class read a csv file
 */
public class CsvReader {

    public static final String UTF_8 = "UTF-8";
    private static String COMMA_DELIMITER = ",";


    /**
     * This method read read a csv file from the inputstream
     * @param in file data
     * @return int array with the information of the persons
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static int [][] readFile(InputStream in) throws FileNotFoundException, IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, UTF_8))) {

            List<List<String>> lines = br.lines().map(line -> Arrays.asList(line.split(COMMA_DELIMITER))).collect(Collectors.toList());
            int[][] listOfKnowPeople = new int[lines.size()][lines.size()];

            for(int i=0; i<lines.size(); i++) {
                for(int j=0; j<lines.size(); j++) {
                    listOfKnowPeople[i][j] = Integer.valueOf(lines.get(i).get(j));
                }
            }

            return listOfKnowPeople;
        }

    }


    /**
     * This method read read a csv file from a specific path
     * @param path
     * @return int array with the information of the persons
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static int [][] readFile(String path) throws FileNotFoundException, IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }

       int persons [][]  = new int[records.size()][records.size()];

        for(int i=0; i<records.size(); i++) {
            for(int j=0; j<records.size(); j++) {
                persons[i][j] = Integer.valueOf(records.get(i).get(j));
            }
        }

        return persons;
    }

}
