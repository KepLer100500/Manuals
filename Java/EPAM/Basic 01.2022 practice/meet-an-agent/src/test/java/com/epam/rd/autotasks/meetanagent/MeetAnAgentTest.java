package com.epam.rd.autotasks.meetanagent;

import static com.epam.rd.autotasks.meetanagent.MeetAnAgent.password;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.stefanbirkner.systemlambda.Statement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class MeetAnAgentTest {

    @ParameterizedTest
    @MethodSource("getParameters")
    public void correctPasswordTest(int userInput, String expected) throws Exception {

        String actual = tapSystemOut(
                () -> withTextFromSystemIn(Integer.toString(userInput))
                        .execute(() -> MeetAnAgent.main(new String[]{}))
        );

        assertEquals(expected, actual.strip());
    }

    private static Stream<Arguments> getParameters() {
        return Stream.of(
                Arguments.of(password, "Hello, Agent"),
                Arguments.of(password + 1, "Access denied"),
                Arguments.of(password + password, "Access denied"),
                Arguments.of(100 + password, "Access denied")
        );
    }
}
