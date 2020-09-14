package com.vectorsearch.faiss.utils;

import com.vectorsearch.faiss.swig.floatArray;
import com.vectorsearch.faiss.swig.intArray;
import com.vectorsearch.faiss.swig.longArray;

import java.util.Random;

public class IndexHelper {
    public static String show(longArray a, int rows, int cols) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(i).append('\t').append('|');
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%5d ", a.getitem(i * cols + j)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String show(floatArray a, int rows, int cols) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(i).append('\t').append('|');
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%7g ", a.getitem(i * cols + j)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static floatArray makeFloatArray(float[][] vectors) {
        final int d = vectors[0].length;
        final int nb = vectors.length;
        final floatArray fa = new floatArray(d * nb);
        for (int i = 0; i < nb; i++) {
            for (int j = 0; j < d; j++) {
                fa.setitem(d * i + j, vectors[i][j]);
            }
        }
        return fa;
    }

    public static longArray makeLongArray(int[] ints) {
        final int len = ints.length;
        final longArray la = new longArray(len);
        for (int i = 0; i < len; i++) {
            la.setitem(i, ints[i]);
        }
        return la;
    }

    public static long[] toArray(longArray c_array, int length) {
        return toArray(c_array, 0, length);
    }

    public static long[] toArray(longArray c_array, int start, int length) {
        final long[] re = new long[length];
        for (int i = start; i < length; i++) {
            re[i] = c_array.getitem(i);
        }
        return re;
    }

    public static int[] toArray(intArray c_array, int length) {
        return toArray(c_array, 0, length);
    }

    public static int[] toArray(intArray c_array, int start, int length) {
        final int[] re = new int[length];
        for (int i = start; i < length; i++) {
            re[i] = c_array.getitem(i);
        }
        return re;
    }

    public static float[] toArray(floatArray c_array, int length) {
        return toArray(c_array, 0, length);
    }

    public static float[] toArray(floatArray c_array, int start, int length) {
        final float[] re = new float[length];
        for (int i = start; i < length; i++) {
            re[i] = c_array.getitem(i);
        }
        return re;
    }

    public static floatArray makeRandomFloatArray(int size, int dim, Random random) {
        final floatArray array = new floatArray(size * dim);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < dim; j++) {
                array.setitem(i * dim + j, random.nextFloat());
            }
            array.setitem(i * dim, i / 1000.f + array.getitem(i * dim));
        }
        return array;
    }
}