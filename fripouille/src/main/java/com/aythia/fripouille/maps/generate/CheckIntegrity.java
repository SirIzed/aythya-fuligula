package com.aythia.fripouille.maps.generate;

/**
 * Created on 29/04/2014.
 */
class CheckIntegrity {

    private int numberColumns = -1;

    public void onNewLine(String lineString) {
        initNumberColumns(lineString);
        checkEmptyLine(lineString);
        checkDifferentSize(lineString);
    }

    private void initNumberColumns(String lineString) {
        if (numberColumns == -1) {
            numberColumns = lineString.length();
        }
    }

    private void checkEmptyLine(String lineString) {
        if (lineString.length() == 0)  {
            throw new RuntimeException("Empty line");
        }

    }

    private void checkDifferentSize(String lineString) {
        if (numberColumns != lineString.length()) {
            throw new RuntimeException("two different line size");
        }
    }

    public void hadLine() {
        if (numberColumns == -1) {
            throw new RuntimeException("No line found");
        }

    }

}
