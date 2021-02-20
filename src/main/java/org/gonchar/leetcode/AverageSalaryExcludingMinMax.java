package org.gonchar.leetcode;

public class AverageSalaryExcludingMinMax {

    public double average(int[] salary) {
        double average = 0.0;
        double min = 10000000.0; // greater than any salary according to constraint
        double max = 10.0; // less than any salary according to constraint
        for (int i=0; i<salary.length; i++) {
            double current = ((double) salary[i]) / (salary.length - 2);
            if (max < current) {
                max = current;
            }
            if (min > current) {
                min = current;
            }
            average = average + current;
        }
        average = average - min - max;
        return average;
    }
}
