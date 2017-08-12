package com.cflint.plugins.core;

import com.cflint.BugInfo;
import com.cflint.Levels;
import com.cflint.BugList;
import com.cflint.plugins.CFLintScannerAdapter;

import ro.fortsoft.pf4j.Extension;

@Extension
public class FileCaseChecker extends CFLintScannerAdapter {
    final Levels severity = Levels.INFO;

    @Override
    public void startFile(final String fileName, final BugList bugs) {
        String actualFileName = fileName;
        final String separator = System.getProperty("file.separator");
        final int seperatorPosition = fileName.lastIndexOf(separator);

        if (seperatorPosition >= 0) {
            actualFileName = fileName.substring(seperatorPosition + 1);
        }

        if (actualFileName.contains(".cfm")) {
            if (Character.isUpperCase(actualFileName.charAt(0))) {
                bugs.add(new BugInfo.BugInfoBuilder().setLine(1).setMessageCode("FILE_SHOULD_START_WITH_LOWERCASE")
                        .setSeverity(severity).setFilename(fileName)
                        .setMessage("File " + actualFileName
                                + " starts with a upper case letter. Only components (.cfc files) should start with an upper case letter.")
                        .build());
            }
        }
    }
}