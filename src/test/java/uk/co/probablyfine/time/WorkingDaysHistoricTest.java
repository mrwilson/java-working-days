package uk.co.probablyfine.time;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

public interface WorkingDaysHistoricTest {

    static Example toExample(String input) {
        String[] split = input.split(",");
        return new Example(split[0], LocalDate.parse(split[1]));
    }

    static Collection<Example> loadExamples(String path) throws IOException {
        return Files.readAllLines(Paths.get(path)).stream()
                .map(WorkingDaysHistoricTest::toExample)
                .collect(Collectors.toList());
    }

    class Example {
        public final String name;
        public final LocalDate date;

        Example(String name, LocalDate date) {
            this.name = name;
            this.date = date;
        }

        @Override
        public String toString() {
            return String.format("%s %s", name, date);
        }
    }
}
