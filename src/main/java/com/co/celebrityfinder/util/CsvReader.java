package com.co.celebrityfinder.util;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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

            IntStream.range(0, lines.size())
                    .forEach(indexX -> {
                        IntStream.range(0, lines.size())
                                .forEach(indexY -> {
                                    listOfKnowPeople[indexX][indexY] = Integer.valueOf(lines.get(indexX).get(indexY));
                                });
                    });

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

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<List<String>> lines = br.lines().map(line -> Arrays.asList(line.split(COMMA_DELIMITER))).collect(Collectors.toList());
            int[][] listOfKnowPeople = new int[lines.size()][lines.size()];

            IntStream.range(0, lines.size())
                    .forEach(indexX -> {
                        IntStream.range(0, lines.size())
                                .forEach(indexY -> {
                                    listOfKnowPeople[indexX][indexY] = Integer.valueOf(lines.get(indexX).get(indexY));
                                });
                    });

            return listOfKnowPeople;
        }

    }


}
