package com.co.celebrityfinder.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class read a csv file
 */
public class CsvReader {

    private static String COMMA_DELIMITER=",";

    /**
     * This method read read a csv file from the inputstream
     * @param in file data
     * @return int array with the information of the persons
     * @throws FileNotFoundException
     * @throws IOException
     */
    public int [][] readFile(InputStream in) throws FileNotFoundException, IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }

        int people [][]  = new int[records.size()][records.size()];

        for(int i=0; i<records.size(); i++) {
            for(int j=0; j<records.size(); j++) {
                people[i][j] = Integer.valueOf(records.get(i).get(j));
            }
        }

        return people;
    }


    /**
     * This method read read a csv file from a specific path
     * @param path
     * @return int array with the information of the persons
     * @throws FileNotFoundException
     * @throws IOException
     */
    public int [][] readFile(String path) throws FileNotFoundException, IOException {
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
