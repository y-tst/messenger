package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.TestExecutionInfoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(TestExecutionInfoExtension.class)
public @interface OutputTestExecutionInfo {
}