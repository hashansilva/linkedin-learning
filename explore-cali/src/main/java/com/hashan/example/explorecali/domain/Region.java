/*
 * Copyright (c) 2023. Hashan Silva
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 */

package com.hashan.example.explorecali.domain;

public enum Region {
    Central_Coast("Central Coast"), Southern_California("Southern California"), Northern_California("Northern California"), Varies("Varies");

    private String label;

    private Region(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    /**
     * Returns the Region for the given label.
     * @param byLabel
     * @return
     */
    public static Region findByLabel(String byLabel) {
        for (Region r : Region.values()) {
            if (r.label.equalsIgnoreCase(byLabel)) {
                return r;
            }
        }
        return null;
    }
}
