package com.ustc.maven;

/**
 * @author Miracle
 * @date 2023/2/13 17:31
 * @description Calculator
 */
public class Calculator implements ICalculator{
    @Override
    public Integer add(Integer i, Integer j) {
        Integer result = i + j;
        return result;
    }

    @Override
    public Integer sub(Integer i, Integer j) {
        Integer result = i - j;
        return result;
    }

    @Override
    public Integer mul(Integer i, Integer j) {
        Integer result = i * j;
        return result;
    }

    @Override
    public Integer div(Integer i, Integer j) {
        Integer result = i / j;
        return result;
    }
}
