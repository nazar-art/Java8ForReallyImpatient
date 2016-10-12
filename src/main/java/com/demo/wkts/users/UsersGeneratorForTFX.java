package com.demo.wkts.users;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UsersGeneratorForTFX {

    public static final String PERFORMANCE_USER_PREFIX = "perf_user_";

    public static final int FROM_USER_COUNT = 110473;
    public static final int TO_USER_COUNT   = 120373;

    public static final int STEP_TO_INCREMENT = 100;
    public static final String FILE_LOCATION = "src/main/resources/userlist.csv";

    public static void main(String[] args) throws IOException {
        Path usersFile = Paths.get(".", FILE_LOCATION);

        if (!Files.exists(usersFile)) {
            Files.createFile(usersFile);
        }

        StringBuilder builder = new StringBuilder();
        for (int index = FROM_USER_COUNT; index <= TO_USER_COUNT; index += STEP_TO_INCREMENT) {
            String indexStr = String.valueOf(index);
//            String content = PERFORMANCE_USER_PREFIX + indexStr + "\n";

            String content = builder.append(PERFORMANCE_USER_PREFIX)
                    .append(indexStr)
                    .append("\n")
                    .toString();

            System.out.print(content);
            if (index == FROM_USER_COUNT) {
                Files.write(usersFile, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                Files.write(usersFile, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            }

            builder.setLength(0);
        }
    }
}
