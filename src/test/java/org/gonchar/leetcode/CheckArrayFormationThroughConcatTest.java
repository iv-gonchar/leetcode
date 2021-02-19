package org.gonchar.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckArrayFormationThroughConcatTest {

    private CheckArrayFormationThroughConcat solution = new CheckArrayFormationThroughConcat();

    @Test
    void canFormArrayEx1() {
        int arr[] = {85};
        int pieces[][] = {{85}};
        assertEquals(true, solution.canFormArray(arr, pieces));
    }

    @Test
    void canFormArrayEx2() {
        int arr[] = {15, 88};
        int pieces[][] = {{88}, {15}};
        assertEquals(true, solution.canFormArray(arr, pieces));
    }

    @Test
    void canFormArrayEx3() {
        int arr[] = {49,18,16};
        int pieces[][] = {{16,18,49}};
        assertEquals(false, solution.canFormArray(arr, pieces));
    }

    @Test
    void canFormArrayEx4() {
        int arr[] = {91,4,64,78};
        int pieces[][] = {{78},{4,64},{91}};
        assertEquals(true, solution.canFormArray(arr, pieces));
    }

    @Test
    void canFormArrayEx5() {
        int arr[] = {1,3,5,7};
        int pieces[][] = {{2,4,6,8}};
        assertEquals(false, solution.canFormArray(arr, pieces));
    }

    @Test
    void canFormArrayEmptyInput() {
        int arr[] = {};
        int pieces[][] = {{}};
        assertEquals(true, solution.canFormArray(arr, pieces));
    }

}