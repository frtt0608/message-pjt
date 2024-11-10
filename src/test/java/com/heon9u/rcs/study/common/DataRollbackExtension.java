package com.heon9u.rcs.study.common;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class DataRollbackExtension implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        DataCleaner dataCleaner = SpringExtension.getApplicationContext(extensionContext).getBean(DataCleaner.class);
        dataCleaner.init();
    }
}
